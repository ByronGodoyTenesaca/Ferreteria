package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Medida;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorCategoria {
 
    private ConexionBD conexion= new ConexionBD();
    
    public void CrearCategoria(String nombre){
        try {
            PreparedStatement pst=null;
            String sql="INSERT INTO CATEGORIA (CAT_CODIGO,CAT_NOMBRE)"
                    + "VALUES (FER_TIPO_MEDIDA_SEQ.NEXTVAL,?)";
            
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setString(1, nombre);
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Categoria Creada Correctamente");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo crear la Categoria");
        }
    }
    
    public void Eliminar(String nombre){
          try {
            PreparedStatement pst=null;
            String sql="DELETE FROM CATEGORIA WHERE CAT_NOMBRE =?";
            
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setString(1, nombre);
             pst.execute();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Categoria Eliminada Correctamente");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo Eliminar la Categoria");
        }
     }
    
    
    public Categoria buscar(String nombre){
        
        try {
            String sql="SELECT * FROM CATEGORIA WHERE CAT_MOMBRE="+nombre+";";
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            Categoria m=new Categoria();
            while(respuesta.next()){
                m.setCodigo(respuesta.getInt(1));
                m.setCategoria(respuesta.getString(2));
            }
            return m;
        } catch (SQLException ex) {
            
        }
        return null;
            
    }
    
    public List<Categoria> Listar(){
        
        try {
            String sql="SELECT * FROM CATEGORIA;";
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            List<Categoria> lista=new ArrayList<>();
            
            while(respuesta.next()){
                Categoria m=new Categoria();
                m.setCodigo(respuesta.getInt(1));
                m.setCategoria(respuesta.getString(2));
                lista.add(m);
            }
            return lista;
        } catch (SQLException ex) {
            
        }
        return null;
            
    }
    
}
