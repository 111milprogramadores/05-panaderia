/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.panaderia.controller;

import java.util.ArrayList;
import poo.panaderia.dao.DinerosDao;
import java.util.List;
import poo.panaderia.Caja;
import poo.panaderia.Cobro;
import poo.panaderia.DetalleProductoCobrado;
import poo.panaderia.Dinero;
import poo.panaderia.MovimientoDinero;
import poo.panaderia.Producto;
import poo.panaderia.dao.ProductosDao;
import poo.panaderia.ui.FilaDinero;
import poo.panaderia.ui.FilaProducto;
import poo.panaderia.ui.PantallaFacturacion;
import poo.panaderia.ui.PantallaVuelto;

/**
 *
 * @author joaquinleonelrobles
 */
public class GestorDeCobros {
    
    private final Caja caja;
    
    private final ProductosDao productosDao;
    private final DinerosDao dinerosDao;
    
    private PantallaFacturacion pantallaFacturacion;

    public GestorDeCobros(ProductosDao productosDao, DinerosDao dinerosDao, Caja caja) {
        this.productosDao = productosDao;
        this.dinerosDao = dinerosDao;
        this.caja = caja;
    }
    
    public void run () {
        this.pantallaFacturacion = new PantallaFacturacion(this);
        this.pantallaFacturacion.setVisible(true);
    }

    public List<Producto> obtenerProductos() {
        return productosDao.obtenerTodos();
    }
    
    public List<Dinero> obtenerDineros() {
        return dinerosDao.obtenerTodos();
    }
    
    public void cobrar (List<FilaProducto> filasProductos, List<FilaDinero> filasDinero) {
        // convertimos las filas completadas en DetalleCobrado
        List<DetalleProductoCobrado> detalleProductos = this.fabricarDetallesProducto(filasProductos);
        System.out.println("Productos comprados: " + "\n" + detalleProductos.toString());
        
        // convertimos las filas completadas en MovimientoDinero
        List<MovimientoDinero> dineroRecibido = this.fabricarDetallesDinero(filasDinero);
        System.out.println("Dinero Recibido: " +  "\n" + dineroRecibido.toString());
        
        // creamos el cobro y calculamos el monto para el vuelto
        Cobro cobro = new Cobro(dineroRecibido, detalleProductos);        
        float montoVuelto = cobro.calcularVuelto(cobro.calcularImporteTotal());
        System.out.println("Monto Vuelto: " + montoVuelto);

        // procesamos el cobro y obtenemos el vuelto
        List<MovimientoDinero> vuelto = caja.ingresarDineroYDarVuelto (dineroRecibido, montoVuelto);        
        System.out.println("El vuelto esta compuesto de la siguiente manera: " + "\n" + vuelto.toString());
        System.out.println("La caja ahora tiene: "+ "\n" + caja.toString());//Ingresamos el cobro a la caja y calculamos el vuelto:
        
        // mostramos el vuelto a entregar en pantalla
        new PantallaVuelto(vuelto).setVisible(true);
    }

    private List<DetalleProductoCobrado> fabricarDetallesProducto(List<FilaProducto> filasProductos) {
        List<DetalleProductoCobrado> detalle = new ArrayList<>();
        
        for (FilaProducto fila : filasProductos) {
            detalle.add(new DetalleProductoCobrado(fila.getCantidad(), fila.getMonto(), fila.getProducto()));
        }
        
        return detalle;
    }

    private List<MovimientoDinero> fabricarDetallesDinero(List<FilaDinero> filasDinero) {
        List<MovimientoDinero> detalle = new ArrayList<>();
        
        for (FilaDinero fila : filasDinero) {
            detalle.add(new MovimientoDinero(fila.getCantidad(), fila.getDinero()));
        }
        
        return detalle;
    }
    
}
