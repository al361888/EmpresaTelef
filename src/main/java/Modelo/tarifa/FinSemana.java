package Modelo.tarifa;

import Modelo.llamada.Llamada;

public class FinSemana extends Oferta{

    public FinSemana(Tarifa tarifa){
        super(tarifa, 0.00);
    }
    @Override
    public double costeLlamada(Llamada llamada) {
        double anterior = getTarifa().costeLlamada(llamada);
        double nuevo = llamada.getDuracion()*getPrecio();
        if(anterior > nuevo)
            return nuevo;
        return anterior;
    }
}
