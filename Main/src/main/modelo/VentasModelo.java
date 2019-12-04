/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import main.controlador.ConexionBD;

/**
 *
 * @author Juan Manuel Arreola
 */
public class VentasModelo extends ConexionBD{
    
    private int idArticulo;
    private String nombreArticulo;
    private int cantidad;
    private float costo;
    private float total;
    private String empleado;
    private String cliente;
    private float comisionempleado;
    private float comisioncliente;

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public float getComisionempleado() {
        return comisionempleado;
    }

    public void setComisionempleado(float comisionempleado) {
        this.comisionempleado = comisionempleado;
    }

    public float getComisioncliente() {
        return comisioncliente;
    }

    public void setComisioncliente(float comisioncliente) {
        this.comisioncliente = comisioncliente;
    }
    
}
