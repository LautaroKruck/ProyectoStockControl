package com.es.stockcontrol.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class Usuario {
    @Id
    @Column(name = "nombre", nullable = false)
    private String nombreUsuario;

    @Column(name = "password", length = 20, nullable = false)
    private String password;

    public Usuario(String nombreUsuario, String password){
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }

    public Usuario() {



    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombreUsuario='" + nombreUsuario + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
