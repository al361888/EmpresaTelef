package Modelo.cliente;

import Modelo.direccion.Direccion;

import java.time.LocalDateTime;

/**
 * Created by al361888 on 27/02/18.
 */
public class Empresa extends Cliente {

    public Empresa(){
        super();
    }

    public Empresa(String nombre, String nif, String email, Direccion direccion){
        super(nombre,nif,email,direccion);
    }

    @Override
    public LocalDateTime getFecha() {
        return super.getFecha();
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + "\nNIF: " + getNIF() + "\nE-mail: " + getEmail() +"\nModelo.fecha de alta: "
                + getFecha().toString() + "\nDirección" + getDireccion().toString() + "\nLLamadas: " + getLlamadas().toString() + "\nFacturas: " + getFacturas().toString();
    }
}
