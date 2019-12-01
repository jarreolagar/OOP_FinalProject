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
import main.modelo.ClienteModel;
import main.modelo.ConsultasBD;
import main.modelo.ConsultasEmpleadoBD;
import main.modelo.ConsultasInventarioBD;
import main.modelo.EmpleadoModelo;
import main.modelo.InventarioModelo;
import main.vista.ClienteVista;
import main.vista.EmpleadoVista;
import main.vista.InventarioVista;


/**
 *
 * @author Juan Manuel Arreola
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
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
        
        
        ClienteControlador ctrl = new ClienteControlador(view, cltemodel, cltsBD);
        EmpleadoControlador econtrol = new EmpleadoControlador(viewEmpleado, emModel, conEmpleado);
        InventarioControlador controlador = new InventarioControlador(vista, modelo, consulta);
        
        ctrl.iniciarVistaCliente();
        view.setVisible(true);
        
        econtrol.iniciarVistaEmpleado();
        viewEmpleado.setVisible(true);
        
        controlador.iniciarVistaInventario();
        vista.setVisible(true);
    }
    
}
