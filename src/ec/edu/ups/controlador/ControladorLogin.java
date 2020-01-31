package ec.edu.ups.controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ControladorLogin {

    private ConexionBD conexion;
    private int codigo=0;
    public ControladorLogin() {
        
        conexion = new ConexionBD();
    
    }
  
    public int inicioSesion(String user,String pasword){
        
        try {
            
            String sql="SELECT EMP_NOMBRE,CARGO_CAR_CODIGO FROM FER_EMPLEADOS WHERE EMP_EMAIL='"+user+"' AND EMP_CONTRASEÑA='"+pasword+"'";
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet res=sta.executeQuery(sql);
            //System.out.println(res.next());
            if(res.next()){
                codigo=res.getInt(2);
                JOptionPane.showMessageDialog(null, "bienvenido: "+res.getString(1));
            }
            return codigo;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
           
        }
        return 0;
    }
    
    
    public int codigoEmpleado(String user,String pasword){
        
        try {
            int codigo=0;
            String sql="SELECT * FROM FER_EMPLEADOS WHERE EMP_EMAIL='"+user+"' AND EMP_CONTRASEÑA='"+pasword+"'";
           
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet res=sta.executeQuery(sql);
            //System.out.println(res.next());
            while(res.next()){
                //System.out.println("login correcto");
                codigo=res.getInt(1);
                //JOptionPane.showMessageDialog(null, "bienvenido: "+res.getString(2));
            }
            return codigo;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
           
        }
        return 0;
    }
    
}
