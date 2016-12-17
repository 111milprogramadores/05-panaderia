/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.panaderia;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Candelaria
 */
public class MovimientoCaja {
    private Date fecha;
    private BigDecimal monto;
    private TipoMovimiento tipoMovimiento;

    /**
    * Constructor por Defecto.
    */
    public MovimientoCaja() {
    }

    /** Constructor con parámetros, sin incluir atributos referenciales.
     * @param fecha              
     * @param monto              
     * @param tipoMovimiento              
    */
    public MovimientoCaja(Date fecha, BigDecimal monto, TipoMovimiento tipoMovimiento) {
        this.fecha = fecha;
        this.monto = monto;
        this.tipoMovimiento = tipoMovimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public TipoMovimiento getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }
    
}
