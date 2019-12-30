package ec.edu.ups.modelo;

public class Producto {

    private int codigo;
    private String nombre;
    private String descripcion;
    private double precioVenta;
    private Double precioCompra;
    private int cantidad;
    private String lugarFabricacion;
    private boolean iva;
    private int codigoCategoria;
    private int codigoMedida;
    
    public Producto() {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getLugarFabricacion() {
        return lugarFabricacion;
    }

    public void setLugarFabricacion(String lugarFabricacion) {
        this.lugarFabricacion = lugarFabricacion;
    }

    public boolean getIva() {
        return iva;
    }

    public void setIva(boolean iva) {
        this.iva = iva;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public int getCodigoMedida() {
        return codigoMedida;
    }

    public void setCodigoMedida(int codigoMedida) {
        this.codigoMedida = codigoMedida;
    }
    
    
}
