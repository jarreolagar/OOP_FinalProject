/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.modelo;

/**
 *
 * @author Juan Manuel Arreola
 */
public class InventarioModelo {
    
    private int idArticulo;
    private String nombreArticulo;
    private int cantidadArticulo;
    private float costoArticulo;
    private int idSucursal;
    private String estatusArticulo;
    private String sucursal;

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

    public int getCantidadArticulo() {
        return cantidadArticulo;
    }

    public void setCantidadArticulo(int cantidadArticulo) {
        this.cantidadArticulo = cantidadArticulo;
    }

    public float getCostoArticulo() {
        return costoArticulo;
    }

    public void setCostoArticulo(float costoArticulo) {
        this.costoArticulo = costoArticulo;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getEstatusArticulo() {
        return estatusArticulo;
    }

    public void setEstatusArticulo(String estatusArticulo) {
        this.estatusArticulo = estatusArticulo;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
    
    
    
}
