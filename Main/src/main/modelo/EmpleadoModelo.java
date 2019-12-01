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
public class EmpleadoModelo {
    
    private int idEmpleado;
    private String nombreEmpleado;
    private String cargoEmpleado;
    private float salarioEmpleado;
    private String horarioEmpleado;
    private float comisionesEmpleado;

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getCargoEmpleado() {
        return cargoEmpleado;
    }

    public void setCargoEmpleado(String cargoEmpleado) {
        this.cargoEmpleado = cargoEmpleado;
    }

    public float getSalarioEmpleado() {
        return salarioEmpleado;
    }

    public void setSalarioEmpleado(float salarioEmpleado) {
        this.salarioEmpleado = salarioEmpleado;
    }
    
    public String getHorarioEmpleado() {
        return horarioEmpleado;
    }

    public void setHorarioEmpleado(String horarioEmpleado) {
        this.horarioEmpleado = horarioEmpleado;
    }

    public float getComisionesEmpleado() {
        return comisionesEmpleado;
    }

    public void setComisionesEmpleado(float comisionesEmpleado) {
        this.comisionesEmpleado = comisionesEmpleado;
    }
    
    
    
}
