/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import main.modelo.ConsultasVentasBD;
import main.modelo.VentasModelo;
import main.vista.VentasVista;

/**
 *
 * @author Juan Manuel Arreola
 */
public class VentasControlador implements ActionListener {

    private VentasVista vistaventa;
    private VentasModelo modeloventa;
    private ConsultasVentasBD consultaventa;

    public VentasControlador(VentasVista vistaventa, VentasModelo modeloventa, ConsultasVentasBD consultaventa) {
        this.vistaventa = vistaventa;
        this.modeloventa = modeloventa;
        this.consultaventa = consultaventa;

        this.vistaventa.buscarProd.addActionListener(this);
    }

    public void iniciarVistaVentas() {
        vistaventa.setTitle("Ventas");
        vistaventa.setLocationRelativeTo(null);
        vistaventa.idarticuloventa.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vistaventa.venderBoton) {

            modeloventa.setCantidad(Integer.parseInt(vistaventa.cantidadVentaText.getText()));

            if (consultaventa.ventaArticulo(modeloventa)) {
                JOptionPane.showMessageDialog(null, "Vendido");
            } else {
                JOptionPane.showMessageDialog(null, "No vendido");
            }

        }

        if (e.getSource() == vistaventa.buscarProd) {

            modeloventa.setNombreArticulo(vistaventa.articuloVentaText.getText());

            if (consultaventa.buscarArti(modeloventa)) {

                vistaventa.idarticuloventa.setText(Integer.toString(modeloventa.getIdArticulo()));
                vistaventa.articuloVentaText.setText(modeloventa.getNombreArticulo());
                vistaventa.costoVentaText.setText(Float.toString(modeloventa.getCosto()));

            } else {
                JOptionPane.showMessageDialog(null, "No se encontró registro");

            }
        }
    }

}
