
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
        
    }

    public Producto(String nombre, double precio) {
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
        sb.append("Producto{");
        sb.append("idProductos=").append(idProductos);
        sb.append(", nombre=").append(nombre);
        sb.append(", precio=").append(precio);
        sb.append('}');
        return sb.toString();
    }
}
