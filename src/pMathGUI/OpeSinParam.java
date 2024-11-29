package pMathGUI; // Define el paquete al que pertenece esta clase

// Importa las clases necesarias de las bibliotecas de Java
import java.awt.*;
import javax.swing.*;

// Define la clase OpeSinParam que extiende la clase ope
public class OpeSinParam extends ope {
    
    // Declaración de variables de instancia
    private GridBagConstraints gbc; // Para configurar el diseño de los componentes
    private JInternalFrame parentFrame; // Marco interno padre
    
    // Constructor de la clase
    public OpeSinParam(JInternalFrame parent, double iNum1, double iNum2) {
        this.parentFrame = parent;
        parentFrame.setTitle("Operaciones Sin Parametros");
        
        // Panel principal con padding
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
        parentFrame.setContentPane(mainPanel);
        
        gbc = new GridBagConstraints();
        
        // Titulo
        jlTituloSinParam = new JLabel("<html><div style='text-align: center;'>OPERACIONES SIN<br>RESTRICCIONES</div></html>");
        jlTituloSinParam.setFont(new Font("Arial Black", Font.BOLD, 30));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 12;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(0, 0, 40, 0);
        mainPanel.add(jlTituloSinParam, gbc);
        
        // Panel para las operaciones
        JPanel operationsPanel = new JPanel(new GridBagLayout());
        gbc.insets = new Insets(5, 5, 5, 15); // Espaciado entre componentes
        
        // Columna izquierda
        int leftRow = 0;
        // Crea componentes para operaciones basicas
        crearComponentesOperacion("La Suma es:", iNum1, iNum2, "+", suma(iNum1, iNum2), 0, leftRow++, operationsPanel);
        crearComponentesOperacion("La resta es:", iNum1, iNum2, "-", resta(iNum1, iNum2), 0, leftRow++, operationsPanel);
        crearComponentesOperacion("La multiplicacion:", iNum1, iNum2, "x", multip(iNum1, iNum2), 0, leftRow++, operationsPanel);
        
        // Crea componentes para valor absoluto si los números son negativos
        if (iNum1 <= 0) {
            crearComponentesUnarios("El valor absoluto:", iNum1, valAbs(iNum1), 0, leftRow++, operationsPanel);
        }
        if (iNum2 <= 0) {
            crearComponentesUnarios("El valor absoluto:", iNum2, valAbs(iNum2), 0, leftRow++, operationsPanel);
        }
        
        // Crea componentes para redondeo
        crearComponentesUnarios("El redondeo de:", iNum1, round(iNum1), 0, leftRow++, operationsPanel);
        crearComponentesUnarios("El redondeo de:", iNum2, round(iNum2), 0, leftRow++, operationsPanel);
        
        // Columna derecha
        int rightRow = 0;
        // Crea componentes para redondeo hacia abajo y hacia arriba
        crearComponentesUnarios("El redondeo bajo:", iNum1, roundFloor(iNum1), 6, rightRow++, operationsPanel);
        crearComponentesUnarios("El redondeo bajo:", iNum2, roundFloor(iNum2), 6, rightRow++, operationsPanel);
        crearComponentesUnarios("El redondeo alto:", iNum1, roundCeil(iNum1), 6, rightRow++, operationsPanel);
        crearComponentesUnarios("El redondeo alto:", iNum2, roundCeil(iNum2), 6, rightRow++, operationsPanel);
        
        // Crea componentes para funciones trigonometricas
        crearComponentesUnarios("El seno de:", iNum1, seno(iNum1), 6, rightRow++, operationsPanel);
        crearComponentesUnarios("El seno de:", iNum2, seno(iNum2), 6, rightRow++, operationsPanel);
        crearComponentesUnarios("El coseno de:", iNum1, cos(iNum1), 6, rightRow++, operationsPanel);
        crearComponentesUnarios("El coseno de:", iNum2, cos(iNum2), 6, rightRow++, operationsPanel);
        crearComponentesUnarios("La tangente de:", iNum1, tan(iNum1), 0, leftRow++, operationsPanel);
        crearComponentesUnarios("La tangente de:", iNum2, tan(iNum2), 0, leftRow++, operationsPanel);
        
        // Agregar el panel de operaciones con scroll
        JScrollPane scrollPane = new JScrollPane(operationsPanel);
        scrollPane.setBorder(null);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(scrollPane, gbc);
        
        // Actualiza y repinta el frame padre
        parentFrame.revalidate();
        parentFrame.repaint();
    }
    
