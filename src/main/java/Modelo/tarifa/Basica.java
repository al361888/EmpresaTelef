package Modelo.tarifa;

import Modelo.llamada.Llamada;

public class Basica extends Tarifa {

    public Basica(){
        super(0.15);
    }

    //Calcular el coste de una Modelo.llamada
    @Override
    public double costeLlamada(Llamada llamada) {
        return llamada.getDuracion()*getPrecio();
    }


}
