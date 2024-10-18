package com.es.stockcontrol.repository;

import com.es.stockcontrol.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
    }

    //Añadir usuario a la lista
    public void addUser(User user) {
        users.add(user);
    }

    //Actualizar usuario
    public boolean updateUser(User updatedUser) {
        for (User user : users) {
            if (user.getNombre_usuario() == updatedUser.getNombre_usuario()) {
                user.setPassword(updatedUser.getPassword());
                return true;
            }
        }
        return false;
    }

    // Buscar al usuario
    public Optional<User> getUserByName(String nombre ) {
        return users.stream()
                .filter(user -> user.getNombre_usuario() == nombre)
                .findFirst();
    }

    //Borrar usuario
    public boolean deleteUserByName(String nombre) {
        Optional<User> user = getUserByName(nombre);
        if (user.isPresent()) {
            users.remove(user.get());
            return true;
        }
        return false;
    }
}
