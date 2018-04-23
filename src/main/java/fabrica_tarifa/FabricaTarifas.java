package fabrica_tarifa;

import tarifa.Basica;
import tarifa.FinSemana;
import tarifa.Tarde;
import tarifa.Tarifa;

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
