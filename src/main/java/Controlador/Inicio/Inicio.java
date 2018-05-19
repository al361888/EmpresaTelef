package Controlador.Inicio;

import Modelo.direccion.Direccion;
import Modelo.fabrica_tarifa.FabricaTarifas;
import Modelo.factura.Factura;
import Modelo.fecha.Fecha;
import Modelo.llamada.Llamada;
import Modelo.tarifa.Tarifa;
import Modelo.cliente.Cliente;
import Modelo.cliente.ClienteManager;
import Modelo.cliente.Empresa;
import Modelo.cliente.Particular;
import Modelo.fabrica_clientes.FabricaClientes;

import javax.swing.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Inicio {

    private static ClienteManager listaClientes;
    private static FabricaClientes fabricaClientes;
    private static FabricaTarifas fabricaTarifas;

    private static void menu() {
        cargarDatos();
        Scanner scan = new Scanner(System.in);
        int eleccion;
        while (true) {
            System.out.println("----FACTURAPPS----");
            System.out.println("¿Qué quieres hacer? (Pulsa el número correspondiente a la elección deseada)");
            System.out.println("(1) Nuevo Modelo.cliente ");
            System.out.println("(2) Borrar Modelo.cliente");
            System.out.println("(3) Cambiar Modelo.tarifa");
            System.out.println("(4) Recuperar Modelo.datos asociados a NIF");
            System.out.println("(5) Lista de clientes");
            System.out.println("(6) Dar de alta una Modelo.llamada");
            System.out.println("(7) Listar llamadas del Modelo.cliente");
            System.out.println("(8) Emitir Modelo.factura del Modelo.cliente");
            System.out.println("(9) Recuperar Modelo.datos de Modelo.factura");
            System.out.println("(10) Recuperar facturas del Modelo.cliente");
            System.out.println("(11) Mostrar clientes que operaron entre dos fechas");
            System.out.println("(12) Mostrar las llamadas de un Modelo.cliente entre dos fechas");
            System.out.println("(13) Mostrsr las facturas de un Modelo.cliente entre dos fechas");
            System.out.println("(14) Salir (guardar Modelo.datos)");
            System.out.println("Elige: ");

            while (true) {
                try {
                    eleccion = scan.nextInt();
                    break;
                } catch (Exception e) {
                    System.exit(0);
                }

            }

            switch (eleccion) {
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
                    mostrarFactura();
                    break;
                case 10:
                    listaFacturas();
                    break;
                case 11:
                    listadoClientes();
                    break;
                case 12:
                    listadoLlamadas();
                    break;
                case 13:
                    listadoFacturas();
                    break;
                case 14:
                    guardarDatos();
                    break;
                default:
                    System.out.println("Elección no válida.");
                    break;
            }
        }
    }


    private static String inputDato(String mensaje) {
        Scanner scan = new Scanner(System.in);
        String eleccion = "";
        try {
            System.out.println(mensaje);
            eleccion = scan.nextLine();
        } catch (Exception e) {
            return eleccion;
        }
        return eleccion;
    }

    private static void rellenarDireccion(Direccion d) {
        d.setCp(inputDato("Código postal: "));
        d.setPoblacion(inputDato("Población: "));
        d.setProvincia(inputDato("Provincia: "));
    }

    private static void rellenarParticular(Particular p) {
        if (p!=null){
            p.setNIF(inputDato("NIF: "));
            p.setNombre(inputDato("Nombre: "));
            p.setApellidos(inputDato("Apellidos: "));
            p.setEmail(inputDato("Email: "));
            rellenarDireccion(p.getDireccion());
        } else
            System.out.println("Parámetro nulo.");
    }

    private static void rellenarEmpresa(Empresa e) { //Optimizar
        if(e!=null){
            e.setNIF(inputDato("NIF: "));
            e.setNombre(inputDato("Nombre: "));
            e.setEmail(inputDato("Email: "));
            rellenarDireccion(e.getDireccion());
        }else
            System.out.println("Parámetro nulo.");
    }

    //1
    private static void altaCliente() {
        System.out.println("¿Qué tipo de Modelo.cliente eres?");
        System.out.println("(1) Particular");
        System.out.println("(2) Empresa");
        String eleccion;
        eleccion = inputDato("Escribe el número correspondiente a la opción deseada: ");
        switch (eleccion) {
            case "1": {
                Particular nuevo = fabricaClientes.getParticular();
                rellenarParticular(nuevo);
                listaClientes.nuevoCliente(nuevo);
                break;
            }
            case "2": {
                Empresa nuevo = fabricaClientes.getEmpresa();
                rellenarEmpresa(nuevo);
                break;
            }
            default:
                System.out.println("Por favor, elige una opción válida.");
                break;
        }
    }

    //2
    private static void borradoCliente() {
        System.out.println("Escribe el DNI del Modelo.cliente que quieras eliminar.");
        String dniABorrar = inputDato("DNI: ");
        Cliente bye = listaClientes.encontrarCliente(dniABorrar);
        listaClientes.borrarCliente(bye);
    }

    //3
    private static void cambioTarifa() {
        System.out.println("Escribe el DNI del Modelo.cliente que quieras cambiar de Modelo.tarifa.");
        String dni = inputDato("DNI: ");
        Cliente cliente = listaClientes.encontrarCliente(dni);
        if (cliente != null){
            System.out.println("¿Qué Modelo.tarifa quieres?");
            System.out.println("Basica (1)");
            System.out.println("Tarde (2)");
            System.out.println("Fin de semana (3)");
            int eleccion = Integer.parseInt(inputDato("Elige: "));
            switch (eleccion){
                case 1:
                    Tarifa tarifa = fabricaTarifas.getBasica();
                    cliente.setTarifa(tarifa);
                    System.out.println("Tarifa cambiada correctamente.");
                    break;
                case 2:
                    Tarifa matinal = fabricaTarifas.getTarde(cliente.getTarifa());
                    cliente.setTarifa(matinal);
                    System.out.println("Tarifa cambiada correctamente.");
                    break;
                case 3:
                    Tarifa finSemana = fabricaTarifas.getFinSemana(cliente.getTarifa());
                    cliente.setTarifa(finSemana);
                    System.out.println("Tarifa cambiada correctamente.");
                    break;
                default:
                    System.out.println("Elección no válida.");
                    break;
            }
        }else {
            System.out.println("El Modelo.cliente especificado no existe.");
        }
    }

    //4
    private static void recuperarDatosNIF() {
        System.out.println("Escribe el DNI del Modelo.cliente del cual quieres saber sus Modelo.datos.");
        String dni = inputDato("DNI: ");
        Cliente cliente = listaClientes.encontrarCliente(dni);
        cliente.toString();
    }

    //5
    private static void recuperarListaClientes() {
        listaClientes.toString();
    }

    private static Tarifa tarifaConveniente(Date fecha){
        int hora = fecha.getHours();
        int dia = fecha.getDay();
        Tarifa tarifa = fabricaTarifas.getBasica();

        if (dia == 0)
            return fabricaTarifas.getFinSemana(tarifa);
        else if(hora >12 && hora<23)
            return fabricaTarifas.getTarde(tarifa);
        
        return tarifa;
    }
    //6
    private static void altaLlamada(){
        System.out.println("¿De quién quieres dar de alta una Modelo.llamada?");
        String dni = inputDato("DNI: ");
        String numero = inputDato("Número al cuál se realizó la Modelo.llamada: ");
        Date fecha = inputFecha();
        Double duracion = Double.valueOf(inputDato("Duración de la Modelo.llamada (en segundos): "));
        Cliente cliente = listaClientes.encontrarCliente(dni);
        Llamada llamada = new Llamada(numero,fecha,duracion,tarifaConveniente(fecha));
        cliente.anadirLlamada(llamada);
    }

    //7
    private static void listaLlamadas() {
        System.out.println("¿De quién quieres ver la lista de llamadas?");
        String dni = inputDato("DNI: ");
        Cliente cliente = listaClientes.encontrarCliente(dni);
        cliente.getLlamadas().toString();
    }

    //8
    private static void importeFactura() {
        String cod = inputDato("Código de Modelo.factura: ");
        String dni = inputDato("DNI: ");
        Cliente cliente = listaClientes.encontrarCliente(dni);
        Factura factura = cliente.encontrarFactura(cod);
        double importe = factura.getImporte();
        System.out.println(importe);
    }


    //9
    private static void mostrarFactura() {
        String cod = inputDato("Código de Modelo.factura: ");
        String dni = inputDato("DNI: ");
        Cliente cliente = listaClientes.encontrarCliente(dni);
        cliente.encontrarFactura(cod).toString();
    }

    //10
    private static void listaFacturas() {
        System.out.println("¿De quién quieres ver la lista de facturas?");
        String dni = inputDato("DNI: ");
        Cliente cliente = listaClientes.encontrarCliente(dni);
        cliente.getFacturas().toString();
    }


    //FUNCIÓN GENÉRICA
    private static <T extends Fecha> Collection<T> metodoGenerico(Collection<T> c, Date inicio, Date fin) {
        Collection<T> datos = new HashSet<>();
        for (T elemento : c) {
            if (elemento.getFecha().after(inicio) && elemento.getFecha().before(fin)) {
                datos.add(elemento);
            }
        }
        return datos;
    }


    private static Date inputFecha() {
        String fecha = inputDato("Modelo.fecha(dd/mm/yyyy): ");
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        Date result = new Date();
        try {
            result = format.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    //11
    private static void listadoClientes() {
        Date inicio = inputFecha();
        Date fin = inputFecha();
        HashSet<Cliente> clientes = new HashSet<>();
        listaClientes.getClientes().forEach((k, v) -> clientes.add(v));
        Collection<Cliente> resultado = metodoGenerico(clientes, inicio, fin);
        resultado.toString();
    }

    //12
    private static void listadoLlamadas() {
        Date inicio = inputFecha();
        Date fin = inputFecha();
        String dni = inputDato("DNI: ");
        Cliente cliente = listaClientes.encontrarCliente(dni);
        HashSet<Llamada> llamadas = cliente.getLlamadas();
        Collection<Llamada> resultado = metodoGenerico(llamadas, inicio, fin);
        resultado.toString();
    }

    //13
    private static void listadoFacturas() {
        Date inicio = inputFecha();
        Date fin = inputFecha();
        String dni = inputDato("DNI: ");
        Cliente cliente = listaClientes.encontrarCliente(dni);

        HashMap<String, Factura> facturas = cliente.getFacturas();
        HashSet<Factura> fac = new HashSet<>();
        facturas.forEach((k, v) -> fac.add(v));

        Collection<Factura> resultado = metodoGenerico(fac, inicio, fin);
        resultado.toString();
    }

    private static void guardarDatos() {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream("Clientes.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listaClientes);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void cargarDatos() {
        FileInputStream fis;
        try {
            fis = new FileInputStream("Clientes.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            listaClientes = (ClienteManager) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    //MAIN
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Primera Ventana");
        ventana.setSize(400, 400);
        ventana.setVisible(true);
        //menu();
    }

}
