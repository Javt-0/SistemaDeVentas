
package dominio;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author jonat
 */
public class Orden {
    private int idOrden;
    private ArrayList<Producto> productos = new ArrayList<>();
    static private int contadorOrdenes;
    static int maxProductos = 10;
    
    //Constructores

    public Orden() {
        this.idOrden = ++Orden.contadorOrdenes;
    }

    public Orden(ArrayList<Producto> productos) {
        this.idOrden = ++Orden.contadorOrdenes;
    }
    
    

    //SET

    

    //GET

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public int getIdOrden() {
        return idOrden;
    }
    @Override
    public int hashCode(){
        int hash = 7;
        hash = 53 * hash + this.idOrden;
        hash = 53 * hash + Objects.hashCode(this.productos);
        return hash;
    }

    //hashCode and equals
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
        final Orden other = (Orden) obj;
        if (this.idOrden != other.idOrden) {
            return false;
        }
        return Objects.equals(this.productos, other.productos);
    }

    //ToString
    
    //Metodos
    public void agregarProducto(Producto producto) {
        if(this.productos.size() < maxProductos){
            this.productos.add(producto);
        }else{
            System.out.println("La cesta esta llena lo siento (MAX. 10) de la Orden numero " + this.idOrden);
        }
    }
    
    public double calcularTotal(ArrayList<Producto> productos){
        double total = 0;
        for(int i=0; i<productos.size(); i++){
            total += productos.get(i).getPrecio();
        }
        return total;
    }
    
    public void mostrarOrden(){
        System.out.println("Orden numero: " + this.idOrden);
        for(int i=0; i<this.productos.size(); i++){
            System.out.println(this.productos.get(i));
        }
    }
}
