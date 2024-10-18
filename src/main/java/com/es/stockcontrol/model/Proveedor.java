package com.es.stockcontrol.model;
//id: Long -> AutoGenerado. PrimaryKey
//nombre: String -> único, longitud 50, not null
//direccion: String -> not null
//productos: List -> Relacion de @OneToMany

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", unique = true,length = 50, nullable = false)
    private String nombre;

    @Column(name = "direccion", length = 50, nullable = false)
    private String direccion;

    @OneToMany(mappedBy = "proveedor")
    private List<Producto> productos;

    public Proveedor(String nombre, String direccion, List<Producto> productos) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.productos = productos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", productos=" + productos +
                '}';
    }
}
