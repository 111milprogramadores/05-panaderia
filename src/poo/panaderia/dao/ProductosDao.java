/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.panaderia.dao;

import java.util.List;
import poo.panaderia.Producto;

/**
 *
 * @author joaquinleonelrobles
 */
public interface ProductosDao {
    
    public void guardar (Producto producto);
    
    public List<Producto> obtenerTodos ();
    
}
