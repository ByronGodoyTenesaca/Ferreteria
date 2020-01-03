package ec.edu.ups.controlador;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConexionBD {

    private Connection conexion= null;
    private String login = "Ferreteria";
    private String pasword = "ferreteria";
    private String url = "jdbc:oracle:thin:@localhost:1521:orcl";

 

   public ConexionBD() {
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public void Conectar() {
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexion = DriverManager.getConnection(url, login, pasword);
            conexion.setAutoCommit(false);
           
        } catch (ClassNotFoundException | SQLException e) {
            
        }
    }

    public void Desconectar() {
        try {
            conexion.close();
            System.out.println("desconectado");
        } catch (SQLException ex) {

        }
    }

    public static void main(String[] args) {
        
            new ConexionBD().Conectar();
        
    }

}
