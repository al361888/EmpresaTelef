package Modelo.fabrica_tarifa;

import Modelo.tarifa.Basica;
import Modelo.tarifa.FinSemana;
import Modelo.tarifa.Tarde;
import Modelo.tarifa.Tarifa;

public class FabricaTarifas implements FabricaT{


    @Override
    public Tarifa getBasica() {
        return new Basica();
    }

    @Override
    public Tarifa getTarde(Tarifa tarifa) {
        return new Tarde(tarifa);
    }

    @Override
    public Tarifa getFinSemana(Tarifa tarifa) {
        return new FinSemana(tarifa);
    }
}
