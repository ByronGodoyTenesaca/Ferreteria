package ec.edu.ups.modelo;

public class Cliente extends Persona{
    private String numeroTarjeta;
    private String Profesion;

    public Cliente() {
    }

    public Cliente(String numeroTarjeta, int codigo, String nombres, String apellidos, String direccion, String cedula, String telefono, String email, String genero, String profesion) {
        super(codigo, nombres, apellidos, direccion, cedula, telefono, email, genero);
        this.numeroTarjeta = numeroTarjeta;
        this.Profesion=profesion;
        
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getProfesion() {
        return Profesion;
    }

    public void setProfesion(String Profesion) {
        this.Profesion = Profesion;
    }

    
    @Override
    public String toString() {
        return "Cliente{" + "numeroTarjeta=" + numeroTarjeta + '}';
    }

   
    
}
