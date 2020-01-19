
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Cargo;
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
public class ControladorCargo {
     private ConexionBD conexion;

    public ControladorCargo() {
    conexion = new ConexionBD();
    }

     
    public void crear(String c) {
        
        PreparedStatement pst = null;
        String sql = "INSERT INTO FER_CARGOS(CAR_CODIGO, CAR_CARGO)"
                + "VALUES (FER_CARGOS_SEQ.NEXTVAL,?)";
        try {
            conexion.Conectar();
            pst = conexion.getConexion().prepareStatement(sql);
            pst.setString(1, c);
            pst.execute();
            System.out.println("Guardado correctamente");
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Cargo Creado Correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
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
            ex.printStackTrace();
            System.out.println("Error " + ex.getMessage());
        }
    }

    public void eliminar(int codigo) {
        try {
            PreparedStatement pst = null;
            String sql = "DELETE FROM CARGO WHERE CAR_CODIGO =?";

            conexion.Conectar();
            pst = conexion.getConexion().prepareStatement(sql);
            pst.setInt(1, codigo);
            pst.execute();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "ELiminado Correctamente", "Eliminar", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se puedo Eliminar Correctamente!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public List<Cargo> listar(){
         try {
             List<Cargo> lista=new ArrayList<>();
             String sql="SELECT * FROM FER_CARGOS";
             conexion.Conectar();
             Statement sta=conexion.getConexion().createStatement();
             ResultSet respuesta =sta.executeQuery(sql);
             
             while(respuesta.next()){
                 Cargo c= new Cargo();
                 c.setCodigo(respuesta.getInt(1));
                 c.setCargo(respuesta.getString(2));
                 lista.add(c);
             }
             conexion.Desconectar();
             return lista;
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
        return null;
    }
    
    public Cargo Buscar(String c){
         try {
            
             String sql="SELECT * FROM FER_CARGOS WHERE CAR_CARGO='"+c+"'";
             conexion.Conectar();
             Statement sta=conexion.getConexion().createStatement();
             ResultSet respuesta =sta.executeQuery(sql);
             Cargo ca= new Cargo();
             while(respuesta.next()){
                 
                 ca.setCodigo(respuesta.getInt(1));
                 ca.setCargo(respuesta.getString(2));
             }
             return ca;
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
        return null;
    }
}
