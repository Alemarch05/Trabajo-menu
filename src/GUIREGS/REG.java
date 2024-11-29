package GUIREGS; // Define el paquete al que pertenece esta clase

// Importa las clases necesarias de las bibliotecas de Java
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

// Define la clase REG que extiende JPanel e implementa ActionListener
public class REG extends JPanel implements ActionListener {
    
    // Declaracion de variables de instancia
    int a = 0; // Variable no utilizada en este codigo
    int cambiar = 0; // Contador para el numero de personas registradas
    int cantCampos; // Almacena la cantidad de campos por persona
    int cantPersonas; // Almacena la cantidad de personas a registrar
    String[] titulo; // Array para almacenar los nombres de los campos
    String[][] cliente; // Array bidimensional para almacenar los datos de los clientes

    // Componentes de la interfaz grafica
    JTable tabla = new JTable(); // Tabla para mostrar los datos
    JButton btnok, btnokCambiar, btnMostrarTabla; // Botones de la interfaz
    JLabel lblTitulo; // Etiqueta para el titulo
    JPanel buttonPanel, tablePanel, mainPanel; // Paneles para organizar los componentes

    // Constructor de la clase
    public REG(JInternalFrame parent) {
        setLayout(new BorderLayout()); // Establece el diseño del panel principal

        // Crea y configura la etiqueta del titulo
        lblTitulo = new JLabel("Registro de Personas", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 24));
        add(lblTitulo, BorderLayout.NORTH); // Añade el titulo en la parte superior

        // Crea y añade el panel principal
        mainPanel = new JPanel(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

        // Crea y configura el panel de botones
        buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Establece el espaciado entre componentes

        // Crea y configura los botones
        btnok = new JButton("Inicio");
        btnokCambiar = new JButton("Siguiente");
        btnMostrarTabla = new JButton("Mostrar Tabla");
        btnMostrarTabla.setVisible(false); // Oculta inicialmente el boton de mostrar tabla

        // Establece la fuente de los botones
        btnok.setFont(new Font("Arial", Font.PLAIN, 18));
        btnokCambiar.setFont(new Font("Arial", Font.PLAIN, 18));
        btnMostrarTabla.setFont(new Font("Arial", Font.PLAIN, 18));

        // Establece los tooltips de los botones
        btnok.setToolTipText("Confirmar cantidad de personas y campos");
        btnokCambiar.setToolTipText("Registrar datos de la siguiente persona");
        btnMostrarTabla.setToolTipText("Mostrar la tabla con los datos registrados");

        // Carga y escala las imagenes para los iconos de los botones
        ImageIcon imgIcon1 = new ImageIcon("src/IMAGENTOTA/PLAY.png");
        Image img1 = imgIcon1.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon imgIcon2 = new ImageIcon("src/IMAGENTOTA/NEXT.png");
        Image img2 = imgIcon2.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon imgIcon3 = new ImageIcon("src/IMAGENTOTA/TABLE.png");
        Image img3 = imgIcon3.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        
        // Asigna los iconos a los botones
        btnok.setIcon(new ImageIcon(img1));
        btnokCambiar.setIcon(new ImageIcon(img2));
        btnMostrarTabla.setIcon(new ImageIcon(img3));

        // Añade los botones al panel de botones
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(btnok, gbc);

        gbc.gridy = 1;
        buttonPanel.add(btnokCambiar, gbc);

        gbc.gridy = 2;
        buttonPanel.add(btnMostrarTabla, gbc);

        // Añade el panel de botones al panel principal
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Crea el panel para la tabla
        tablePanel = new JPanel(new BorderLayout());

        // Añade los listeners a los botones
        btnok.addActionListener(this);
        btnokCambiar.addActionListener(this);
        btnMostrarTabla.addActionListener(this);
    }

    // Metodo que maneja los eventos de los botones
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnok) {
            // Solicita la cantidad de personas y campos
            cantPersonas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de personas a registrar:"));
            cantCampos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de campos por persona:"));

            // Inicializa los arrays para almacenar los datos
            titulo = new String[cantCampos];
            cliente = new String[cantPersonas][cantCampos];

            // Solicita los nombres de los campos
            for (int i = 0; i < cantCampos; i++) {
                titulo[i] = JOptionPane.showInputDialog("Nombre del Campo " + (i + 1));
                // Convierte el nombre del campo a mayusculas
                titulo[i] = titulo[i].toUpperCase();
            }

            btnok.setEnabled(false); // Desactiva el boton de inicio
        }

        if (ae.getSource() == btnokCambiar) {
            if (cambiar < cantPersonas) {
                // Solicita los datos de cada persona
                for (int i = 0; i < cantCampos; i++) {
                    cliente[cambiar][i] = JOptionPane.showInputDialog("Ingrese " + titulo[i] + " para Persona " + (cambiar + 1));
                }
                cambiar++; // Incrementa el contador de personas registradas
            }
            
            if (cambiar == cantPersonas) {
                // Si se han registrado todas las personas, desactiva el boton de cambiar y muestra el de mostrar tabla
                btnokCambiar.setEnabled(false);
                btnMostrarTabla.setVisible(true);
            }
        }

        if (ae.getSource() == btnMostrarTabla) {
            mostrarTabla(); // Llama al metodo para mostrar la tabla
        }
    }

    // Metodo para mostrar la tabla con los datos registrados
    private void mostrarTabla() {
        // Crea un modelo de tabla con los datos registrados
        DefaultTableModel model = new DefaultTableModel(cliente, titulo);
        tabla.setModel(model);

        // Configura el aspecto de la tabla
        tabla.setRowHeight(30);
        tabla.setFont(new Font("Arial", Font.PLAIN, 12));

        // Crea un panel de desplazamiento para la tabla
        JScrollPane scrollPane = new JScrollPane(tabla);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        // Elimina todos los componentes del panel principal y muestra solo la tabla
        mainPanel.removeAll();
        mainPanel.add(tablePanel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
}