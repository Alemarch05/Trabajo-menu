package log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz implements ActionListener 
{
    ImageIcon img1 = new ImageIcon(getClass().getResource("/IMAGENTOTA/images.jpg"));    
    JPanel jpnCombox, jpnInstruccion,jpnbotones,jpnEspacio,jpnEspacioblanco;
    JButton btn1, btn3;
    JMenuItem itemAhorcado, itemOperacion, itemMult, itemReg, itemExt,itemBD,itemInicio;
    JDesktopPane dkpAhorcado;
    JFrame mdi = new JFrame("Menu"); // Ventana principal (MDI)
    JLabel lblFto, lbl1, lblOp,lblAho,lblExt,lblTab,lblReg,lbl4,lblEs1,lblEs2,lblEs3;
    JTextField txt1, txt2;
     String descripcionOp = "OPERACION: EN ESTE PRIMER JUEGO VAMOS A TENER UNA APLICACION QUE NOS PERMITE REALIZAR OPERACIONES\n"
                + "A TRAVEZ DE DOS NUMEROS DIGITADOS ESTOS NOS VA A PERMITIR REALIZAR OPERACION\n"
                + "CON Y SIN RESTRICCIONES";
     String descripcionAho = "AHORCADO: EN ESTE JUEGO VAMOS A TENER UNA APLICACION QUE VA A SIMULAR UN AHORCADO EL CUAL\n"
                + "SOLO USA CONCEPTOS DE PROGRAMACION. \n"
                + "";
     String descripcionExt = "EXTRACTOR DE PALABRAS: EN ESTE JUEGO VAMOS A TENER UNA APLICACION QUE NOS PERMITE DIGITALIZAR\n"
                + "LA CUAL SE VA A PODER SEPARAR LAS LETRAS BAJO CONDICIONES QUE SE IMPONGAN\n"
                + "";
     String descripcionTab = "TABLAS DE MULTIPLICAR: EN ESTE JUEGO VAMOS A TENER UNA APLICACION QUE NOS PERMITE INGRESAR RANGOS\n"
                + "PARA MOSTRAR LAS TABLAS DE MULTIPLICAR\n"
                + "";
     String descripcionReg= "REGISTROS: EN ESTE JUEGO VAMOS A TENER UNA APLICACION QUE NOS PERMITE REALIZAR REGISTROS\n"
                + "O CONSULTARLOS\n"
                + "";

   

    public Interfaz() 
    {
        lblFto = new JLabel("");
        ImageIcon mita = new ImageIcon(img1.getImage().getScaledInstance(1400,500, Image.SCALE_DEFAULT));
        lblFto.setIcon(mita);
        lbl1 = new JLabel("Title",JLabel.CENTER);
        lblAho = new JLabel("Contenido",JLabel.CENTER);
        lblExt = new JLabel("Contenido",JLabel.CENTER);
        lblOp = new JLabel("Contenido",JLabel.CENTER);
        lblTab = new JLabel("Contenido",JLabel.CENTER);
        lblReg = new JLabel("Contenido",JLabel.CENTER);
        lbl4 = new JLabel("");
        lblEs1 = new JLabel("");
        lblEs2 = new JLabel("");
        lblEs3 = new JLabel("");
       
        lbl1.setText("Instrucciones");
        lblAho.setText("Contenido");
        
        jpnCombox = new JPanel(new GridLayout(2,1,5,5));
        jpnEspacio = new JPanel(new GridLayout(1,1,5,5));
        jpnEspacioblanco = new JPanel();
        jpnInstruccion = new JPanel(new GridLayout(6,1,5,5));
        jpnbotones = new JPanel(new GridLayout(2,3,60,100));
        
        // Cargar la imagen de Instrucciones
        ImageIcon instruccionesIcono = new ImageIcon("src/IMAGENTOTA/Instrucciones.png");
        Image instruccionesImagen = instruccionesIcono.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon instruccionesIconoEscalado = new ImageIcon(instruccionesImagen);

        // Crear el botón y asignarle la imagen
        btn1 = new JButton("Instrucciones");
        btn1.setIcon(instruccionesIconoEscalado);

        // Cargar la imagen de Salir
        ImageIcon salirIcono = new ImageIcon("src/IMAGENTOTA/salir.png");
        Image salirImagen = salirIcono.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon salirIconoEscalado = new ImageIcon(salirImagen);

        // Crear el botón y asignarle la imagen
        btn3 = new JButton("Salir");
        btn3.setIcon(salirIconoEscalado);
        
        btn1.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        btn3.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        btn1.addActionListener(this);
        btn3.addActionListener(this);
        
        jpnEspacio.add(lblFto);
        jpnbotones.add(lblEs1);
        jpnbotones.add(lblEs2);
        jpnbotones.add(lblEs3);
        jpnbotones.add(btn1);
        jpnbotones.add(lbl4);
        jpnbotones.add(btn3);
        
        mdi.setLayout(new GridLayout(2,1,90,20));
        mdi.setTitle("Juegos MDI");
        mdi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mdi.add(jpnEspacio);
        mdi.add(jpnbotones);
        
        // Configuración del JDesktopPane para las ventanas internas
        dkpAhorcado = new JDesktopPane();
        
        // Agregar los botones del menú
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opciones");
        menu.setIcon(createScaledIcon("src/IMAGENTOTA/imgOptions.png", 30,30));
        
        
        itemBD = new JMenuItem("BASES DE DATOS");
        itemInicio = new JMenuItem("INICIO");
        
        JMenu menuAhorcado = new JMenu("Juego Ahorcado");
        menuAhorcado.setIcon(createScaledIcon("src/IMAGENTOTA/imgAhorcado.png", 30,30));
        
        itemAhorcado = new JMenuItem("JUEGO");
        itemAhorcado.setIcon(createScaledIcon("src/IMAGENTOTA/PLAY.png", 20,20));
        
        JMenu menuMult = new JMenu("Tablas Multiplicar");
        menuMult.setIcon(createScaledIcon("src/IMAGENTOTA/SinParametros.png", 30,30));
        
        itemMult = new JMenuItem("JUEGO");
        itemMult.setIcon(createScaledIcon("src/IMAGENTOTA/PLAY.png", 20,20));
        
        JMenu menuExt = new JMenu("Extractor");
        menuExt.setIcon(createScaledIcon("src/IMAGENTOTA/imgPalabras.png", 30,30));
        
        itemExt = new JMenuItem("JUEGO");
        itemExt.setIcon(createScaledIcon("src/IMAGENTOTA/PLAY.png", 20,20));
        
        JMenu menuReg = new JMenu("Registros");
        menuReg.setIcon(createScaledIcon("src/IMAGENTOTA/imgRegistro.png", 30,30));
        
        itemReg = new JMenuItem("JUEGO");
        itemReg.setIcon(createScaledIcon("src/IMAGENTOTA/PLAY.png", 20,20));
        
        JMenu menuOperacion = new JMenu("Operaciones");
        menuOperacion.setIcon(createScaledIcon("src/IMAGENTOTA/imgOperaciones.png", 30,30));
        
        itemOperacion = new JMenuItem("JUEGO");
        itemOperacion.setIcon(createScaledIcon("src/IMAGENTOTA/PLAY.png", 20,20));

        
        
        
        // Agregar ActionListener a los elementos
        itemInicio.addActionListener(this);
        itemBD.addActionListener(this);
        itemAhorcado.addActionListener(this);
        itemOperacion.addActionListener(this);
        itemExt.addActionListener(this);
        itemMult.addActionListener(this);
        itemReg.addActionListener(this);
        menu.add(itemInicio);
        menu.add(itemBD);
        menuOperacion.add(itemOperacion);
        menuAhorcado.add(itemAhorcado);
        menuExt.add(itemExt);
        menuReg.add(itemReg);
        menuMult.add(itemMult);
        menuBar.add(menuOperacion);
        menuBar.add(menuAhorcado);
        menuBar.add(menuExt);
        menuBar.add(menuMult);
        menuBar.add(menuReg);
        menuBar.add(menu);
        mdi.setJMenuBar(menuBar);

        
        
        // Configuración de la ventana MDI
        mdi.setExtendedState(JFrame.MAXIMIZED_BOTH);
         
        dkpAhorcado.setBounds(0, 5, 1370, 660);

        // Mostrar la ventana principal
        mdi.setVisible(true);
    }

     // Método para escalar la imagen directamente
    private ImageIcon createScaledIcon(String path, int width, int height) {
        ImageIcon originalIcon = new ImageIcon(path); // Cargar la imagen original
        Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH); // Escalar
        return new ImageIcon(scaledImage); // Devolver la imagen escalada
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
       
    }

    public static void main(String[] args) {
        Login login = new Login(null);
        login.setVisible(true);

        // Continuar con el flujo existente
        Union union = new Union();
        ActionEvent e = null;
        union.actionPerformed(e);
        new Interfaz(); // Crear y mostrar la interfaz
       
    }
}
