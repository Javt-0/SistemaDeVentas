package com.ventas.accesodatos;

import dominio.Orden;
import dominio.Producto;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jonat
 */
public class ImpTxt implements IAccesoDatos{
    
    static private ArrayList<Producto> colecProductos = new ArrayList<>();
    static private Scanner teclado = new Scanner(System.in);
    
    @Override
    public void crearOrdenesTxt() {
        System.out.println("Insertando desde MySql");
    }

    @Override
    public void leerOrden() { 
        System.out.println("Listando desde MySql");
    }

    @Override
    public void escribirOrden(String nombre, Orden o1) { 
        ArrayList<Producto> produc = (ArrayList<Producto>)o1.getProductos().clone();
        PrintWriter salida = null;
        File archivo= new File(nombre);
        try {
            salida = new PrintWriter(archivo);
            //salida = new PrintWriter(new FileWriter(nombre, true));
            salida.print("Orden: " + o1.getIdOrden() + "\n");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }finally{
            salida.close();
        }
        
        //File archivo = new File(nombre);
        for(int i=0; i<produc.size(); i++){
            try {
                salida = new PrintWriter(new FileWriter(nombre, true));
                salida.print("\t" + produc.get(i).getIdProductos() + " ");
                salida.print("" + produc.get(i).getNombre() + " ");
                salida.print("" + produc.get(i).getPrecio() + "\n");
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }finally{
                salida.close();
            }
        }
        
    }
    
    @Override
    public void crearProductosTxt(String nombre){
        File archivo = new File(nombre);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
    @Override
    public void leerProductos(){
    
    }
    
    @Override
    public void introducirProducto(){
        String nombre;
        double precio;
        System.out.print("\nIngrese el nombre del producto: ");
        nombre = teclado.nextLine().toUpperCase();
        Producto p = new Producto(nombre);
        
        while(colecProductos.contains(p) == true){
            System.out.print("El producto ya se encuentra registrado, intente de nuevo porfavor: ");
            nombre = teclado.nextLine().toUpperCase();
            p = new Producto(nombre);
        }
        
        System.out.print("Ingrese el precio del producto: ");
        precio = teclado.nextDouble();
        //p.setPrecio(precio);
        
        p = new Producto(nombre, precio);
        
        System.out.println("Los datos del producto son:" + p);
           //System.out.println("¿Deseas incluir este producto al sistema? (S/N): ");
            teclado.nextLine();
            //elegir = teclado.nextLine();
            colecProductos.add(p);
    }
}
