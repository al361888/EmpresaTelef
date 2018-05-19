package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaMenu {

    public Ventana ventana;

    public void ejecuta(){
        ventana = new Ventana();
        ventana.setTitle("Inicio");
        Container contenedor = ventana.getContentPane();

        //Panel Norte
        JPanel panelNorte = new JPanel();
        panelNorte.add(new JLabel("OPCIONES"));
        contenedor.add(panelNorte, BorderLayout.NORTH);

        //Panel Central
        JPanel panelCentral = new JPanel();
        JButton op1 = new JButton("Nuevo cliente");
        op1.setActionCommand("1");
        op1.addActionListener(new EscuchadorMenu());
        panelCentral.add(op1);
        contenedor.add(panelCentral, BorderLayout.CENTER);


    }

    public static void main (String[] args) {
        new VentanaMenu().ejecuta();
    }

    public class EscuchadorMenu implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()){
                case "1":
                    System.out.println("has pulsado 1");
                    break;
                case "mi":
                    System.out.println("has pulsado MI");
                    break;
                case "donaciones":
                    System.out.println("Las donaciones están actualmente desactivadas. Prueba más adelante.");
                    break;
            }
        }
    }
}
