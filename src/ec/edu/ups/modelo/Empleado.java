
package ec.edu.ups.modelo;

/**
 *
 * @author Ronal
 */
public class Empleado extends Persona{
    private String contraseña;
    private String cargo;

    public Empleado() {
    }

    public Empleado(String contraseña, String cargo, int codigo, String nombres, String apellidos, String direccion, String cedula, String telefono, String email, String genero) {
        super(codigo, nombres, apellidos, direccion, cedula, telefono, email, genero);
        this.contraseña = contraseña;
        this.cargo = cargo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Empleado{" + "contrase\u00f1a=" + contraseña + ", cargo=" + cargo + '}';
    }
    
}
