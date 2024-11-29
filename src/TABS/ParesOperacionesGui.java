package TABS;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class ParesOperacionesGui {
    private JTextPane resultadosPane;
    private StyledDocument doc;
    private int mndoIn, mndoFn, mdorIn, mdorFn;

    public ParesOperacionesGui(int mndoIn, int mndoFn, int mdorIn, int mdorFn) {
        this.mndoIn = mndoIn;
        this.mndoFn = mndoFn;
        this.mdorIn = mdorIn;
        this.mdorFn = mdorFn;

        JFrame frame = new JFrame("Resultados de las Tablas de Multiplicación");
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
            for (int i = mndoIn; i <= mndoFn; i++) { // Itera sobre cada número en el rango del multiplicando
                doc.insertString(doc.getLength(), "Tabla del " + i + ":\n", null);
                for (int j = mdorIn; j <= mdorFn; j++) { // Itera sobre cada número en el rango del multiplicador
                    int resultado = i * j;
                    SimpleAttributeSet estilo = new SimpleAttributeSet();

                    // Color del resultado: azul para pares, rojo para impares
                    if (resultado % 2 == 0) {
                        StyleConstants.setForeground(estilo, Color.BLUE);
                    } else {
                        StyleConstants.setForeground(estilo, Color.RED);
                    }

                    // Imprime el resultado en el formato "i x j = resultado"
                    doc.insertString(doc.getLength(),
                            i + " x " + j + " = " + resultado + "\n", estilo);
                }
                doc.insertString(doc.getLength(), "\n", null); // Salto de línea entre tablas
            }
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
}





