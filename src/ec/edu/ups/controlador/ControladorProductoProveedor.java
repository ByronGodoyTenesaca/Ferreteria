package ec.edu.ups.controlador;

import ec.edu.ups.modelo.ProductoProveedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControladorProductoProveedor {
 
    private ConexionBD conexion= new ConexionBD();
    
    public void CrearProductoProveedor(ProductoProveedor pp){
        try {
            PreparedStatement pst=null;
            String sql="INSERT INTO PRODUCTO_PROVEEDOR (PROD_PRO_CODIGO,PROD_PROV_CANTIDAD, FER_PROVEEDOR_PROV_CODIGO, FER_PRODUCTO_PRO_CODIGO)"
                    + "VALUES (PRODUCTO_PROVEEDOR_SEQ.NEXTVAL,?,?,?)";
            
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setDouble(1, pp.getCantidad());
            pst.setInt(2, pp.getCodigoProveedor());
            pst.setInt(3, pp.getCodigoProducto());
            conexion.Desconectar();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo completar el guardado de informacion");
        }
    }
    
    public int buscarcodproveedor(int codigo){
        try {
            String sql="SELECT * FROM PRODUCTO_PROVEEDOR WHERE FER_PRODUCTO_PRO_CODIGO="+codigo+";";
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            int codigoPro=0;
            while(respuesta.next()){
                codigoPro=respuesta.getInt(3);
            }
            return codigoPro;
        } catch (SQLException ex) {
           
        }
        return 0;
    }
}
