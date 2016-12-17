/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.panaderia;

/**
 *
 * @author Candelaria
 */
public class TipoMovimiento {
    private String nombre;
    private String descripcion;

    /**
    * Constructor por Defecto.
    */
    public TipoMovimiento() {
    }

    /** Constructor con parámetros, sin incluir atributos referenciales.
     * @param nombre          
     * @param descripcion          
    */
    public TipoMovimiento(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
