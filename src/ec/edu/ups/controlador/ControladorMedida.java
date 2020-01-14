
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Medida;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorMedida {
    private ConexionBD conexion= new ConexionBD();
    
    public void CrearMedida(String nombre){
        try {
            PreparedStatement pst=null;
            String sql="INSERT INTO FER_TIPO_MEDIDAS (MED_CODIGO,MED_NOMBRE)"
                    + "VALUES (FER_TIPO_MEDIDA_SEQ.NEXTVAL,?)";
            
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setString(1, nombre);
             pst.executeUpdate();
            conexion.getConexion().commit();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Medida Creada Correctamente");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "no se pudo crear la medida");
        }
    }
    
    public void Eliminar(String nombre){
          try {
            PreparedStatement pst=null;
            String sql="DELETE FROM FER_TIPO_MEDIDAS WHERE MED_NOMBRE =?";
            
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setString(1, nombre);
             pst.execute();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Medida Eliminado Correctamente");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo Eliminar la Medida");
        }
     }
    
    
    public Medida buscar(String nombre){
        
        try {
            String sql="SELECT * FROM FER_TIPO_MEDIDAS WHERE MED_NOMBRE="+nombre+";";
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            Medida m=new Medida();
            while(respuesta.next()){
                m.setCodigo(respuesta.getInt(1));
                m.setTipo(respuesta.getString(2));
            }
            return m;
        } catch (SQLException ex) {
            
        }
        return null;
            
    }
    
    public List<Medida> Listar(){
        
        try {
            String sql="SELECT * FROM FER_TIPO_MEDIDAS";
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            List<Medida> lista=new ArrayList<>();
            while(respuesta.next()){
                Medida m=new Medida();
                m.setCodigo(respuesta.getInt(1));
                m.setTipo(respuesta.getString(2));
                lista.add(m);
            }
            return lista;
        } catch (SQLException ex) {
            
        }
        return null;
            
    }
}
