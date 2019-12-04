/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import main.controlador.ConexionBD;

/**
 *
 * @author Juan Manuel Arreola
 */
public class ConsultasVentasBD extends ConexionBD{

    public void cargarComboBoxEmpleado(JComboBox comboBoxEmpleado) {

        PreparedStatement ps = null;
        Connection cn = getConnection();
        ResultSet rs = null;

        String sql = "SELECT nombre FROM Empleados ORDER BY nombre ASC";

        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            comboBoxEmpleado.addItem("Seleccione un empleado");

            while (rs.next()) {

                comboBoxEmpleado.addItem(rs.getString("nombre"));
                
            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);

        } finally {

            if (cn != null) {

                try {

                    cn.close();
                    rs.close();

                    cn = null;
                    rs = null;
                } catch (SQLException e) {

                    JOptionPane.showMessageDialog(null, e);

                }
            }
        }
    }
    
    public void cargarComboBoxCliente(JComboBox comboBoxCliente){
        
        PreparedStatement ps = null;
        Connection cn = getConnection();
        ResultSet rs = null;
        
        String sql = "SELECT nombre FROM Clientes ORDER BY nombre ASC";
        
        try{
            
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            comboBoxCliente.addItem("Seleccione el cliente");
            
            while(rs.next()){
                
                comboBoxCliente.addItem(rs.getString("nombre"));
                //comboBoxCliente.addItem(rs.getString("apellido"));
                
            }
            
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, e);
            
        }finally {

            if (cn != null) {

                try {

                    cn.close();
                    rs.close();

                    cn = null;
                    rs = null;
                } catch (SQLException e) {

                    JOptionPane.showMessageDialog(null, e);

                }
            }
        }
    }
    
    public boolean ventaArticulo(VentasModelo ventaModelo){
        
        PreparedStatement ps = null;
        Connection cn = getConnection();
        //int cant = ventaModelo.getCantidad();
        
        String sql = "UPDATE Inventario SET articulo=?,cantidad=cantidad-'"+ventaModelo.getCantidad()+"', WHERE articulo=?";
        
        try{
            
            ps = cn.prepareStatement(sql);
            ps.setString(1, ventaModelo.getNombreArticulo());
            ps.setInt(2, ventaModelo.getCantidad());
            ps.setInt(6, ventaModelo.getIdArticulo());
            ps.execute();
            
            return true;
            
        }catch(SQLException e){
            
            System.out.println(e);
            return false;
            
        }finally{
            
            try{
                cn.close();
            }catch(SQLException e){
                System.out.println(e);
            }
        }
    }
    
    public boolean buscarArti(VentasModelo ventaModelo){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = getConnection();
        boolean res = false;
        String sql = "SELECT id,articulo,costo FROM Inventario WHERE articulo=?";
        
        try{
            ps = cn.prepareStatement(sql);
            ps.setString(1, ventaModelo.getNombreArticulo());
            rs = ps.executeQuery();
            
            if(rs.next()){
                ventaModelo.setIdArticulo(Integer.parseInt(rs.getString("id")));
                ventaModelo.setNombreArticulo(rs.getString("articulo"));
                ventaModelo.setCosto(Float.parseFloat(rs.getString("costo")));
                
                res = true;
            }
        }catch(SQLException e){
            
            System.out.println(e.getMessage());
            
        }finally{
            try{
                cn.close();
            }catch(SQLException e){
                System.out.println(e);
            }
        }
        return res;
    }
}


