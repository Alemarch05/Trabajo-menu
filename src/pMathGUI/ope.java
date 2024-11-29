package pMathGUI; // Define el paquete al que pertenece esta clase

import javax.swing.JOptionPane; // Importa la clase JOptionPane para mostrar mensajes de dialogo

// Define la clase ope que extiende la clase pMathGui
public class ope extends pMathGui {
    
    // Constructor vacioo de la clase
    public ope() {
        // Constructor vacioo
    }
    
    // Metodos de operaciones matematicas sin parametros (no tienen restricciones)
    
    // Metodo para sumar dos números
    public double suma(double iNum1, double iNum2) {
        return iNum1 + iNum2;
    }
    
    // Metodo para restar dos números
    public double resta(double iNum1, double iNum2) {
        return iNum1 - iNum2;
    }
    
    // Metodo para multiplicar dos números
    public double multip(double iNum1, double iNum2) {
        return iNum1 * iNum2;
    }
    
    // Metodo para calcular el valor absoluto de un número
    public double valAbs(double num) {
        return Math.abs(num);
    }

    // Metodo para redondear un número al entero mas cercano
    public double round(double num) {
        return Math.round(num);
    }

    // Metodo para redondear un número hacia abajo (floor)
    public double roundFloor(double num) {
        return Math.floor(num);
    }
    
    // Metodo para redondear un número hacia arriba (ceiling)
    public double roundCeil(double num) {
        return Math.ceil(num);
    }
    
    // Metodo para calcular el seno de un número
    public double seno(double num) {
        return Math.sin(num);
    }
    
    // Metodo para calcular el coseno de un número
    public double cos(double num) {
        return Math.cos(num);
    }
    
    // Metodo para calcular la tangente de un número
    public double tan(double num) {
        return Math.tan(num);
    }
    
    // Metodos para operaciones matematicas con parametros (tienen restricciones)
    
    // Metodo para dividir dos números
    public double div(double iNum1, double iNum2) {
        if (iNum2 != 0) {
            return iNum1 / iNum2;
        } else {
            // Muestra un mensaje de error si se intenta dividir por cero
            JOptionPane.showMessageDialog(null, "Error: Division por cero", "Error", JOptionPane.ERROR_MESSAGE);
            return Double.NaN; // Retorna Not-a-Number en caso de error
        }
    }
    
    // Metodo para calcular la potencia de un número
    public double expo(double iNum1, double iNum2) {
        if (iNum1 <0 && iNum2 %1 !=0) {
            JOptionPane.showMessageDialog(null, "Error: Exponente no valida", "Error", JOptionPane.ERROR_MESSAGE);
            return Double.NaN; // Retorna Not-a-Number en caso de error
        }
        return Math.pow(iNum1, iNum2);
    }
    
    // Metodo para calcular la raioz n-esima de un número
    public double raiz(double iNum1, double iNum2) {
        if (iNum2 < 0 || (iNum1 < 0 && iNum2 % 2 == 0)) {
            // Muestra un mensaje de error si la raioz no es valida
            JOptionPane.showMessageDialog(null, "Error: Raioz no valida", "Error", JOptionPane.ERROR_MESSAGE);
            return Double.NaN; // Retorna Not-a-Number en caso de error
        }
        // Calcula la raioz, manejando el caso de números negativos
        return Math.pow(Math.abs(iNum1), 1.0 / iNum2) * (iNum1 < 0 ? -1 : 1);
    }

    // Metodo para calcular el logaritmo de un número en una base especiofica
    public double logBase(double iNum1, double iNum2) {
        if (iNum1 <= 0 || iNum2 <= 1) {
            // Muestra un mensaje de error si el logaritmo no es valido
            JOptionPane.showMessageDialog(null, "Error: Logaritmo no valido", "Error", JOptionPane.ERROR_MESSAGE);
            return Double.NaN; // Retorna Not-a-Number en caso de error
        }
        return Math.log(iNum1) / Math.log(iNum2);
    }

    // Metodo para calcular el arcocoseno de un número
    public double ArcCoSen(double num) {
        if (num < -1 || num > 1) {
            // Muestra un mensaje de error si el arcocoseno esta fuera de rango
            JOptionPane.showMessageDialog(null, "Error: Arcocoseno fuera de rango", "Error", JOptionPane.ERROR_MESSAGE);
            return Double.NaN; // Retorna Not-a-Number en caso de error
        }
        return Math.acos(num);
    }

    // Metodo para calcular el arcoseno de un número
    public double ArcSen(double num) {
        if (num < -1 || num > 1) {
            // Muestra un mensaje de error si el arcoseno esta fuera de rango
            JOptionPane.showMessageDialog(null, "Error: Arcoseno fuera de rango", "Error", JOptionPane.ERROR_MESSAGE);
            return Double.NaN; // Retorna Not-a-Number en caso de error
        }
        return Math.asin(num);
    }
}