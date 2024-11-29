
package GUI;


public class Diccionario 
{
//esta clase va a almacenar todas las palabras y definiciones necesarias
//tambien me va a guardar la palabra y definicion
public static String sDefinicion;
public static String sPalabAdiv;
public static int iRandom;
public static int Ran;
/*TABLA DE PALABRAS*/
public static String[] sCabPal = {"idPalabra", "Palabra"};
public static Object[][] oPalabra
            = {{0, "clase"},
            {1, "objeto"},
            {2, "herencia"},
            {3, "encapsulamiento"},
            {4, "polimorfismo"},
            {5, "atributo"},
            {6, "constructor"},
            {7, "interfaz"},
            {8, "instancia"},
            {9, "sobrecarga"},
            {10, "superclase"},
            {11, "subclase"},
            {12, "modificadores"},
            {13, "biblioteca"},
            {14, "funcion"},
            {15, "variable"},
            {16, "parametro"},
            {17, "condicional"},
            {18, "bucle"},
            {19, "array"},
            {20, "string"},
            {21, "entero"},
            {22, "booleano"},
            {23, "algoritmo"},
            {24, "compilador"},
            {25, "debugging"},
            {26, "ejecucion"},
            {27, "abstraccion"},
            {28, "excepcion"},
            {29, "metodo"}};
/*TABLA DE DEFINICIONES*/
public static String[] sCabDef = {"idDefinicion", "idPalabra", "Definicion"};
    public static Object[][] oDefinicion
            = {{1, 00, "Es una plantilla o modelo que define las caracteristicas"},
            {2, 01, "Es una representacion de una entidad en la programación"},
            {3, 02, "es un mecanismo que permite a una clase heredar caracteristeicas de otra"},
            {4, 03, "Oculta los detalles internos de una clase"},
            {5, 04, "Capacidad de un objeto de adoptar diferentes formas"},
            {6, 05, "Propiedad o característica de un objeto"},
            {7, 06, "Método especial que se ejecuta al crear una nueva instancia"},
            {8, 07, "Contrato que define los métodos que una clase debe implementar"},
            {9, 8, "Es un objeto creado a partir de una clase"},
            {10, 9, "Define múltiples métodos del mismo nombre pero diferente parámetros"},
            {11, 10, "Clase de la cual otra clase hereda sus atributos y métodos"},
            {12, 11, "Clase que hereda de otra clase, obteniendo sus propiedades y métodos"},
            {13, 12, "Palabras clave que controlan el acceso y comportamiento de clases"},
            {14, 13, "Conjunto de funciones y clases predefinidas que facilitan la programación"},
            {15, 14, "Bloque de código reutilizable que realiza una tarea específica "},
            {16, 15, "Representacion global de un dato"},
            {17, 16, "Valor que se pasa a una función o método que utiliza en ejecución"},
            {18, 17, "Estructura que permite ejecutar código basado en si una condición es verdadera o falsa"},
            {19, 18, "Estructura que permite repetir un bloque de código mientras se cumpla una condición"},
            {20, 19, "Estructura de datos que almacena una colección de elementos del mismo tipo"},
            {21, 20, "Tipo de dato que representa una secuencia de caracteres"},
            {22, 21, "Tipo de dato que representa un número sin parte decimal"},
            {23, 22, "Tipo de dato que solo puede tener dos valores: verdadero o falso"},
            {24, 23, "Conjunto de instrucciones o pasos para resolver un problema"},
            {25, 24, "Programa que traduce el código fuente en un lenguaje comprensible"},
            {26, 25, "Proceso de identificar y corregir errores en el código"},
            {27, 26, "Proceso de correr o ejecutar un programa para que realice las tareas programadas"},
            {28, 27, "Proceso de simplificar y ocultar los detalles de implementación, enfocándose solo en lo esencial"},
            {29, 28, "Evento que ocurre durante la ejecución de un programa y que altera el flujo normal del código"},
            {30, 29, "Función definida dentro de una clase"}};//falta estos    
   //constructor vacio
    public Diccionario()
    {
    }   
    //metodo el cual me va a permitir guardar la palabra y la definicion
    public  String Randomizar(int iRandom)
    {
    sPalabAdiv = (String) oPalabra[iRandom/*FILAS*/][1/*COLUMNA DE PALABRA*/]; 

return sPalabAdiv;    

    }
    /*METODO PARA TRAER LA DEFINICIONES*/
    public String Definicio(int iRandom)
    {
    
    return sDefinicion = (String) oDefinicion [iRandom][2];
    }
}
