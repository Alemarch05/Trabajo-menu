package GUIREGS; // Define el paquete al que pertenece esta clase

// Importa las clases necesarias de las bibliotecas de Java
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

// Define la clase REGCREADO que extiende JPanel
public class REGCREADO extends JPanel {
    
    // Array con los nombres de las columnas de la tabla
    String[] sDatos = { "ID", "NOMBRE", "APELLIDOS", "NACIONALIDAD", "ESTADO CIVIL", "GeNERO", "FECHA DE NACIMIENTO",
            "LUGAR DE NACIMIENTO", "PESO", "ALTURA", "TELeFONO", "COLOR DE OJOS", "COLOR DE CABELLO", "IDIOMAS",
            "OCUPACIoN", "HOBBIES", "PASATIEMPOS" };

    // Array bidimensional con los datos de los registros
    Object[][] oRegistros = { 
        { "01", "Alejandro", "Martinez", "Colombia", "Casado", "Masculino", "2005/02/19",
          "Bogota", 76, 1.75, "+57 300 123 4567", "Cafe", "Negro", "Español, Ingles", "Estudiante",
          "Fotografia, Lectura", "Jugar futbol, Ver peliculas" },
        { "02", "Ana", "Garcia", "España", "Soltera", "Femenino", "1996/03/15", "Valencia", 58, 1.65,
          "+34 612 345 678", "Grises", "Castaño", "Español, Ingles, Frances", "Ingeniera de software",
          "Fotografia, senderismo", "Leer novelas de ciencia ficcion, cocinar" },
        { "03", "Carlos", "Rodriguez", "Mexico", "Casado", "Masculino", "1989/09/22", "Guadalajara", 75, 1.78,
          "+52 33 1234 5678", "Verde", "Negro", "Español, Ingles", "Arquitecto",
          "Tocar guitarra,pintar", "Ver documentales, jardineria" } 
    };

    // Declaracion de componentes de la interfaz grafica
    JTable tabla;
    JButton btBuscar;
    JTextField tfBuscarID;
    JLabel lblBuscarID, lblFoto;
    JScrollPane scrollPane;
    DefaultTableModel modeloTabla;
    
    // Constructor de la clase
    public REGCREADO(JInternalFrame parent) {
        setLayout(new BorderLayout()); // Establece el diseño del panel principal

        // Crea un panel superior con GridBagLayout para los controles de busqueda
        JPanel topPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Establece el espaciado entre componentes

        // Crea el modelo de la tabla y la tabla
        modeloTabla = new DefaultTableModel(oRegistros, sDatos);
        tabla = new JTable(modeloTabla);
        tabla.setFont(new Font("Arial", Font.PLAIN, 12));
        tabla.setRowHeight(30);
        
        // Establece el ancho de las columnas de la tabla
        int[] anchos = { 40, 100, 100, 100, 100, 80, 150, 120, 50, 50, 150, 80, 80, 150, 100, 100, 100 };
        for (int i = 0; i < anchos.length; i++) {
            tabla.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }

        // Crea un panel de desplazamiento para la tabla
        scrollPane = new JScrollPane(tabla);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // Crea y configura la etiqueta y el campo de texto para buscar por ID
        lblBuscarID = new JLabel("Buscar por ID:");
        lblBuscarID.setFont(new Font("Arial Black", Font.PLAIN, 12));

        tfBuscarID = new JTextField(10);
        tfBuscarID.setFont(new Font("Arial", Font.PLAIN, 12));

        // Crea y configura el boton de busqueda
        ImageIcon iconLupa = new ImageIcon(new ImageIcon("src/IMAGENTOTA/LUPA.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        btBuscar = new JButton("Buscar", iconLupa);
        btBuscar.setToolTipText("BUSCAR");
        btBuscar.setFont(new Font("Arial", Font.PLAIN, 12));

        // Crea y configura la etiqueta para mostrar la foto
        lblFoto = new JLabel("Foto");
        lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
        lblFoto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblFoto.setFont(new Font("Arial", Font.PLAIN, 12));
        lblFoto.setPreferredSize(new Dimension(150, 150));

        // Añade un ActionListener al boton de busqueda
        btBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarRegistroPorID(tfBuscarID.getText());
            }
        });

        // Añade los componentes al panel superior usando GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        topPanel.add(lblFoto, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        topPanel.add(lblBuscarID, gbc);

        gbc.gridy = 1;
        topPanel.add(tfBuscarID, gbc);

        gbc.gridx = 2;
        topPanel.add(btBuscar, gbc);

        // Añade el panel superior y la tabla al panel principal
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Metodo para buscar un registro por ID
    private void buscarRegistroPorID(String id) {
        boolean encontrado = false;
        modeloTabla.setRowCount(0); // Limpia la tabla

        // Busca el registro con el ID especificado
        for (Object[] registro : oRegistros) {
            if (registro[0].equals(id)) {
                modeloTabla.addRow(registro);
                mostrarFoto(id);
                lblFoto.setText("");
                encontrado = true;
                break;
            }
        }

        // Si no se encuentra el ID, muestra un mensaje de error y todos los registros
        if (!encontrado) {
            JOptionPane.showMessageDialog(this, "ID no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            for (Object[] registro : oRegistros) {
                modeloTabla.addRow(registro);
            }
            lblFoto.setIcon(null);
            lblFoto.setText("Foto");
        }
    }

    // Metodo para mostrar la foto correspondiente al ID
    private void mostrarFoto(String id) {
        String rutaImagen = "";
        // Selecciona la ruta de la imagen segun el ID
        switch (id) {
            case "01":
                rutaImagen = "src/IMAGENTOTA/Alejo.jpg";
                break;
            case "02":
                rutaImagen = "src/IMAGENTOTA/ana.jpg";
                break;
            case "03":
                rutaImagen = "src/IMAGENTOTA/carlos.jpg";
                break;
        }

        try {
            // Carga y muestra la imagen
            BufferedImage img = ImageIO.read(new File(rutaImagen));
            ImageIcon icon = new ImageIcon(img.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
            lblFoto.setIcon(icon);
        } catch (Exception ex) {
            // Si hay un error al cargar la imagen, muestra un mensaje de error
            lblFoto.setIcon(null);
            JOptionPane.showMessageDialog(this, "No se pudo cargar la imagen: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}