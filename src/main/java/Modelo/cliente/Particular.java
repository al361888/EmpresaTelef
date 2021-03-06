package Modelo.cliente;

import Modelo.direccion.Direccion;

import java.time.LocalDateTime;

/**
 * Created by al361888 on 27/02/18.
 */
public class Particular extends Cliente {

    private String apellidos;

    public Particular(){
        super();
        this.apellidos = null;
    }

    public Particular(String nombre, String nif, String email, Direccion direccion, String apellidos){
        super(nombre,nif,email,direccion);
        this.apellidos = apellidos;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public LocalDateTime getFecha() {
        return super.getFecha();
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() +"\nApellidos"+ apellidos+ "\nNIF: " + getNIF() + "\nE-mail: " + getEmail() +"\nModelo.fecha de alta: "
                + getFecha().toString() + "\nDirección" + getDireccion().toString() + "\nLLamadas: " + getLlamadas().toString() + "\nFacturas: " + getFacturas().toString() ;
    }
}
