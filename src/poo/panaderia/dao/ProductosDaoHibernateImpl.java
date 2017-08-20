/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.panaderia.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import poo.panaderia.Producto;

/**
 *
 * @author joaquinleonelrobles
 */
public class ProductosDaoHibernateImpl implements ProductosDao {
    
    private final SessionFactory sessionFactory;

    public ProductosDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardar(Producto producto) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(producto);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Producto> obtenerTodos() {
        Session session = sessionFactory.openSession();
        List<Producto> retorno = session.createQuery("from Producto").list();
        session.close();
        
        return retorno;
    }
    
}
