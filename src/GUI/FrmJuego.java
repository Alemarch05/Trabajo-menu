/*PAQUETE GUI CLASE DONDE SE VA A HACER EL FORMULARIO y MAIN*/
package GUI;
/*Java Abstract Window Toolkit*/
import java.awt.BorderLayout;
import java.awt.Color;
/*
ESTA CLASE DEL PAQUETE AWT CREA COLORES USANDO
 RedGrennBlue (RGB)
*/
import java.awt.Dimension;
/*
//Contiene la altura y el ancho de un componente
en un número entero, así como precisión doble.
*/
import java.awt.Font;
import java.awt.GridLayout;
/*
LA CLASE FONT DEL PAQUETE AWT SIRVE PARA DARLE COLOR ALTURA Y TIPO DE LETRA
A UN TEXTO
*/
import java.awt.Image;
/*
BASICAMENTE ESTA CLASE LA USAMOS PARA LA IMAGEN COMO SCALE_DEFAULT
*/
import java.awt.event.ActionEvent;
/*ESTA CLASE VA A SER EL EMISOR*/
import java.awt.event.ActionListener;
/*CLASE QUE VA A SER EL RECEPTOR EL LISTENER*/
import javax.swing.BorderFactory;
/*NOS PERMITE GENERAR UN RECUADRO Y ESTIPULA COLOR Y DISTINTAS FORMAS*/
import javax.swing.ImageIcon;
/*CLASE LA CUAL NOS VA A PERMITIR TRAER LA IMAGEN DENTRO DE UN
PAQUETE DE UN PROYECTO*/
import javax.swing.JButton;
import javax.swing.JDesktopPane;
/*JFRAME QUE NOS VA A PERMITIR USAR COMPONENTES QUE VA A SER BOTONES*/
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
/*EL JFRAME ES EL FORMULARIO*/
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/*LABELS = ETIQUETAS*/
import javax.swing.JTextField;
/*CUADROS DE TEXTO*/

/*CLASE QUE VA A CONTENER EL MAIN Y EL DISEÑO 
IMPLEMENTS ES INTERFAZ DE ACTIONLISTENER PARA PODER MANEJAR LOS EVENTOS
PERO ESTA NOS VA A HACER USAR EL METODO ActionPerformed(ActionEvent e)*/
public class FrmJuego extends JInternalFrame implements ActionListener
{
    /*INSTANCIAMOS UN OBJETO d EN LA CLASE DIMENSION*/
    Dimension d = new Dimension();
    /*INSTANCIAMOS UN OBJETO img.img1,img2 EN LA CLASE ImageIcon
    El GETCLASS() DEVUELVE EL OBJETO DE LA CLASE PARA INVOCAR AL METODO Y LO
    USAMOS PARA TENER LA RUTA DE ACCESO URL BUSCÁNDOLO EN EL MISMO 
    PROYECTO*/
    ImageIcon imgChulo = new ImageIcon(getClass().getResource("/IMAGENTOTA/imgChulo.png"));
    Image imagenEscalada = imgChulo.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
        
    ImageIcon imgX = new ImageIcon(getClass().getResource("/IMAGENTOTA/cerrar.jpeg"));
    Image imagenEscalada1 = imgX.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado1 = new ImageIcon(imagenEscalada1);
        
    ImageIcon imgReturn = new ImageIcon(getClass().getResource("/IMAGENTOTA/Return.png"));
    Image imagenEscalada2 = imgReturn.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado2 = new ImageIcon(imagenEscalada2);
        
    ImageIcon imgTroste = new ImageIcon(getClass().getResource("/IMAGENTOTA/imgTroste.png"));
    Image imagenEscalada3 = imgTroste.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado3 = new ImageIcon(imagenEscalada3);
    
        ImageIcon imgFeli = new ImageIcon(getClass().getResource("/IMAGENTOTA/imgFelicidad.png"));
    Image imagenEscalada4 = imgFeli.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado4 = new ImageIcon(imagenEscalada4);
    
    ImageIcon img = new ImageIcon(getClass().getResource("/IMAGENTOTA/ahorcado1.jpeg"));
    ImageIcon img1 = new ImageIcon(getClass().getResource("/IMAGENTOTA/user.png"));
    ImageIcon img2 = new ImageIcon(getClass().getResource("/IMAGENTOTA/chulo.png"));

