/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.panaderia.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import poo.panaderia.Caja;
import poo.panaderia.Cobro;
import poo.panaderia.ComposicionCaja;
import poo.panaderia.DetalleProductoCobrado;
import poo.panaderia.Dinero;
import poo.panaderia.MovimientoDinero;
import poo.panaderia.Producto;
import poo.panaderia.dao.DinerosDao;
import poo.panaderia.dao.DinerosDaoImpl;
import poo.panaderia.dao.ProductosDao;
import poo.panaderia.dao.ProductosDaoImpl;

/**
 *
 * @author Candelaria
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // inicializamos las capas de acceso a datos
        ProductosDao productosDao = new ProductosDaoImpl();
        DinerosDao dinerosDao = new DinerosDaoImpl();
        
        // seteamos la composición de la caja con 10 billetes de 10        
        ArrayList<ComposicionCaja> composiciones = new ArrayList<>();
        ComposicionCaja c = new ComposicionCaja();
        c.setCantidad(10);
        c.setDinero(dinerosDao.buscarBillete(10));
        composiciones.add(c);
        
        // inicializamos la caja
        Caja caja = new Caja();
        caja.setComposiciones(composiciones);
        
        // iniciamos el caso de uso
        new GestorDeCobros(productosDao, dinerosDao, caja).run();
    }
    
}
