package Factura;


import Fecha.Fecha;

import java.util.Date;

public class Factura implements Fecha{
    private String cod; //Único de cada factura
    private String tarifa; //(€/min)
    private Date fechaEmision;
    private Date fechaInicio;
    private Date fechafin;
    private double importe;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getTarifa() {
        return tarifa;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    @Override
    public Date getFecha() {
        return fechaEmision;
    }

    public void setFecha(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
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
        return "Código: " + cod + "\nTarifa: " + tarifa + "\nFecha de emisión: " + fechaEmision +"\nPeriodo: " + fechaInicio + "-" + fechafin + "\nImporte: " + importe;
    }
}
