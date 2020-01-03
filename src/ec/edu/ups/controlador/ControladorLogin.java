package ec.edu.ups.controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ControladorLogin {

    private ConexionBD conexion;
    
    public ControladorLogin() {
    
    }
  
    public int inicioSesion(String user,String pasword){
        
        try {
            int codigo=0;
            String sql="SELECT * FROM EMPLEADO WHERE EMP_EMAIL='"+user+"' AND EMP_CONTRASEÑA='"+pasword+"';";
            System.out.println(sql);
            conexion.Conectar();
            Statement sta=conexion.getConexion().createStatement();
            ResultSet res=sta.executeQuery(sql);
            while(res.next()){
                codigo=res.getInt(10);
                JOptionPane.showMessageDialog(null, "bienvenido"+res.getString(2));
            }
            
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Usuario y Contraseña incorrecto");
        }catch(java.lang.NullPointerException e){
            e.printStackTrace();
        }
        return 0;
    }
    
    
}
