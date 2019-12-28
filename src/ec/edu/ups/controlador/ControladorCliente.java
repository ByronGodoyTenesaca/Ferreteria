package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class ControladorCliente {
    
    private ConexionBD conexion=new ConexionBD();
    
    
    public void CrearCliente(Cliente c,int n){
        try {
            PreparedStatement pst=null;
            String sql="INSERT INTO CLIENTE (CLI_CODIGO, CLI_NOMBRE, CLI_APELLIDO, CLI_DIRECCION, CLI_CEDULA, CLI_EMAIL, CLI_NUM_TARJETA, CLI_GENERO, CLI_TELEFONO, PROFESION_PRO_CODIGO)"
                    + " VALUES (CLIENTE_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?)";
            
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setString(1, c.getNombres());
            pst.setString(2, c.getApellidos());
            pst.setString(3, c.getDireccion());
            pst.setString(4, c.getCedula());
            pst.setString(5, c.getEmail());
            pst.setString(6, c.getNumeroTarjeta());
            pst.setString(7, c.getGenero());
            pst.setString(8, c.getTelefono());
            pst.setInt(9, n);
            pst.execute();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Cliente Creado Correctamente");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo crear el Cliente");
        }
        
    }
    
     public void Actualizar(Cliente c,int n){
            try {
            PreparedStatement pst=null;
            String sql="UPDATE CLIENTE SET CLI_NOMBRE= ?, CLI_APELLIDO= ?, CLI_DIRECCION= ?, CLI_EMAIL= ?, CLI_NUM_TARJETA= ?, CLI_GENERO= ?, CLI_TELEFONO= ?, PROFESION_PRO_CODIGO= ?"
                    + " WHERE CLI_CEDULA =?";
            
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setString(1, c.getNombres());
            pst.setString(2, c.getApellidos());
            pst.setString(3, c.getDireccion());
            pst.setString(4, c.getEmail());
            pst.setString(5, c.getNumeroTarjeta());
            pst.setString(6, c.getGenero());
            pst.setString(7, c.getTelefono());
            pst.setInt(8, n);
            pst.setString(9, c.getCedula());
            pst.execute();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Cliente Actualizado Correctamente");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo Actualizar el Cliente");
        }
            
        }
     
     public void Eliminar(String Cedula){
          try {
            PreparedStatement pst=null;
            String sql="DELETE FROM CLIENTE WHERE CLI_CEDULA =?";
            
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setString(1, Cedula);
             pst.execute();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Cliente Eliminado Correctamente");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo Eliminar el Cliente");
        }
     }
     
     public Cliente ListarCedula(String Cedula){
        try {
            // List<Cliente> lista=new ArrayList<>();
            Cliente c=new Cliente();
            String sql="SELECT * FROM CLIENTE WHERE CLI_CEDULA = "+Cedula+";";
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            
            while(respuesta.next()){
                c.setCodigo(respuesta.getInt(1));
                c.setNombres(respuesta.getString(2));
                c.setApellidos(respuesta.getString(3));
                c.setDireccion(respuesta.getString(4));
                c.setCedula(Cedula);
                c.setEmail(respuesta.getString(6));
                c.setNumeroTarjeta(respuesta.getString(7));
                c.setGenero(respuesta.getString(8));
                c.setTelefono(respuesta.getString(9));
                

// ---------->>>>  falta la de profesion  
                break;
                
            }
            return c;
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "No se pudo encontrar a la persona");
        }
        return null;
     }
     
     public List<Cliente> ListarProfesion(int n){
        try {
             List<Cliente> lista=new ArrayList<>();
            
            String sql="SELECT * FROM CLIENTE WHERE CLI_PROFESION = "+n+";";
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            
            while(respuesta.next()){
                Cliente c=new Cliente();
                c.setCodigo(respuesta.getInt(1));
                c.setNombres(respuesta.getString(2));
                c.setApellidos(respuesta.getString(3));
                c.setDireccion(respuesta.getString(4));
                c.setCedula(respuesta.getString(5));
                c.setEmail(respuesta.getString(6));
                c.setNumeroTarjeta(respuesta.getString(7));
                c.setGenero(respuesta.getString(8));
                c.setTelefono(respuesta.getString(9));
                // ---------->>>>  falta la de profesion 
                lista.add(c);
            }
            return lista;
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "No se pudo encontrar a las profesiones");
        }
        return null;
     }
}
