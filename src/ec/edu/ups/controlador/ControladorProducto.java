package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorProducto {
  
    private ConexionBD conexion= new ConexionBD();
    
    public void Crear(Producto p){
        try {
            boolean estado=true;
            PreparedStatement pst=null;
            String sql="INSERT INTO FER_PRODUCTOS (PRO_CODIGO,PRO_NOMBRE,PRO_DESCRIPCION,PRO_COSTO_VENTA,PRO_COSTO_COMPRA,PRO_CANTIDAD,PRO_LUGAR_FABRICACION,PRO_IVA,FER_CATEGORIA_CAT_CODIGO, FER_TIPO_MEDIDA_MED_CODIGO,PRO_ESTADO)"
                    + "VALUES (FER_PRODUCTOS_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setString(1, p.getNombre());
            pst.setString(2, p.getDescripcion());
            pst.setDouble(3, p.getPrecioVenta());
            pst.setDouble(4, p.getPrecioCompra());
            pst.setInt(5, p.getCantidad());
            pst.setString(6, p.getLugarFabricacion());
            pst.setBoolean(7, p.getIva());
            pst.setInt(8, p.getCodigoCategoria());
            pst.setInt(9, p.getCodigoMedida());
            pst.setBoolean(10,estado );
            
            pst.executeUpdate();
            conexion.getConexion().commit();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Producto Creado Correctamente");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo crear el producto");
        }
    }
    
    public void Actualizar(Producto p){
        try {
            PreparedStatement pst=null;
            String sql="UPDATE FER_PRODUCTOS SET PRO_NOMBRE=?,PRO_DESCRIPCION=?,PRO_COSTO_VENTA=?,PRO_COSTO_COMPRA=?,PRO_CANTIDAD=?,PRO_LUGAR_FABRICACION=?,"
                    + "PRO_IVA=?,FER_CATEGORIA_CAT_CODIGO=?, FER_TIPO_MEDIDA_MED_CODIGO=?"
                    + "WHERE PRO_CODIGO = ?";
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setString(1, p.getNombre());
            pst.setString(2, p.getDescripcion());
            pst.setDouble(3, p.getPrecioVenta());
            pst.setDouble(4, p.getPrecioCompra());
            pst.setInt(5, p.getCantidad());
            pst.setString(6, p.getLugarFabricacion());
            pst.setBoolean(7, p.getIva());
            pst.setInt(8, p.getCodigoCategoria());
            pst.setInt(9, p.getCodigoMedida());
            pst.setInt(10, p.getCodigo());
            
            pst.execute();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Producto Actualizado Correctamente");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo Actualizar el producto");
        }
    }
    
    public void ActualizarMercaderia(int p,int nuevo){
        try {
            PreparedStatement pst=null;
            String sql="UPDATE FER_PRODUCTOS SET PRO_CANTIDAD=?"
                    + "WHERE PRO_CODIGO = ?";
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
           
            pst.setInt(1, nuevo);
            pst.setInt(2, p);
            
            pst.execute();
            conexion.Desconectar();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo Actualizar el producto");
        }
    }
    
    
     public void Eliminar(int codigo){
          try {
            boolean estado=false;
            PreparedStatement pst=null;
            String sql="UPDATE FER_PRODUCTOS SET PRO_ESTADO = ?"
                    + "WHERE PRO_CODIGO= ?";
            
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setBoolean(1, estado);
            pst.setInt(2, codigo);
             pst.execute();
             conexion.getConexion().commit();
            conexion.Desconectar();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo Eliminar el Producto");
        }
     }
     
     
     public List<Producto> buscarCategoria(int cat){
     
        try {
            List<Producto> lista=new ArrayList<>();
            conexion.Conectar();
            String sql="SELECT * FROM FER_PRODUCTOS WHERE FER_CATEGORIA_CAT_CODIGO="+cat+" AND PRO_ESTADO= 1";
            System.out.println(sql);
            Statement sta= conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            
            while(respuesta.next()){
                Producto p=new Producto();
                p.setCodigo(respuesta.getInt(1));
                p.setNombre(respuesta.getString(2));
                p.setDescripcion(respuesta.getString(3));
                p.setPrecioVenta(respuesta.getDouble(4));
                p.setPrecioCompra(respuesta.getDouble(5));
                p.setCantidad(respuesta.getInt(6));
                p.setLugarFabricacion(respuesta.getString(7));
                p.setIva(respuesta.getBoolean(8));
                p.setCodigoCategoria(respuesta.getInt(9));
                p.setCodigoMedida(respuesta.getInt(10));
                
                lista.add(p);
            }
            
            return lista;
        } catch (SQLException ex) {
            
        }
        return null;
     }   
      
      public List<Producto> buscarEmpresa(String cat){
     
        try {
            List<Producto> lista=new ArrayList<>();
            conexion.Conectar();
            String sql="SELECT PRO_CODIGO,PRO_NOMBRE,PRO_DESCRIPCION,PRO_COSTO_VENTA,"
                    + "PRO_COSTO_COMPRA,PRO_CANTIDAD,PRO_LUGAR_FABRICACION,PRO_IVA,FER_CATEGORIA_CAT_CODIGO,"
                    + "FER_TIPO_MEDIDA_MED_CODIGO "
                    + "FROM FER_PRODUCTOS P,FER_PROVEEDORES PR,FER_PRODUCTO_PROVEEDORES PP "
                    + "WHERE PR.PROV_EMPRESA LIKE '"+cat+"%' AND PR.PROV_CODIGO=PP.FER_PROVEEDOR_PROV_CODIGO "
                    + "AND P.PRO_CODIGO=PP.FER_PRODUCTO_PRO_CODIGO "
                    + "UNION "
                    + "SELECT PRO_CODIGO,PRO_NOMBRE,PRO_DESCRIPCION,PRO_COSTO_VENTA,"
                    + "PRO_COSTO_COMPRA,PRO_CANTIDAD,PRO_LUGAR_FABRICACION,PRO_IVA,FER_CATEGORIA_CAT_CODIGO,"
                    + "FER_TIPO_MEDIDA_MED_CODIGO FROM FER_PRODUCTOS WHERE PRO_ESTADO= 1";
            
            Statement sta= conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            
            while(respuesta.next()){
                Producto p=new Producto();
                p.setCodigo(respuesta.getInt(1));
                p.setNombre(respuesta.getString(2));
                p.setDescripcion(respuesta.getString(3));
                p.setPrecioVenta(respuesta.getDouble(4));
                p.setPrecioCompra(respuesta.getDouble(5));
                p.setCantidad(respuesta.getInt(6));
                p.setLugarFabricacion(respuesta.getString(7));
                p.setIva(respuesta.getBoolean(8));
                p.setCodigoCategoria(respuesta.getInt(9));
                p.setCodigoMedida(respuesta.getInt(10));
                
                lista.add(p);
            }
            
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
     }
     public List<Producto> buscarProducto(String cat){
     
        try {
            List<Producto> lista=new ArrayList<>();
            conexion.Conectar();
            String sql="SELECT * FROM FER_PRODUCTOS WHERE PRO_NOMBRE LIKE '"+cat+"%' AND PRO_ESTADO = 1";
            System.out.println(sql);
            Statement sta= conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            
            while(respuesta.next()){
                Producto p=new Producto();
                p.setCodigo(respuesta.getInt(1));
                p.setNombre(respuesta.getString(2));
                p.setDescripcion(respuesta.getString(3));
                p.setPrecioVenta(respuesta.getDouble(4));
                p.setPrecioCompra(respuesta.getDouble(5));
                p.setCantidad(respuesta.getInt(6));
                p.setLugarFabricacion(respuesta.getString(7));
                p.setIva(respuesta.getBoolean(8));
                p.setCodigoCategoria(respuesta.getInt(9));
                p.setCodigoMedida(respuesta.getInt(10));
                
                lista.add(p);
            }
            
            return lista;
        } catch (SQLException ex) {
            
        }
        return null;
     }
     
     public Producto buscarProductoFactura(int codigo){
        try {
            String sql="SELECT * FROM FER_PRODUCTOS WHERE PRO_CODIGO = "+codigo+" AND PRO_ESTADO= 1";
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            Producto p=new Producto();
            while(respuesta.next()){
                p.setCodigo(respuesta.getInt(1));
                p.setNombre(respuesta.getString(2));
                p.setDescripcion(respuesta.getString(3));
                p.setPrecioVenta(respuesta.getDouble(4));
                p.setPrecioCompra(respuesta.getDouble(5));
                p.setCantidad(respuesta.getInt(6));
                p.setLugarFabricacion(respuesta.getString(7));
                p.setIva(respuesta.getBoolean(8));
                p.setCodigoCategoria(respuesta.getInt(9));
                p.setCodigoMedida(respuesta.getInt(10));
            }
            conexion.Desconectar();
            return p;
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return null;
    }
     
      public String descripcion(int codigo){
        try {
            String sql="SELECT PRO_DESCRIPCION FROM FER_PRODUCTOS WHERE PRO_CODIGO = "+codigo+" AND PRO_ESTADO= 1";
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            String p="";
            while(respuesta.next()){
               p=respuesta.getString(1);
            }
            conexion.Desconectar();
            return p;
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return null;
    }
     
     public int buscarcodproducto(String nombre){
        try {
            String sql="SELECT * FROM FER_PRODUCTOS WHERE PRO_NOMBRE ='"+nombre+"' AND PRO_ESTADO = 1 ";
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            int codigoPro=0;
            while(respuesta.next()){
                 codigoPro=respuesta.getInt(1);
                 System.out.println("es el codigo del producto " +codigoPro);
               
            }
            return codigoPro;
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return 0;
    }
     
     public void ingresarMercaderia(int codigo,int suma){
        try {
            PreparedStatement pst=null;
            String sql="UPDATE FER_PRODUCTOS SET PRO_CANTIDAD=?"
                    + "WHERE PRO_CODIGO = ?";
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setInt(1, suma);
            pst.setInt(2, codigo);
            
            pst.execute();
            conexion.getConexion().commit();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null,"Stock ingresado Satisfactoriamente");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo Actualizar el Stock");
        }
    }
}
