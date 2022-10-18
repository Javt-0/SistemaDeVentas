
package sistemadeventas;

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
        Producto p1 = new Producto("Patata", 2.4);
        Producto p2 = new Producto("Leche", 1.15);
        Producto p3 = new Producto("Huevos", 3.60);
        Producto p4 = new Producto("Pan", 0.90);
        Producto p5 = new Producto("Pan", 0.90);
        Producto p6 = new Producto("Pan", 0.90);
        Producto p7 = new Producto("Pan", 0.90);
        Producto p8 = new Producto("Pan", 0.90);
        Producto p9 = new Producto("Pan", 0.90);
        Producto p10 = new Producto("Pan", 0.90);
        Producto p11 = new Producto("Pan", 0.90);
        Producto p12 = new Producto("Pan", 0.90);
        
        
        o1.agregarProducto(p1);
        o1.agregarProducto(p2);
        o1.agregarProducto(p3);
        o1.agregarProducto(p4);
        o1.agregarProducto(p5);
        o1.agregarProducto(p6);
        o1.agregarProducto(p7);
        o2.agregarProducto(p8);
        o2.agregarProducto(p9);
        o2.agregarProducto(p1);
        o2.agregarProducto(p2);
        o2.agregarProducto(p5);
        
        o1.mostrarOrden();
        o2.mostrarOrden();
        System.out.printf("\nEl total a pagar es %.2f€\n",o1.calcularTotal());
    }
    
    public static void introducirProductos(){
        
    }
    
}
