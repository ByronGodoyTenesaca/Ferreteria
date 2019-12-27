package ec.edu.ups.modelo;

public class Cliente extends Persona{
    private String numeroTarjeta;

    public Cliente() {
    }

    public Cliente(String numeroTarjeta, int codigo, String nombres, String apellidos, String direccion, String cedula, String telefono, String email, String genero) {
        super(codigo, nombres, apellidos, direccion, cedula, telefono, email, genero);
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    @Override
    public String toString() {
        return "Cliente{" + "numeroTarjeta=" + numeroTarjeta + '}';
    }

   
    
}
