/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.panaderia.dao;

import java.util.List;
import poo.panaderia.Dinero;

/**
 *
 * @author joaquinleonelrobles
 */
public interface DinerosDao {
    
    public List<Dinero> obtenerTodos ();
    
    public Dinero buscarBillete (float valor);
    
    public Dinero buscarMoneda (float valor);
    
}
