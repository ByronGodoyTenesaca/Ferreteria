package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Empleado;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronal
 */
public class ControladorEmpleado {

    private ConexionBD conexion;

    public void crear(Empleado em) {
        conexion = new ConexionBD();
        PreparedStatement pst = null;
        String sql = "INSERT INTO EMPLEADOS(EMP_CODIGO, EMP_NOMBRE, EMP_APELLIDO, EMP_DIRECCION, EMP_CEDULA, EMP_TELEFONO, EMP_EMAIL, EMP_GENERO, EMP_CONTRASENA, EMP_CARGO)"
                + "VALUES (EMPLEADOS_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?)";
        try {
            conexion.Conectar();
            pst = conexion.getConexion().prepareStatement(sql);
            pst.setString(1, em.getNombres());
            pst.setString(2, em.getApellidos());
            pst.setString(3, em.getDireccion());
            pst.setString(4, em.getCedula());
            pst.setString(5, em.getTelefono());
            pst.setString(6, em.getEmail());
            pst.setString(7, em.getGenero() + "");
            pst.setString(8, em.getContraseña());
            pst.setString(9, em.getCargo());
            pst.execute();
            System.out.println("GUardado correctamente");
            conexion.Desconectar();
        } catch (SQLException e) {
            System.out.println("No se pudo guardar " + e.getMessage());
        }
    }

    public void actualizar(Empleado e, int n) {
        PreparedStatement pst = null;
        String sql = "UPDATE EMPLEADO SET EMP_NOMBRE= ?, EMP_APELLIDO= ?, EMP_DIRECCION= ?, EMP_CEDULA= ?, EMP_TELEFONO= ?, EMP_EMAIL= ?, EMP_GENERO= ?, EMP_CONTRASENA= ?, EMP_CARGO=?"
                + " WHERE EMP_CEDULA =?";
        try {
            conexion.Conectar();
            pst = conexion.getConexion().prepareStatement(sql);
            pst.setString(1, e.getNombres());
            pst.setString(2, e.getApellidos());
            pst.setString(3, e.getDireccion());
            pst.setString(4, e.getCedula());
            pst.setString(5, e.getTelefono());
            pst.setString(6, e.getEmail());
            pst.setString(7, e.getGenero());
            pst.setString(8, e.getContraseña());
            pst.setString(9, e.getCargo());
            pst.execute();
            System.out.println("Actualizado correctamete");
            conexion.Desconectar();
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }

    public void eliminar(String Cedula) {
        try {
            PreparedStatement pst = null;
            String sql = "DELETE FROM EMPLEADO WHERE EMP_CEDULA =?";

            conexion.Conectar();
            pst = conexion.getConexion().prepareStatement(sql);
            pst.setString(1, Cedula);
            pst.execute();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Empleado ELiminado Correctamente", "Eliminar", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puedo Eliminar Correctamente!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


