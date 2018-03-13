package Tarifa;

/**
 * Created by al361888 on 27/02/18.
 */
public class Tarifa { //Done
    private double precio; // €/min
    double defecto = 0.01; //€/min

    //Constructores
    public Tarifa(){
        precio = defecto;
    }

    public Tarifa(double precio){
        this.precio = precio;
    }

    //Métodos
    public double getPrecio(){
        return precio;
    }

    public void setPrecio(double nuevo){
        this.precio = nuevo;
    }

    @Override
    public String toString(){
        return precio + "(€/min)";
    }
}