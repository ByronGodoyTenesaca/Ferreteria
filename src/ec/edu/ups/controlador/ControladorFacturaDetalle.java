package ec.edu.ups.controlador;

import ec.edu.ups.modelo.FacturaDetalle;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControladorFacturaDetalle {

 
    private ConexionBD conexion;

    public ControladorFacturaDetalle() {
    conexion=new ConexionBD();
    }
    
    
    public void crearFactura(FacturaDetalle factura){
        try {
            PreparedStatement pst=null;
            boolean estado=true;
            String sql="INSERT INTO FER_FACTURA_DETALLES (FAC_DET_CODIGO, FAC_DET_CANTIDAD, FAC_DET_PRECIO_UNI, FAC_DET_PRECIO_TOTAL, FER_FACTURA_FAC_CODIGO,FER_PRODUCTO_PRO_CODIGO)"
                    + "VALUES (FER_FACTURA_DETALLES_SEQ.NEXTVAL,?,?,?,?,?)";
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setInt(1, factura.getCantidad());
            pst.setDouble(2, factura.getPrecioUnitario());
            pst.setDouble(3, factura.getPrecioTotal());
            pst.setInt(4, factura.getCodigoFactura());
            pst.setInt(5, factura.getCodigoProducto());
            pst.executeUpdate();
            conexion.getConexion().commit();
            conexion.Desconectar();
            
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }
    
    public void actualizarCodFactura(int codigoProducto,int codigoFactura){
        try {
            PreparedStatement pst=null;
            String sql="UPDATE FER_FACTURA_DETALLES SET FER_FACTURA_FAC_CODIGO= ?"
                    + "WHERE FER_PRODUCTO_PRO_CODIGO= ?";
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setInt(1, codigoFactura);
            pst.setInt(2, codigoProducto);
            
            pst.executeUpdate();
            conexion.Desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void eliminarDetalle(int codigo){
        try {
            PreparedStatement pst=null;
            String sql="DELETE FROM FER_FACTURA_DETALLES WHERE FER_PRODUCTO_PRO_CODIGO="+codigo+"";
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.executeUpdate();
        } catch (SQLException ex) {
            
        }
    }
    
    public List<FacturaDetalle> listar(int codigo){
        
        try {
            List<FacturaDetalle> lista=new ArrayList<>();
            String sql="SELECT * FROM FER_FACTURA_DETALLES WHERE FER_FACTURA_FAC_CODIGO= "+codigo+"";
            System.out.println(sql);
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            while(respuesta.next()){
                FacturaDetalle f=new FacturaDetalle();
                f.setCodigo(respuesta.getInt(1));
                f.setCantidad(respuesta.getInt(2));
                f.setPrecioUnitario(respuesta.getDouble(3));
                f.setPrecioTotal(respuesta.getDouble(4));
                f.setCodigoFactura(respuesta.getInt(5));
                f.setCodigoProducto(respuesta.getInt(6));
                lista.add(f);
            }
            conexion.Desconectar();
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
