package com.es.stockcontrol.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class Usuario {
    @Id
    @Column(name = "nombre", nullable = false)
    private String nombre_usuario;

    @Column(name = "password", length = 20, nullable = false)
    private String password;

    public Usuario(String nombre_usuario, String password){
        this.nombre_usuario = nombre_usuario;
        this.password = password;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
