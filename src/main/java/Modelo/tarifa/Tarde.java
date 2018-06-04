package Modelo.tarifa;

import Modelo.llamada.Llamada;

public class Tarde extends Oferta{

    public Tarde(Tarifa tarifa){
        super(tarifa,0.15);
    }

    @Override
    public double costeLlamada(Llamada llamada) {
        double anterior = getTarifa().costeLlamada(llamada);
        double nuevo = llamada.getDuracion()*getPrecio();
        if(anterior > nuevo){
            if(llamada.getFecha().getHour() >= 17)
            return nuevo;
        }

        return anterior;
    }
}
