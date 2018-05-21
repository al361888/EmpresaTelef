package Vista;

import Controlador.Inicio.Inicio;

import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;


public class VentanaClientes extends JPanel {

    private ArrayList<String> datos;

    private void ejecuta(){
        Ventana ventana = new Ventana();
        ventana.setTitle("Opciones clientes");
        ventana.setSize(900,400);
        ventana.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Container contenedor = ventana.getContentPane();
        JTabbedPane panel = new JTabbedPane();

        JPanel op1 = new JPanel();
        panel.addTab("Alta cliente", op1);
        opcion1(op1);

        JPanel op2 = new JPanel();
        panel.addTab("Borrar cliente", op2);
        opcion2(op2);

        JPanel op3 = new JPanel();
        panel.addTab("Cambiar tarifa", op3);
        opcion3(op3);

        JPanel op4 = new JPanel();
        panel.addTab("Recuperar datos", op4);
        opcion4(op4);

        JPanel op5 = new JPanel();
        panel.addTab("Lista clientes", op5);
        opcion5(op5);

        JPanel op11 = new JPanel();
        panel.addTab("Clientes entre fechas", op11);
        opcion11(op11);


        contenedor.add(panel);
    }




    private void opcion1(JPanel op1){
        JTextField nombre = new JTextField(20);
        JLabel campo1 = new JLabel("Nombre");
        op1.add(campo1);
        op1.add(nombre);

        JTextField nif = new JTextField(20);
        JLabel campo2 = new JLabel("NIF");
        op1.add(campo2);
        op1.add(nif);

        JTextField email = new JTextField(20);
        JLabel campo3 = new JLabel("E-Mail");
        op1.add(campo3);
        op1.add(email);

        JTextField cp = new JTextField(20);
        JLabel campo4 = new JLabel("Código postal");
        op1.add(campo4);
        op1.add(cp);

        JTextField poblacion = new JTextField(20);
        JLabel campo5 = new JLabel("Población");
        op1.add(campo5);
        op1.add(poblacion);

        JTextField provincia = new JTextField(20);
        JLabel campo6 = new JLabel("Província");
        op1.add(campo6);
        op1.add(provincia);

        JButton enviar = new JButton("Enviar");
        enviar.addActionListener(e -> {
            datos.add(nombre.getText());
            datos.add(email.getText());
            datos.add(cp.getText());
            datos.add(poblacion.getText());
            datos.add(provincia.getText());
        });

        op1.add(enviar);
    }


    private void opcion2(JPanel op2){
        JTextField nif = new JTextField(20);
        JLabel campo1 = new JLabel("NIF");
        op2.add(campo1);
        op2.add(nif);

        JButton enviar = new JButton("Enviar");
        enviar.addActionListener(e -> Inicio.borradoCliente(nif.getText()));

        op2.add(enviar);

    }

    private void opcion3(JPanel op3){
        JTextField nif = new JTextField(20);
        JLabel campo1 = new JLabel("NIF");
        op3.add(campo1);
        op3.add(nif);

        JRadioButton basica = new JRadioButton("Básica",true);
        op3.add(basica);
        JRadioButton tarde = new JRadioButton("Tarde",false);
        op3.add(tarde);
        JRadioButton finDeSemana = new JRadioButton("Fin de semana",false);
        op3.add(finDeSemana);

        ButtonGroup grupo1 = new ButtonGroup();
        grupo1.add(basica);
        grupo1.add(tarde);
        grupo1.add(finDeSemana);

        JButton enviar = new JButton("Enviar");
        enviar.addActionListener(e -> {
            if(basica.isSelected()) {
                Inicio.cambioTarifa(nif.getText(),1);
            } else if(tarde.isSelected()) {
                Inicio.cambioTarifa(nif.getText(),2);
            } else Inicio.cambioTarifa(nif.getText(),3);
        });

        op3.add(enviar);

    }

    private void opcion4(JPanel op4){
        JTextField nif = new JTextField(20);
        JLabel campo1 = new JLabel("NIF");
        op4.add(campo1);
        op4.add(nif);

        JButton listar = new JButton("Listar");
        listar.addActionListener(e -> Inicio.recuperarDatosNIF(nif.getText()));

        op4.add(listar);

    }

    private void opcion5(JPanel op5) {
        JButton enviar = new JButton("Enviar");
        enviar.addActionListener(e -> Inicio.recuperarListaClientes());
        op5.add(enviar);
    }

    private void opcion11(JPanel op11) {
        JTextField fecha1 = new JTextField(20);
        JLabel primera = new JLabel("Primera fecha(dd/mm/yyyy)");
        op11.add(primera);
        op11.add(fecha1);

        JTextField fecha2 = new JTextField(20);
        JLabel segunda = new JLabel("Segunda fecha(dd/mm/yyyy)");
        op11.add(segunda);
        op11.add(fecha2);

        JButton enviar = new JButton("Enviar");
        enviar.addActionListener(e -> Inicio.listadoClientes(fecha1.getText(),fecha2.getText()));

        op11.add(enviar);

    }
    public static void main (String[] args) {
        new VentanaClientes().ejecuta();
    }

}
