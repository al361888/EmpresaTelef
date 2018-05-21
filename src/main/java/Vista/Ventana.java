package Vista;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame{

    public Ventana() {
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Toolkit display = Toolkit.getDefaultToolkit();
        Dimension resolucion = display.getScreenSize();
        int anchura = resolucion.width;
        int altura = resolucion.height;
        setLocation(anchura/4, altura/4); // pantalla centrada
    }


    public static void main(String[] args) {
        new Ventana();
    }
}
