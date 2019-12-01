/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import main.modelo.ConsultasEmpleadoBD;
import main.modelo.EmpleadoModelo;
import main.vista.EmpleadoVista;

/**
 *
 * @author Juan Manuel Arreola
 */
public class EmpleadoControlador implements ActionListener {

    private EmpleadoVista viewEmpleado;
    private EmpleadoModelo emModelo;
    private ConsultasEmpleadoBD conEmpleado;

    public EmpleadoControlador(EmpleadoVista viewEmpleado, EmpleadoModelo emModelo, ConsultasEmpleadoBD conEmpleado) {
        this.viewEmpleado = viewEmpleado;
        this.emModelo = emModelo;
        this.conEmpleado = conEmpleado;
        //DECLARAR ACTION LISTENER BOTONES
        this.viewEmpleado.empleadoGuardarBoton.addActionListener(this);
        this.viewEmpleado.empleadoModificarBoton.addActionListener(this);
        this.viewEmpleado.empleadoEliminarBoton.addActionListener(this);
        this.viewEmpleado.empleadoBuscarBoton.addActionListener(this);
        this.viewEmpleado.empleadoLimpiarBoton.addActionListener(this);
    }

    public void iniciarVistaEmpleado() {
        viewEmpleado.setTitle("Empleados");
        viewEmpleado.setLocationRelativeTo(null);
        viewEmpleado.idEmpleadoTextField.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == viewEmpleado.empleadoGuardarBoton) {

            emModelo.setNombreEmpleado(viewEmpleado.empleadoNombreTextField.getText());
            emModelo.setCargoEmpleado(viewEmpleado.cargoEmpleadoTextField.getText());
            emModelo.setSalarioEmpleado(Float.parseFloat(viewEmpleado.salarioEmpleadoTextField.getText()));
            emModelo.setHorarioEmpleado(viewEmpleado.horarioEmpleadoTextField.getText());
            emModelo.setComisionesEmpleado(Float.parseFloat(viewEmpleado.comisionesEmpleadoTextField.getText()));

            if (conEmpleado.registrarEmpleado(emModelo)) {
                JOptionPane.showMessageDialog(null, "Empleado guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiar();
            }

        }

        if (e.getSource() == viewEmpleado.empleadoModificarBoton) {

            emModelo.setIdEmpleado(Integer.parseInt(viewEmpleado.idEmpleadoTextField.getText()));
            emModelo.setNombreEmpleado(viewEmpleado.empleadoNombreTextField.getText());
            emModelo.setCargoEmpleado(viewEmpleado.cargoEmpleadoTextField.getText());
            emModelo.setSalarioEmpleado(Float.parseFloat(viewEmpleado.salarioEmpleadoTextField.getText()));
            emModelo.setHorarioEmpleado(viewEmpleado.horarioEmpleadoTextField.getText());
            emModelo.setComisionesEmpleado(Float.parseFloat(viewEmpleado.comisionesEmpleadoTextField.getText()));

            if (conEmpleado.modificarEmpleado(emModelo)) {
                JOptionPane.showMessageDialog(null, "Empleado modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiar();
            }
        }

        if (e.getSource() == viewEmpleado.empleadoEliminarBoton) {
            emModelo.setNombreEmpleado(viewEmpleado.empleadoNombreTextField.getText());

            if (conEmpleado.eliminarEmpleado(emModelo)) {
                JOptionPane.showMessageDialog(null, "Empleado eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();
            }
        }

        if (e.getSource() == viewEmpleado.empleadoBuscarBoton) {
            emModelo.setNombreEmpleado(viewEmpleado.empleadoNombreTextField.getText());

            if (conEmpleado.buscarEmpleado(emModelo)) {

               viewEmpleado.idEmpleadoTextField.setText(Integer.toString(emModelo.getIdEmpleado()));
               viewEmpleado.empleadoNombreTextField.setText(emModelo.getNombreEmpleado());
               viewEmpleado.cargoEmpleadoTextField.setText(emModelo.getCargoEmpleado());
               viewEmpleado.salarioEmpleadoTextField.setText(Float.toString(emModelo.getSalarioEmpleado()));
               viewEmpleado.horarioEmpleadoTextField.setText(emModelo.getHorarioEmpleado());
               viewEmpleado.comisionesEmpleadoTextField.setText(Float.toString(emModelo.getComisionesEmpleado()));

            } else {
                JOptionPane.showMessageDialog(null, "No se encontró registro");
                limpiar();
            }
        }

        if (e.getSource() == viewEmpleado.empleadoLimpiarBoton) {
            limpiar();
        }
    }

    public void limpiar() {
        viewEmpleado.empleadoNombreTextField.setText(null);
        viewEmpleado.cargoEmpleadoTextField.setText(null);
        viewEmpleado.salarioEmpleadoTextField.setText(null);
        viewEmpleado.horarioEmpleadoTextField.setText(null);
        viewEmpleado.comisionesEmpleadoTextField.setText(null);
    }

}
