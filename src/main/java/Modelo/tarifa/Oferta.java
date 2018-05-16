package Modelo.tarifa;

public abstract class Oferta extends Tarifa{

    private Tarifa tarifa;

    public Oferta(Tarifa tarifa, double precio){
        super(precio);
        this.tarifa = tarifa;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

}
