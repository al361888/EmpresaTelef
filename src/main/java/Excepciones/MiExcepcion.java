package Excepciones;


public class MiExcepcion extends Exception{

    public MiExcepcion(){
        super("El número de teléfono debe tener 9 dígitos.");
    }
}
