/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.panaderia;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Candelaria
 */
public class Cobro {
    private List<DineroRecibido> dineroRecibido;
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
    public Cobro(List<DineroRecibido> dineroRecibido, List<DetalleProductoCobrado> detalleCobro) {
        this.dineroRecibido = dineroRecibido;
        this.detalleCobro = detalleCobro;
    }

    public List<DineroRecibido> getDineroRecibido() {
        return dineroRecibido;
    }

    public void setDineroRecibido(List<DineroRecibido> dineroRecibido) {
        this.dineroRecibido = dineroRecibido;
    }

    public List<DetalleProductoCobrado> getDetalleCobro() {
        return detalleCobro;
    }

    public void setDetalleCobro(List<DetalleProductoCobrado> detalleCobro) {
        this.detalleCobro = detalleCobro;
    }
    
}
