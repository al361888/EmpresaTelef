package fabrica_tarifa;

import tarifa.Tarifa;

public class FabricaTarifas implements FabricaT{

    @Override
    public Tarifa getTarifa() {
        return new Tarifa();
    }

    @Override
    public Tarifa getTarifa(double precio) {
        return new Tarifa(precio);
    }
}
