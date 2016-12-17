/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.panaderia;

import java.math.BigDecimal;

/**
 *
 * @author Candelaria
 */
public class Producto {
    private String descripcion;
    private String nombre;
    private BigDecimal precio;
    private UnidadMedida unidadMedida;

    /**
    * Constructor por Defecto
    */
    public Producto() {
    }

    /**
    * Constructor con parámetros, sin incluir atributos referenciales.
     * @param descripcion     
     * @param nombre     
     * @param precio     
    */
    public Producto(String descripcion, String nombre, BigDecimal precio) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.precio = precio;
    }

    /**
    * Constructor con parámetros, con todos los atributos de la clase Producto.
     * @param descripcion     
     * @param nombre     
     * @param precio     
     * @param unidadMedida     
    */
    public Producto(String descripcion, String nombre, BigDecimal precio, UnidadMedida unidadMedida) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.precio = precio;
        this.unidadMedida = unidadMedida;
    }
        
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
}
