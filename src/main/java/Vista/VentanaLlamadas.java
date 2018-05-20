package Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaLlamadas extends JPanel {

    private void ejecuta(){
        Ventana ventana = new Ventana();
        ventana.setTitle("Opciones llamadas");
        ventana.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Container contenedor = ventana.getContentPane();
        JTabbedPane panel = new JTabbedPane();

        JPanel op6 = new JPanel();
        panel.addTab("Dar alta", op6);

        JPanel op7 = new JPanel();
        panel.addTab("Listar llamadas", op7);

        JPanel op12 = new JPanel();
        panel.addTab("Llamadas entre fechas", op12);

        contenedor.add(panel);

    }

    public static void main (String[] args) {
        new VentanaLlamadas().ejecuta();
    }
}
