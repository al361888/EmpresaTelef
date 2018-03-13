package Datos;

import es.uji.belfern.generador.GeneradorDatosINE;

public class Generador {

    public static void main( String[] args){
        GeneradorDatosINE ine = new GeneradorDatosINE();
        for(int i = 0; i < 100; i++){
            System.out.println("Hombre: " + ine.getNombreHombre());
            System.out.println("Mujer: " + ine.getNombreMujer());
            System.out.println("Random nombre: " + ine.getNombre());
            String provincia = ine.getProvincia();
            System.out.println("Provincia: " + provincia);
            System.out.println("Poblacion: " + ine.getPoblacion(provincia));
            System.out.println("DNI: " + ine.getNIF());
        }

    }
}