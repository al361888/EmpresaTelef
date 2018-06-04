package Modelo.llamada;

import Modelo.excepciones.MiExcepcion;
import Modelo.fecha.Fecha;
import Modelo.tarifa.Tarifa;

import java.time.LocalDateTime;

public class Llamada implements Fecha{
    private String numero;
    private LocalDateTime fecha;
    private double duracion; //No muy claro el tipo de dato
    private double importe;

    public Llamada(String numero, LocalDateTime fecha, Double duracion, Tarifa tarifa){
        this.numero = numero;
        this.fecha = fecha;
        this.duracion = duracion;
        this.importe = tarifa.costeLlamada(this);
    }

    @Override
    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
            this.fecha = fecha;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) throws MiExcepcion {
        if (numero.length()!=9)
            throw new MiExcepcion();
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
        return "Número : " + numero + "\nModelo.fecha: " + fecha + "\nDuración: " + duracion;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}