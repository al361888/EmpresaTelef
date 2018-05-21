package Vista;

import Controlador.Inicio.Inicio;

import javax.swing.*;
import java.awt.*;

public class VentanaLlamadas extends JPanel {

    private void ejecuta(){
        Ventana ventana = new Ventana();
        ventana.setTitle("Opciones llamadas");
        ventana.setSize(900,400);
        ventana.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Container contenedor = ventana.getContentPane();
        JTabbedPane panel = new JTabbedPane();

        JPanel op6 = new JPanel();
        panel.addTab("Dar alta", op6);
        opcion6(op6);

        JPanel op7 = new JPanel();
        panel.addTab("Listar llamadas", op7);
        opcion7(op7);

        JPanel op12 = new JPanel();
        panel.addTab("Llamadas entre fechas", op12);
        opcion12(op12);

        contenedor.add(panel);

    }

    private void opcion6(JPanel op6){
        JTextField dni = new JTextField(20);
        JLabel campo1 = new JLabel("NIF");
        op6.add(campo1);
        op6.add(dni);

        JTextField num = new JTextField(20);
        JLabel campo2 = new JLabel("Número");
        op6.add(campo2);
        op6.add(num);

        JTextField fecha = new JTextField(20);
        JLabel campo3 = new JLabel("Fecha(dd/mm/yyyy)");
        op6.add(campo3);
        op6.add(fecha);

        JTextField duracion = new JTextField(20);
        JLabel campo4 = new JLabel("Duración");
        op6.add(campo4);
        op6.add(duracion);

        JButton enviar = new JButton("Enviar");
        enviar.addActionListener(e -> Inicio.altaLlamada(dni.getText(), num.getText(), fecha.getText(), duracion.getText()));

        op6.add(enviar);
    }

    private void opcion7(JPanel op7){
        JTextField nif = new JTextField(20);
        JLabel campo1 = new JLabel("NIF");
        op7.add(campo1);
        op7.add(nif);

        JButton enviar = new JButton("Enviar");
        enviar.addActionListener(e -> Inicio.listaLlamadas(nif.getText()));

        op7.add(enviar);

    }

    private void opcion12(JPanel op12) {
        JTextField fecha1 = new JTextField(20);
        JLabel primera = new JLabel("Primera fecha(dd/mm/yyyy)");
        op12.add(primera);
        op12.add(fecha1);

        JTextField fecha2 = new JTextField(20);
        JLabel segunda = new JLabel("Segunda fecha(dd/mm/yyyy)");
        op12.add(segunda);
        op12.add(fecha2);

        JTextField dni = new JTextField(20);
        JLabel campo1 = new JLabel("NIF");
        op12.add(campo1);
        op12.add(dni);

        JButton enviar = new JButton("Enviar");
        enviar.addActionListener(e -> Inicio.listadoLlamadas(fecha1.getText(),fecha2.getText(),dni.getText()));

        op12.add(enviar);

    }

    public static void main (String[] args) {
        new VentanaLlamadas().ejecuta();
    }
}
