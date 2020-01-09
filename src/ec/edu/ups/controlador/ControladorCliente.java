package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class ControladorCliente {
    
    private ConexionBD conexion;

    public ControladorCliente() {
    conexion=new ConexionBD();
    }
    
    public void CrearCliente(Cliente c,int n) throws SQLException{
        try {
            PreparedStatement pst=null;
            String sql="INSERT INTO FER_CLIENTES (CLI_CODIGO, CLI_NOMBRE, CLI_APELLIDO, CLI_DIRECCION, CLI_CEDULA, CLI_EMAIL, CLI_NUM_TARJETA, CLI_GENERO, CLI_TELEFONO, PROFESION_PRO_CODIGO)"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?)";
            
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setInt(1, 6);
            pst.setString(2, c.getNombres());
            pst.setString(3, c.getApellidos());
            pst.setString(4, c.getDireccion());
            pst.setString(5, c.getCedula());
            pst.setString(6, c.getEmail());
            pst.setString(7, c.getNumeroTarjeta());
            pst.setString(8, c.getGenero());
            pst.setString(9, c.getTelefono());
            pst.setInt(10, n);
            pst.executeUpdate();
            conexion.getConexion().commit();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Cliente Creado Correctamente");
            
        } catch (SQLException ex) {
            conexion.getConexion().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo crear el Cliente");
            ex.printStackTrace();
        }
        
    }
    
     public void Actualizar(Cliente c,int n){
            try {
            PreparedStatement pst=null;
            String sql="UPDATE FER_CLIENTES SET CLI_NOMBRE= ?, CLI_APELLIDO= ?, CLI_DIRECCION= ?, CLI_EMAIL= ?, CLI_NUM_TARJETA= ?, CLI_GENERO= ?, CLI_TELEFONO= ?, PROFESION_PRO_CODIGO= ?"
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
           pst.executeUpdate();
        
            
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Cliente Actualizado Correctamente");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo Actualizar el Cliente");
        }
            
        }
     
     public void Eliminar(String Cedula){
          try {
            PreparedStatement pst=null;
            String sql="DELETE FROM FER_CLIENTES WHERE CLI_CEDULA =?";
            
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setString(1, Cedula);
            pst.executeUpdate();
            
            
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
            String sql="SELECT "
                    + "CLI_CODIGO,CLI_NOMBRE,CLI_APELLIDO,CLI_DIRECCION,CLI_CEDULA,CLI_EMAIL,CLI_NUM_TARJETA,\n" 
                    + "CLI_GENERO,CLI_TELEFONO,PRO_PROFESION"
                    + " FROM FER_CLIENTES C, FER_PROFESIONES P "
                    + "WHERE CLI_CEDULA = '"+Cedula+"' AND C.PROFESION_PRO_CODIGO=P.PRO_CODIGO";
            System.out.println(sql);
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            System.out.println(respuesta);
            
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
                c.setProfesion(respuesta.getString(10));
                break;
                
            }
            conexion.Desconectar();
            return c;
        } catch (SQLException ex) {
            ex.printStackTrace();
           JOptionPane.showMessageDialog(null, "No se pudo encontrar a la persona");
        }
        return null;
     }
     
     public List<Cliente> ListarProfesion(String n){
        try {
             List<Cliente> lista=new ArrayList<>();
            
             String sql="SELECT "
                    + "CLI_CODIGO,CLI_NOMBRE,CLI_APELLIDO,CLI_DIRECCION,CLI_CEDULA,CLI_EMAIL,CLI_NUM_TARJETA,\n" 
                    + "CLI_GENERO,CLI_TELEFONO,PRO_PROFESION"
                    + " FROM FER_CLIENTES C, FER_PROFESIONES P "
                    + "WHERE P.PRO_PROFESION = '"+n+"' AND C.PROFESION_PRO_CODIGO=P.PRO_CODIGO";
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
                c.setProfesion(respuesta.getString(10));
                lista.add(c);
            }
            conexion.Desconectar();
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
           JOptionPane.showMessageDialog(null, "No se pudo encontrar a las profesiones");
        }
        return null;
     }
     
     
     
     public List<Cliente> ListarNombre(String n){
        try {
             List<Cliente> lista=new ArrayList<>();
            
             String sql="SELECT "
                    + "CLI_CODIGO,CLI_NOMBRE,CLI_APELLIDO,CLI_DIRECCION,CLI_CEDULA,CLI_EMAIL,CLI_NUM_TARJETA," 
                    + "CLI_GENERO,CLI_TELEFONO,PRO_PROFESION"
                    + " FROM FER_CLIENTES C, FER_PROFESIONES P "
                    + "WHERE C.CLI_NOMBRE LIKE '"+n+"%' AND C.PROFESION_PRO_CODIGO=P.PRO_CODIGO";
             System.out.println(sql);
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
                c.setProfesion(respuesta.getString(10));
                lista.add(c);
            }
            conexion.Desconectar();
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
           JOptionPane.showMessageDialog(null, "No se pudo encontrar a las profesiones");
        }
        return null;
     }
}
