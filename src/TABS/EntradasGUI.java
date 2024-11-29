//Terminado samuel gg pinedita estuvoaqui ahora si se ve
package TABS;

import javax.swing.*;
import java.awt.*;

public class EntradasGUI {
    private JFrame frame;
    private JTextField desdeMult, hastaMult, desdeMultic, hastaMultic;
    private JButton generar;

    public EntradasGUI(String tipo) {
        frame = new JFrame("Tablas de " + tipo);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout()); // Usamos BorderLayout para organizar la ventana principal
        JPanel panelEntradas = new JPanel(new GridLayout(5, 2, 10, 10)); // GridLayout de 5 filas y 2 columnas

        // Componentes
        panelEntradas.add(new JLabel("Multiplicando Desde:"));
        desdeMult = new JTextField(5);
        panelEntradas.add(desdeMult);

        panelEntradas.add(new JLabel("Multiplicando Hasta:"));
        hastaMult = new JTextField(5);
        panelEntradas.add(hastaMult);

        panelEntradas.add(new JLabel("Multiplicador Desde:"));
        desdeMultic = new JTextField(5);
        panelEntradas.add(desdeMultic);

        panelEntradas.add(new JLabel("Multiplicador Hasta:"));
        hastaMultic = new JTextField(5);
        panelEntradas.add(hastaMultic);

        // Cargar la imagen
        ImageIcon ingresarIcono = new ImageIcon("src/IMAGENTOTA/ingresar.png");
        Image ingresarImagen = ingresarIcono.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon ingresarIconoEscalado = new ImageIcon(ingresarImagen);

        // Crear el botón con la imagen
        generar = new JButton("Generar", ingresarIconoEscalado);
        panelEntradas.add(generar);


        frame.add(panelEntradas, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public int getDesdeMult() {
        return Integer.parseInt(desdeMult.getText());
    }

    public int getHastaMult() {
        return Integer.parseInt(hastaMult.getText());
    }

    public int getDesdeMultic() {
        return Integer.parseInt(desdeMultic.getText());
    }

    public int getHastaMultic() {
        return Integer.parseInt(hastaMultic.getText());
    }

    public JButton getGenerar() {
        return generar;
    }
}



