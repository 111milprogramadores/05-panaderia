/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.panaderia.main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import poo.panaderia.Caja;
import poo.panaderia.Cobro;
import poo.panaderia.ComposicionCaja;
import poo.panaderia.DetalleProductoCobrado;
import poo.panaderia.Dinero;
import poo.panaderia.MovimientoDinero;
import poo.panaderia.Producto;

/**
 *
 * @author Candelaria
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Dinero> dineros= new ArrayList<>();
        Dinero dos = new Dinero("Billete de dos pesos",false,2);
        dineros.add(dos);
        Dinero cinco = new Dinero("Billete de cinco pesos",false,5);
        dineros.add(cinco);
        Dinero diez = new Dinero("Billete de diez pesos",false,10);
        dineros.add(diez);
        Dinero veinte = new Dinero("Billete de veinte pesos",false,20);
        dineros.add(veinte);
        Dinero cincuenta = new Dinero("Billete de cincuenta pesos",false,50);
        dineros.add(cincuenta);
        Dinero cien = new Dinero("Billete de cien pesos",false,100);
        dineros.add(cien);
        Dinero quinientos = new Dinero("Billete de quinientos pesos",false,500);  
        dineros.add(quinientos);
        Dinero unoMoneda = new Dinero("Moneda de un peso",true, 1);
        dineros.add(unoMoneda);
        Dinero cincuentaMoneda = new Dinero("Moneda de cincuenta centavos",true, (float)0.50);
        dineros.add(cincuentaMoneda);
        Dinero veinticincoMoneda = new Dinero("Moneda de veinticinco centavos",true, (float)0.25);
        dineros.add(veinticincoMoneda);
        Dinero diezMoneda = new Dinero("Moneda de diez centavos",true, (float)0.10);
        dineros.add(diezMoneda);
        Dinero cincoMoneda = new Dinero("Moneda de cinco centavos",true, (float)0.05);
        dineros.add(cincoMoneda);
        Dinero dosMoneda = new Dinero ("Moneda de dos pesos",true, 2);
        dineros.add(dosMoneda);
       
        /*Seteamos la composición de la caja con 10 billetes/monedas de cada dinero creado anteriormente
        ArrayList<ComposicionCaja> composiciones = new ArrayList<>();
        for (Dinero dinero : dineros) {
            ComposicionCaja c = new ComposicionCaja();
            c.setCantidad(10);
            c.setDinero(dinero);
            composiciones.add(c);
        }*/
        
        //Seteamos la composición de la caja con 10 billetes de 10        
        ArrayList<ComposicionCaja> composiciones = new ArrayList<>();
        ComposicionCaja c = new ComposicionCaja();
        c.setCantidad(10);
        c.setDinero(diez);
        composiciones.add(c);
        
        Caja caja = new Caja();
        caja.setComposiciones(composiciones);
        
        //IMPRIMIMOS
        System.out.println("Caja Inicial : " + caja.toString());
        
        
        //Seteamos el dinero que recibimos del cliente - En este caso pago con 300 $
        ArrayList<MovimientoDinero> dineroRecibido = new ArrayList<>();
        MovimientoDinero d1= new MovimientoDinero(3,cien);
        dineroRecibido.add(d1);
        
        //IMPRIMIMOS
        System.out.println("Dinero Recibido: " +  "\n" + dineroRecibido.toString());
        
        //Creamos el producto y el detalle del producto cobrado
        
        Producto tartaManzana = new Producto("Tarza deliciosa de manzana", "Tarta de Manzana",BigDecimal.valueOf(120.00));
        float total = tartaManzana.getPrecio().floatValue()*2;
        DetalleProductoCobrado detalle = new DetalleProductoCobrado(2,BigDecimal.valueOf(total),tartaManzana);
        ArrayList<DetalleProductoCobrado> detalles = new ArrayList<>();
        detalles.add(detalle);
        
        //IMPRIMIMOS
        System.out.println("Productos comprados: " + "\n" + detalles.toString());
        //Creamos el cobro y calculamos el monto para el vuelto
        Cobro cobro = new Cobro(dineroRecibido, detalles);        
        float montoVuelto=cobro.calcularVuelto(cobro.calcularImporteTotal());
        System.out.println("Monto Vuelto: " + montoVuelto);
        
        //OPCION PRIMERO INGRESO DINERO Y LUEGO CALCULO BILLETES VUELTO     
//        System.out.println("Ahora se realiza el ingreso del dinero a la caja...");
//        caja.ingresarDineroACaja(dineroRecibido); 
//        System.out.println("La caja ahora tiene: "+ "\n" + caja.toString());//Ingresamos el cobro a la caja y calculamos el vuelto:
//        
//        ArrayList<MovimientoDinero> vueltoComposicion =caja.calcularBilletesVuelto(montoVuelto);
//        System.out.println("El vuelto es: " + vueltoComposicion);
//        System.out.println("La caja ahora tiene: "+ "\n" + caja.toString());//Ingresamos el cobro a la caja y calculamos el vuelto:
//        
        //OPCION INGRESO DINERO Y CALCULO BILLETES VUELTO EN UN MISMO METODO

        ArrayList<MovimientoDinero> vuelto= caja.ingresarDineroYDarVuelto(dineroRecibido, montoVuelto);        
        System.out.println("El vuelto esta compuesto de la siguiente manera: " + "\n" + vuelto.toString());
        System.out.println("La caja ahora tiene: "+ "\n" + caja.toString());//Ingresamos el cobro a la caja y calculamos el vuelto:
        
    }
    
}
