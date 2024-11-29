package GUIREGS; // Define el paquete al que pertenece esta clase

// Importa las clases necesarias de las bibliotecas de Java
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// Define la clase REGUNIDOS que extiende JInternalFrame e implementa ActionListener
public class REGUNIDOS extends JInternalFrame implements ActionListener {

    // Declaracion de componentes de la interfaz grafica
    private JButton btnRegistroManual;
    private JButton btnRegistroCreado;
    private JLabel lblPregunta;
    private JPanel menuPanel, contentPanel;
    private CardLayout cardLayout;

    // Constructor de la clase
    public REGUNIDOS() {
        // Llama al constructor de JInternalFrame con parametros para configurar la ventana
        super("Registros", true, true, true, true);
        setLayout(new BorderLayout()); // Establece el diseño del frame
        setSize(1000, 600); // Establece el tamaño del frame

        // Inicializa los paneles
        menuPanel = new JPanel(new GridBagLayout());
        contentPanel = new JPanel(new CardLayout());
        cardLayout = (CardLayout) contentPanel.getLayout();

        // Configura las restricciones para el GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Establece el espaciado entre componentes

        // Crea y configura la etiqueta de pregunta
        lblPregunta = new JLabel("¿Que tipo de registro quieres?", JLabel.CENTER);
        lblPregunta.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        menuPanel.add(lblPregunta, gbc);
// Crea y configura el boton de Registro Manual
btnRegistroManual = new JButton("Registro Manual");
btnRegistroManual.setFont(new Font("Arial", Font.PLAIN, 14));

// Carga la imagen como icono, y la escala
ImageIcon iconoRegistro = new ImageIcon("src/IMAGENTOTA/Registross.jpg");
Image imagenRegistro = iconoRegistro.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
ImageIcon iconoRegistroEscalado = new ImageIcon(imagenRegistro);
btnRegistroManual.setIcon(iconoRegistroEscalado);

btnRegistroManual.addActionListener(this);
gbc.gridy = 1;
gbc.gridwidth = 1;
menuPanel.add(btnRegistroManual, gbc);

// Crea y configura el boton de Registro Creado
btnRegistroCreado = new JButton("Registro Creado");
btnRegistroCreado.setFont(new Font("Arial", Font.PLAIN, 14));

// Carga la imagen y la escala
ImageIcon icono = new ImageIcon("src/IMAGENTOTA/RegistroCre.png");
Image imagen = icono.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
ImageIcon iconoEscalado = new ImageIcon(imagen);
btnRegistroCreado.setIcon(iconoEscalado);

btnRegistroCreado.addActionListener(this);
gbc.gridx = 1;
menuPanel.add(btnRegistroCreado, gbc);

// Añade el panel de menu al frame
add(menuPanel, BorderLayout.CENTER);



        setVisible(true); // Hace visible el frame
    }

    // Metodo que maneja los eventos de los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        remove(menuPanel); // Elimina el panel de menu
        if (e.getSource() == btnRegistroManual) {
            // Crea y muestra el panel de Registro Manual
            REG regPanel = new REG(this);
            contentPanel.add(regPanel, "REG");
            cardLayout.show(contentPanel, "REG");
        } else if (e.getSource() == btnRegistroCreado) {
            // Crea y muestra el panel de Registro Creado
            REGCREADO regCreadoPanel = new REGCREADO(this);
            contentPanel.add(regCreadoPanel, "REGCREADO");
            cardLayout.show(contentPanel, "REGCREADO");
        }
        add(contentPanel, BorderLayout.CENTER); // Añade el panel de contenido
        revalidate(); // Revalida el layout
        repaint(); // Vuelve a pintar el componente
    }
}