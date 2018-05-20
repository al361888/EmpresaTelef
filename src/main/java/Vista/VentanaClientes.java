package Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaClientes extends JPanel {

    private void ejecuta(){
        Ventana ventana = new Ventana();
        ventana.setTitle("Opciones clientes");
        ventana.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Container contenedor = ventana.getContentPane();
        JTabbedPane panel = new JTabbedPane();

        JPanel op1 = new JPanel();
        panel.addTab("Alta cliente", op1);

        JPanel op2 = new JPanel();
        panel.addTab("Borrar cliente", op2);

        JPanel op3 = new JPanel();
        panel.addTab("Cambiar tarifa", op3);

        JPanel op4 = new JPanel();
        panel.addTab("Recuperar datos", op4);

        JPanel op5 = new JPanel();
        panel.addTab("Lista clientes", op5);

        JPanel op11 = new JPanel();
        panel.addTab("Clientes entre fechas", op11);


        contenedor.add(panel);
    }

    public static void main (String[] args) {
        new VentanaClientes().ejecuta();
    }

}
