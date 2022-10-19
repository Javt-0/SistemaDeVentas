package com.ventas.accesodatos;

import dominio.Orden;

/**
 *
 * @author jonat
 */
public interface IAccesoDatos {
    void crearOrdenesTxt();
    
    void leerOrden();
    
    void escribirOrden(String nombre, Orden o1);
    
    void crearProductosTxt(String nombre);
    
    void leerProductos();
    
    void introducirProducto();
    
}
