package Llamada;

import Fecha.Fecha;

import java.sql.Time;
import java.util.Date;
import java.util.Timer;

public class Llamada implements Fecha{
    private String numero;
    private Date fecha;
    private double duracion; //No muy claro el tipo de dato

    public Llamada(){
        numero = null;
        fecha = null;
        duracion = 0;
    }

    public Llamada(String numero, Date fecha, double duracion){
        this.numero = numero;
        this.fecha = fecha;
        this.duracion = duracion;
    }

    @Override
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Número : " + numero + "\nFecha: " + fecha + "\nDuración: " + duracion;
    }

}