package Vista;

import Controlador.Inicio.Inicio;

import javax.swing.*;
import java.awt.*;

public class VentanaFacturas extends JPanel {

    private void ejecuta(){
        Ventana ventana = new Ventana();
        ventana.setTitle("Opciones facturas");
        ventana.setSize(900,400);
        ventana.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Container contenedor = ventana.getContentPane();
        JTabbedPane panel = new JTabbedPane();

        JPanel op8 = new JPanel();
        panel.addTab("Emitir factura", op8);
        opcion8(op8);

        JPanel op9 = new JPanel();
        panel.addTab("Recuperar datos", op9);
        opcion9(op9);

        JPanel op10 = new JPanel();
        panel.addTab("Recuperar factura", op10);
        opcion10(op10);

        JPanel op13 = new JPanel();
        panel.addTab("Facturas entre fechas", op13);
        opcion13(op13);

        contenedor.add(panel);
    }

    private void opcion8(JPanel op8){
        JTextField nif = new JTextField(20);
        JLabel campo1 = new JLabel("NIF");
        op8.add(campo1);
        op8.add(nif);

        JTextField cod = new JTextField(20);
        JLabel campo2 = new JLabel("Código de factura");
        op8.add(campo2);
        op8.add(cod);

        JButton enviar = new JButton("Enviar");
        enviar.addActionListener(e -> Inicio.importeFactura(nif.getText(), cod.getText()));

        op8.add(enviar);
    }

    private void opcion9(JPanel op9){
        JTextField nif = new JTextField(20);
        JLabel campo1 = new JLabel("NIF");
        op9.add(campo1);
        op9.add(nif);

        JTextField cod = new JTextField(20);
        JLabel campo2 = new JLabel("Código de factura");
        op9.add(campo2);
        op9.add(cod);

        JButton enviar = new JButton("Enviar");
        enviar.addActionListener(e -> Inicio.mostrarFactura(nif.getText(), cod.getText()));

        op9.add(enviar);
    }

    private void opcion10(JPanel op10){
        JTextField nif = new JTextField(20);
        JLabel campo1 = new JLabel("NIF");
        op10.add(campo1);
        op10.add(nif);

        JButton enviar = new JButton("Enviar");
        enviar.addActionListener(e -> Inicio.listaFacturas(nif.getText()));

        op10.add(enviar);
    }

    private void opcion13(JPanel op13) {
        JTextField fecha1 = new JTextField(20);
        JLabel primera = new JLabel("Primera fecha(dd/mm/yyyy)");
        op13.add(primera);
        op13.add(fecha1);

        JTextField fecha2 = new JTextField(20);
        JLabel segunda = new JLabel("Segunda fecha(dd/mm/yyyy)");
        op13.add(segunda);
        op13.add(fecha2);

        JTextField dni = new JTextField(20);
        JLabel campo1 = new JLabel("NIF");
        op13.add(campo1);
        op13.add(dni);

        JButton enviar = new JButton("Enviar");
        enviar.addActionListener(e -> Inicio.listadoFacturas(fecha1.getText(),fecha2.getText(),dni.getText()));

        op13.add(enviar);

    }

    public static void main (String[] args) {
        new VentanaFacturas().ejecuta();
    }
}
