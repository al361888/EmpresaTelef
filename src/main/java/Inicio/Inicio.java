package Inicio;

import Direccion.Direccion;
import cliente.Cliente;
import cliente.ClienteManager;
import cliente.Empresa;
import cliente.Particular;

import java.util.Scanner;

public class Inicio {

    private static ClienteManager listaClientes;

    public static void main( String[] args){
        Scanner scan = new Scanner(System.in);
        int eleccion;
        while (true){
            System.out.println("--FACTURAPPS--");
            System.out.println("¿Qué quieres hacer? (Pulsa el número correspondiente a la elección deseada)");
            System.out.println("(1) Nuevo cliente ");
            System.out.println("(2) Borrar cliente");
            System.out.println("(3) Cambiar tarifa");
            System.out.println("(4) Recuperar datos asociados a NIF");
            System.out.println("(5) Lista de clientes");
            System.out.println("(6) Dar de alta una llamada");
            System.out.println("(7) Listar llamadas del cliente");
            System.out.println("(8) Emitir factura del cliente");
            System.out.println("(9) Recuperar datos de factura");
            System.out.println("(10) Recuperar facturas del cliente");
            System.out.println("Elige: ");

            while (true){
                try {
                    eleccion = scan.nextInt();
                    break;
                }catch (Exception e){
                    System.exit(0);
                }

            }

            switch (eleccion){
                case 1:
                    altaCliente();
                    break;
                case 2:
                    borradoCliente();
                    break;
                case 3:
                    cambioTarifa();
                    break;
                case 4:
                    recuperarDatosNIF();
                    break;
                case 5:
                    recuperarListaClientes();
                    break;
                case 6:
                    altaLlamada();
                    break;
                case 7:
                    listaLlamadas();
                    break;
                case 8:
                    importeFactura();
                    break;
                case 9:
                    mostrarFacura();
                    break;
                case 10:
                    listaFacturas();
                    break;
                default:
                    System.out.println("Elección no válida.");
                    break;
            }
        }

    }


    private static String inputDato(String mensaje){
        Scanner scan = new Scanner(System.in);
        String eleccion = "";
        try {
            System.out.println(mensaje);
            eleccion = scan.nextLine();
        }catch (Exception e){
            return eleccion;
        }
        return eleccion;
    }

    private static void rellenarDireccion(Direccion d){
        d.setCp(inputDato("Código postal: "));
        d.setPoblacion(inputDato("Población: "));
        d.setProvincia(inputDato("Provincia: "));
    }

    private static void rellenarParticular(Particular p){
        p.setNIF(inputDato("NIF: "));
        p.setNombre(inputDato("Nombre: "));
        p.setApellidos(inputDato("Apellidos: "));
        p.setEmail(inputDato("Email: "));
        rellenarDireccion(p.getDireccion());
    }

    private static void rellenarEmpresa(Empresa e) { //Optimizar
        e.setNIF(inputDato("NIF: "));
        e.setNombre(inputDato("Nombre: "));
        e.setEmail(inputDato("Email: "));
        rellenarDireccion(e.getDireccion());
    }

    private static boolean altaCliente() {
        System.out.println("¿Qué tipo de cliente eres?");
        System.out.println("(1) Particular");
        System.out.println("(2) Empresa");
        String eleccion = "";
        eleccion = inputDato("Escribe el número correspondiente a la opción deseada: ");
        if (eleccion == "1"){
            Particular nuevo = new Particular();
            rellenarParticular(nuevo);
            listaClientes.nuevoCliente(nuevo);
        }else if (eleccion == "2"){
            Empresa nuevo = new Empresa();
            rellenarEmpresa(nuevo);
        }else{
            System.out.println("Por favor, elige una opción válida.");
            return false;
        }

        return true;
    }



    private static void borradoCliente() {


    }

    private static void cambioTarifa() {

    }

    private static void recuperarDatosNIF(){

    }

    private static void recuperarListaClientes() {

    }

    private static void altaLlamada() {

    }

    private static void listaLlamadas() {

    }

    private static void importeFactura() {

    }

    private static void mostrarFacura() {

    }

    private static void listaFacturas() {

    }

}
