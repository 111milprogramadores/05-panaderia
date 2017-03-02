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
public class MovimientoDinero {
    private int cantidad;
    private Dinero dinero;

    /**
    * Constructor por Defecto.
    */
    public MovimientoDinero() {
    }

    /** Constructor con parámetros, con todos los atributos de la clase DineroRecibido.
     * @param cantidad           
     * @param dinero           
    */
    public MovimientoDinero(int cantidad, Dinero dinero) {
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

    @Override
    public String toString() {
        return this.cantidad + " de " + this.dinero.getDenominacion() + " - valor: "+ this.dinero.getValor()*this.cantidad; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
