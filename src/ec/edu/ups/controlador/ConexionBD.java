package ec.edu.ups.controlador;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConexionBD {

    private Connection conexion= null;
    private String login = "ProyectoFerreteria";
    private String pasword = "ferreteria";
    private String url = "jdbc:oracle:thin:@localhost:1521:orcl";

    //private String login = "FERRETERIA";
    //private String pa = "123";
    //private String url = "jdbc:oracle:thin:@localhost:1521:xe";

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

}
