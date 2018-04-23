package cliente;

import direccion.Direccion;
import factura.Factura;
import fecha.Fecha;
import llamada.Llamada;
import tarifa.Tarifa;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by al361888 on 27/02/18.
 */

public abstract class Cliente implements Fecha{
    private String nombre;
    private String NIF;
    private String email;
    private Date fechaAlta;
    private Direccion direccion;
    private Tarifa tarifa;
    private HashSet<Llamada> llamadas;
    private HashMap<String,Factura> facturas;

    //Constructores
    public Cliente(){
        nombre = null;
        NIF = null;
        email = null;
        fechaAlta = new Date();
        direccion = new Direccion();
        tarifa = new Tarifa();
        llamadas = new HashSet<Llamada>();
        facturas = new HashMap<String, Factura>();
    }

    public Cliente(String nombre, String NIF,String email, Direccion direccion){
        this.nombre = nombre;
        this.NIF = NIF;
        this.email = email;
        this.fechaAlta = new Date();
        this.direccion = direccion;
        this.tarifa = new Tarifa();
        this.llamadas = new HashSet<>();
        this.facturas = new HashMap<>();
    }

    //Métodos
    @Override
    public Date getFecha() {
        return fechaAlta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public HashMap<String,Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(HashMap<String,Factura> facturas) {
        this.facturas = facturas;
    }

    public boolean anadirFactura(Factura factura){
        if (factura==null)
            return false;
        else{
            facturas.put(factura.getCod(),factura);
            return true;
        }
    }

    public Factura encontrarFactura(String cod){
        if (facturas.containsKey(cod)){
            return facturas.get(cod);
        }
        return null;
    }

    public HashSet<Llamada> getLlamadas() {
        return llamadas;
    }

    public void setLlamadas(HashSet<Llamada> llamadas) {
        this.llamadas = llamadas;
    }

    public boolean anadirLlamada(Llamada llamada){
        if (llamada==null)
            return false;
        else{
            llamadas.add(llamada);
            return true;
        }
    }



    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nNIF: " + NIF + "\nE-mail: " + email +"\nfecha de alta: "
                + fechaAlta.toString() + "\nDirección" + direccion.toString() + "\nLLamadas: " + llamadas.toString() + "\nFacturas: " + facturas.toString();
    }

}