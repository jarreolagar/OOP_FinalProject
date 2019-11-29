/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import main.ClienteView;
import main.modelo.ClienteModel;
import main.modelo.ConsultasBD;
import main.vista.ClienteVista;

/**
 *
 * @author Juan Manuel Arreola
 */
public class ClienteControlador implements ActionListener {

    private ClienteVista vista;
    private ClienteModel cltemodel;
    private ConsultasBD cltsBD;

    public ClienteControlador(ClienteVista vista, ClienteModel cltemodel, ConsultasBD cltsBD) {
        this.vista = vista;
        this.cltemodel = cltemodel;
        this.cltsBD = cltsBD;
        //Declarar ActionListener Botones
        this.vista.clienteGuardarButton.addActionListener(this);
        this.vista.clienteModificarButton.addActionListener(this);
        this.vista.clienteEliminarButton.addActionListener(this);
        this.vista.clienteLimpiarButton.addActionListener(this);
        this.vista.clienteBuscarButton.addActionListener(this);
    }


    //METODO PARA QUE PUEDA INICIAR LA VISTA
    public void iniciarVistaCliente() {
        vista.setTitle("Clientes");
        vista.setLocationRelativeTo(null);
        vista.clienteIdTextField.setVisible(false);
    }

    //METODO PARA TRAER EL EVENTO DEL BOTÓN SELECCIONADO
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.clienteGuardarButton) {
            cltemodel.setNombreCliente(vista.clienteNombreTextField.getText());
            cltemodel.setApellidoCliente(vista.clienteApellidoTextField.getText());
            cltemodel.setSexo(vista.clienteSexoTextField.getText());
            cltemodel.setFechaNacimiento(vista.clienteFNTextField.getText());
            cltemodel.setTarjeta(Float.parseFloat(vista.clienteTarjetaTextField.getText()));

            if (cltsBD.registrarCliente(cltemodel)) {
                JOptionPane.showMessageDialog(null, "Cliente guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiar();
            }
        }

        if (e.getSource() == vista.clienteModificarButton) {
            cltemodel.setId(Integer.parseInt(vista.clienteIdTextField.getText()));
            cltemodel.setNombreCliente(vista.clienteNombreTextField.getText());
            cltemodel.setApellidoCliente(vista.clienteApellidoTextField.getText());
            cltemodel.setSexo(vista.clienteSexoTextField.getText());
            cltemodel.setFechaNacimiento(vista.clienteFNTextField.getText());
            cltemodel.setTarjeta(Float.parseFloat(vista.clienteTarjetaTextField.getText()));

            if (cltsBD.modificarCliente(cltemodel)) {
                JOptionPane.showMessageDialog(null, "Cliente modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiar();
            }
        }
        
        if (e.getSource() == vista.clienteEliminarButton) {
            cltemodel.setId(Integer.parseInt(vista.clienteIdTextField.getText()));
          
            if (cltsBD.eliminarCliente(cltemodel)) {
                JOptionPane.showMessageDialog(null, "Cliente eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();
            }
        }
        
        if (e.getSource() == vista.clienteBuscarButton) {
            cltemodel.setNombreCliente(vista.clienteNombreTextField.getText());
          
            if (cltsBD.buscarCliente(cltemodel)) {
                
                vista.clienteIdTextField.setText(Integer.toString(cltemodel.getId()));
                vista.clienteNombreTextField.setText(cltemodel.getNombreCliente());
                vista.clienteApellidoTextField.setText(cltemodel.getApellidoCliente());
                vista.clienteSexoTextField.setText(cltemodel.getSexo());
                vista.clienteFNTextField.setText(cltemodel.getFechaNacimiento());
                vista.clienteTarjetaTextField.setText(""+cltemodel.getTarjeta());
                
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró registro");
                limpiar();
            }
        }
        
        if(e.getSource() == vista.clienteLimpiarButton){
            limpiar();
        }
    }

    public void limpiar() {
        vista.clienteIdTextField.setText(null);
        vista.clienteNombreTextField.setText(null);
        vista.clienteApellidoTextField.setText(null);
        vista.clienteSexoTextField.setText(null);
        vista.clienteFNTextField.setText(null);
        vista.clienteTarjetaTextField.setText(null);
    }

}
