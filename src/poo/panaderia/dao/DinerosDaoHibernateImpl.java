/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.panaderia.dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import poo.panaderia.Dinero;

/**
 *
 * @author joaquinleonelrobles
 */
public class DinerosDaoHibernateImpl implements DinerosDao {
    
    private final SessionFactory sessionFactory;

    public DinerosDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Dinero> obtenerTodos() {
        Session session = sessionFactory.openSession();
        List<Dinero> retorno = session.createQuery("from Dinero").list();
        session.close();
        
        return retorno;
    }

    @Override
    public Dinero buscarBillete(float valor) {
        return buscarDinero(valor, false);
    }

    @Override
    public Dinero buscarMoneda(float valor) {
        return buscarDinero(valor, true);
    }
    
    private Dinero buscarDinero (float valor, boolean esMoneda) {
        Session session = sessionFactory.openSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Dinero> query = builder.createQuery(Dinero.class);
        Root<Dinero> root = query.from(Dinero.class);
        query.select(root);
        
        query.where(builder.equal(root.get("esMoneda"), esMoneda));
        query.where(builder.equal(root.get("valor"), valor));
        
        Dinero dinero = session.createQuery(query).uniqueResult();
        
        session.close();
        
        return dinero;
    }
    
}
