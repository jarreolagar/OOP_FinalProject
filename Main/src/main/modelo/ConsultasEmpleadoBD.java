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
//AQUI VAN TODOS LOS METODOOS Y CONSULTAS A LA BD
public class ConsultasEmpleadoBD extends ConexionBD {

    public boolean registrarEmpleado(EmpleadoModelo em) {

        PreparedStatement ps = null;
        Connection cn = getConnection();

        String sql = "INSERT INTO Empleados (nombre,cargo,salario,horario,comisiones) VALUES(?,?,?,?,?)";

        try {
            
            ps = cn.prepareStatement(sql);
            ps.setString(1, em.getNombreEmpleado());
            ps.setString(2, em.getCargoEmpleado());
            ps.setFloat(3, em.getSalarioEmpleado());
            ps.setString(4, em.getHorarioEmpleado());
            ps.setFloat(5, em.getComisionesEmpleado());
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

    public boolean modificarEmpleado(EmpleadoModelo em) {

        PreparedStatement ps = null;
        Connection cn = getConnection();

        String sql = "UPDATE Empleados SET nombre=?,cargo=?,salario=?,horario=?,comisiones=? WHERE id=?";

        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, em.getNombreEmpleado());
            ps.setString(2, em.getCargoEmpleado());
            ps.setFloat(3, em.getSalarioEmpleado());
            ps.setString(4, em.getHorarioEmpleado());
            ps.setFloat(5, em.getComisionesEmpleado());
            ps.setInt(6, em.getIdEmpleado());
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
    
    public boolean eliminarEmpleado(EmpleadoModelo em) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = getConnection();
        boolean res = false;
        
        String sql = "DELETE FROM Empleados WHERE id=?";

        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, em.getIdEmpleado());
            rs = ps.executeQuery();

            //return true;
        } catch (SQLException e) {
            System.out.println(e);
            res = true;

        } finally {

            try {
                cn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return res;
    }
    
    public boolean buscarEmpleado(EmpleadoModelo em) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = getConnection();
        boolean res = false;
        String sql = "SELECT * FROM Empleados WHERE nombre=?";
        //System.out.println(sql);
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, em.getNombreEmpleado());
            rs = ps.executeQuery();
            
            if(rs.next()){
                em.setIdEmpleado(Integer.parseInt(rs.getString("id")));
                em.setNombreEmpleado(rs.getString("nombre"));
                em.setCargoEmpleado(rs.getString("cargo"));
                em.setSalarioEmpleado(Float.parseFloat(rs.getString("salario")));
                em.setHorarioEmpleado(rs.getString("horario"));
                em.setComisionesEmpleado(Float.parseFloat(rs.getString("comisiones")));
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
