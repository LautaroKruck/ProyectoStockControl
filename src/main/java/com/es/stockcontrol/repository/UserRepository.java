package com.es.stockcontrol.repository;

import com.es.stockcontrol.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("StockControl");

    public Usuario getUsuario(String nombre) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Usuario usuario = em.find(Usuario.class, nombre);

        em.close();

        return usuario;

    }

    private List<Usuario> users;

    public UserRepository() {
        this.users = new ArrayList<>();
    }

    //Añadir usuario a la lista
    public void addUser(Usuario user) {
        users.add(user);
    }

    //Actualizar usuario
    public boolean updateUser(Usuario updatedUser) {
        for (Usuario user : users) {
            if (user.getNombre_usuario() == updatedUser.getNombre_usuario()) {
                user.setPassword(updatedUser.getPassword());
                return true;
            }
        }
        return false;
    }

    // Buscar al usuario
    public Optional<Usuario> getUserByName(String nombre ) {
        return users.stream()
                .filter(user -> user.getNombre_usuario() == nombre)
                .findFirst();
    }

    //Borrar usuario
    public boolean deleteUserByName(String nombre) {
        Optional<Usuario> user = getUserByName(nombre);
        if (user.isPresent()) {
            users.remove(user.get());
            return true;
        }
        return false;
    }
}
