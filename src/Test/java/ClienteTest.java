import Modelo.cliente.Cliente;
import Modelo.cliente.Empresa;
import Modelo.direccion.Direccion;
import Modelo.cliente.Particular;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClienteTest {
    private static Cliente miguel;
    private static Cliente ousama;

    @BeforeClass
    public static void init() {
        Direccion Grao = new Direccion("12100", "Castellón", "Grao");
        Direccion vall = new Direccion("12600", "Castellón", "Valld'Uxó");
        miguel = new Particular("miguel", "20902969V", "al361888@uji.es", Grao, "Ligero Nebot");
        ousama = new Empresa("ousama", "12345678X", "al234567@uji.es", vall);
    }

    @Test
    public void getNombreTest() {
        assertTrue("Comprobando Nombre", miguel.getNombre().equals("miguel"));
        assertTrue("Comprobando Nombre", ousama.getNombre().equals("ousama"));
        assertFalse("Comprobando Nombre", miguel.getNombre().equals("test"));
        assertFalse("Comprobando nombre", ousama.getNombre().equals("test"));
    }
}


