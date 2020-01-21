package ec.edu.ups.controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    
}
