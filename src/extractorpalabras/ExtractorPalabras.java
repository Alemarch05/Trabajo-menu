/*Terrminado mas comentarios
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extractorpalabras;

// Clase ExtractorPalabras: Encargada de extraer diferentes tipos de caracteres de una cadena de texto
public class ExtractorPalabras {

    // Método para extraer letras mayúsculas
    public String extraerMayusculas(String palabra) {
        StringBuilder resultado = new StringBuilder(); // Usamos StringBuilder para construir el resultado
        for (char c : palabra.toCharArray()) { // Iteramos cada carácter de la palabra
            if (Character.isUpperCase(c)) { // Comprobamos si es mayúscula
                resultado.append(c); // Añadimos la mayúscula al resultado
            }
        }
        return resultado.toString(); // Retornamos el resultado como cadena
    }

    // Método para extraer letras minúsculas
    public String extraerMinusculas(String palabra) {
        StringBuilder resultado = new StringBuilder();
        for (char c : palabra.toCharArray()) {
            if (Character.isLowerCase(c)) {
                resultado.append(c);
            }
        }
        return resultado.toString();
    }

    // Método para extraer vocales
    public String extraerVocales(String palabra) {
        StringBuilder resultado = new StringBuilder();
        for (char c : palabra.toCharArray()) {
            if ("AEIOUaeiou".indexOf(c) != -1) { // Comprobamos si el carácter es una vocal
                resultado.append(c);
            }
        }
        return resultado.toString();
    }

    // Método para extraer consonantes
    public String extraerConsonantes(String palabra) {
        StringBuilder resultado = new StringBuilder();
        for (char c : palabra.toCharArray()) {
            // Comprobamos que no sea vocal y que sea una letra
            if ("AEIOUaeiou".indexOf(c) == -1 && Character.isLetter(c)) {
                resultado.append(c);
            }
        }
        return resultado.toString();
    }

    // Método para extraer números
    public String extraerNumeros(String palabra) {
        StringBuilder resultado = new StringBuilder();
        for (char c : palabra.toCharArray()) {
            if (Character.isDigit(c)) { // Comprobamos si es un dígito
                resultado.append(c);
            }
        }
        return resultado.toString();
    }

    // Método para extraer letras acentuadas
    public String extraerTildes(String palabra) {
        StringBuilder resultado = new StringBuilder();
        for (char c : palabra.toCharArray()) {
            if ("áéíóúÁÉÍÓÚ".indexOf(c) != -1) { // Comprobamos si es una letra acentuada
                resultado.append(c);
            }
        }
        return resultado.toString();
    }

    // Método para extraer letras Ñ/ñ
    public String extraerEnies(String palabra) {
        StringBuilder resultado = new StringBuilder();
        for (char c : palabra.toCharArray()) {
            if (c == 'ñ' || c == 'Ñ') { // Comprobamos si es Ñ o ñ
                resultado.append(c);
            }
        }
        return resultado.toString();
    }

    // Método para extraer caracteres especiales (comodines)
    public String extraerComodines(String palabra) {
        StringBuilder resultado = new StringBuilder();
        for (char c : palabra.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != ' ') { // Comprobamos que no sea letra, dígito o espacio
                resultado.append(c);
            }
        }
        return resultado.toString();
    }

    // Método para extraer espacios
    public String extraerEspacios(String palabra) {
        return palabra.replaceAll("[^ ]", ""); // Reemplazamos todo menos los espacios por vacío
    }
}


    