package com.es.stockcontrol.repository;

import com.es.stockcontrol.model.Proveedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class ProveedorRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("StockControl");

    public Proveedor getProveedor(int id) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Proveedor proveedor = em.find(Proveedor.class, id);

        em.getTransaction().commit(); // Aseguramos que la transacción se cierra
        em.close();

        return proveedor;
    }

    public List<Proveedor> getTodosProveedores() {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query query = em.createQuery("SELECT p FROM Proveedor p", Proveedor.class);
        List<Proveedor> listaProveedores = query.getResultList();

        em.getTransaction().commit(); // Aseguramos que la transacción se cierra
        em.close();

        return listaProveedores;
    }

    public void agregarProveedor(Proveedor proveedor) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(proveedor);

        em.getTransaction().commit(); // Aseguramos que la transacción se cierra
        em.close();
    }

    public void actualizarProveedor(Proveedor proveedor) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.merge(proveedor);

        em.getTransaction().commit(); // Aseguramos que la transacción se cierra
        em.close();
    }

    public void eliminarProveedor(int id) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Proveedor proveedor = em.find(Proveedor.class, id);
        if (proveedor != null) {
            em.remove(proveedor);
        }

        em.getTransaction().commit(); // Aseguramos que la transacción se cierra
        em.close();
    }

    public List<Proveedor> obtenerProveedoresPorProducto(String idProducto) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query query = em.createQuery("SELECT p FROM Proveedor p JOIN p.productos prod WHERE prod.id = :idProducto", Proveedor.class);
        query.setParameter("idProducto", idProducto);
        List<Proveedor> listaProveedores = query.getResultList();

        em.getTransaction().commit(); // Aseguramos que la transacción se cierra
        em.close();

        return listaProveedores;
    }
}
