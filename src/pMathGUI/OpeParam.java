package pMathGUI; // Define el paquete al que pertenece esta clase

// Importa las clases necesarias de las bibliotecas de Java
import java.awt.*;
import javax.swing.*;

// Define la clase OpeParam que extiende la clase ope
public class OpeParam extends ope {
    // Declaración de variables de instancia
    private GridBagConstraints gbc; // Para configurar el diseño de los componentes
    private JInternalFrame parentFrame; // Marco interno padre
    // Constructor de la clase
    public OpeParam(JInternalFrame parent, double iNum1, double iNum2) {
        this.parentFrame = parent;
        parentFrame.setTitle("Operaciones Con Paraemetros");
        
        // Panel principal con padding
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
        parentFrame.setContentPane(mainPanel);
        
        gbc = new GridBagConstraints();
        
        // Titulo
        jlTituloParam = new JLabel("<html><div style='text-align: center;'>OPERACIONES CON<br>RESTRICCIONES</div></html>");
        jlTituloParam.setFont(new Font("Arial Black", Font.BOLD, 30));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 12;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(0, 0, 40, 0);
        mainPanel.add(jlTituloParam, gbc);
        
        // Panel para las operaciones
        JPanel operationsPanel = new JPanel(new GridBagLayout());
        gbc.insets = new Insets(5, 5, 5, 15); // Espaciado entre componentes
        
        // Operaciones baesicas
        crearComponentesOperacion("La division es:", iNum1, iNum2, "/", div(iNum1, iNum2), 0, 0, operationsPanel);
        crearComponentesOperacion("La potencia es:", iNum1, iNum2, "^", expo(iNum1, iNum2), 0, 1, operationsPanel);
        crearComponentesRaiz(iNum1, iNum2, raiz(iNum1, iNum2), 0, 2, operationsPanel);
        crearComponentesLogaritmo(iNum1, iNum2, logBase(iNum1, iNum2), 0, 3, operationsPanel);
        
        // Funciones trigonometricas inversas
        crearComponentesArcTrig("El arcocoseno de:", iNum1, ArcCoSen(iNum1), iNum2, ArcCoSen(iNum2), 0, 4, operationsPanel);
        crearComponentesArcTrig("El arcoseno de:", iNum1, ArcSen(iNum1), iNum2, ArcSen(iNum2), 0, 5, operationsPanel);
        
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
    // Metodo para crear componentes de operación baesica
    private void crearComponentesOperacion(String labelText, double num1, double num2, String operador, double resultado, 
                                         int x, int y, JPanel panel) {
        
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        // Crea y configura la etiqueta de la operación
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
        JTextField tfResultado = new JTextField(Double.isNaN(resultado) ? "Error" : String.format("%.2f", resultado));
        tfResultado.setFont(fontGrande);
        tfResultado.setEditable(false);
        tfResultado.setPreferredSize(new Dimension(70, 35));
        panel.add(tfResultado, gbc);
    }
    // Metodo para crear componentes de operación de raiz
    private void crearComponentesRaiz(double num1, double num2, double resultado, int x, int y, JPanel panel) {
        // Configuración similar a crearComponentesOperacion, pero adaptada para la operación de raiz
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        
        JLabel label = new JLabel("La raiz es:");
        label.setFont(fontGrande);
        label.setPreferredSize(new Dimension(180, 35));
        panel.add(label, gbc);

        gbc.gridx++;
        JTextField tfNum1 = new JTextField(String.valueOf(num1));
        tfNum1.setFont(fontGrande);
        tfNum1.setEditable(false);
        tfNum1.setPreferredSize(new Dimension(70, 35));
        panel.add(tfNum1, gbc);

        gbc.gridx++;
        JLabel labelRaiz = new JLabel(" √ ");
        labelRaiz.setFont(new Font("Arial", Font.BOLD, 35));
        labelRaiz.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelRaiz, gbc);

        gbc.gridx++;
        JTextField tfNum2 = new JTextField(String.valueOf(num2));
        tfNum2.setFont(fontGrande);
        tfNum2.setEditable(false);
        tfNum2.setPreferredSize(new Dimension(70, 35));
        panel.add(tfNum2, gbc);

        gbc.gridx++;
        JLabel labelIgual = new JLabel(" = ");
        labelIgual.setFont(fontGrande);
        labelIgual.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelIgual, gbc);