    // Metodo para crear componentes de operaciones binarias (con dos operandos)
    private void crearComponentesOperacion(String labelText, double num1, double num2, String operador, double resultado, 
                                         int x, int y, JPanel panel) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        
        // Crea y configura la etiqueta de la operacion
        JLabel label = new JLabel(labelText);
        label.setFont(fontGrande);
        label.setPreferredSize(new Dimension(180, 35));
        panel.add(label, gbc);

        // Crea y configura el campo de texto para el primer número
        gbc.gridx++;
        JTextField tfNum1 = new JTextField(String.valueOf(num1));
        tfNum1.setFont(fontGrande);
        tfNum1.setEditable(false);
        tfNum1.setPreferredSize(new Dimension(70, 35));
        panel.add(tfNum1, gbc);

        // Crea y configura la etiqueta del operador
        gbc.gridx++;
        JLabel labelOperador = new JLabel(" " + operador + " ");
        labelOperador.setFont(fontGrande);
        labelOperador.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelOperador, gbc);

        // Crea y configura el campo de texto para el segundo número
        gbc.gridx++;
        JTextField tfNum2 = new JTextField(String.valueOf(num2));
        tfNum2.setFont(fontGrande);
        tfNum2.setEditable(false);
        tfNum2.setPreferredSize(new Dimension(70, 35));
        panel.add(tfNum2, gbc);

        // Crea y configura la etiqueta de igualdad
        gbc.gridx++;
        JLabel labelIgual = new JLabel(" = ");
        labelIgual.setFont(fontGrande);
        labelIgual.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelIgual, gbc);

        // Crea y configura el campo de texto para el resultado
        gbc.gridx++;
        JTextField tfResultado = new JTextField(String.format("%.2f", resultado));
        tfResultado.setFont(fontGrande);
        tfResultado.setEditable(false);
        tfResultado.setPreferredSize(new Dimension(70, 35));
        panel.add(tfResultado, gbc);
    }
    
    // Metodo para crear componentes de operaciones unarias (con un solo operando)
    private void crearComponentesUnarios(String labelText, double num, double resultado, int x, int y, JPanel panel) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        
        // Crea y configura la etiqueta de la operación
        JLabel label = new JLabel(labelText);
        label.setFont(fontGrande);
        label.setPreferredSize(new Dimension(180, 35));
        panel.add(label, gbc);

        // Crea y configura el campo de texto para el número
        gbc.gridx++;
        JTextField tfNum = new JTextField(String.valueOf(num));
        tfNum.setFont(fontGrande);
        tfNum.setEditable(false);
        tfNum.setPreferredSize(new Dimension(70, 35));
        panel.add(tfNum, gbc);

        // Crea y configura la etiqueta "Es"
        gbc.gridx++;
        JLabel labelEs = new JLabel(" Es ");
        labelEs.setFont(fontGrande);
        labelEs.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelEs, gbc);

        // Crea y configura el campo de texto para el resultado
        gbc.gridx++;
        JTextField tfResultado = new JTextField(String.format("%.2f", resultado));
        tfResultado.setFont(fontGrande);
        tfResultado.setEditable(false);
        tfResultado.setPreferredSize(new Dimension(70, 35));
        panel.add(tfResultado, gbc);
    }
}