/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.SQLException;
import main.controlador.ClienteControlador;
import main.controlador.EmpleadoControlador;
import main.controlador.InventarioControlador;
import main.controlador.VentasControlador;
import main.modelo.ClienteModel;
import main.modelo.ConsultasBD;
import main.modelo.ConsultasEmpleadoBD;
import main.modelo.ConsultasInventarioBD;
import main.modelo.ConsultasVentasBD;
import main.modelo.EmpleadoModelo;
import main.modelo.InventarioModelo;
import main.modelo.VentasModelo;
import main.vista.ClienteVista;
import main.vista.EmpleadoVista;
import main.vista.InventarioVista;
import main.vista.VentasVista;


/**
 *
 * @author Juan Manuel Arreola
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{
        // TODO code application logic here
        ClienteModel cltemodel = new ClienteModel();
        ConsultasBD cltsBD = new ConsultasBD();
        ClienteVista view = new ClienteVista();
        
        
        EmpleadoModelo emModel = new EmpleadoModelo();
        ConsultasEmpleadoBD conEmpleado = new ConsultasEmpleadoBD();
        EmpleadoVista viewEmpleado = new EmpleadoVista();
        
        
        InventarioModelo modelo = new InventarioModelo();
        ConsultasInventarioBD consulta = new ConsultasInventarioBD();
        InventarioVista vista = new InventarioVista();
        
        
        VentasModelo modeloventa = new VentasModelo();
        ConsultasVentasBD consultaventa = new ConsultasVentasBD();
        VentasVista vistaventa = new VentasVista();
        
        /*********************************************************************************/
        
        ClienteControlador ctrl = new ClienteControlador(view, cltemodel, cltsBD);
        EmpleadoControlador econtrol = new EmpleadoControlador(viewEmpleado, emModel, conEmpleado);
        InventarioControlador controlador = new InventarioControlador(vista, modelo, consulta);
        VentasControlador ventacontrolador = new VentasControlador(vistaventa, modeloventa, consultaventa);
        
        
        ctrl.iniciarVistaCliente();
        view.setVisible(true);
        
        econtrol.iniciarVistaEmpleado();
        viewEmpleado.setVisible(true);
        
        controlador.iniciarVistaInventario();
        vista.setVisible(true);
        
        ventacontrolador.iniciarVistaVentas();
        vistaventa.setVisible(true);
    }
    
}
