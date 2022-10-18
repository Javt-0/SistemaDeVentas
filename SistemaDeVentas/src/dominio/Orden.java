
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Orden{");
        sb.append("idOrden=").append(idOrden);
        sb.append(", productos=").append(productos);
        sb.append('}');
        return sb.toString();
    }
    
    
    //Metodos
    public void agregarProducto(Producto producto){
        contadorOrdenes ++;
        
        if(contadorOrdenes > maxProductos){
            this.productos.add(producto);
        }else{
            System.out.println("La cesta esta llena lo siento (MAX. 10)");
        }
    }
    
    public double calcularTotal(){
        
        return 0;
    }
    
    public void mostrarOrden(){
        for(int i=0; i<productos.size(); i++){
            System.out.println("Producto " + productos.size() + ": " + productos.get(i));
        }
    }
}
