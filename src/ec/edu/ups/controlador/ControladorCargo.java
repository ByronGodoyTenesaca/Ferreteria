
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Cargo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronal
 */
public class ControladorCargo {
     private ConexionBD conexion;

    public void crear(Cargo c) {
        conexion = new ConexionBD();
        PreparedStatement pst = null;
        String sql = "INSERT INTO EMPLEADOS(CAR_CODIGO, CAR_CARGO)"
                + "VALUES (EMPLEADOS_SEQ.NEXTVAL,?)";
        try {
            conexion.Conectar();
            pst = conexion.getConexion().prepareStatement(sql);
            pst.setString(1, c.getCargo());
            pst.execute();
            System.out.println("GUardado correctamente");
            conexion.Desconectar();
        } catch (SQLException e) {
            System.out.println("No se pudo guardar " + e.getMessage());
        }
    }

    public void actualizar(Cargo c, int n) {
        PreparedStatement pst = null;
        String sql = "UPDATE CARGO SET CAR_CARGO= ?"
                + " WHERE CAR_CODIGO =?";
        try {
            conexion.Conectar();
            pst = conexion.getConexion().prepareStatement(sql);
            pst.setString(1, c.getCargo());
            pst.execute();
            System.out.println("Actualizado correctamete");
            conexion.Desconectar();
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }

    public void eliminar(int codigo) {
        try {
            PreparedStatement pst = null;
            String sql = "DELETE FROM CARGO WHERE CAR_CODIGO =?";

            conexion.Conectar();
            pst = conexion.getConexion().prepareStatement(sql);
            pst.setString(1, String.valueOf(codigo));
            pst.execute();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "ELiminado Correctamente", "Eliminar", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puedo Eliminar Correctamente!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
