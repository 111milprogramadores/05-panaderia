/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.panaderia.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import poo.panaderia.Dinero;

/**
 *
 * @author joaquinleonelrobles
 */
public class DinerosDaoImpl implements DinerosDao {
    
    private final List<Dinero> dineros;

    public DinerosDaoImpl() {
        this.dineros = new ArrayList<>();
        
        Dinero dos = new Dinero("Billete de dos pesos",false,2, "/resources/imagenes/dinero/2-pesos.gif");
        dineros.add(dos);
        Dinero cinco = new Dinero("Billete de cinco pesos",false,5, "/resources/imagenes/dinero/5-pesos.gif");
        dineros.add(cinco);
        Dinero diez = new Dinero("Billete de diez pesos",false,10, "/resources/imagenes/dinero/10-pesos.gif");
        dineros.add(diez);
        Dinero veinte = new Dinero("Billete de veinte pesos",false,20, "/resources/imagenes/dinero/20-pesos.gif");
        dineros.add(veinte);
        Dinero cincuenta = new Dinero("Billete de cincuenta pesos",false,50, "/resources/imagenes/dinero/50-pesos.gif");
        dineros.add(cincuenta);
        Dinero cien = new Dinero("Billete de cien pesos",false,100, "/resources/imagenes/dinero/100-pesos.gif");
        dineros.add(cien);
        Dinero quinientos = new Dinero("Billete de quinientos pesos",false,500, "/resources/imagenes/dinero/500-pesos.gif");  
        dineros.add(quinientos);
        Dinero unoMoneda = new Dinero("Moneda de un peso",true, 1, "/resources/imagenes/dinero/1-peso.jpg");
        dineros.add(unoMoneda);
        Dinero cincuentaMoneda = new Dinero("Moneda de cincuenta centavos",true, (float)0.50, "/resources/imagenes/dinero/50-centavos.jpg");
        dineros.add(cincuentaMoneda);
        Dinero veinticincoMoneda = new Dinero("Moneda de veinticinco centavos",true, (float)0.25, "/resources/imagenes/dinero/25-centavos.jpg");
        dineros.add(veinticincoMoneda);
        Dinero diezMoneda = new Dinero("Moneda de diez centavos",true, (float)0.10, "/resources/imagenes/dinero/10-centavos.jpg");
        dineros.add(diezMoneda);
        Dinero cincoMoneda = new Dinero("Moneda de cinco centavos",true, (float)0.05, "/resources/imagenes/dinero/5-centavos.jpg");
        dineros.add(cincoMoneda);
        Dinero dosMoneda = new Dinero ("Moneda de dos pesos",true, 2, "/resources/imagenes/dinero/2-pesos-moneda.jpg");
        dineros.add(dosMoneda);
    }

    @Override
    public List<Dinero> obtenerTodos() {
        return dineros;
    }

    @Override
    public Dinero buscarBillete(float valor) {
        return buscarPorValor(valor, false);
    }

    @Override
    public Dinero buscarMoneda(float valor) {
        return buscarPorValor(valor, true);
    }
    
    private Dinero buscarPorValor (float valor, boolean esMoneda) {
        Dinero dinero = null;
        
        Iterator<Dinero> iter = dineros.iterator();
        while (iter.hasNext()) {
            Dinero actual = iter.next();
            
            if (actual.isEsMoneda() == esMoneda && actual.getValor() == valor) {
                dinero = actual;
                break;
            }
        }
        
        return dinero;
    }
    
}
