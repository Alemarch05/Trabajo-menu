package TABS;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class PrimosOperacionesGui {
    private JTextPane resultadosPane;
    private StyledDocument doc;
    private int mndoIn, mndoFn, mdorIn, mdorFn;

    public PrimosOperacionesGui(int mndoIn, int mndoFn, int mdorIn, int mdorFn) {
        this.mndoIn = mndoIn;
        this.mndoFn = mndoFn;
        this.mdorIn = mdorIn;
        this.mdorFn = mdorFn;

        JFrame frame = new JFrame("Resultados de las Tablas de Primos");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        resultadosPane = new JTextPane();
        resultadosPane.setEditable(false);
        doc = resultadosPane.getStyledDocument();
        frame.add(new JScrollPane(resultadosPane), BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public void ejecutar() {
        try {
            for (int i = mndoIn; i <= mndoFn; i++) {
                if (esPrimo(i)) {  // Solo procesar números primos
                    // Crear un estilo rojo para "Tabla del #"
                    SimpleAttributeSet estiloRojo = new SimpleAttributeSet();
                    StyleConstants.setForeground(estiloRojo, Color.RED);
                    
                    // Insertar "Tabla del #" en rojo solo si el número es primo
                    doc.insertString(doc.getLength(), "Tabla del " + i + ":\n", estiloRojo);
                    
                    // Insertar los resultados de las multiplicaciones sin estilo de color
                    for (int j = mdorIn; j <= mdorFn; j++) {
                        // Solo imprimir multiplicaciones con j > 1
                        if (j > 1) {
                            int resultado = i * j;
                            doc.insertString(doc.getLength(),
                                    i + " x " + j + " = " + resultado + "\n", null);
                        }
                    }
                    doc.insertString(doc.getLength(), "\n", null); // Salto de línea entre tablas
                }
            }
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    private boolean esPrimo(int numero) {
        if (numero <= 1) return false;  // 1 no es primo
        for (int i = 2; i <= Math.sqrt(numero); i++) {  // Solo hasta la raíz cuadrada de 'numero'
            if (numero % i == 0) return false;  // Si el número es divisible, no es primo
        }
        return true;  // Si no tiene divisores, es primo
    }
}


