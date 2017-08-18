/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.panaderia.ui;

import java.math.BigDecimal;
import javax.swing.ImageIcon;
import poo.panaderia.Producto;

/**
 *
 * @author joaquinleonelrobles
 */
public class FilaProducto {
    
    private Producto producto;
    private ImageIcon foto;
    private Integer cantidad;
    private BigDecimal monto;

    public FilaProducto (Producto producto) {
        this.producto = producto;
        this.foto = new ImageIcon(getClass().getResource(producto.getRutaFoto()));
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ImageIcon getFoto() {
        return foto;
    }

    public void setFoto(ImageIcon foto) {
        this.foto = foto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
    
    
}
