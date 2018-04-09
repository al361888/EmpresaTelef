package Inicio;

import Direccion.Direccion;
import Factura.Factura;
import Fecha.Fecha;
import Llamada.Llamada;
import Tarifa.Tarifa;
import cliente.Cliente;
import cliente.ClienteManager;
import cliente.Empresa;
import cliente.Particular;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Inicio {

    private static ClienteManager listaClientes;

    private static void menu() {
        cargarDatos();
        Scanner scan = new Scanner(System.in);
        int eleccion;
        while (true) {
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
            System.out.println("(11) Mostrar clientes que operaron entre dos fechas");
            System.out.println("(12) Mostrar las llamadas de un cliente entre dos fechas");
            System.out.println("(10) Mostrsr las facturas de un cliente entre dos fechas");
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

    //1
    private static void altaCliente() {
        System.out.println("¿Qué tipo de cliente eres?");
        System.out.println("(1) Particular");
        System.out.println("(2) Empresa");
        String eleccion;
        eleccion = inputDato("Escribe el número correspondiente a la opción deseada: ");
        switch (eleccion) {
            case "1": {
                Particular nuevo = new Particular();
                rellenarParticular(nuevo);
                listaClientes.nuevoCliente(nuevo);
                break;
            }
            case "2": {
                Empresa nuevo = new Empresa();
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
        System.out.println("Escribe el DNI del cliente que quieras eliminar.");
        String dniABorrar = inputDato("DNI: ");
        Cliente bye = listaClientes.encontrarCliente(dniABorrar);
        listaClientes.borrarCliente(bye);
    }

    //3
    private static void cambioTarifa() {
        System.out.println("Escribe el DNI del cliente que quieras cambiar de tarifa.");
        String dni = inputDato("DNI: ");
        Cliente cliente = listaClientes.encontrarCliente(dni);
        double precio = Double.parseDouble(inputDato("¿Qué tarifa eliges?: "));
        Tarifa tarifa = new Tarifa(precio);
        cliente.setTarifa(tarifa);
    }

    //4
    private static void recuperarDatosNIF() {
        System.out.println("Escribe el DNI del cliente del cual quieres saber sus datos.");
        String dni = inputDato("DNI: ");
        Cliente cliente = listaClientes.encontrarCliente(dni);
        cliente.toString();
    }

    //5
    private static void recuperarListaClientes() {
        listaClientes.toString();
    }

    //6
    private static void altaLlamada() {

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
        String cod = inputDato("Código de factura: ");
        String dni = inputDato("DNI: ");
        Cliente cliente = listaClientes.encontrarCliente(dni);
        Factura factura = cliente.encontrarFactura(cod);
        double importe = factura.getImporte();
        System.out.println(importe);
    }


    //9
    private static void mostrarFactura() {
        String cod = inputDato("Código de factura: ");
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
    private static <T> Collection<T> metodoGenerico(Collection<? extends Fecha> c, Date inicio, Date fin) {
        Collection<T> datos = new HashSet<T>();
        for (Fecha elemento : c) {
            if (elemento.getFecha().after(inicio) && elemento.getFecha().before(fin)) {
                datos.add((T) elemento);
            }
        }
        return datos;
    }


    private static Date inputFecha() {
        String fecha = inputDato("Fecha(dd/mm/yyyy): ");
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
    private static Collection<Cliente> listadoClientes() {//Faltan los print
        Date inicio = inputFecha();
        Date fin = inputFecha();
        HashSet<Cliente> clientes = new HashSet<Cliente>();
        listaClientes.getClientes().forEach((k, v) -> clientes.add(v));
        return metodoGenerico(clientes, inicio, fin);
    }

    //12
    private static Collection<Llamada> listadoLlamadas() {//Faltan los print
        Date inicio = inputFecha();
        Date fin = inputFecha();
        String dni = inputDato("DNI: ");
        Cliente cliente = listaClientes.encontrarCliente(dni);
        HashSet<Llamada> llamadas = cliente.getLlamadas();
        return metodoGenerico(llamadas, inicio, fin);
    }

    //13
    private static Collection<Factura> listadoFacturas() {//Faltan los print
        Date inicio = inputFecha();
        Date fin = inputFecha();
        String dni = inputDato("DNI: ");
        Cliente cliente = listaClientes.encontrarCliente(dni);

        HashMap<String, Factura> facturas = cliente.getFacturas();
        HashSet<Factura> fac = new HashSet<Factura>();
        facturas.forEach((k, v) -> fac.add(v));

        return metodoGenerico(fac, inicio, fin);
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
        menu();
        guardarDatos();
    }

}
