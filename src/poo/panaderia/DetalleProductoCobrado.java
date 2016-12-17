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
public class DetalleProductoCobrado {
    private int cantidad;
    private BigDecimal monto;
    private Producto producto;

    /**
    * Constructor por Defecto.
    */
    public DetalleProductoCobrado() {
    }

    /**
    * Constructor con parámetros, con todos los atributos de la clase DetalleProductoCobrado.     * @param cantidad     
     * @param cantidad
     * @param monto     
     * @param producto     
    */
    public DetalleProductoCobrado(int cantidad, BigDecimal monto, Producto producto) {
        this.cantidad = cantidad;
        this.monto = monto;
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
}
