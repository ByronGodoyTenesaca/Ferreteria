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
            PreparedStatement pst=null;
            String sql="INSERT INTO PRODUCTO (POR_CODIGO,PRO_NOMBRE,PRO_DESCRIPCION,PRO_COSTO_VENTA,PRO_COSTO_COMPRA,PRO_CANTIDAD,PRO_LUGAR_FABRICACION,PRO_IVA,FER_CATEGORIA_CAT_CODIGO, FER_TIPO_MEDIDA_MED_CODIGO)"
                    + "VALUES (PRODUCTO_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?)";
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
            
            pst.execute();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Producto Creado Correctamente");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo crear el producto");
        }
    }
    
    public void Actualizar(Producto p){
        try {
            PreparedStatement pst=null;
            String sql="UPDATE PRODUCTO SET PRO_NOMBRE=?,PRO_DESCRIPCION=?,PRO_COSTO_VENTA=?,PRO_COSTO_COMPRA=?,PRO_CANTIDAD=?,PRO_LUGAR_FABRICACION=?,"
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
    
    
     public void Eliminar(int codigo){
          try {
            PreparedStatement pst=null;
            String sql="DELETE FROM PRODUCTO WHERE PRO_CODIGO =?";
            
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setInt(1, codigo);
             pst.execute();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Producto Eliminado Correctamente");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo Eliminar el Producto");
        }
     }
     
     
     public List<Producto> buscarCategoria(int cat){
     
        try {
            List<Producto> lista=new ArrayList<>();
            conexion.Conectar();
            String sql="SELECT * FROM PRODUCTO WHERE FER_CATEGORIA_CAT_CODIGO="+cat+";";
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
}
