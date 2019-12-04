/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import main.modelo.ConsultasInventarioBD;
import main.modelo.InventarioModelo;
import main.vista.InventarioVista;
import main.vista.VentasVista;

/**
 *
 * @author Juan Manuel Arreola
 */
public class InventarioControlador implements ActionListener{
    
    private InventarioVista vista;
    private InventarioModelo modelo;
    private ConsultasInventarioBD consulta;
    
    
    public InventarioControlador(InventarioVista vista, InventarioModelo modelo, ConsultasInventarioBD consulta) {
        this.vista = vista;
        this.modelo = modelo;
        this.consulta = consulta;
        //Declarar los ActionListener de los botones
        this.vista.guardarInventarioBoton.addActionListener(this);
        this.vista.modificarInventarioBoton.addActionListener(this);
        this.vista.eliminarInventarioBoton.addActionListener(this);
        this.vista.limpiarInventarioBoton.addActionListener(this);
        this.vista.buscarInventarioBoton.addActionListener(this);
    }
    
    public void iniciarVistaInventario(){
        vista.setTitle("Inventario");
        vista.setLocationRelativeTo(null);
        vista.buscarInventarioTextField.setVisible(false);
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == vista.guardarInventarioBoton){
            
            modelo.setNombreArticulo(vista.articuloInventarioTextField.getText());
            modelo.setCantidadArticulo(Integer.parseInt(vista.cantidadInventarioTextField.getText()));
            modelo.setCostoArticulo(Float.parseFloat(vista.costoInventarioTextField.getText()));
            modelo.setSucursal(vista.comboBoxSucursal.getSelectedItem().toString());
            //modelo.setIdSucursal(Integer.parseInt(vista.comboBoxSucursal.getSelectedItem().toString()));
            modelo.setEstatusArticulo(vista.estatusInventarioTextField.getText());
            
            if(consulta.registrarArticulo(modelo)){
                
                JOptionPane.showMessageDialog(null, "Articulo guardado");
                limpiar();
                
            }else{
                
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiar();
                
            }
        }
        
        if(e.getSource() == vista.modificarInventarioBoton){
            
            modelo.setIdArticulo(Integer.parseInt(vista.buscarInventarioTextField.getText()));
            modelo.setNombreArticulo(vista.articuloInventarioTextField.getText());
            modelo.setCantidadArticulo(Integer.parseInt(vista.cantidadInventarioTextField.getText()));
            modelo.setCostoArticulo(Float.parseFloat(vista.costoInventarioTextField.getText()));
            modelo.setSucursal(vista.comboBoxSucursal.getSelectedItem().toString());
            modelo.setEstatusArticulo(vista.estatusInventarioTextField.getText());
            
            if(consulta.modificarArticulo(modelo)){
                
                JOptionPane.showMessageDialog(null, "Articulo modificado");
                limpiar();
                
            }else{
                
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiar();
                
            }
        }
        
        if(e.getSource() == vista.eliminarInventarioBoton){
            
            modelo.setIdArticulo(Integer.parseInt(vista.buscarInventarioTextField.getText()));
            
            if(consulta.eliminarArticulo(modelo)){
                JOptionPane.showMessageDialog(null, "Articulo eliminado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();
            }
        }
        
        if(e.getSource() == vista.buscarInventarioBoton){
            
            modelo.setNombreArticulo(vista.articuloInventarioTextField.getText());
            
            if(consulta.buscarArticulo(modelo)){
                vista.buscarInventarioTextField.setText(Integer.toString(modelo.getIdArticulo()));
                vista.articuloInventarioTextField.setText(modelo.getNombreArticulo());
                vista.cantidadInventarioTextField.setText(Integer.toString(modelo.getCantidadArticulo()));
                vista.costoInventarioTextField.setText(Float.toString(modelo.getCostoArticulo()));
                vista.comboBoxSucursal.setSelectedItem(modelo.getSucursal());
                vista.estatusInventarioTextField.setText(modelo.getEstatusArticulo());
            }else {
                JOptionPane.showMessageDialog(null, "No se encontró registro");
                limpiar();
            }
        }
        
        if(e.getSource() == vista.limpiarInventarioBoton){
            limpiar();
        }
    }
    
    

    private void limpiar() {
        
        vista.articuloInventarioTextField.setText(null);
        vista.cantidadInventarioTextField.setText(null);
        vista.costoInventarioTextField.setText(null);
        vista.estatusInventarioTextField.setText(null);
    }
   
}
