/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.panaderia.ui;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;
import poo.panaderia.Producto;

/**
 *
 * @author joaquinleonelrobles
 */
public class TablaProductosModel extends AbstractTableModel {
        
    private static final String[] COLUMNAS = { "Foto", "Nombre", "Unidad", "Precio u.", "Cantidad", "Monto" };
    
    private final List<FilaProducto> filasProductos;

    public TablaProductosModel(List<Producto> productos) {
        this.filasProductos = new ArrayList<>();
        
        Iterator<Producto> iter = productos.iterator();
        while (iter.hasNext()) {
            filasProductos.add(new FilaProducto(iter.next()));
        }
    }

    @Override
    public int getRowCount() {
        return this.filasProductos.size();
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
        FilaProducto fila = filasProductos.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                retorno = fila.getFoto();
                break;
            case 1:
                retorno = fila.getProducto().getNombre();
                break;
            case 2:
                retorno = fila.getProducto().getUnidadMedida();
                break;
            case 3:
                retorno = fila.getProducto().getPrecio();
                break;    
            case 4:
                retorno = fila.getCantidad();
                break;
            case 5:
                retorno = fila.getMonto();
                break;
        }
        
        return retorno;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        FilaProducto fila = filasProductos.get(rowIndex);
        
        switch (columnIndex) {
            case 4:
                fila.setCantidad((Integer) aValue);
                fila.setMonto(fila.getProducto().getPrecio().multiply(new BigDecimal(fila.getCantidad())));
                
                break;
            case 5:
                fila.setMonto((BigDecimal) aValue);
                break;
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
            case 4:
                retorno = Integer.class;
                break;
            case 5:
                retorno = BigDecimal.class;
                break;
            default:
                retorno = super.getColumnClass(columnIndex);
        }
        
        return retorno;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        boolean retorno = false;
        //Producto producto = productos.get(rowIndex);
        
        switch (columnIndex) {
            case 4:
                retorno = true;
                break;
            case 5:
                retorno = true;
                break;
            default:
                retorno = false;
        }
        
        return retorno;
    }

    public List<FilaProducto> obtenerFilasSeleccionadas() {
        List<FilaProducto> seleccionadas = new ArrayList<>();
        
        Iterator<FilaProducto> iter = filasProductos.iterator();
        while (iter.hasNext()) {
            FilaProducto fila = iter.next();
            
            if (fila.getMonto() != null) {
                seleccionadas.add(fila);
            }
        }
        
        return seleccionadas;
    }

    public BigDecimal calcularTotal() {
        BigDecimal total = BigDecimal.ZERO;
        
        Iterator<FilaProducto> iter = obtenerFilasSeleccionadas().iterator();
        while (iter.hasNext()) {
            FilaProducto fila = iter.next();
            
            total = total.add(fila.getMonto());
        }
        
        return total;
    }
    
}
