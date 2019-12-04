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
import main.controlador.ConexionBD;

/**
 *
 * @author Juan Manuel Arreola
 */
public class ConsultasBD extends ConexionBD {

    //SE HEREDA DE CONEXIONBD PARA USAR DIRECTAMENTE AQUI LA CLASE Y NO REALIZAR INSTANCIAS DE ESTA MISMA
    //MÉTODOS PARA REALIZAR MIS CONSULTAS A LA BASE DE DATOS
    public boolean registrarCliente(ClienteModel cm) {

        PreparedStatement ps = null;
        Connection cn = getConnection();

        String sql = "INSERT INTO Clientes (nombre,sexo,fechaNacimiento,tarjeta) VALUES(?,?,?,?)";

        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, cm.getNombreCliente());
            ps.setString(2, cm.getSexo());
            ps.setString(3, cm.getFechaNacimiento());
            ps.setFloat(4, cm.getTarjeta());
            ps.execute();
            return true;
        } catch (SQLException e) {

            System.out.println(e);
            return false;

        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    
    public boolean modificarCliente(ClienteModel cm) {

        PreparedStatement ps = null;
        Connection cn = getConnection();

        String sql = "UPDATE Clientes SET nombre=?,sexo=?,fechaNacimiento=?,tarjeta=? WHERE id=?";

        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, cm.getNombreCliente());
            ps.setString(2, cm.getSexo());
            ps.setString(3, cm.getFechaNacimiento());
            ps.setFloat(4, cm.getTarjeta());
            ps.setInt(5, cm.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            
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
    
    public boolean eliminarCliente(ClienteModel cm) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = getConnection();
        boolean res = false;
        String sql = "DELETE FROM Clientes WHERE id=?";

        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, cm.getId());
            rs = ps.executeQuery();
            //return true;
        } catch (SQLException e) {
            
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
    
    public boolean buscarCliente(ClienteModel cm) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = getConnection();
        boolean res = false;
        String sql = "SELECT * FROM Clientes WHERE nombre=?";
        //System.out.println(sql);
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, cm.getNombreCliente());
            rs = ps.executeQuery();
            
            if(rs.next()){
                cm.setId(Integer.parseInt(rs.getString("id")));
                cm.setNombreCliente(rs.getString("nombre"));
                cm.setSexo(rs.getString("sexo"));
                cm.setFechaNacimiento(rs.getString("fechaNacimiento"));
                cm.setTarjeta(Float.parseFloat(rs.getString("tarjeta")));
                res= true;
            }
            
        } catch (SQLException e) {
            
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
