/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.panaderia.controller;

import java.util.ArrayList;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import poo.panaderia.Caja;
import poo.panaderia.ComposicionCaja;
import poo.panaderia.dao.DinerosDao;
import poo.panaderia.dao.DinerosDaoHibernateImpl;
import poo.panaderia.dao.ProductosDao;
import poo.panaderia.dao.ProductosDaoHibernateImpl;

/**
 *
 * @author Candelaria
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SessionFactory sessionFactory = null;
        
        // A SessionFactory is set up once for an application!
	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure("resources/hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
			.build();
	try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
	}
	catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
            
            throw e;
	}
        
        // inicializamos las capas de acceso a datos
        ProductosDao productosDao = new ProductosDaoHibernateImpl(sessionFactory);
        DinerosDao dinerosDao = new DinerosDaoHibernateImpl(sessionFactory);
        
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
