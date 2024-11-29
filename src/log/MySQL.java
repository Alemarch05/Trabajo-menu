/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log;

import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager; // importacion de librerias a usar
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author aleja
 */

//CLASE MYSQL
public class MySQL extends Exception {
    public static Connection Conexion;
    public static Statement st;
    public static ResultSet rs;
    public static PreparedStatement ps;

    ArrayList sql_1 = new ArrayList(); // vector que almacenara los datos consultados
    public int existe = 0; // variable usada para condicionar

   

    public MySQL() 
    {
    }
    public void deleteDatabase(String dbName) 
    {
    try {
        // Verificar si la conexión está activa
        if (Conexion != null && !Conexion.isClosed()) {
            // Consulta para eliminar la base de datos
            String query = "DROP DATABASE " + dbName;
            Statement st = Conexion.createStatement();
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "La base de datos " + dbName + " ha sido eliminada exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No hay una conexión activa con el servidor. Conéctate primero.");
        }
    } catch (SQLException ex) {
        Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, "Error al eliminar la base de datos.", ex);
        JOptionPane.showMessageDialog(null, "Error al intentar eliminar la base de datos: " + ex.getMessage());
    }
   }
    public boolean verificarTabla(String nombreBD, String nombreTabla) {
    boolean existe = false;
    try {
        // Consulta que especifica la base de datos
        String consulta = "SELECT COUNT(*) AS total FROM information_schema.tables "
                + "WHERE table_schema = '" + nombreBD + "' AND table_name = '" + nombreTabla + "'";
        Statement st = Conexion.createStatement();
        ResultSet rs = st.executeQuery(consulta);

        if (rs.next()) {
            existe = rs.getInt("total") > 0;
        }
    } catch (SQLException ex) {
        Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, "Error al verificar la tabla.", ex);
    }
    return existe;
}
    
   public boolean verificarBaseDeDatos(String nombreBD) {
    boolean existe = false; // Variable que indica si la base de datos existe
    try {
        String consulta = "SHOW DATABASES"; // Consulta para listar las bases de datos
        Statement st = Conexion.createStatement();
        ResultSet rs = st.executeQuery(consulta);

        // Iteramos sobre los resultados
        while (rs.next()) {
            String db_name = rs.getString(1); // Obtenemos el nombre de la base de datos
            if (db_name.equalsIgnoreCase(nombreBD)) 
            {   
                existe = true;
                break; // Si encontramos la base de datos, salimos del bucle
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, "Error al verificar las bases de datos.", ex);
    }
    return existe;
}
    public void MySQLConnection(String user, String pass, String db_name) {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/" + db_name, user, pass);
            JOptionPane.showMessageDialog(null, "se ha iniciado la conexion con el servidor de forma exitosa");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

public void closeConnection() {
    // cierra la conexion con la BD
    try {
        Conexion.close();
        JOptionPane.showConfirmDialog(null, "Se ha finalizado la conexion con el servidor");
    } catch (SQLException ex) {
        Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public void crateDB(String name) {
    // crea la BD en caso de que no exista
    try {
        String Query = "CREATE DATABASE " + name;
        Statement st = Conexion.createStatement();
        st.executeUpdate(Query);
        MySQLConnection("root", "", name);
        JOptionPane.showMessageDialog(null, "Se ha creado la base de datos " + name + " de forma exitosa.");
    } catch (SQLException ex) {
        Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
    }
}
public void createTable(String name) {
    // crea tablas con los campos indicados y sus tamaños referenciados
    try {
        String Query = "CREATE TABLE " + name + " ("
                                                 +"ID VARCHAR(8),"
                                                 +" Nombre VARCHAR(50),"
                                                 + " password VARCHAR(10))";
        JOptionPane.showMessageDialog(null, "Se ha creado la tabla " + name + " de forma exitosa");
        Statement st = Conexion.createStatement();
        st.executeUpdate(Query);
    } catch (SQLException ex) {
        Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public void insertData(String table_name, String ID, String name, String passwword) 
{
    try {
        String Query = "INSERT INTO " + table_name + " VALUES(" +
                "\"" + ID + "\", " +
                "\"" + name + "\", " +
                "\"" + passwword + "\")";
        Statement st = Conexion.createStatement();
        st.executeUpdate(Query);
        JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
    }
}


//*******************NAVEGACIÓN DE LOS REGISTROS*****************************************


}
