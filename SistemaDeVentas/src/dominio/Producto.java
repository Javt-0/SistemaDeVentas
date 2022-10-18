
package dominio;

/**
 *
 * @author jonat
 */
public class Producto {

    private int idProductos;
    private String nombre;
    private double precio;
    static private int contadorProductos;
    
    //Constructores

    public Producto() {
        this.idProductos = ++Producto.contadorProductos;
    }

    public Producto(String nombre, double precio) {
        this.idProductos = ++Producto.contadorProductos;
        this.nombre = nombre;
        this.precio = precio;
    }
    
    //Get

    public int getIdProductos() {
        return idProductos;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
    
    //Set

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    //HashCode and equals

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idProductos;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        return this.idProductos == other.idProductos;
    }
    
    //toString

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nProducto ");
        sb.append("").append(idProductos);
        sb.append(": \n").append(nombre);
        sb.append("\nPrecio ").append(precio);
        return sb.toString();
    }
}
