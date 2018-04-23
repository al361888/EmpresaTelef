package llamada;

import excepciones.MiExcepcion;
import fecha.Fecha;
import tarifa.Tarifa;

import java.util.Date;

public class Llamada implements Fecha{
    private String numero;
    private Date fecha;
    private double duracion; //No muy claro el tipo de dato
    private double importe;

    public Llamada(){
        numero = null;
        fecha = null;
        duracion = 0;
    }

    public Llamada(String numero, Date fecha, Double duracion, Tarifa tarifa){
        this.numero = numero;
        this.fecha = fecha;
        this.duracion = duracion;
        this.importe = tarifa.costeLlamada(this);
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
        return "Número : " + numero + "\nfecha: " + fecha + "\nDuración: " + duracion;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}