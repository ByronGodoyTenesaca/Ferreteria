package ec.edu.ups.modelo;

public class Profesion {
    private int codigo;
    private String nombre;
    private double descuento;

    public Profesion() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Profesion{" + "codigo=" + codigo + ", nombre=" + nombre + ", descuento=" + descuento + '}';
    }
    
    
}