        gbc.gridx++;
        JTextField tfResultado = new JTextField(Double.isNaN(resultado) ? "Error" : String.format("%.2f", resultado));
        tfResultado.setFont(fontGrande);
        tfResultado.setEditable(false);
        tfResultado.setPreferredSize(new Dimension(70, 35));
        panel.add(tfResultado, gbc);
    }
    // Metodo para crear componentes de operación de logaritmo
    private void crearComponentesLogaritmo(double num1, double num2, double resultado, int x, int y, JPanel panel) {
        // Configuración similar a crearComponentesOperacion, pero adaptada para la operación de logaritmo
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        
        JLabel label = new JLabel("El logaritmo de:");
        label.setFont(fontGrande);
        label.setPreferredSize(new Dimension(180, 35));
        panel.add(label, gbc);

        gbc.gridx++;
        JTextField tfNum1 = new JTextField(String.valueOf(num1));
        tfNum1.setFont(fontGrande);
        tfNum1.setEditable(false);
        tfNum1.setPreferredSize(new Dimension(70, 35));
        panel.add(tfNum1, gbc);

        gbc.gridx++;
        JLabel labelBase = new JLabel(" Base ");
        labelBase.setFont(fontGrande);
        labelBase.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelBase, gbc);

        gbc.gridx++;
        JTextField tfNum2 = new JTextField(String.valueOf(num2));
        tfNum2.setFont(fontGrande);
        tfNum2.setEditable(false);
        tfNum2.setPreferredSize(new Dimension(70, 35));
        panel.add(tfNum2, gbc);

        gbc.gridx++;
        JLabel labelEs = new JLabel(" Es ");
        labelEs.setFont(fontGrande);
        labelEs.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelEs, gbc);

        gbc.gridx++;
        JTextField tfResultado = new JTextField(Double.isNaN(resultado) ? "Error" : String.format("%.2f", resultado));
        tfResultado.setFont(fontGrande);
        tfResultado.setEditable(false);
        tfResultado.setPreferredSize(new Dimension(70, 35));
        panel.add(tfResultado, gbc);
    }
    // Metodo para crear componentes de operaciones trigonometricas inversas
    private void crearComponentesArcTrig(String labelText, double num1, double res1, double num2, double res2, 
                                       int x, int y, JPanel panel) {
        // Configuración similar a crearComponentesOperacion, pero adaptada para operaciones trigonometricas inversas
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        
        JLabel label = new JLabel(labelText);
        label.setFont(fontGrande);
        label.setPreferredSize(new Dimension(180, 35));
        panel.add(label, gbc);

        gbc.gridx++;
        JTextField tfNum1 = new JTextField(String.valueOf(num1));
        tfNum1.setFont(fontGrande);
        tfNum1.setEditable(false);
        tfNum1.setPreferredSize(new Dimension(70, 35));
        panel.add(tfNum1, gbc);

        gbc.gridx++;
        JLabel labelEs1 = new JLabel(" Es ");
        labelEs1.setFont(fontGrande);
        labelEs1.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelEs1, gbc);

        gbc.gridx++;
        JTextField tfRes1 = new JTextField(Double.isNaN(res1) ? "Error" : String.format("%.2f", res1));
        tfRes1.setFont(fontGrande);
        tfRes1.setEditable(false);
        tfRes1.setPreferredSize(new Dimension(70, 35));
        panel.add(tfRes1, gbc);

        gbc.gridx++;
        JLabel labelDe = new JLabel("y de: ");
        labelDe.setFont(fontGrande);
        labelDe.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelDe, gbc);

        gbc.gridx++;
        JTextField tfNum2 = new JTextField(String.valueOf(num2));
        tfNum2.setFont(fontGrande);
        tfNum2.setEditable(false);
        tfNum2.setPreferredSize(new Dimension(70, 35));
        panel.add(tfNum2, gbc);

        gbc.gridx++;
        JLabel labelEs2 = new JLabel(" Es ");
        labelEs2.setFont(fontGrande);
        labelEs2.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelEs2, gbc);

        gbc.gridx++;
        JTextField tfRes2 = new JTextField(Double.isNaN(res2) ? "Error" : String.format("%.2f", res2));
        tfRes2.setFont(fontGrande);
        tfRes2.setEditable(false);
        tfRes2.setPreferredSize(new Dimension(70, 35));
        panel.add(tfRes2, gbc);
    }
}