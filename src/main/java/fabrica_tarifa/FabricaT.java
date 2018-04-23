package fabrica_tarifa;

import tarifa.Tarifa;

public interface FabricaT {
    Tarifa getTarifa();
    Tarifa getTarifa(double precio);
}
