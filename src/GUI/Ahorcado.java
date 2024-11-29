/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author aleja
 */
public class Ahorcado extends FrmJuego
{

    public JLabel Foto;
    public ImageIcon img;
  private static int iScore = 0;
  /*CONSTRUCTOR CON ARGUMENTOS */
  public Ahorcado(int iScore,JLabel Foto)
  {
      //VARIABLE AUXILIAR
  this.Foto = Foto;
  this.img = img;
  this.iScore = iScore;    
  }
  //METODO CON PARAMETROS POR SI SE FALLA QUE CAMBIE LA IMAGEN
  public void vDibujarAhorcado() {
        switch (iScore) 
        {
            
            case 1:
        img = new ImageIcon(getClass().getResource("/IMAGENTOTA/ahoracado2.jpg"));
        ImageIcon mitad = new 
        ImageIcon(img.getImage().getScaledInstance(Foto.getWidth(),Foto.getHeight(), Image.SCALE_DEFAULT));
              Foto.setIcon(mitad);
                break;
            case 2:
        img = new ImageIcon(getClass().getResource("/IMAGENTOTA/ahoracado3.jpg"));
        ImageIcon mitad1 = new 
        ImageIcon(img.getImage().getScaledInstance(Foto.getWidth(),Foto.getHeight(), Image.SCALE_DEFAULT));
              Foto.setIcon(mitad1);
                break;
            case 3:
                img = new ImageIcon(getClass().getResource("/IMAGENTOTA/ahoracado4.jpg"));
        ImageIcon mitad3 = new 
        ImageIcon(img.getImage().getScaledInstance(Foto.getWidth(),Foto.getHeight(), Image.SCALE_DEFAULT));
              Foto.setIcon(mitad3);
        }
    }
/*GETTERS Y SETTERS*/
    public JLabel getFoto() {
        return Foto;
    }

    public void setFoto(JLabel Foto) {
        this.Foto = Foto;
    }

    public ImageIcon getImg() {
        return img;
    }

    public void setImg(ImageIcon img) {
        this.img = img;
    }

    public static int getiScore() {
        return iScore;
    }

    public static void setiScore(int iScore) {
        Ahorcado.iScore = iScore;
    }
  
}
