/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.panaderia.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import poo.panaderia.Producto;
import poo.panaderia.UnidadMedida;

/**
 *
 * @author joaquinleonelrobles
 */
public class ProductosDaoImpl implements ProductosDao {
    
    private final List<Producto> productos;

    public ProductosDaoImpl() {
        this.productos = new ArrayList<>();
        
        // creamos la unidad de medida "Unidades"
        UnidadMedida unidades = new UnidadMedida("uni", "Unidades", "u");
        
        this.productos.add(new Producto("Alfajores Cordobeces", "Alfajor Cordobés", BigDecimal.valueOf(20.00), "/resources/imagenes/productos/alfajor.jpg", unidades));
        this.productos.add(new Producto("Vigilantes Calentitos", "Vigilante", BigDecimal.valueOf(15.00), "/resources/imagenes/productos/vigilante.jpg", unidades));
    }

    @Override
    public void guardar(Producto producto) {
        this.productos.add(producto);
    }

    @Override
    public List<Producto> obtenerTodos() {
        return this.productos;
    }
    
}
