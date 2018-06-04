import Modelo.cliente.Cliente;
import Modelo.cliente.ClienteManager;
import Modelo.cliente.Empresa;
import Modelo.cliente.Particular;
import Modelo.direccion.Direccion;
import Modelo.fabrica_tarifa.FabricaTarifas;
import Modelo.llamada.Llamada;
import org.junit.BeforeClass;
import org.junit.Test;
import Modelo.tarifa.Basica;
import Modelo.tarifa.FinSemana;
import Modelo.tarifa.Tarde;
import Modelo.tarifa.Tarifa;

import java.time.LocalDateTime;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class InicioTest {

    private static FabricaTarifas fabricaTarifas;

    @BeforeClass
    public static void primero() {
        Direccion Grao = new Direccion("12100", "Castellón", "Grao");
        Direccion vall = new Direccion("12600", "Castellón","Valld'Uxó");
        Cliente miguel = new Particular("miguel", "20902969V", "al361888@uji.es", Grao, "Ligero Nebot");
        Cliente ousama = new Empresa("ousama", "12345678X", "al234567@uji.es", vall);
        ClienteManager lista = new ClienteManager();
        fabricaTarifas = new FabricaTarifas();
    }


    @Test
    public void TarifasTester(){
        Llamada nueva = new Llamada("633644212", LocalDateTime.now(),23.2,new Basica());
        Tarifa basica = new Basica();
        assertThat(basica.costeLlamada(nueva), is (10.0));
        basica = new Tarde(basica);
        assertEquals(basica.costeLlamada(nueva), 6.0,0.0);
    }

    @Test
    public void FabricaTarifasTest(){
        Tarifa basica = new Basica();
        assertEquals(fabricaTarifas.getBasica(),basica);
        Tarifa domingo = new FinSemana(basica);
        assertEquals(fabricaTarifas.getFinSemana(basica),domingo);
        Tarifa tarde = new Tarde(basica);
        assertEquals(fabricaTarifas.getTarde(basica),tarde);


    }



}
