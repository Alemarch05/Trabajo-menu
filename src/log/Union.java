package log;

import GUI.FrmJuego;
import pMathGUI.pMathGui;
import extractorpalabras.GUI;
import TABS.MainInterface;
import GUIREGS.REGUNIDOS;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Union extends Interfaz implements ActionListener {
   
    @Override
    public void actionPerformed(ActionEvent e) 
    {

        if (e.getSource() == btn1)
        {
        mdi.remove(jpnEspacio);
        mdi.remove(jpnbotones);
        lbl1.setText("\t\t\t INSTRUCCIONES \t\t\t");
        lblOp.setText(descripcionOp);
        lblExt.setText(descripcionExt);
        lblReg.setText(descripcionReg);
        lblTab.setText(descripcionTab);
        lblAho.setText(descripcionAho);
       jpnInstruccion.add(lbl1);
       jpnInstruccion.add(lblAho);
       jpnInstruccion.add(lblOp);
       jpnInstruccion.add(lblTab);
       jpnInstruccion.add(lblReg);
       jpnInstruccion.add(lblExt);
       mdi.add(jpnInstruccion);
       mdi.add(jpnbotones);
       mdi.revalidate();
       mdi.repaint();
        }
        
        if (e.getSource() == btn3) 
        {
        System.exit(0);
        }
        // Ya no es necesario hacer mdi.setVisible(true) aquí
        if (e.getSource() == itemAhorcado) 
        {
            
            mdi.remove(jpnInstruccion);
            mdi.remove(jpnEspacio);
            mdi.remove(jpnbotones);
            mdi.setLayout(new GridLayout(1, 1, 5, 5));
            FrmJuego intframe = new FrmJuego();
            dkpAhorcado.add(intframe);
            mdi.add(dkpAhorcado);
            mdi.revalidate();
            mdi.repaint();
            intframe.actionPerformed(e);
            // Crear el formulario del juego Ahorcado 
            // Añadir el JInternalFrame (formulario Ahorcado) al JDesktopPane
        }
        if (e.getSource() == itemOperacion) 
        {
            mdi.remove(jpnInstruccion);
            mdi.remove(jpnEspacio);
            mdi.remove(jpnbotones);
            mdi.setLayout(new GridLayout(1, 1, 5, 5));
            pMathGui mthGUI = new pMathGui(); // Crea una instancia de la clase para mostrar la GUI.
            dkpAhorcado.add(mthGUI);
            mdi.add(dkpAhorcado);
            mdi.revalidate();
            mdi.repaint();
            mthGUI.setVisible(true);
        }
        if (e.getSource() == itemMult)
        {
            mdi.remove(jpnInstruccion);
            mdi.remove(jpnEspacio);
            mdi.remove(jpnbotones);
            mdi.setLayout(new GridLayout(1, 1, 5, 5));
            MainInterface interMult = new MainInterface();
            dkpAhorcado.add(interMult);
            mdi.add(dkpAhorcado);
            mdi.revalidate();
            mdi.repaint();
            interMult.actionPerformed(e);
            
        }
        if (e.getSource()== itemExt) 
        {
            mdi.remove(jpnInstruccion);
            mdi.remove(jpnEspacio);
            mdi.remove(jpnbotones);
            mdi.setLayout(new GridLayout(1, 1, 5, 5));
            GUI interfr = new GUI();
            dkpAhorcado.add(interfr);
            mdi.add(dkpAhorcado);
            mdi.revalidate();
            mdi.repaint();
            interfr.actionPerformed(e);
        }
        if (e.getSource() == itemReg) 
        {
            mdi.remove(jpnInstruccion);
             mdi.remove(jpnEspacio);
            mdi.remove(jpnbotones);
            mdi.setLayout(new GridLayout(1, 1, 5, 5));
            REGUNIDOS interReg = new REGUNIDOS();
            dkpAhorcado.add(interReg);
            mdi.add(dkpAhorcado);
            mdi.revalidate();
            mdi.repaint();
            interReg.setVisible(true);
            
        }
        if (e.getSource() == btn1) 
        {
            // Acción cuando el botón "Instrucciones" es presionado
            JOptionPane.showMessageDialog(mdi, "BIENBENIDO SE LE VAN A DAR LAS INSTRUCCIONES DE LOS JUEGOS", "Instrucciones", JOptionPane.INFORMATION_MESSAGE);
        } 
        if (e.getSource() == btn3) 
        {
            // Acción cuando el botón "Salir" es presionado
            System.exit(0);  // Cerrar la aplicación
        }
        if (e.getSource() == itemBD) 
        {
        int des = JOptionPane.showConfirmDialog(mdi, "DESEA BORRAR UNA BASE DE DATOS", "BD", JOptionPane.OK_CANCEL_OPTION);
               if (des == 0) 
            {
            String deletBd = JOptionPane.showInputDialog(null, "NOMBRE DE LA BD QUE DESEA ELIMINAR");
            MySQL _elimated = new MySQL();
            _elimated.MySQLConnection("root", "", "");
            _elimated.deleteDatabase(deletBd);
            }
               if (des == 2) 
            {
            JOptionPane.showMessageDialog(null, "SE HA CANCELADO LA ACCION");
            }
         
        }
        if (e.getSource() == itemInicio) 
        {
          JOptionPane.showMessageDialog(null, "VOLVIENDO AL INICIO");
          mdi.remove(dkpAhorcado);
          mdi.setLayout(new GridLayout(2,1,90,20));
          mdi.add(jpnEspacio);
          mdi.add(jpnbotones);
          mdi.revalidate();
          mdi.repaint();
        }
    }
}
