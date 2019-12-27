package ec.edu.ups.modelo;

public class Persona {
  private int codigo;
private String nombres;
private String apellidos;
private String direccion;
private String cedula;
private String telefono;
private String email;
private String genero;

    public Persona() {
    }

    public Persona(int codigo, String nombres, String apellidos, String direccion, String cedula, String telefono, String email, String genero) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.cedula = cedula;
        this.telefono = telefono;
        this.email = email;
        this.genero = genero;
    }
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Persona{" + "codigo=" + codigo + ", nombres=" + nombres + ", apellidos=" + apellidos + ", direccion=" + direccion + ", cedula=" + cedula + ", telefono=" + telefono + ", email=" + email + ", genero=" + genero + '}';
    }


}
