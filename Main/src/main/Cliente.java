/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import java.util.*;

/**
 *
 * @author Juan Manuel Arreola
 */
public class Cliente {

    private int id;
    private String nombre;
    private String fNacimiento;
    private String sexo;
    private String correo;
    private String telefono;
    private float tarjetaPuntos = 0;
    public int op;

    Scanner leer = new Scanner(System.in);
    //Arreglo de objetos
    Cliente myCliente[] = new Cliente[10];

    public Cliente() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(String fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public float getTarjetaPuntos() {
        return tarjetaPuntos;
    }

    public void setTarjetaPuntos(float tarjetaPuntos) {
        this.tarjetaPuntos = tarjetaPuntos;
    }

    //Hacer Menú
    public void menu() {

            System.out.println("MENU CLIENTES\n");
            System.out.println("1. Alta Cliente\n");
            System.out.println("2. Baja Cliente\n");
            System.out.println("3. Modificar\n");
            System.out.println("Inserte opción: ");
            op = leer.nextInt();

            switch (op) {

                case 1:
                    altaCliente();
                    break;
                case 2:
                    bajaCliente();
                    break;
                case 3:
                    modificarCliente();
                    break;
                default:
                    System.out.println("Ingrese una opción válida.");

            }

        
        
    }

    public void altaCliente(){
        
        for(int i=0; i< myCliente.length; i++){
            
            System.out.println("Ingrese ID: ");
            id = leer.nextInt();
            leer.nextLine();
            System.out.println("Ingrese nombre: ");
            nombre = leer.nextLine();
            System.out.println("Ingrese Fecha de Nacimiento: ");
            fNacimiento = leer.nextLine();
            System.out.println("Ingrese sexo: ");
            sexo = leer.nextLine();
            System.out.println("Ingrese correo: ");
            correo = leer.nextLine();
            System.out.println("Ingrese teléfono: ");
            telefono = leer.nextLine();
            
        }
    }
    
    public void bajaCliente(){
        
        System.out.println("BAJAS");
        
    }
    
    public void modificarCliente(){
        
        System.out.println("MODIFICAR");
        
    }
}

