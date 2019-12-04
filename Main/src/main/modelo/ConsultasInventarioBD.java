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
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import main.controlador.ConexionBD;
import main.vista.InventarioVista;
import main.vista.VentasVista;

/**
 *
 * @author Juan Manuel Arreola
 */
public class ConsultasInventarioBD extends ConexionBD {
    
    public void cargarComboBox(JComboBox comboBoxSucursal) {

        PreparedStatement ps = null;
        Connection cn = getConnection();
        ResultSet rs = null;

        String sql = "SELECT nombre FROM Sucursal ORDER BY nombre ASC";

        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            comboBoxSucursal.addItem("Seleccione una sucursal");

            while (rs.next()) {

                comboBoxSucursal.addItem(rs.getString("nombre"));
                

            }
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, e);
            
        }finally{
            
            if(cn != null){
                
                try{
                    
                    cn.close();
                    rs.close();
                    
                    cn = null;
                    rs = null;
                }catch(SQLException e){
                    
                    JOptionPane.showMessageDialog(null, e);
                    
                }
            }
        }

    }
    
  
    public boolean registrarArticulo(InventarioModelo invenModelo){
        
        PreparedStatement ps = null;
        Connection cn = getConnection();
        
        String sql = "INSERT INTO Inventario(articulo,cantidad,costo,estatus,sucursal) VALUES(?,?,?,?,?)";
        
        try{
            
            ps = cn.prepareStatement(sql);
            ps.setString(1, invenModelo.getNombreArticulo());
            ps.setInt(2, invenModelo.getCantidadArticulo());
            ps.setFloat(3, invenModelo.getCostoArticulo());
            //ps.setInt(4, invenModelo.getIdSucursal());
            ps.setString(4, invenModelo.getEstatusArticulo());
            ps.setString(5, invenModelo.getSucursal());
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
    
    public boolean modificarArticulo(InventarioModelo invenModelo){
        
        PreparedStatement ps = null;
        Connection cn = getConnection();
        
        String sql = "UPDATE Inventario SET articulo=?,cantidad=?,costo=?,estatus=?,sucursal=? WHERE id=?";
        
        try{
            
            ps = cn.prepareStatement(sql);
            ps.setString(1, invenModelo.getNombreArticulo());
            ps.setInt(2, invenModelo.getCantidadArticulo());
            ps.setFloat(3, invenModelo.getCostoArticulo());
            ps.setString(4, invenModelo.getEstatusArticulo());
            ps.setString(5, invenModelo.getSucursal());
            ps.setInt(6, invenModelo.getIdArticulo());
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
    
    public boolean eliminarArticulo(InventarioModelo invenModelo){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = getConnection();
        boolean res = false;
        String sql = "DELETE FROM Inventario WHERE id=?";
        
        try{
            ps = cn.prepareStatement(sql);
            ps.setInt(1, invenModelo.getIdArticulo());
            rs = ps.executeQuery();
            
        }catch(SQLException e){
            
            System.out.println(e);
            res = true;
            
        }finally{
            
            try{
                cn.close();
            }catch(SQLException e){
                System.out.println(e);
            }
        }
        return res;
    }
    
    public boolean buscarArticulo(InventarioModelo invenModelo){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = getConnection();
        boolean res = false;
        String sql = "SELECT * FROM Inventario WHERE articulo=?";
        
        try{
            ps = cn.prepareStatement(sql);
            ps.setString(1, invenModelo.getNombreArticulo());
            rs = ps.executeQuery();
            
            if(rs.next()){
                invenModelo.setIdArticulo(Integer.parseInt(rs.getString("id")));
                invenModelo.setNombreArticulo(rs.getString("articulo"));
                invenModelo.setCantidadArticulo(Integer.parseInt(rs.getString("cantidad")));
                invenModelo.setCostoArticulo(Float.parseFloat(rs.getString("costo")));
                invenModelo.setEstatusArticulo(rs.getString("estatus"));
                invenModelo.setSucursal(rs.getString("sucursal"));
                
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
