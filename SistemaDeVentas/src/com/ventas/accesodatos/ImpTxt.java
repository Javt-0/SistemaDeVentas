package com.ventas.accesodatos;

import dominio.Orden;
import dominio.Producto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
        Orden o1 = new Orden();
        System.out.println("Cuantos productos va introducir a la orden?");
        int num = teclado.nextInt();
        teclado.nextLine();
        //ArrayList<Producto> colecProducOrden = new ArrayList<>();
        for(int i=0; i<num; i++){
            System.out.print("Ingrese el nombre del producto que quiere introducir a la orden: ");
            
            String nombre = teclado.nextLine().toUpperCase();
            Producto p = new Producto(nombre);

            while(colecProductos.contains(p) == false){
                System.out.print("El producto no esta en stock, intente de nuevo porfavor: ");
                nombre = teclado.next().toUpperCase();
                p = new Producto(nombre);
            }
            
            for(int j=0; j<colecProductos.size(); j++){
                if(colecProductos.get(j).getNombre().equalsIgnoreCase(nombre) == true){
                    o1.agregarProducto(colecProductos.get(j));
                }
            }
        }
        o1.mostrarOrden();
        escribirOrden("Ordenes.txt", o1);
    }

    @Override
    public void leerOrden() { 
        
    }

    @Override
    public void escribirOrden(String nombre, Orden o1) { 
        ArrayList<Producto> produc = (ArrayList<Producto>)o1.getProductos().clone();
        PrintWriter salida = null;
        File archivo= new File(nombre);
        try {
            salida = new PrintWriter(archivo);
            salida = new PrintWriter(new FileWriter(nombre, true));
            salida.print(o1.getIdOrden() + "-");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }finally{
            salida.close();
        }
        
        
        for(int i=0; i<produc.size(); i++){
            try {
                salida = new PrintWriter(new FileWriter(nombre, true));
                salida.print(produc.get(i).getIdProductos() + ",");
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }finally{
                salida.close();
            }
        }
        
        try {
                salida = new PrintWriter(new FileWriter(nombre, true));
                salida.format("-%.2f\n", o1.calcularTotal(o1.getProductos()));
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }finally{
                salida.close();
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
    
    static int num = 0;
    @Override
    public void leerProductos(String nombre){
        BufferedReader entrada = null;
        File archivo = new File(nombre);
        int id = 0;
        String nombrePro = "";
        double precio = 0;
        
        if (num == 0) {
            try {
                entrada = new BufferedReader (new FileReader(archivo));
                String lectura = entrada.readLine();

                while (lectura != null) {
                    String [] partes = lectura.split("-");
                    id = Integer.parseInt(partes[0]);
                    nombrePro = partes[1];
                    precio = Double.parseDouble(partes[2]);
                    Producto p = new Producto(nombrePro, precio);
                    colecProductos.add(p);
                    lectura = entrada.readLine();
                }
                //System.out.println(colecProductos);
                entrada.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace(System.out);
            } catch (IOException ex){
                ex.printStackTrace(System.out);
            }
            num = 1;
        }else if(num == 1){
            System.out.println(colecProductos);
        }
                
        
    }
    
    @Override
    public void introducirProducto(){
        String elegir;
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
        System.out.println("¿Deseas incluir este Producto al stock? (S/N): ");
        teclado.nextLine();
        elegir = teclado.nextLine();
        
        
        if(elegir.toUpperCase().compareToIgnoreCase("S") == 0){
            colecProductos.add(p);
        }else{
            System.out.println("No se añadio el producto.\n");
        }
        
        PrintWriter salida = null;
        try {
            salida = new PrintWriter(new FileWriter("Producto.txt", true));
            salida.print(colecProductos.get(colecProductos.size()-1).getIdProductos() + "-");
            salida.print(colecProductos.get(colecProductos.size()-1).getNombre() + "-");
            salida.print(colecProductos.get(colecProductos.size()-1).getPrecio() + "\n");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }finally{
            salida.close();
        }
    }
}
