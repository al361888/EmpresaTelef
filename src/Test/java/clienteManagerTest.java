import cliente.Cliente;
import cliente.ClienteManager;
import cliente.Empresa;
import Direccion.Direccion;
import cliente.Particular;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

import static org.junit.Assert.*;

public class clienteManagerTest {
    private static Cliente miguel;
    private static Cliente ousama;
    private static ClienteManager lista;

    @BeforeClass
    public static void primero() {
        Direccion Grao = new Direccion("12100", "Castellón", "Grao");
        Direccion vall = new Direccion("12600", "Castellón","Valld'Uxó");
        miguel = new Particular("miguel", "20902969V", "al361888@uji.es", Grao,"Ligero Nebot");
        ousama= new Empresa("ousama","12345678X", "al234567@uji.es", vall);
        lista = new ClienteManager();
    }


    @Test
    public void getClientesTest(){
        HashMap<String,Cliente> clientes = new HashMap<String, Cliente>();
        assertEquals(clientes, lista.getClientes());
    }

    @Test
    public void nuevoClienteTest(){
        assertTrue("Insertando cliente", lista.nuevoCliente(miguel));
        assertFalse("Volviendo a añadir al mismo cliente", lista.nuevoCliente(miguel));
    }

    @Test
    public void borrarClienteTest(){
        lista.nuevoCliente(ousama);
        assertTrue("Borrando cliente", lista.borrarCliente(ousama));
        assertFalse("Borrando cliente ya borrado", lista.borrarCliente(ousama));
    }

    @Test
    public void encontrarClienteTest(){
        lista.nuevoCliente(miguel);
        assertEquals(miguel, lista.encontrarCliente("20902969V"));
    }

}