    /*CREAMOS LOS COMPONENTES NECESARIOS PARA NUESTRO GUI*/
    JPanel pnlTop, pnlCenter, pnlBottom;
    JButton btnReg, btnPal, btnSal;
    JLabel lblFoto, lblPal, lblInstru, lblMostrarName, lblMostrarId, lblMostrarScore, lblTitulo,lblVacio1,lblVacio2,lblVacio3;
    JTextField txtUserName, txtUserId, txtPal;
    JDesktopPane dkp;
    ActionEvent e;
    /*CONSTRUCTOR SIN ARGUMENTO / PARAMETROS EL CUAL VA A SER HEREDADO
    A LA CLASE LÓGICA*/
   public static char cResp;
    public static char cLetraAdv;
    public static String sDecicion;
    public static char[] cLetraCorrect;
    private static boolean bVolver;
    private static boolean bGano;
    private static int iIntentos = 0;
    private static boolean bAcierto = true;
    public static int iRandom = 0;
    public static int iScore = 0;
    /*CREAMOS EL OBJETO _palabra PARA USAR SUS METODOS*/
    Diccionario _palabra = new Diccionario();
    public static String Palabra;
    public static String[] guardar;
    public static String snick;
    public static int iidUser;
    public static int iAssiPalMin;
    public static int iAssiPalMayus;
    public static int inumRandom;
    public static String sDesicion;

    /*RANDOMIZAR UN NÚMERO*/
    // MATH.RANDOM ME VA A GENERAR UN NUM ALEATORIO ENTRE LA CANTIDAD DE 
    // OBJETOS QUE TENGA EL ARRAY 
    public int RandomizarNumero() {   
        return inumRandom = (int) (Math.random() * Diccionario.oPalabra.length);
    }

