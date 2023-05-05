package Modelo;

import java.sql.Connection;
//import com.mysql.jdbc.Connection;
import java.sql.*;
//
import javax.swing.JOptionPane;

public class Conexion {
    //Datos de conexion
    private static final String driver="com.mysql.jdbc.Driver";
    private static final String bbdd="jdbc:mysql://localhost/gasolina";
    private static final String usuario ="root";
    private static final String clave="Jm20221578075";
    
    //Funcion que se cobecta a bd de mysql
    public static Connection Conectar(){
        /*Declaramos una variable para almacenar la cadena de conexión.
        Primero la iniciamos en null.*/
        Connection con = null;
        try {
            Class.forName(driver);//Registrar el driver
            con = DriverManager.getConnection(bbdd, usuario, clave);//Creamos una conexión a la Base de Datos 
            if(con!=null){
                //JOptionPane.showMessageDialog(null, "Base de datos conecta correctamente");
                System.out.println("Base de datos conectada ");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Base de datos conecta correctamente"+e.toString());
        }
        // Devolvemos la conexión.
        return con;
    }

}
