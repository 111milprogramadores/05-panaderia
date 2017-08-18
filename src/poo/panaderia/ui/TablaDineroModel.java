/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.panaderia.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;
import poo.panaderia.Dinero;
import poo.panaderia.MovimientoDinero;

/**
 *
 * @author joaquinleonelrobles
 */
public class TablaDineroModel extends AbstractTableModel {
        
    private static final String[] COLUMNAS = { "Foto", "Denominación", "Valor", "Cantidad" };
    
    private final List<FilaDinero> filasDinero;

    public TablaDineroModel() {
        super();
        this.filasDinero = new ArrayList<>();
    }

    public TablaDineroModel(List<Dinero> dinero) {
        super();
        this.filasDinero = new ArrayList<>();
        
        Iterator<Dinero> iter = dinero.iterator();
        while (iter.hasNext()) {
            filasDinero.add(new FilaDinero(iter.next()));
        }
    }

    @Override
    public int getRowCount() {
        return this.filasDinero.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNAS.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMNAS[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object retorno = null;
        FilaDinero fila = filasDinero.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                retorno = fila.getFoto();
                break;
            case 1:
                retorno = fila.getDinero().getDenominacion();
                break;
            case 2:
                retorno = fila.getDinero().getValor();
                break;
            case 3:
                retorno = fila.getCantidad();
                break;
        }
        
        return retorno;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        FilaDinero fila = filasDinero.get(rowIndex);
        
        if (columnIndex == 3) {
            fila.setCantidad((Integer) aValue);
        }
        
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class retorno = null;
        
        switch (columnIndex) {
            case 0:
                retorno = ImageIcon.class;
                break;
            case 2:
                retorno = Float.class;
                break;
            case 3:
                retorno = Integer.class;
                break;
            default:
                retorno = super.getColumnClass(columnIndex);
        }
        
        return retorno;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 3;
    }

    public List<FilaDinero> obtenerFilasSeleccionadas() {
        List<FilaDinero> seleccionadas = new ArrayList<>();
        
        Iterator<FilaDinero> iter = filasDinero.iterator();
        while (iter.hasNext()) {
            FilaDinero fila = iter.next();
            
            if (fila.getCantidad() != null && fila.getCantidad() > 0) {
                seleccionadas.add(fila);
            }
        }
        
        return seleccionadas;
    }
    
    public void completarConMovimientos (List<MovimientoDinero> movimientos) {
        this.filasDinero.clear();
        
        Iterator<MovimientoDinero> iter = movimientos.iterator();
        while (iter.hasNext()) {
            filasDinero.add(new FilaDinero(iter.next()));
        }
    }
            
    
}
