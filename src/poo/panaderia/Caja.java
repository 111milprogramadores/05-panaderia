/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.panaderia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Candelaria
 */
public class Caja {
    private Date fecha;
    private Date horaApertura;
    private Date horaCierre;
    private List<Cobro> cobros;
    private List<MovimientoCaja> movimientos;
    private List<ComposicionCaja> composiciones;

    /**
    * Constructor por Defecto.
    */
    public Caja() {
        cobros= new ArrayList<>();
        movimientos = new ArrayList<>();
        composiciones = new ArrayList<>();
    }
    
    /**
    * Constructor con parámetros, con los atributos referenciales.    
     * @param fecha
     * @param horaApertura
     * @param horaCierre
    */
    public Caja(Date fecha, Date horaApertura, Date horaCierre) {
        this.fecha = fecha;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }

    /**
    * Constructor con parámetros, con todos los atributos de la clase Caja.
     * @param fecha
     * @param horaApertura
     * @param horaCierre
     * @param cobros
     * @param movimientos
     * @param composiciones
    */
    public Caja(Date fecha, Date horaApertura, Date horaCierre, List<Cobro> cobros, List<MovimientoCaja> movimientos, List<ComposicionCaja> composiciones) {
        this.fecha = fecha;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.cobros = cobros;
        this.movimientos = movimientos;
        this.composiciones = composiciones;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(Date horaApertura) {
        this.horaApertura = horaApertura;
    }

    public Date getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(Date horaCierre) {
        this.horaCierre = horaCierre;
    }

    public List<Cobro> getCobros() {
        return cobros;
    }

    public void setCobros(List<Cobro> cobros) {
        this.cobros = cobros;
    }

    public List<MovimientoCaja> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<MovimientoCaja> movimientos) {
        this.movimientos = movimientos;
    }

    public List<ComposicionCaja> getComposiciones() {
        return composiciones;
    }

    public void setComposiciones(List<ComposicionCaja> composiciones) {
        this.composiciones = composiciones;
    }
}
