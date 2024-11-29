/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extractorpalabras;

import java.awt.event.ActionEvent; // Importamos ActionEvent para manejar eventos de acción
import java.awt.event.ActionListener; // Importamos ActionListener para escuchar acciones

// Clase Logica: Maneja la lógica de la aplicación al responder a eventos de la GUI
public class Logica implements ActionListener {

    private ExtractorPalabras extractor; // Instancia de ExtractorPalabras para realizar extracciones
    private GUI gui; // Instancia de la GUI para interactuar con la interfaz

    // Constructor que recibe la GUI
    public Logica(GUI gui) {
        this.gui = gui; // Asignamos la GUI a la variable de instancia
        this.extractor = new ExtractorPalabras(); // Inicializamos el extractor de palabras
    }

    // Método que se llama al realizar una acción en los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        String palabra = gui.getPalabra(); // Obtenemos la palabra de la GUI
        if (palabra == null || palabra.isEmpty()) { // Verificamos si la entrada está vacía
            gui.mostrarMensaje("Ingrese una palabra."); // Mostramos mensaje de error
            return; // Salimos del método
        }

        String resultado = ""; // Variable para almacenar el resultado de la extracción
        // Comprobamos qué botón se ha presionado y llamamos al método correspondiente
        if (e.getSource() == gui.getBtOp1()) {
            resultado = extractor.extraerMayusculas(palabra);
        } else if (e.getSource() == gui.getBtOp2()) {
            resultado = extractor.extraerMinusculas(palabra);
        } else if (e.getSource() == gui.getBtOp3()) {
            resultado = extractor.extraerVocales(palabra);
        } else if (e.getSource() == gui.getBtOp4()) {
            resultado = extractor.extraerConsonantes(palabra);
        } else if (e.getSource() == gui.getBtOp5()) {
            resultado = extractor.extraerNumeros(palabra);
        } else if (e.getSource() == gui.getBtOp6()) {
            resultado = extractor.extraerTildes(palabra);
        } else if (e.getSource() == gui.getBtOp7()) {
            resultado = extractor.extraerEnies(palabra);
        } else if (e.getSource() == gui.getBtOp8()) {
            resultado = extractor.extraerComodines(palabra);
        } else if (e.getSource() == gui.getBtOp9()) {
            resultado = extractor.extraerEspacios(palabra);
        }

        gui.mostrarResultado(resultado); // Mostramos el resultado en la GUI
    }
}


    

