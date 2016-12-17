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
public class Dinero {
    private String denominacion;
    private boolean esMoneda;
    private int valor;

    /**
    * Constructor por Defecto.
    */
    public Dinero() {
    }

    /** Constructor con parámetros, sin incluir atributos referenciales.
     * @param denominacion       
     * @param esMoneda       
     * @param valor       
    */
    public Dinero(String denominacion, boolean esMoneda, int valor) {
        this.denominacion = denominacion;
        this.esMoneda = esMoneda;
        this.valor = valor;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public boolean isEsMoneda() {
        return esMoneda;
    }

    public void setEsMoneda(boolean esMoneda) {
        this.esMoneda = esMoneda;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
}
