package pMathGUI; // Define el paquete al que pertenece esta clase

// Importa las clases necesarias de las bibliotecas de Java
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// Define la clase pMathGui que extiende JInternalFrame e implementa ActionListener
public class pMathGui extends JInternalFrame implements ActionListener {
    // Declaracion de componentes de la interfaz grafica
    protected JLabel jlTitulo, jlDig1, jlDig2, jlTituloParam, jlTituloSinParam;
    protected JTextField jtNum1, jtNum2;
    protected JButton jbOperarSinParam, jbOperarParam;
    protected double iNum1, iNum2;
    protected Font fontGrande, fontInicio;
    protected GridBagConstraints gbc;
      
    // Constructor de la clase
    public pMathGui() {
        // Llama al constructor de JInternalFrame con parametros para configurar la ventana
        super("Operaciones Con/sin Parametros", true, true, true, true);
        
        // Inicializa las fuentes
        fontGrande = new Font("Arial", Font.BOLD, 20);
        fontInicio = new Font("Arial", Font.BOLD, 25);
        
        // Configura el layout y las restricciones
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        // Crea y configura el titulo
        jlTitulo = new JLabel("OPERACIONES MATEMATICAS");
        jlTitulo.setFont(new Font("Arial Black", Font.BOLD, 30));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        add(jlTitulo, gbc);

        // Crea y configura la etiqueta y el campo de texto para el primer número
        jlDig1 = new JLabel("DIGITE PRIMER NUMERO");
        jlDig1.setFont(fontInicio);
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        add(jlDig1, gbc);
        
        jtNum1 = new JTextField(15);
        jtNum1.setFont(fontInicio);
        gbc.gridy = 2;
        add(jtNum1, gbc);
        
        // Crea y configura la etiqueta y el campo de texto para el segundo número
        jlDig2 = new JLabel("DIGITE SEGUNDO NUMERO");
        jlDig2.setFont(fontInicio);
        gbc.gridy = 3;
        add(jlDig2, gbc);
        
        jtNum2 = new JTextField(15);
        jtNum2.setFont(fontInicio);
        gbc.gridy = 4;
        add(jtNum2, gbc);
        
        // Crea y configura el boton para operar con parametros
        jbOperarParam = new JButton("Operar Parametros");
        jbOperarParam.setFont(fontGrande);
        ImageIcon icono = new ImageIcon("src/IMAGENTOTA/Parametros.png");
        Image img = icono.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
        jbOperarParam.setIcon(new ImageIcon(img));
        jbOperarParam.setHorizontalTextPosition(SwingConstants.RIGHT);
        jbOperarParam.setToolTipText("Haz clic para operar parametros");
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(jbOperarParam, gbc);
        
        // Crea y configura el boton para operar sin parametros
        jbOperarSinParam = new JButton("Operar Sin Parametros");
        jbOperarSinParam.setFont(fontGrande);
        ImageIcon icono1 = new ImageIcon("src/IMAGENTOTA/SinParametros.png");
        Image img1 = icono1.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
        jbOperarSinParam.setIcon(new ImageIcon(img1));
        jbOperarSinParam.setHorizontalTextPosition(SwingConstants.RIGHT);
        jbOperarSinParam.setToolTipText("Haz clic para operar sin parametros");
        gbc.gridy = 4;
        add(jbOperarSinParam, gbc);
        
        // Configura el tamaño y la capacidad de redimensionar
        setSize(1100, 820);
        setResizable(true);
        
        // Añade los listeners a los botones
        jbOperarParam.addActionListener(this);
        jbOperarSinParam.addActionListener(this);
        setVisible(true);
    }
    
    // Implementacion del metodo actionPerformed para manejar eventos de botones
    @Override
    public void actionPerformed(ActionEvent e) {
        // Verifica si los campos estan vacios
        if (jtNum1.getText().isEmpty() || jtNum2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: campos vacios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            // Intenta convertir los textos ingresados a números
            iNum1 = Double.parseDouble(jtNum1.getText());
            iNum2 = Double.parseDouble(jtNum2.getText());
            
            // Limpia el contenido actual del frame
            getContentPane().removeAll();
            getContentPane().revalidate();
            getContentPane().repaint();
            
            // Crea una nueva instancia de OpeParam o OpeSinParam según el boton presionado
            if (e.getSource() == jbOperarParam) {
                new OpeParam(this, iNum1, iNum2);
            } else if (e.getSource() == jbOperarSinParam) {
                new OpeSinParam(this, iNum1, iNum2);
            }
        } catch (NumberFormatException ex) {
            // Muestra un mensaje de error si se ingresan letras en lugar de números
            JOptionPane.showMessageDialog(this, "Error: se estan ingresando letras", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}