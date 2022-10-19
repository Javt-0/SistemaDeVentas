/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ventas.accesodatos;

import dominio.Orden;
import dominio.Producto;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author jonat
 */
public class ImpTxt implements IAccesoDatos{
    
    @Override
    public void crear() {
        System.out.println("Insertando desde MySql");
    }

    @Override
    public void leer() { 
        System.out.println("Listando desde MySql");
    }

    @Override
    public void escribir(String nombre, Orden o1) { 
        ArrayList<Producto> produc = (ArrayList<Producto>)o1.getProductos().clone();
        PrintWriter salida = null;
        
        try {
                salida = new PrintWriter(new FileWriter(nombre, true));
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
}