    /*CUANDO SE VALIDE QUE NO HAYAN '_' EN cLetraCorrect, UN CUADRO DIALOGO VA A PREGUNTAR
    SI SE QUIERE CONTINUAR. EN CASO DE QUE SÍ, ME VA A VOLVER A RANDOMIZAR LA PALABRA,
    A RELLENAR LOS GUIONES Y TAMBIÉN A RESETEAR TODAS LAS VARIABLES NECESARIAS Y A VOLVER
    A MOSTRAR ALGUNOS LABELS Y TEXTFIELDS*/
    public void reiniciarJuego() {
        RandomizarNumero();
        // Randomizar una nueva palabra
        _palabra.Randomizar(inumRandom);

        // Reiniciar los guiones
        MostrarGuiones(_palabra.sPalabAdiv);
        cRellenarPalabra(_palabra.sPalabAdiv);
        
        // Resetear intentos y aciertos
        iIntentos = 0;
        bAcierto = true;
        bVolver = true;
        ImageIcon mita = new ImageIcon(img.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
        lblFoto.setIcon(mita);

        // Actualizar el JLabel con los nuevos guiones
        pnlCenter.add(lblPal);
        pnlCenter.add(txtPal);
        pnlCenter.add(btnPal);
        lblPal.setText(Palabra);
        revalidate();
        repaint();
    }

    // VALIDAR SI HAY GUIONES EN EL ARRAY PARA SABER SI SE HA ACERTADO
    public boolean bAcertarPalabra(String sPalabAdiv, char[] cLetraCorrect) {                     
        bGano = true;
        for (int z = 0; z < sPalabAdiv.length(); z++) { 
            if (cLetraCorrect[z] == '_') {
                bGano = false;
                break;
            }
        }
        return bGano;    
    }

    // PASAR A CÓDIGO ASSCI Y SUMARLE 32 PARA PODER PASARLO A MINÚSCULAS
    public static char cMinimizarLetra(char cRes) {
        int iAssiPalMayus = (int) cResp;
        if (iAssiPalMayus >= 65 && iAssiPalMayus <= 90) {
            iAssiPalMin = iAssiPalMayus + 32;
            cResp = (char) iAssiPalMin;
        }
        return cResp;
    }

    // RELLENA EL ARRAY CON LA CANTIDAD DE LETRAS QUE TENGA LA PALABRA RANDOMICA
    public char[] cRellenarPalabra(String sPalabAdiv) {     
        cLetraCorrect = new char[sPalabAdiv.length()];
        
        // RELLENAR cLetraCorrect CON GUIONES YA QUE SE VA A IR PONIENDO
        // LETRAS POR PARTES
        for (int a = 0; a < sPalabAdiv.length(); a++) {
            cLetraCorrect[a] = '_'; //FALTA
        }
        return cLetraCorrect;
    }

    // LOS LABEL PIDEN UN STRING Y SI ESTE ES UN ARRAY, ESTOS NOS VA A GENERAR UN ERROR
    public void MostrarGuiones(String sPalabAdiv) {
        guardar = new String[sPalabAdiv.length()];
        cLetraCorrect = new char[sPalabAdiv.length()];    
        
        // RELLENAR cLetraCorrect CON GUIONES YA QUE SE VA A IR PONIENDO
        // LETRAS POR PARTES
        for (int a = 0; a < sPalabAdiv.length(); a++) {
            cLetraCorrect[a] = '_';
            /*NOS PERMITE CONVERTIR A UNA CADENA DE CARACTERES */
            guardar[a] = String.valueOf(cLetraCorrect[a]) + " ";
        }
        /*USAMOS LA CLASE STRING PARA PODER MODIFICAR ESTE ARRAY YA QUE
        ESTA NOS PERMITE REPRESENTAR UNA SECUENCIA DE CARACTERES CON UN SEPARADOR
        EL CUAL ES EL ESPACIO String.join(delimiter, elements)
        delimiter: Especifica el separador que se colocará entre los elementos
        siendo el elemento un array que pasamos como STRING*/
        Palabra = String.join(" ", guardar);
    }

    // VALIDACIÓN DE LA LETRA DIGITADA CON CADA LETRA DE LA PALABRA
    public void vValidacionPalabras(char guardarLetra, String pal, char[] cLetra) {
        bAcierto = false;
        for (int j = 0; j < pal.length(); j++) {
            cLetraAdv = pal.charAt(j);
            if (guardarLetra == cLetraAdv) {
                cLetra[j] = guardarLetra;
                bAcierto = true;
            }
        }
    }

    public void vMostrarContinuar(int score, JLabel lblMostrarName, JLabel lblMostrarId, int sDecicion, String snick, int iidUser) {
        /*METODO CON PARAMETROS PARA CUANDO SE FALLE 3 VECES O SE GANE Y DEVUELVE UN TRUE PARA REINICIAR EL JUEGO
        O MOSTRAR LOS DATOS DEL USUARIO*/
        if (sDecicion == JOptionPane.YES_OPTION) {
            bVolver = true;
        } else {
            pnlCenter.remove(lblPal);
            pnlCenter.remove(txtPal);
            lblMostrarId.setText(String.valueOf(iidUser));
            lblMostrarName.setText(snick);
            lblMostrarScore.setText(String.valueOf(score));
            pnlCenter.add(lblMostrarId);
            pnlCenter.add(lblMostrarName);
            pnlCenter.add(lblMostrarScore);
            pnlCenter.add(lblTitulo);
            revalidate();
            repaint();
            bVolver = false;
        }
    }

    public String Entar() {
        /*CUADRO DE DIALOGO PARA PODER PREGUNTAR SI SE QUIERE COMENZAR*/
        return sDesicion = JOptionPane.showInputDialog("¿QUIERE COMENZAR CON EL JUEGO?");
    }
    public FrmJuego(ActionEvent e)
    {
    this.e = e;
    }
    public FrmJuego() 
    {
        super("Juego del Ahorcado", true, true, true, true);
        dkp = new JDesktopPane();
        
        setLayout(new GridLayout(3,1,10,10));
        /*LAYOUT ES GESTIÓN DE COMPONENTES
        definir el tipo de layout manager que controlará la disposición
        de los componentes dentro del contenedor (como posicionar y redimensionar)
        los componentes (como botones, etiquetas, paneles, etc. PERO AL DECIRLE QUE VA A HACER
        NULL LE ESTAMOS DICIENDO QUE VAMOS A TRABAJAR TODA LA ORGANIZACIÓN MANUALMENTE*/
        pnlTop = new JPanel();
        pnlTop.setLayout(new GridLayout(1, 1, 20, 20));
        pnlTop.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlCenter = new JPanel();
        pnlCenter.setLayout(new GridLayout(3, 1, 5, 5));
        pnlCenter.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlBottom = new JPanel();
        pnlBottom.setLayout(new GridLayout(2, 1, 5, 2));
        pnlBottom.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        

        //INSTANCIAMOS TODOS LOS COMPONENTES
        lblFoto = new JLabel("",JLabel.CENTER);
        //SET ES MODIFICAR / UPDATE
        /*POSICIÓN = X,Y TAMAÑO = WIDTH, HEIGHT*/
        /*BORDER VISIBLE CON COLOR NEGRO 1 PIXEL*/
        lblFoto.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
        ImageIcon mita = new ImageIcon(img.getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT));
        lblFoto.setIcon(mita);
        pnlTop.add(lblFoto, BorderLayout.CENTER);
        lblPal = new JLabel();
        lblPal.setBounds(50, 480, 400, 60);
        //FONT ES PARA MODIFICAR LA LETRA QUE ESTÉ EN EL LABEL
        lblPal.setFont(new Font("Arial", Font.PLAIN, 24));

        lblInstru = new JLabel("Digite su Nickname e Identificación", JLabel.CENTER);
        
        txtUserName = new JTextField("SU NICK");

        txtUserId = new JTextField("SU ID");

        txtPal = new JTextField("DIGITE PALABRA");
        pnlCenter.add(lblInstru);
        pnlCenter.add(txtUserName);
        pnlCenter.add(txtUserId);
        btnReg = new JButton();
        /*LO USAMOS PARA DAR INDICACIÓN DE QUÉ HACE ESE BOTÓN
        SOBREPONIENDO EL CURSOR SOBRE EL COMPONENTE*/
        btnReg.setToolTipText("DE CLICK PARA INGRESAR DATOS");
        ImageIcon mita1 = new ImageIcon(img1.getImage().getScaledInstance(30, 30, 10));
        btnReg.setIcon(mita1);
        
        pnlBottom.add(btnReg);
        
        btnPal = new JButton();
        btnPal.setToolTipText("DE CLICK PARA VALIDAR LETRAS");
        ImageIcon mita2 = new ImageIcon(img2.getImage().getScaledInstance(30, 30, 10));
        btnPal.setIcon(mita2);

        lblMostrarName = new JLabel("ALEMAR");

        lblMostrarId = new JLabel("1020");

        btnSal = new JButton();

        lblMostrarScore = new JLabel("2");
        lblMostrarScore.setBounds(50, 500, 90, 40);

        lblTitulo = new JLabel("TUS DATOS");

        lblMostrarId.setFont(new Font("Arial", Font.PLAIN, 24));
        lblTitulo.setFont(new Font("Arial", Font.PLAIN, 24));
        lblMostrarScore.setFont(new Font("Arial", Font.PLAIN, 24));
        lblMostrarName.setFont(new Font("Arial", Font.PLAIN, 24));

        //AGREGAMOS ESTOS COMPONENTES EN EL JFRAME EL FORMULARIO
        add(pnlTop);
        add(pnlCenter);
        add(pnlBottom);
       

        //AGREGAMOS RECEPTORES EN ESTOS COMPONENTES QUE ESCUCHARÁN, EN ESTE CASO EL CLICK
        btnReg.addActionListener(this);
        btnPal.addActionListener(this);
        btnSal.addActionListener(this);

        //TAMAÑO DEL FORMULARIO
        setSize(600, 700);
        //DONDE APARECE ESTE FORMULARIO EN LA PANTALLA Y CON EL D VAMOS A TENER EL ANCHO 
        //DE LA PANTALLA PARA QUE ESTA QUEDE ACOMODADA DEPENDIENDO DE LA RESOLUCIÓN

        // Hacemos visible el JInternalFrame
        setResizable(false);
        setVisible(true);
        
    }

    
    
@Override
public void actionPerformed(ActionEvent e) 
    {   
     if (e.getSource() == btnReg) {
                // INICIO DE JUEGO METODO RANDOMIZAR
                RandomizarNumero();
                // METODO CON ARGUMENTOS
                _palabra.Randomizar(inumRandom);
                /*SE GUARDA EL TEXTO QUE SE TENGA EN EL TXTUSERID Y TXTUSERNAME PARA DEFINIRLO EN UNA VARIABLE
                EL INTEGER ES PARA EXTRAER EL NUMERO QUE ESTE EN CADENA DE TEXTO*/
                iidUser = Integer.parseInt(txtUserId.getText());
                snick = txtUserName.getText();
                JOptionPane.showMessageDialog(this, "Datos guardados", "Guardado",
                        JOptionPane.OK_OPTION, iconoEscalado);
                MostrarGuiones(_palabra.sPalabAdiv);
                lblPal.setText(Palabra);
                cRellenarPalabra(_palabra.sPalabAdiv);
                /*PERMITE QUITAR COMPONENTES DEL JFRAME*/
                pnlCenter.remove(lblInstru);
                pnlCenter.remove(txtUserName);
                pnlCenter.remove(txtUserId);
                pnlBottom.remove(btnReg);
                pnlCenter.add(lblPal);
                pnlCenter.add(txtPal);
                pnlBottom.add(btnPal);
                /*REFRESCA Y VUELVE A CARGAR EL FORMULARIO*/
                revalidate();
                repaint();
            }

            if (e.getSource() == btnPal) {
                /*QUE OBTENGA LA PRIMERA LETRA DE LA CADENA */
                cResp = txtPal.getText().charAt(0);
                cMinimizarLetra(cResp);
                /*MODIFICAR EL TEXTO ESCRITO Y CON EL NULL LO LIMPIA*/
                txtPal.setText(null);
                vValidacionPalabras(cResp, _palabra.sPalabAdiv, cLetraCorrect);
                for (int a = 0; a < _palabra.sPalabAdiv.length(); a++) {
                    guardar[a] = String.valueOf(cLetraCorrect[a]) + " ";
                }
                if (bAcierto) {
                    JOptionPane.showMessageDialog(this, "LETRA CORRECTA", "Acierto",
                            JOptionPane.OK_OPTION, iconoEscalado );
                    
                    Palabra = String.join(" ", guardar);
                    /*MODIFICA POR LA PALABRA RANDOMIZADA LOS GUIONES Y CÓMO ESTA
                    SE VA MODIFICANDO*/
                    lblPal.setText(Palabra);
                    repaint();    
                } else if (!bAcierto) {
                    JOptionPane.showMessageDialog(this, "LO SENTIMOS, HAS FALLADO", "Fallo",
                            JOptionPane.OK_OPTION, iconoEscalado1);
                    iIntentos++;
                    Ahorcado _dibujar = new Ahorcado(iIntentos, lblFoto);
                    _dibujar.vDibujarAhorcado();
                    revalidate();
                    repaint();
                }
                bAcertarPalabra(_palabra.sPalabAdiv, cLetraCorrect);
                if (bGano) {
                    // SI SE GANA, SE SUMA UNA AL SCORE Y SE MUESTRA LA DEFINICIÓN A TRAVÉS DEL NÚMERO
                    // RANDOMIZADO EN EL METODO
                    iScore++;
                    JOptionPane.showMessageDialog(this, "HAS GANADO, ¡FELICIDADES!\n" + _palabra.Definicio(inumRandom), "Felicidades",
                            JOptionPane.OK_OPTION, iconoEscalado4);
                    pnlCenter.remove(txtPal);
                    pnlCenter.remove(lblPal);
                    pnlCenter.remove(btnPal);
                    int sDecicion = JOptionPane.showConfirmDialog(this, "¿DESEA CONTINUAR?", "Continuar?",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,iconoEscalado2);
                    // METODO CON ARGUMENTOS
                    vMostrarContinuar(iScore, lblMostrarName, lblMostrarId, sDecicion, snick, iidUser);
                }
                if (iIntentos == 3) {
                    JOptionPane.showMessageDialog(this, "HAS PERDIDO", "Lo Sentimos",
                            JOptionPane.OK_OPTION, iconoEscalado3);
                    int sDecicion = JOptionPane.showConfirmDialog(this, "¿DESEA CONTINUAR?", "Continuar?",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,iconoEscalado2);
                    // METODO CON ARGUMENTOS
                    vMostrarContinuar(iScore, lblMostrarName, lblMostrarId, sDecicion, snick, iidUser);
                }
                if (bVolver) {
                    // METODO PARA QUE SE VUELVA A REPETIR
                    reiniciarJuego();
                }
                /*LE DECIMOS FALSO REINICIAR */
                bVolver = false;
            }

    }
    //SOBRESCRIBIMOS ESTE MÉTODO EN LA CLASE LÓGICA (POLIMORFISMO)
}
