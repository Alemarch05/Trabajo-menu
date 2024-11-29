/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extractorpalabras;

import javax.swing.*; // Importamos clases de Swing para crear la interfaz gráfica
import java.awt.*; // Importamos clases de AWT para manejar la disposición y componentes
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Clase GUI: Encargada de construir la interfaz gráfica del extractor de palabras
public class GUI extends JInternalFrame implements ActionListener {

    // Declaración de componentes de la GUI
    private JTextField jtTxtIngre; // Campo de texto para ingresar la palabra
    private JLabel jlTxtResult, jlImagen, jlMayus, jlMinus, jlVocal, jlConson, jlNums, jlTild, jlEñe, jlComs, jlEspa, jlCerra; // Etiquetas para mostrar resultados e imágenes
    private JButton btOp1, btOp2, btOp3, btOp4, btOp5, btOp6, btOp7, btOp8, btOp9, btCerrar; // Botones para las diferentes funciones
    int ancho = 100;
    int alto = 150;
    public GUI() {
        super("Extractor de Palabras", true, true, true, true);
        setTitle("EXTRACTOR DE PALABRAS"); // Título de la ventana
        setSize(700, 600); // Tamaño de la ventana
        
        // Usamos GridLayout con 6 filas y 2 columnas para organizar los botones y resultados
        setLayout(new GridLayout(6, 2, 10, 10)); // 6 filas, 2 columnas, con espacio de 10px entre los componentes
        
        // Establecer la acción de cierre para que no cierre la aplicación, solo el InternalFrame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

        // Etiqueta del título
        JLabel jlTitulo = new JLabel("EXTRACTOR DE PALABRAS", SwingConstants.CENTER);
        jlTitulo.setFont(new Font("Arial", Font.BOLD, 16)); // Cambiar fuente para mayor visibilidad
        add(jlTitulo); // La agregamos en la cuadrícula

        // Etiqueta para ingresar texto
        JLabel jlIngtxt = new JLabel("Ingrese el texto:");
        add(jlIngtxt); // La agregamos en la cuadrícula

        // Campo de texto para entrada
        jtTxtIngre = new JTextField();
        add(jtTxtIngre); // La agregamos en la cuadrícula

        
        ImageIcon iconMayus = new ImageIcon(getClass().getResource("/IMAGENTOTA/mayus.jpeg"));
        ImageIcon iconMinus = new ImageIcon(getClass().getResource("/IMAGENTOTA/minus.jpeg"));
        ImageIcon iconVocal = new ImageIcon(getClass().getResource("/IMAGENTOTA/vocales.jpg"));
        ImageIcon iconConson = new ImageIcon(getClass().getResource("/IMAGENTOTA/consonantes.jpg"));
        ImageIcon iconNums = new ImageIcon(getClass().getResource("/IMAGENTOTA/numeros.jpg"));
        ImageIcon iconTild = new ImageIcon(getClass().getResource("/IMAGENTOTA/tilde.png"));
        ImageIcon iconEñes = new ImageIcon(getClass().getResource("/IMAGENTOTA/ñ.png"));
        ImageIcon iconComs = new ImageIcon(getClass().getResource("/IMAGENTOTA/Comodines.png"));
        ImageIcon iconEspa = new ImageIcon(getClass().getResource("/IMAGENTOTA/espacio.jpeg"));
        ImageIcon iconCerra = new ImageIcon(getClass().getResource("/IMAGENTOTA/cerrar.jpeg"));
       
        
        //Redimensionamos las imagenes
        
        Image imgMayus = iconMayus.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        Image imgMinus = iconMinus.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        Image imgVocal = iconVocal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        Image imgConson = iconConson.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        Image imgNums = iconNums.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        Image imgTild = iconTild.getImage().getScaledInstance(ancho, 60, Image.SCALE_SMOOTH);
        Image imgEñes = iconEñes.getImage().getScaledInstance(ancho, 60, Image.SCALE_SMOOTH);
        Image imgComs = iconComs.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        Image imgEspa = iconEspa.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        Image imgCerra = iconCerra.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        
        ImageIcon sIconMayus = new ImageIcon(imgMayus);
        ImageIcon sIconMinus = new ImageIcon(imgMinus);
        ImageIcon sIconVocal = new ImageIcon(imgVocal);
        ImageIcon sIconConson = new ImageIcon(imgConson);
        ImageIcon sIconNums = new ImageIcon(imgNums);
        ImageIcon sIconTild = new ImageIcon(imgTild);
        ImageIcon sIconEñe = new ImageIcon(imgEñes);
        ImageIcon sIconComs = new ImageIcon(imgComs);
        ImageIcon sIconEspa = new ImageIcon(imgEspa);
        ImageIcon sIconCerra = new ImageIcon(imgCerra);
        
        jlMayus = new JLabel(sIconMayus);
        jlMinus = new JLabel(sIconMinus);
        jlVocal = new JLabel(sIconVocal);
        jlConson = new JLabel(sIconConson);
        jlNums = new JLabel(sIconNums);
        jlTild = new JLabel(sIconTild);
        jlEñe = new JLabel(sIconEñe);
        jlComs = new JLabel(sIconComs);
        jlEspa = new JLabel(sIconEspa);
        jlCerra = new JLabel(sIconCerra);
        
        
        
        
           
        // Botones para las diferentes opciones de extracción
        btOp1 = new JButton("Mayúsculas", sIconMayus);
        btOp1.addActionListener(this); // Agregamos ActionListener
        add(btOp1);
        

        btOp2 = new JButton("Minúsculas", sIconMinus);
        btOp2.addActionListener(this); // Agregamos ActionListener
        add(btOp2);
        

        btOp3 = new JButton("Vocales", sIconVocal);
        btOp3.addActionListener(this);
        add(btOp3);

        btOp4 = new JButton("Consonantes", sIconConson);
        btOp4.addActionListener(this);
        add(btOp4);

        btOp5 = new JButton("Números", sIconNums);
        btOp5.addActionListener(this);
        add(btOp5);

        btOp6 = new JButton("Tildes", sIconTild);
        btOp6.addActionListener(this);
        add(btOp6);

        btOp7 = new JButton("Eñes", sIconEñe);
        btOp7.addActionListener(this);
        add(btOp7);

        btOp8 = new JButton("Comodines", sIconComs);
        btOp8.addActionListener(this);
        add(btOp8);

        btOp9 = new JButton("Espacios", sIconEspa);
        btOp9.addActionListener(this);
        add(btOp9);

        // Botón para cerrar el JInternalFrame
        btCerrar = new JButton("Cerrar", sIconCerra);
        btCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra el JInternalFrame cuando se presiona el botón
            }
        });
        add(btCerrar); // Lo agregamos en la cuadrícula
        
        
        
        // Etiqueta para mostrar el resultado de la extracción
        jlTxtResult = new JLabel();
        add(jlTxtResult); // La agregamos en la cuadrícula

        // Cargar una imagen y redimensionarla
        ImageIcon icon = new ImageIcon("src/IMAGENTOTA/morrongobobien.jpg");
        
        
        // Dimensiones deseadas para la imagen
        
        
        // Redimensionar la imagen
        Image imagenEscalada = icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        
        
        
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
        
        // Añadir la imagen al JLabel
        jlImagen = new JLabel(iconoEscalado);
        
        add(jlImagen); // La agregamos en la cuadrícula
        
        

        setVisible(true); // Hacer visible la ventana
    }

    // Método para obtener el texto ingresado
    public String getPalabra() {
        return jtTxtIngre.getText();
    }

    // Método para mostrar el resultado de la extracción
    public void mostrarResultado(String resultado) {
        jlTxtResult.setText("Resultado: " + resultado);
    }

    // Método para mostrar mensajes de error o información
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    // Métodos para obtener los botones
    public JButton getBtOp1() { return btOp1; }
    public JButton getBtOp2() { return btOp2; }
    public JButton getBtOp3() { return btOp3; }
    public JButton getBtOp4() { return btOp4; }
    public JButton getBtOp5() { return btOp5; }
    public JButton getBtOp6() { return btOp6; }
    public JButton getBtOp7() { return btOp7; }
    public JButton getBtOp8() { return btOp8; }
    public JButton getBtOp9() { return btOp9; }
    public JButton getBtCerrar() { return btCerrar; }

    @Override
    public void actionPerformed(ActionEvent e) {
        ExtractorPalabras extractor = new ExtractorPalabras();
        String palabra = getPalabra();
        if (palabra == null || palabra.isEmpty()) {
            mostrarResultado("Ingrese una palabra.");
            return;
        }

        String resultado = "";
        if (e.getSource() == btOp1) {
            resultado = extractor.extraerMayusculas(palabra);
        } else if (e.getSource() == btOp2) {
            resultado = extractor.extraerMinusculas(palabra);
        } else if (e.getSource() == btOp3) {
            resultado = extractor.extraerVocales(palabra);
        } else if (e.getSource() == btOp4) {
            resultado = extractor.extraerConsonantes(palabra);
        } else if (e.getSource() == btOp5) {
            resultado = extractor.extraerNumeros(palabra);
        } else if (e.getSource() == btOp6) {
            resultado = extractor.extraerTildes(palabra);
        } else if (e.getSource() == btOp7) {
            resultado = extractor.extraerEnies(palabra);
        } else if (e.getSource() == btOp8) {
            resultado = extractor.extraerComodines(palabra);
        } else if (e.getSource() == btOp9) {
            resultado = extractor.extraerEspacios(palabra);
        }

        mostrarResultado(resultado);
    }
}


