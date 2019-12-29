package ec.edu.ups.controlador;

import ec.edu.ups.modelo.ProductoProveedor;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControladorProductoProveedor {
 
    private ConexionBD conexion= new ConexionBD();
    
    public void CrearCategoria(ProductoProveedor pp){
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
}
