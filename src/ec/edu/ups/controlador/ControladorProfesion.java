package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Profesion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorProfesion {
    private ConexionBD conexion=new ConexionBD();
    
    public void crearProfesion(Profesion p){
        try {
            PreparedStatement pst=null;
            String sql="INSERT INTO FER_PROFESIONES (PRO_CODIGO, PRO_PROFESION, PRO_DESCUENTO)"
                    + "VALUES(FER_PROFESIONES_SEQ.nextval,?,?) ";
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
           
            //pst.setInt(1, 2);
            pst.setString(1, p.getNombre());
            pst.setDouble(2, p.getDescuento());
            pst.execute();
            
            conexion.getConexion().commit();
            
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Profesion Creada Correctamente");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "no se pudo crear la profesion");
        }
    }
    
    public void ActualizarProfesion(Profesion p){
        try {
            PreparedStatement pst=null;
            String sql="UPDATE FER_PROFESIONES SET PRO_DESCUENTO= ?"
                    + "WHERE PRO_PROFESION= ?";
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setString(2, p.getNombre());
            pst.setDouble(1, p.getDescuento());
            pst.execute();
            conexion.getConexion().commit();
            
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Profesion Actualizado Correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "no se pudo crear la profesion");
        }
    }
    
    public void eliminarProfesion(String codigo){
        try {
            PreparedStatement pst=null;
            String sql="DELETE FROM FER_PROFESIONES WHERE PRO_PROFESION = ?";
            
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setString(1, codigo);
             pst.execute();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Profesion Eliminado Correctamente");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo Eliminar la profesion");
        }
    }
    
    public int buscarCodigo(String p){
        try {
            String sql="SELECT * FROM FER_PROFESIONES WHERE PRO_PROFESION = '"+p+"'";
            System.out.println(sql);
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            int codigo=0;
            while(respuesta.next()){
                codigo=respuesta.getInt(1);
            }
            return codigo;
            }catch(SQLException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "no se puede encontrar el codigo");
            }
        return 0;
    }
    
    public double buscarDescuento(String p){
        try {
            String sql="SELECT PRO_DESCUENTO FROM FER_PROFESIONES WHERE PRO_PROFESION = '"+p+"'";
            System.out.println(sql);
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            double codigo=0;
            while(respuesta.next()){
                codigo=respuesta.getDouble(1);
            }
            return codigo;
            }catch(SQLException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "no se puede encontrar el Nombre");
            }
        return 0;
    }
    
     public List<Profesion> buscarNombre(String p){
        try {
            String sql="SELECT * FROM FER_PROFESIONES WHERE PRO_PROFESION LIKE'"+p+"%'";
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            
            List<Profesion> lista=new ArrayList<>();
            while(respuesta.next()){
                Profesion profesion=new Profesion();
                profesion.setCodigo(respuesta.getInt(1));
                profesion.setNombre(respuesta.getString(2));
                profesion.setDescuento(respuesta.getDouble(3));
                lista.add(profesion);
            }
            conexion.Desconectar();
            return lista;
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "no se puede encontrar el codigo");
            }
        return null;
    }
     
     public List<Profesion> listar(){
        try {
            String sql="SELECT * FROM FER_PROFESIONES";
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            List<Profesion> lista=new ArrayList<>();
            while(respuesta.next()){
                Profesion p=new Profesion();
                p.setCodigo(respuesta.getInt(1));
                p.setNombre(respuesta.getString(2));
                p.setDescuento(respuesta.getDouble(3));
                lista.add(p);
            }
            conexion.Desconectar();
            return lista;
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "no se puede encontrar el codigo");
            }
        return null;
    }
    
}
