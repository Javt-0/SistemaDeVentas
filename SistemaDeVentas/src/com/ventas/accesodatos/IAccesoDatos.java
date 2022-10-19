/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ventas.accesodatos;

import dominio.Orden;

/**
 *
 * @author jonat
 */
public interface IAccesoDatos {
    void crear();
    void leer();
    void escribir(String nombre, Orden o1);
}
