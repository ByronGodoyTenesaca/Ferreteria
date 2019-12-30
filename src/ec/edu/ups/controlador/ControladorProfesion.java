package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Profesion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ControladorProfesion {
    private ConexionBD conexion=new ConexionBD();
    
    public void crearProfesion(Profesion p){
        try {
            PreparedStatement pst=null;
            String sql="INSERT INTO PROFESION (PRO_CODIGO, PRO_PROFESION, PRO_DESCUENTO)"
                    + "VALUES(PROFESION_SEQ.NEXTVAL,?,?) ";
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setString(1, p.getNombre());
            pst.setDouble(2, p.getDescuento());
            pst.execute();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Profesion Creada Correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "no se pudo crear la profesion");
        }
    }
    
    public void ActualizarProfesion(Profesion p){
        try {
            PreparedStatement pst=null;
            String sql="UPDATE PROFESION SET PRO_DESCUENTO= ?"
                    + "WHERE PRO_PROFESION= ?";
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setString(2, p.getNombre());
            pst.setDouble(1, p.getDescuento());
            pst.execute();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Profesion Creada Correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "no se pudo crear la profesion");
        }
    }
    
    public void eliminarProfesion(int codigo){
        try {
            PreparedStatement pst=null;
            String sql="DELETE FROM CLIENTE WHERE PRO_CODIGO =?";
            
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setInt(1, codigo);
             pst.execute();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Profesion Eliminado Correctamente");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo Eliminar la profesion");
        }
    }
    
    public int buscarCodigo(String p){
        try {
            String sql="SELECT * FROM PROFESION WHERE PRO_PROFESION = "+p+";";
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            int codigo=0;
            while(respuesta.next()){
                codigo=respuesta.getInt(1);
            }
            return codigo;
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "no se puede encontrar el codigo");
            }
        return 0;
    }
    
    
     public String buscarNombre(String p){
        try {
            String sql="SELECT * FROM PROFESION WHERE PRO_PROFESION = "+p+";";
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            String profesion="";
            while(respuesta.next()){
                profesion=respuesta.getString(2);
            }
            return profesion;
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "no se puede encontrar el codigo");
            }
        return null;
    }
    
}
