package TABS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainInterface extends JInternalFrame implements ActionListener {

    private JButton paresButton;
    private JButton primosButton;

    public MainInterface() {
        // Configuración del JInternalFrame
        super("Selecciona Tipo de Tabla", true, true, true, true);
        setSize(600, 600); // Ajuste del tamaño del marco
        setLayout(new GridLayout(3, 1, 10, 10)); // Cambié a GridLayout de 3 filas y 1 columna

        // Crear JLabel para el texto superior
        JLabel tituloLabel = new JLabel("OPRIME LA IMAGEN DE ACUERDO A TU SELECCIÓN", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 16));

        // Añadir el JLabel al frame
        add(tituloLabel);

        // Cargar imágenes para los botones
        ImageIcon paresIcono = new ImageIcon("src/IMAGENTOTA/Paresim.png");
        Image paresImagen = paresIcono.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon paresIconoEscalado = new ImageIcon(paresImagen);

        ImageIcon primosIcono = new ImageIcon("src/IMAGENTOTA/Primosim.png");
        Image primosImagen = primosIcono.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon primosIconoEscalado = new ImageIcon(primosImagen);

        // Crear botones con las imágenes como fondo
        paresButton = new JButton(paresIconoEscalado);
        primosButton = new JButton(primosIconoEscalado);

        // Configurar botones para que solo muestren la imagen
        paresButton.setContentAreaFilled(false);
        paresButton.setBorderPainted(false);
        paresButton.setFocusPainted(false);

        primosButton.setContentAreaFilled(false);
        primosButton.setBorderPainted(false);
        primosButton.setFocusPainted(false);

        // Añadir ActionListener a los botones
        paresButton.addActionListener(this);
        primosButton.addActionListener(this);

        // Añadir botones al JInternalFrame
        JPanel botonesPanel = new JPanel(new GridLayout(1, 2, 10, 10)); // GridLayout para los botones
        botonesPanel.add(paresButton);
        botonesPanel.add(primosButton);
        add(botonesPanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == paresButton) {
            mostrarInterfaz("Pares");
        } else if (e.getSource() == primosButton) {
            mostrarInterfaz("Primos");
        }
    }

    private void mostrarInterfaz(String tipo) {
        EntradasGUI entradasGUI = new EntradasGUI(tipo);
        entradasGUI.getGenerar().addActionListener(new GenerarActionListener(entradasGUI, tipo));
    }

    private class GenerarActionListener implements ActionListener {
        private EntradasGUI entradasGUI;
        private String tipo;

        public GenerarActionListener(EntradasGUI entradasGUI, String tipo) {
            this.entradasGUI = entradasGUI;
            this.tipo = tipo;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int min = entradasGUI.getDesdeMult();
                int mfn = entradasGUI.getHastaMult();
                int din = entradasGUI.getDesdeMultic();
                int dfn = entradasGUI.getHastaMultic();

                if (min > mfn) {
                    JOptionPane.showMessageDialog(null,
                            "El valor inicial del Multiplicando no puede ser mayor al valor final.",
                            "Error en rango de Multiplicando", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (din > dfn) {
                    JOptionPane.showMessageDialog(null,
                            "El valor inicial del Multiplicador no puede ser mayor al valor final.",
                            "Error en rango de Multiplicador", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (tipo.equals("Pares")) {
                    ParesOperacionesGui paresGUI = new ParesOperacionesGui(min, mfn, din, dfn);
                    paresGUI.ejecutar();
                } else {
                    PrimosOperacionesGui primosGUI = new PrimosOperacionesGui(min, mfn, din, dfn);
                    primosGUI.ejecutar();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese valores numéricos válidos.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
