package com.es.stockcontrol.repository;

import com.es.stockcontrol.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UsuarioRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("StockControl");

    public Usuario getUsuario(String nombre) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Usuario usuario = em.find(Usuario.class, nombre);

        em.close();

        return usuario;

    }
}
