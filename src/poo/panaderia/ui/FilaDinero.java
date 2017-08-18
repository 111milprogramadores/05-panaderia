/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.panaderia.ui;

import javax.swing.ImageIcon;
import poo.panaderia.Dinero;
import poo.panaderia.MovimientoDinero;

/**
 *
 * @author joaquinleonelrobles
 */
public class FilaDinero {
    
    private Dinero dinero;
    private Integer cantidad;
    private ImageIcon foto;

    public FilaDinero(Dinero dinero) {
        this.dinero = dinero;
        this.foto = new ImageIcon(getClass().getResource(dinero.getRutaFoto()));
    }
    
    public FilaDinero (MovimientoDinero movimientoDinero) {
        this.dinero = movimientoDinero.getDinero();
        this.foto = new ImageIcon(getClass().getResource(movimientoDinero.getDinero().getRutaFoto()));
        this.cantidad = movimientoDinero.getCantidad();
    }

    public Dinero getDinero() {
        return dinero;
    }

    public void setDinero(Dinero dinero) {
        this.dinero = dinero;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public ImageIcon getFoto() {
        return foto;
    }

    public void setFoto(ImageIcon foto) {
        this.foto = foto;
    }
    
    
    
}
