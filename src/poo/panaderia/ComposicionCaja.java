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
public class ComposicionCaja {
    private int cantidad;
    private Dinero dinero;

    /**
    * Constructor por Defecto.
    */
    public ComposicionCaja() {
    }

    /**
    * Constructor con parámetros, con todos los atributos de la clase ComposicionCaja.     
     * @param cantidad     
     * @param dinero     
    */
    public ComposicionCaja(int cantidad, Dinero dinero) {
        this.cantidad = cantidad;
        this.dinero = dinero;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Dinero getDinero() {
        return dinero;
    }

    public void setDinero(Dinero dinero) {
        this.dinero = dinero;
    }
    
}
