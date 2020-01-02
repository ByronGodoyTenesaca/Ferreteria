package ec.edu.ups.controlador;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConexionBD {

    private Connection conexion;
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
            if (getConexion() != null) {
                System.out.println("Se ha establecido la conexion");
            } else {
                System.out.println("error de conexion");
            }
        } catch (Exception e) {
            e.printStackTrace();
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
