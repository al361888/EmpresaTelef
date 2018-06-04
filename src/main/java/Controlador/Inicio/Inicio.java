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

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class Inicio {

    private static ClienteManager listaClientes;
    private static FabricaClientes fabricaClientes;
    private static FabricaTarifas fabricaTarifas;

    private static void menu() {
        cargarDatos();
        //Scanner scan = new Scanner(System.in);
        /*int eleccion;
        while (true) {
            System.out.println("----FACTURAPPS----");
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
            System.out.println("(13) Mostrar las facturas de un cliente entre dos fechas");
            System.out.println("(14) Salir (guardar datos)");
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
        }*/
    }


    /*private static String inputDato(String mensaje) {
        Scanner scan = new Scanner(System.in);
        String eleccion = "";
        try {
            System.out.println(mensaje);
            eleccion = scan.nextLine();
        } catch (Exception e) {
            return eleccion;
        }
        return eleccion;
    }*/

    private static void rellenarDireccion(Direccion d, String cp, String poblacion, String provincia) {
        d.setCp(cp);
        d.setPoblacion(poblacion);
        d.setProvincia(provincia);
    }

    private static void rellenarParticular(Particular p, String nif, String nombre, String email,String cp, String poblacion, String provincia, String apellidos) {
        if (p!=null){
            p.setNIF(nif);
            p.setNombre(nombre);
            p.setApellidos(apellidos);
            p.setEmail(email);
            rellenarDireccion(p.getDireccion(), cp, poblacion, provincia);
        } else
            System.out.println("Parámetro nulo.");
    }

    private static void rellenarEmpresa(Empresa e, String nif, String nombre, String email,String cp, String poblacion, String provincia) { //Optimizar
        if(e!=null){
            e.setNIF(nif);
            e.setNombre(nombre);
            e.setEmail(email);
            rellenarDireccion(e.getDireccion(), cp, poblacion, provincia);
        }else
            System.out.println("Parámetro nulo.");
    }

    //1
    public static void altaCliente(String eleccion, String nif, String nombre, String email, String cp, String poblacion, String provincia, String apellidos) {
        //System.out.println("¿Qué tipo de Modelo.cliente eres?");
        //System.out.println("(1) Particular");
        //System.out.println("(2) Empresa");
        //String eleccion;
        //eleccion = inputDato("Escribe el número correspondiente a la opción deseada: ");
        switch (eleccion) {
            case "1": {
                Particular nuevo = fabricaClientes.getParticular();
                rellenarParticular(nuevo, nif, nombre, email, cp, poblacion, provincia,apellidos);
                listaClientes.nuevoCliente(nuevo);
                break;
            }
            case "2": {
                Empresa nuevo = fabricaClientes.getEmpresa();
                rellenarEmpresa(nuevo, nif, nombre, email, cp, poblacion, provincia);
                break;
            }
            default:
                System.out.println("Por favor, elige una opción válida.");
                break;
        }
    }

    //2
    public static void borradoCliente(String dni) {
        //System.out.println("Escribe el DNI del Modelo.cliente que quieras eliminar.");
        //String dniABorrar = inputDato("DNI: ");
        Cliente bye = listaClientes.encontrarCliente(dni);
        listaClientes.borrarCliente(bye);
    }

    //3
    public static void cambioTarifa(String dni, int eleccion) {
        //System.out.println("Escribe el DNI del Modelo.cliente que quieras cambiar de Modelo.tarifa.");
        //String dni = inputDato("DNI: ");
        Cliente cliente = listaClientes.encontrarCliente(dni);
        if (cliente != null){
            //System.out.println("¿Qué tarifa quieres?");
            //System.out.println("Basica (1)");
            //System.out.println("Tarde (2)");
            //System.out.println("Fin de semana (3)");
            //int eleccion = Integer.parseInt(inputDato("Elige: "));
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
            System.out.println("El cliente especificado no existe.");
        }
    }

    //4
    public static void recuperarDatosNIF(String dni) {
        //System.out.println("Escribe el DNI del Modelo.cliente del cual quieres saber sus Modelo.datos.");
        //String dni = inputDato("DNI: ");
        Cliente cliente = listaClientes.encontrarCliente(dni);
        cliente.toString();
    }

    //5
    public static void recuperarListaClientes() {
        listaClientes.toString();
    }

    private static Tarifa tarifaConveniente(LocalDateTime fecha){
        int hora = fecha.getHour();
        int dia = fecha.getDayOfWeek().getValue();
        Tarifa tarifa = fabricaTarifas.getBasica();

        if (dia == 6 || dia == 7)
            return fabricaTarifas.getFinSemana(tarifa);
        else if(hora >12 && hora<23)
            return fabricaTarifas.getTarde(tarifa);

        return tarifa;
    }
    //6
    public static void altaLlamada(String dni, String numero, String f, String tiempo){
        System.out.println("¿De quién quieres dar de alta una Modelo.llamada?");
        //String dni = inputDato("DNI: ");
        //String numero = inputDato("Número al cuál se realizó la Modelo.llamada: ");
        LocalDateTime fecha = inputFechaGenerica(f);
        //Double duracion = Double.valueOf(inputDato("Duración de la Modelo.llamada (en segundos): "));
        double duracion = Double.parseDouble(tiempo);
        Cliente cliente = listaClientes.encontrarCliente(dni);
        Llamada llamada = new Llamada(numero,fecha,duracion,tarifaConveniente(fecha));
        cliente.anadirLlamada(llamada);
    }

    //7
    public static void listaLlamadas(String dni) {
        //System.out.println("¿De quién quieres ver la lista de llamadas?");
        //String dni = inputDato("DNI: ");
        Cliente cliente = listaClientes.encontrarCliente(dni);
        cliente.getLlamadas().toString();
    }

    //8
    public static void importeFactura(String cod, String dni) {
        //String cod = inputDato("Código de Modelo.factura: ");
        //String dni = inputDato("DNI: ");
        Cliente cliente = listaClientes.encontrarCliente(dni);
        Factura factura = cliente.encontrarFactura(cod);
        double importe = factura.getImporte();
        System.out.println(importe);
    }


    //9
    public static void mostrarFactura(String cod, String dni) {
        //String cod = inputDato("Código de Modelo.factura: ");
        //String dni = inputDato("DNI: ");
        Cliente cliente = listaClientes.encontrarCliente(dni);
        cliente.encontrarFactura(cod).toString();
    }

    //10
    public static void listaFacturas(String dni) {
        //System.out.println("¿De quién quieres ver la lista de facturas?");
        //String dni = inputDato("DNI: ");
        Cliente cliente = listaClientes.encontrarCliente(dni);
        cliente.getFacturas().toString();
    }


    //FUNCIÓN GENÉRICA
    private static <T extends Fecha> Collection<T> metodoGenerico(Collection<T> c, LocalDateTime inicio, LocalDateTime fin) {
        Collection<T> datos = new HashSet<>();
        for (T elemento : c) {
            if (elemento.getFecha().isAfter(inicio) && elemento.getFecha().isBefore(fin)) {
                datos.add(elemento);
            }
        }
        return datos;
    }


    /*private static Date inputFecha() {
        String fecha = inputDato("fecha(dd/mm/yyyy): ");
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        Date result = new Date();
        try {
            result = format.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }*/

    //Hecho a causa de la vistaClientes
    private static LocalDateTime inputFechaGenerica(String fecha) {
        //String fecha = inputDato("fecha(dd/mm/yyyy): ");
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        Date result = new Date();
        try {
            result = format.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return LocalDateTime.ofInstant(result.toInstant(), ZoneId.systemDefault());
    }

    //11
    public static void listadoClientes(String ini, String finale) {
        LocalDateTime inicio = inputFechaGenerica(ini);
        LocalDateTime fin = inputFechaGenerica(finale);
        HashSet<Cliente> clientes = new HashSet<>();
        listaClientes.getClientes().forEach((k, v) -> clientes.add(v));
        Collection<Cliente> resultado = metodoGenerico(clientes, inicio, fin);
        resultado.toString();
    }

    //12
    public static void listadoLlamadas(String text, String text1, String dni) {
        LocalDateTime inicio = inputFechaGenerica(text);
        LocalDateTime fin = inputFechaGenerica(text1);
        //String dni = inputDato("DNI: ");
        Cliente cliente = listaClientes.encontrarCliente(dni);
        HashSet<Llamada> llamadas = cliente.getLlamadas();
        Collection<Llamada> resultado = metodoGenerico(llamadas, inicio, fin);
        resultado.toString();
    }

    //13
    public static void listadoFacturas(String ini, String finale, String dni) {
        LocalDateTime inicio = inputFechaGenerica(ini);
        LocalDateTime fin = inputFechaGenerica(finale);
        //String dni = inputDato("DNI: ");
        Cliente cliente = listaClientes.encontrarCliente(dni);

        HashMap<String, Factura> facturas = cliente.getFacturas();
        HashSet<Factura> fac = new HashSet<>();
        facturas.forEach((k, v) -> fac.add(v));

        Collection<Factura> resultado = metodoGenerico(fac, inicio, fin);
        resultado.toString();
    }

    public static void guardarDatos() {
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


    public static void cargarDatos() {
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
    }
}
