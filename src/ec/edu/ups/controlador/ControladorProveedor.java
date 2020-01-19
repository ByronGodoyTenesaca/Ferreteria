package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Proveedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorProveedor {
    
    private ConexionBD conexion=new ConexionBD();
    
    
    public void crearProveedor(Proveedor c){
        try {
            PreparedStatement pst=null;
            String sql="INSERT INTO FER_PROVEEDORES (PROV_CODIGO, PROV_EMPRESA, PROV_DIRECCION, PROV_TELEFONO, PORV_NOMBRE, PROV_APELLIDO,  PROV_CEDULA, PROV_EMAIL, PROV_GENERO)"
                    + " VALUES (FER_PROVEEDORES_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
            
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setString(1, c.getEmpresa());
            pst.setString(2, c.getDireccion());
            pst.setString(3, c.getTelefono());
            pst.setString(4, c.getNombres());
            pst.setString(5, c.getApellidos());
            pst.setString(6, c.getCedula());
            pst.setString(7, c.getEmail());
            pst.setString(8, c.getGenero());
           
            pst.executeUpdate();
            conexion.getConexion().commit();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Proveedor Creado Correctamente");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo crear el Proveedor");
        }
        
    }
    
    public void actualizarProveedor(Proveedor c){
        try {
            PreparedStatement pst=null;
            String sql="UPDATE FER_PROVEEDORES SET PROV_EMPRESA=?, PROV_DIRECCION=?, PROV_TELEFONO=?, PORV_NOMBRE=?, PROV_APELLIDO=?,  PROV_CEDULA=?, PROV_EMAIL=?, PROV_GENERO=?"
                    + " WHERE PROV_CODIGO =?";
            
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setString(4, c.getNombres());
            pst.setString(5, c.getApellidos());
            pst.setString(2, c.getDireccion());
            pst.setString(6, c.getCedula());
            pst.setString(7, c.getEmail());
            pst.setString(1, c.getEmpresa());
            pst.setString(8, c.getGenero());
            pst.setString(3, c.getTelefono());
            pst.setInt(9, c.getCodigo());
            pst.execute();
            conexion.getConexion().commit();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Proveedor Actualizado Correctamente");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo crear el Proveedor");
        }
        
    }
    
    public void Eliminar(int codigo){
          try {
            PreparedStatement pst=null;
            String sql="DELETE FROM FER_PROVEEDORES WHERE PROV_CODIGO =?";
            
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setInt(1, codigo);
             pst.execute();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Proveedor Eliminado Correctamente");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo Eliminar el Proveedor");
        }
     }
    
    
    public Proveedor buscarCedula(String cedula){
        
        try {
            String sql ="SELECT * FROM FER_PROVEEDORES WHERE PROV_CEDULA='"+cedula+"'";
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            Proveedor p=new Proveedor();
            while(respuesta.next()){
                p.setCodigo(respuesta.getInt(1));
                p.setEmpresa(respuesta.getString(2));
                p.setDireccion(respuesta.getString(3));
                p.setTelefono(respuesta.getString(4));
                p.setNombres(respuesta.getString(5));
                p.setApellidos(respuesta.getString(6));
                p.setCedula(respuesta.getString(7));
                p.setEmail(respuesta.getString(8));
                p.setGenero(respuesta.getString(9));
            }
            return p;
        } catch (SQLException ex) {
            
        }
        return null;
    }
    
    public List<Proveedor> buscarEmpresa(String empresa){
        
        try {
            String sql ="SELECT * FROM FER_PROVEEDORES WHERE PROV_EMPRESA LIKE '"+empresa+"%'";
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            List<Proveedor> lista=new ArrayList<>();
            while(respuesta.next()){
                Proveedor p=new Proveedor();
                p.setCodigo(respuesta.getInt(1));
                p.setEmpresa(respuesta.getString(2));
                p.setDireccion(respuesta.getString(3));
                p.setTelefono(respuesta.getString(4));
                p.setNombres(respuesta.getString(5));
                p.setApellidos(respuesta.getString(6));
                p.setCedula(respuesta.getString(7));
                p.setEmail(respuesta.getString(8));
                p.setGenero(respuesta.getString(9));
                lista.add(p);
            }
            return lista;
        } catch (SQLException ex) {
            
        }
        return null;
    }
    
    
    public List<Proveedor> buscarNombre(String nombre){
        
        try {
            String sql ="SELECT * FROM FER_PROVEEDORES WHERE PROV_NOMBRE LIKE '"+nombre+"%'";
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            List<Proveedor> lista= new ArrayList<>();
            while(respuesta.next()){
                Proveedor p=new Proveedor();
                p.setCodigo(respuesta.getInt(1));
                p.setEmpresa(respuesta.getString(2));
                p.setDireccion(respuesta.getString(3));
                p.setTelefono(respuesta.getString(4));
                p.setNombres(respuesta.getString(5));
                p.setApellidos(respuesta.getString(6));
                p.setCedula(respuesta.getString(7));
                p.setEmail(respuesta.getString(8));
                p.setGenero(respuesta.getString(9));
                lista.add(p);
            }
            return lista;
        } catch (SQLException ex) {
            
        }
        return null;
    }
    
    
    public List<Proveedor> listar(){
        List<Proveedor>lista=new ArrayList<>();
        try {
            String sql ="SELECT * FROM FER_PROVEEDORES";
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            
            while(respuesta.next()){
                Proveedor p=new Proveedor();
                p.setCodigo(respuesta.getInt(1));
                p.setEmpresa(respuesta.getString(2));
                p.setDireccion(respuesta.getString(3));
                p.setTelefono(respuesta.getString(4));
                p.setNombres(respuesta.getString(5));
                p.setApellidos(respuesta.getString(6));
                p.setCedula(respuesta.getString(7));
                p.setEmail(respuesta.getString(8));
                p.setGenero(respuesta.getString(9));
                lista.add(p);
            }
            return lista;
        } catch (SQLException ex) {
            
        }
        return null;
    }
}
