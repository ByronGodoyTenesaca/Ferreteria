package ec.edu.ups.controlador;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {

    private Connection conexion;
    public ConexionBD() {
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    
    
   public void Conectar(){
    try{
    String usuario ="SYSTEM";
    String contraseña = "SYSTEM";
    Class.forName("oracle.jdbc.OracleDriver");
    String cadenaConexion = "jdbc:oracle:thin:@localhost:1521:XE";
    setConexion(DriverManager.getConnection
            (cadenaConexion,usuario,contraseña));
    if( getConexion()!=null)
    {
    System.out.println("Se ha establecido la conexion con el esquema BDVENTAS");
    }
    else{System.out.println("error de conexion");}
    }
    catch(Exception e)
    {e.printStackTrace();}
}
   
   public void Desconectar(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            
        }
   }
    
   
}
