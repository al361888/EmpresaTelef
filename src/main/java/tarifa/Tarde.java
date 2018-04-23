package tarifa;

import llamada.Llamada;

public class Tarde extends Oferta{

    public Tarde (Tarifa tarifa){
        super(tarifa,0.15);
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
