/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.controlador;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Juan Manuel Arreola
 */
public class ConexionBD {
    
    //Clase conectora a la base de datos
    private static Connection cn;
    
    public static Connection getConnection(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn=DriverManager.getConnection("jdbc:sqlserver://THINKPAD-L470\\MSSQLSERVER02:53356;"
                    + "databaseName=POOBD;integratedSecurity=true;"
                    + "user=juanelo;password=123;");
        }catch(Exception e){
            cn=null;
        }
        return cn;
    }
    public static void main(String[] args) {
        Connection pruebaCn= ConexionBD.getConnection();
        if(pruebaCn != null){
            System.out.println("Conexión establecida");
            System.out.println("" + pruebaCn);
        }else{
            System.out.println("Desconectado");
        }
    }
}
