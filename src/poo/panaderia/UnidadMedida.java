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
public class UnidadMedida {
    
    private Integer id;
    private String abreviatura;
    private String nombre;
    private String simbolo;

    /**
    * Constructor por Defecto
    */
    public UnidadMedida() {
    }

    /**
    * Constructor con parámetros, con todos los atributos de la clase UnidadMedida.
     * @param abreviatura     
     * @param nombre     
     * @param simbolo     
    */
    public UnidadMedida(String abreviatura, String nombre, String simbolo) {
        this.abreviatura = abreviatura;
        this.nombre = nombre;
        this.simbolo = simbolo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
