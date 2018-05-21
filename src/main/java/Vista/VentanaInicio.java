package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInicio{

    public Ventana ventana;

    public void ejecuta(){
        ventana = new Ventana();
        ventana.setTitle("Inicio");
        Container contenedor = ventana.getContentPane();

        //Panel Norte
        JPanel panelNorte = new JPanel();
        panelNorte.add(new JLabel("FACTURAPP"));
        contenedor.add(panelNorte, BorderLayout.NORTH);

        //Panel Central
        JPanel panelCentral = new JPanel();
        JButton inicio = new JButton("Inicio");
        inicio.setActionCommand("inicio");
        inicio.addActionListener(new EscuchadorBotones());
        panelCentral.add(inicio);
        contenedor.add(panelCentral, BorderLayout.CENTER);

        JButton salir = new JButton("Salir");
        salir.setActionCommand("s");
        salir.addActionListener(new EscuchadorBotones());
        panelCentral.add(salir);
        contenedor.add(panelCentral, BorderLayout.CENTER);

        //Panel Sur
        JPanel panelSur = new JPanel();

        JButton sobremi = new JButton("Sobre mí");
        sobremi.setActionCommand("mi");
        panelSur.add(sobremi);
        sobremi.addActionListener(new EscuchadorBotones());

        JButton donaciones = new JButton("Donaciones");
        donaciones.setActionCommand("donaciones");
        donaciones.addActionListener(new EscuchadorBotones());
        panelSur.add(donaciones);

        contenedor.add(panelSur, BorderLayout.SOUTH);
    }

    public class EscuchadorBotones implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()){
                case "inicio":
                    System.out.println("Has pulsado INICIO");
                    VentanaMenu.main(null);
                    ventana.setVisible(false);
                    break;
                case "mi":
                    System.out.println("Esta aplicación ha sido desarrollada por Miguel Ligero, alumno de Ingeniería Informática en la UJI.");
                    break;
                case "donaciones":
                    System.out.println("Las donaciones están actualmente desactivadas. Prueba más adelante.");
                    break;
                case "s":
                    System.exit(0);
                    break;
            }
        }
    }

    public static void main (String[] args) {
        new VentanaInicio().ejecuta();
    }


}
