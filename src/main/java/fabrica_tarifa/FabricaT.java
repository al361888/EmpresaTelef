package fabrica_tarifa;

import tarifa.Tarifa;

public interface FabricaT {
    Tarifa getBasica();
    Tarifa getTarde(Tarifa tarifa);
    Tarifa getFinSemana(Tarifa tarifa);
}
