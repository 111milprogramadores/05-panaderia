/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.panaderia.ui;

import java.math.BigDecimal;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 *
 * @author joaquinleonelrobles
 */
public class TablaProductosListener implements TableModelListener {
    
    private final PantallaFacturacion pantalla;

    public TablaProductosListener(PantallaFacturacion pantalla) {
        this.pantalla = pantalla;
    }

    @Override
    public void tableChanged (TableModelEvent e) {
        // obtenemos el total de la venta
        BigDecimal total = ((TablaProductosModel) e.getSource()).calcularTotal();
        
        // asignamos el total al input
        pantalla.setTotalVenta(total);
    }
    
}
