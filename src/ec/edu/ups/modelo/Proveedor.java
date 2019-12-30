package ec.edu.ups.modelo;

public class Proveedor extends Persona{
 
    private String empresa;

    public Proveedor(String empresa, int codigo, String nombres, String apellidos, String direccion, String cedula, String telefono, String email, String genero) {
        super(codigo, nombres, apellidos, direccion, cedula, telefono, email, genero);
        this.empresa = empresa;
    }

    public Proveedor() {
    }
    

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
    
    
}
