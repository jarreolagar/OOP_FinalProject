/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.modelo;

import javax.swing.JTextField;

/**
 *
 * @author Juan Manuel Arreola
 */
public class ClienteModel {
    
    private int id;
    private String nombreCliente;
    private String sexo;
    private String fechaNacimiento;
    private float tarjeta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public float getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(float tarjeta) {
        this.tarjeta = tarjeta;
    }
    
}
