package Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaFacturas extends JPanel {

    private void ejecuta(){
        Ventana ventana = new Ventana();
        ventana.setTitle("Opciones facturas");
        ventana.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Container contenedor = ventana.getContentPane();
        JTabbedPane panel = new JTabbedPane();

        JPanel op8 = new JPanel();
        panel.addTab("Emitir", op8);

        JPanel op9 = new JPanel();
        panel.addTab("Recuperar datos", op9);

        JPanel op10 = new JPanel();
        panel.addTab("Recuperar factura", op10);

        JPanel op13 = new JPanel();
        panel.addTab("Facturas entre fechas", op13);

        contenedor.add(panel);


    }

    public static void main (String[] args) {
        new VentanaFacturas().ejecuta();
    }
}
