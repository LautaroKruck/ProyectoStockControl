package com.es.stockcontrol.repository;

import com.es.stockcontrol.model.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;


public class ProductoRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("StockControl");

    public Producto getProducto(String id) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Producto p = em.find(Producto.class, id);

        em.close();

        return p;

    }

    public List<Producto> getProductoConStock() {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query query = em.createQuery("SELECT * FROM Producto WHERE stock != 0 || stock != null");

        List<Producto> listaP = query.getResultList();

        em.close();

        return listaP;

    }

    public List<Producto> getProductoSinStock() {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query query = em.createQuery("SELECT * FROM Producto WHERE stock == 0 || stock == null");

        List<Producto> listaP = query.getResultList();

        em.close();

        return listaP;

    }

    public Producto altaProducto(Producto p) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(p);

        em.getTransaction().commit();

        em.close();

        return em.find(Producto.class, p.getId());

    }

    public Producto bajaProducto(String idProducto) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Producto p = em.find(Producto.class, idProducto);

        em.remove(p);

        em.getTransaction().commit();

        em.close();

        return p;

    }

    public Producto modificarNombreProducto(String idProducto, String nuevoNombre) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Producto p = em.find(Producto.class, idProducto);

        p.setNombre(nuevoNombre);

        em.getTransaction().commit();

        em.close();

        return em.find(Producto.class, p.getId());

    }

    public Producto modificarStockProducto(String idProducto, Integer nuevoStock) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Producto p = em.find(Producto.class, idProducto);

        p.setStock(nuevoStock);

        em.getTransaction().commit();

        em.close();

        return em.find(Producto.class, p.getId());

    }

}
