package tarifa;

import llamada.Llamada;

public class Basica extends Tarifa {

    public Basica(){
        super(0.20);
    }

    //Calcular el coste de una llamada
    @Override
    public double costeLlamada(Llamada llamada) {
        return llamada.getDuracion()*getPrecio();
    }


}
