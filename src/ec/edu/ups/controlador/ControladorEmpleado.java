package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class ControladorEmpleado {

    private ConexionBD conexion;

    public ControladorEmpleado() {
    conexion = new ConexionBD();
    }

    
    public void crear(Empleado em) {
        
        PreparedStatement pst = null;
        String sql = "INSERT INTO FER_EMPLEADOS(EMP_CODIGO, EMP_NOMBRE, EMP_APELLIDO, EMP_DIRECCION, EMP_CEDULA, EMP_EMAIL, EMP_CONTRASEÑA,  EMP_GENERO, EMP_TELEFONO, CARGO_CAR_CODIGO)"
                + "VALUES (FER_EMPLEADOS_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?)";
        try {
            conexion.Conectar();
            pst = conexion.getConexion().prepareStatement(sql);
            
            pst.setString(1, em.getNombres());
            pst.setString(2, em.getApellidos());
            pst.setString(3, em.getDireccion());
            pst.setString(4, em.getCedula());
            pst.setString(5, em.getEmail());
            pst.setString(6, em.getContraseña());
            pst.setString(7, em.getGenero());
            pst.setString(8, em.getTelefono());
            pst.setInt(9, em.getCargo());
            pst.executeUpdate();
            conexion.getConexion().commit();
            JOptionPane.showMessageDialog(null, em.getNombres()+" Creado Correctamente");
            conexion.Desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }

    public void actualizar(Empleado e) {
        PreparedStatement pst = null;
        String sql = "UPDATE FER_EMPLEADOS SET EMP_NOMBRE= ?, EMP_APELLIDO= ?, EMP_DIRECCION= ?, EMP_CEDULA= ?, EMP_TELEFONO= ?, EMP_EMAIL= ?, EMP_GENERO= ?, EMP_CONTRASEÑA= ?, CARGO_CAR_CODIGO=?"
                + " WHERE EMP_CODIGO =?";
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
            pst.setInt(9, e.getCargo());
            pst.setInt(10, e.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, e.getNombres()+" Actualizado Correctamente");
            conexion.getConexion().commit();
            conexion.Desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error " + ex.getMessage());
        }
    }

    public void eliminar(int Codigo) {
        try {
            PreparedStatement pst = null;
            String sql = "DELETE FROM FER_EMPLEADOS WHERE EMP_CODIGO =?";

            conexion.Conectar();
            pst = conexion.getConexion().prepareStatement(sql);
            pst.setInt(1, Codigo);
            pst.execute();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Empleado ELiminado Correctamente", "Eliminar", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se puedo Eliminar Correctamente!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Empleado buscarXCedula(String c){
        try {
            Empleado e= new Empleado();
            String sql="SELECT * FROM FER_EMPLEADOS WHERE EMP_CEDULA='"+c+"'";
           
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            
            while(respuesta.next()){
                e.setCodigo(respuesta.getInt(1));
                e.setNombres(respuesta.getString(2));
                e.setApellidos(respuesta.getString(3));
                e.setDireccion(respuesta.getString(4));
                e.setCedula(respuesta.getString(5));
                e.setEmail(respuesta.getString(6));
                e.setContraseña(respuesta.getString(7));
                e.setGenero(respuesta.getString(8));
                e.setTelefono(respuesta.getString(9));
                e.setCargo(respuesta.getInt(10));
            }
            conexion.Desconectar();
            return e;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<Empleado> buscarXNombre(String c){
        try {
            List<Empleado>lista=new ArrayList<>();
            String sql="SELECT * FROM FER_EMPLEADOS WHERE EMP_NOMBRE LIKE '"+c+"%'";
            
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            while(respuesta.next()){
                Empleado e= new Empleado();
                e.setCodigo(respuesta.getInt(1));
                e.setNombres(respuesta.getString(2));
                e.setApellidos(respuesta.getString(3));
                e.setDireccion(respuesta.getString(4));
                e.setCedula(respuesta.getString(5));
                e.setEmail(respuesta.getString(6));
                e.setContraseña(respuesta.getString(7));
                e.setGenero(respuesta.getString(8));
                e.setTelefono(respuesta.getString(9));
                e.setCargo(respuesta.getInt(10));
                lista.add(e);
            }
            conexion.Desconectar();
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
   public List<Empleado> buscarXTrabajo(int n){
        try {
            List<Empleado>lista=new ArrayList<>();
            String sql="SELECT * FROM FER_EMPLEADOS WHERE CARGO_CAR_CODIGO= "+n+"";
            
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            while(respuesta.next()){
                Empleado e= new Empleado();
                e.setCodigo(respuesta.getInt(1));
                e.setNombres(respuesta.getString(2));
                e.setApellidos(respuesta.getString(3));
                e.setDireccion(respuesta.getString(4));
                e.setCedula(respuesta.getString(5));
                e.setEmail(respuesta.getString(6));
                e.setContraseña(respuesta.getString(7));
                e.setGenero(respuesta.getString(8));
                e.setTelefono(respuesta.getString(9));
                e.setCargo(respuesta.getInt(10));
                lista.add(e);
            }
            conexion.Desconectar();
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}


