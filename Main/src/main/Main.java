/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.SQLException;
import main.controlador.ClienteControlador;
import main.modelo.ClienteModel;
import main.modelo.ConsultasBD;
import main.vista.ClienteVista;


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
        
        ClienteControlador ctrl = new ClienteControlador(view, cltemodel, cltsBD);
        
        ctrl.iniciarVistaCliente();
        view.setVisible(true);
    }
    
}
