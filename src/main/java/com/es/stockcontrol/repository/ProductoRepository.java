package com.es.stockcontrol.repository;

import com.es.stockcontrol.model.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProductoRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("StockControl");

    public Producto getProducto(String id) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        return em.find(Producto.class, id);

    }

    public Producto altaProducto(Producto p) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(p);

        em.getTransaction().commit();

        em.close();

        return getProducto(p.getId());

    }

}
