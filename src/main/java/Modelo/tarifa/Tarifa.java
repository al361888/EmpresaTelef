package Modelo.tarifa;

import Modelo.llamada.Llamada;

import java.io.Serializable;

/**
 * Created by al361888 on 27/02/18.
 */
public abstract class Tarifa implements Serializable{ //Done
    private double precio; // €/min

    //Constructores
    public Tarifa(){
        precio = 0.20;
    }

    public Tarifa(double precio){
        this.precio = precio;
    }

    //Métodos
    public double getPrecio(){
        return precio;
    }

    public abstract double costeLlamada(Llamada llamada);


    @Override
    public String toString(){
        return precio + "(€/min)";
    }

}