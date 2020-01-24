package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Factura;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
public class ControladorFactura {

    private ConexionBD conexion;
    public ControladorFactura() {
    conexion= new ConexionBD();
    }

    public int numeroFactura(){
       int numero=0;
        try {
            String sql="select nvl(max(FAC_CODIGO),0) from FER_FACTURAS";
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet res=sta.executeQuery(sql);
            while(res.next()){
                numero=res.getInt(1);
                numero++;
            }
            conexion.Desconectar();
            return numero;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return numero;
    }
    
    public void crearFactura(Factura factura){
        try {
            PreparedStatement pst=null;
            boolean estado=true;
            String sql="INSERT INTO FER_FACTURAS (FAC_CODIGO, FAC_FECHA, FAC_SUBTOTAL, FAC_DESCUENTO, FAC_IVA, FAC_TOTAL, FAC_FORMA_PAGO, FER_CLIENTE_CLI_CODIGO, FER_EMPLEADO_EMP_CODIGO,FAC_ESTADO)"
                    + "VALUES (FER_FACTURA_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?)";
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            SimpleDateFormat formateador = new SimpleDateFormat ("yy-MM-dd");
            String fecha=formateador.format (new Date());
            pst.setString(1, fecha);
            pst.setDouble(2, factura.getSubtotal());
            pst.setDouble(2, factura.getDescuento());
            pst.setDouble(4, factura.getIva());
            pst.setDouble(5, factura.getTotal());
            pst.setString(6, factura.getFormaPago());
            pst.setInt(7, factura.getCodigoCliente());
            pst.setInt(8, factura.getCodigoEmpleado());
            pst.setBoolean(9, estado);
            pst.executeUpdate();
            conexion.getConexion().commit();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Factura Creada Correctamente");
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }
    
    
    public void anularFactura(int codigo){
        try {
            PreparedStatement pst=null;
            boolean estado=false;
            String sql="UPDATE FER_FACTURAS SET FAC_ESTADO=?"
                    + "WHERE FAC_CODIGO=?";
            
            conexion.Conectar();
            pst=conexion.getConexion().prepareStatement(sql);
            pst.setBoolean(1, estado);
            pst.setInt(2, codigo);
            pst.executeUpdate();
            conexion.Desconectar();
            JOptionPane.showConfirmDialog(null, "Factura Anulada");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public List<Factura> buscarFactura(String cedula){
        List<Factura> lista= new ArrayList<>();
        try {
            String sql="SELECT * FROM FER_FACTURAS F,FER_CLIENTES C"
                    + "WHERE F.FER_CLIENTE_CLI_CODIGO=C.CLI_CODIGO AND C.CLI_CEDULA= '"+cedula+"' AND F.FAC_ESTADO= 1";
            
            Statement sta=conexion.getConexion().createStatement();
            ResultSet respuesta=sta.executeQuery(sql);
            while(respuesta.next()){
                Factura f=new Factura();
                f.setCodigo(respuesta.getInt(1));
                f.setFecha(respuesta.getDate(2));
                f.setSubtotal(respuesta.getDouble(3));
                f.setDescuento(respuesta.getDouble(4));
                f.setIva(respuesta.getDouble(5));
                f.setTotal(respuesta.getDouble(6));
                f.setFormaPago(respuesta.getString(7));
                f.setCodigoCliente(respuesta.getInt(8));
                f.setCodigoEmpleado(respuesta.getInt(9));
                lista.add(f);
            }
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
