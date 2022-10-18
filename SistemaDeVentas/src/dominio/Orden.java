
package dominio;

import java.util.ArrayList;

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

    //SET

    

    //GET
    
    
    //hashCode and equals

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idOrden;
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
        final Orden other = (Orden) obj;
        return this.idOrden == other.idOrden;
    }
    
    //ToString    
    
    //Metodos
    static int contMax = 0;
    public void agregarProducto(Producto producto){
        
        if(contMax < maxProductos){
            this.productos.add(producto);
            contMax ++;
        }else{
            System.out.println("La cesta esta llena lo siento (MAX. 10)");
        }
    }
    
    public double calcularTotal(){
        double total = 0;
        for(int i=0; i<this.productos.size(); i++){
            total += this.productos.get(i).getPrecio();
        }
        return total;
    }
    
    public void mostrarOrden(){
        System.out.println("Orden numero: " + contadorOrdenes);
        for(int i=0; i<this.productos.size(); i++){
            System.out.println(this.productos.get(i));
        }
    }
}
