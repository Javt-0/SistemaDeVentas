
package sistemadeventas;


import com.ventas.accesodatos.IAccesoDatos;
import com.ventas.accesodatos.ImpTxt;
import dominio.Orden;
import dominio.Producto;

/**
 *
 * @author jonat
 */
public class SistemaDeVentas {

    
    public static void main(String[] args) {
        
        Orden o1 = new Orden();
        Orden o2 = new Orden();
        //Producto p1 = new Producto("Patata", 2.4);
        //Producto p2 = new Producto("Leche", 1.15);
        /*Producto p3 = new Producto("Huevos", 3.60);
        
        
        o1.agregarProducto(p1);
        o1.agregarProducto(p2);
        o1.agregarProducto(p3);
        o1.agregarProducto(p1);
        o1.agregarProducto(p2);
        o1.agregarProducto(p3);
        o1.agregarProducto(p1);
        o1.agregarProducto(p2);
        o1.agregarProducto(p3);
        o1.agregarProducto(p1);
        o1.agregarProducto(p2);
        o1.agregarProducto(p3);
        
        o2.agregarProducto(p1);
        o2.agregarProducto(p2);
        o2.agregarProducto(p3);
        o2.agregarProducto(p1);
        o2.agregarProducto(p2);
        o2.agregarProducto(p3);
        o2.agregarProducto(p1);
        o2.agregarProducto(p2);
        o2.agregarProducto(p3);
        o2.agregarProducto(p1);
        o2.agregarProducto(p2);
        o2.agregarProducto(p3);*/
        
        IAccesoDatos impleTxt = new ImpTxt();
        impleTxt.crearProductosTxt("Producto.txt");
        impleTxt.introducirProducto();
        impleTxt.introducirProducto();
        //impleTxt.escribir("Ordenes.txt", o2);
        
        //o1.mostrarOrden();
    }
    
    public static void introducirProductos(){
        
    }
    
}
