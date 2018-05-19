package Vista;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame{

    public Ventana() {
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        new Ventana();
    }
}
