/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.panaderia;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Candelaria
 */
public class Cobro {
    private List<MovimientoDinero> dineroRecibido;
    private List<DetalleProductoCobrado> detalleCobro;

    /**
    * Constructor por Defecto.
    */
    public Cobro() {
        dineroRecibido= new ArrayList<>();
        detalleCobro= new ArrayList<>();
    }

    /**
    * Constructor con parámetros, con todos los atributos de la clase DetalleProductoCobrado.     * @param cantidad
     * @param dineroRecibido
     * @param detalleCobro
    */
    public Cobro(ArrayList<MovimientoDinero> dineroRecibido, ArrayList<DetalleProductoCobrado> detalleCobro) {
        this.dineroRecibido = dineroRecibido;
        this.detalleCobro = detalleCobro;
    }

    public List<MovimientoDinero> getDineroRecibido() {
        return dineroRecibido;
    }

    public void setDineroRecibido(ArrayList<MovimientoDinero> dineroRecibido) {
        this.dineroRecibido = dineroRecibido;
    }

    public List<DetalleProductoCobrado> getDetalleCobro() {
        return detalleCobro;
    }

    public void setDetalleCobro(ArrayList<DetalleProductoCobrado> detalleCobro) {
        this.detalleCobro = detalleCobro;
    }
 
    public float calcularVuelto(float importeTotalCompra)
    {
        Iterator i = getDineroRecibido().iterator();
        float montoRecibido=0;
        while (i.hasNext())
        {
            MovimientoDinero movimientoDinero =(MovimientoDinero) i.next();            
            montoRecibido += movimientoDinero.getCantidad() * movimientoDinero.getDinero().getValor();
        }
        if(montoRecibido == importeTotalCompra)
            return 0;
        else
            return montoRecibido - importeTotalCompra;
    }
    
    public float calcularImporteTotal()
    {
        float total=0;
        for (DetalleProductoCobrado detalle: detalleCobro) {
            total += detalle.calcularSubTotal().floatValue();
        }
        return total;
    }
}
