package Modelo.fabrica_tarifa;

import Modelo.tarifa.Tarifa;

public interface FabricaT {
    Tarifa getBasica();
    Tarifa getTarde(Tarifa tarifa);
    Tarifa getFinSemana(Tarifa tarifa);
}
