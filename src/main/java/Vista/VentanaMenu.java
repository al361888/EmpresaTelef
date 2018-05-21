package Vista;

import Controlador.Inicio.Inicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaMenu {

    private void ejecuta(){
        Ventana ventana = new Ventana();
        ventana.setTitle("Menu");
        Container contenedor = ventana.getContentPane();

        JPanel panelMenu = new JPanel();
        JButton clientes = new JButton("Clientes");
        clientes.setActionCommand("c");
        clientes.addActionListener(new EscuchadorMenu());
        panelMenu.add(clientes);

        JPanel panelMenuC = new JPanel();
        JButton facturas = new JButton("Facturas");
        facturas.setActionCommand("f");
        facturas.addActionListener(new EscuchadorMenu());
        panelMenuC.add(facturas);

        JButton llamadas = new JButton("Llamadas");
        llamadas.setActionCommand("l");
        llamadas.addActionListener(new EscuchadorMenu());
        panelMenuC.add(llamadas);

        JPanel panelMenuS = new JPanel();
        JButton salir = new JButton("Salir");
        salir.setActionCommand("s");
        salir.addActionListener(new EscuchadorMenu());
        panelMenuS.add(salir,BorderLayout.SOUTH);

        contenedor.add(panelMenu,BorderLayout.NORTH);
        contenedor.add(panelMenuC, BorderLayout.CENTER);
        contenedor.add(panelMenuS, BorderLayout.SOUTH);
    }

    public class EscuchadorMenu implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()){
                case "c":
                    VentanaClientes.main(null);
                    break;
                case "f":
                    VentanaFacturas.main(null);
                    break;
                case "l":
                    VentanaLlamadas.main(null);
                    break;
                case "s":
                    Inicio.guardarDatos();
                    System.exit(0);
                    break;
            }
        }
    }

    public static void main (String[] args) {
        new VentanaMenu().ejecuta();
    }

}
