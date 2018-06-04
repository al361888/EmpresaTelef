package Modelo.factura;


import Modelo.fecha.Fecha;
import Modelo.tarifa.Tarifa;

import java.time.LocalDateTime;

public class Factura implements Fecha{
    private String cod; //Único de cada Modelo.factura
    private Tarifa tarifa; //(€/min)
    private LocalDateTime fechaEmision;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechafin;
    private double importe;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    @Override
    public LocalDateTime getFecha() {
        return fechaEmision;
    }

    public void setFecha(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechafin() {
        return fechafin;
    }

    public void setFechafin(LocalDateTime fechafin) {
        this.fechafin = fechafin;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "Código: " + cod + "\nModelo.tarifa: " + tarifa + "\nModelo.fecha de emisión: " + fechaEmision +"\nPeriodo: " + fechaInicio + "-" + fechafin + "\nImporte: " + importe;
    }
}
