package ec.edu.ups.controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ControladorLogin {

    private ConexionBD conexion;
    
    public ControladorLogin() {
        
        conexion = new ConexionBD();
    
    }
  
    public int inicioSesion(String user,String pasword){
        
        try {
            int codigo=0;
            String sql="SELECT * FROM FER_EMPLEADOS WHERE EMP_EMAIL='"+user+"' AND EMP_CONTRASEÑA='"+pasword+"'";
           
            System.out.println(sql);
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet res=sta.executeQuery(sql);
            System.out.println(res.next());
            while(res.next()){
                //System.out.println("login correcto");
                codigo=res.getInt(10);
                JOptionPane.showMessageDialog(null, "bienvenido: "+res.getString(2));
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
           
            System.out.println(sql);
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet res=sta.executeQuery(sql);
            System.out.println(res.next());
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
