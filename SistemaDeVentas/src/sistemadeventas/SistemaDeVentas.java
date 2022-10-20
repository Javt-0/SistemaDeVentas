
package sistemadeventas;


import com.ventas.accesodatos.IAccesoDatos;
import com.ventas.accesodatos.ImpTxt;
import dominio.Orden;
import dominio.Producto;
import java.util.Scanner;

/**
 *
 * @author jonat
 */
public class SistemaDeVentas {

    static private Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        //Los .txt de orden y productos estan creados por eso no se usan los metodos de crear
        //pero estan construidos por si se quieren usar en un futuro
        
        menu();
    }
    
    public static void menu(){
        IAccesoDatos impleTxt = new ImpTxt();
        impleTxt.leerProductos("Producto.txt");
        int opcion = -1;
        int alum =0;
        while(opcion != 0){
            System.out.flush();
            System.out.println("");
            System.out.println("\t\t\t\t********************************************************");
            System.out.println("\t\t\t\t************                               *************");
            System.out.println("\t\t\t\t**** BIENVENIDO AL SISTEMA DE GESTION DE PRODUCTOS *****");
            System.out.println("\t\t\t\t************                               *************");
            System.out.println("\t\t\t\t********************************************************");
            System.out.println("\t\t\t\t========================================================");
            System.out.println("\t\t\t\t||         1. AÑADIR UN PRODUCTO                      ||");
            System.out.println("\t\t\t\t||         2. CREAR NUEVA ORDEN                      ||");
            System.out.println("\t\t\t\t||         3. VISUALIZAR HISTORICO DE ORDENES         ||");
            System.out.println("\t\t\t\t||         4. VISUALIZAR EL STOCK                     ||");
            System.out.println("\t\t\t\t||         0. SALIR                                   ||");
            System.out.println("\t\t\t\t=========================================================");
            System.out.print("\t\t\t\tSeleccionar una opciones del menú: ");
            opcion = teclado.nextInt();

            switch(opcion){
                case 1:
                    impleTxt.introducirProducto();
                    break;
                case 2:
                    impleTxt.crearOrdenesTxt();
                    break;
                case 3:
                    System.out.println("En construccion......");
                    break;
                case 4:
                    System.out.println("Este es el stock de productos:");
                    impleTxt.leerProductos("Producto.txt");
                    break;
                case 0:
                    System.out.println("******** GRACIAS POR UTILIZAR EL PROGRAMA ********");
                    break;
                default:
                    System.out.println("!!!!!!!! ERROR !!!!!!!!\n");
                    System.out.println("Fuera de los parámetros establecidos, ingrese de nuevo la opción\n");
                    break;
            }
            
            System.out.println("Pulse ENTER para volver....");
            teclado.nextLine();
            teclado.nextLine();
                    
            for(int i=0; i<20; i++){
                System.out.println(" ");
            }
        }
    }
    
}
