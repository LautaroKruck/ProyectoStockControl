package com.es.stockcontrol.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    private String id;

    @Column(name = "category", nullable = false, length = 50)
    private String category;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio_sin_iva", nullable = false)
    private Float precio_sin_iva;

    @Column(name = "precio_con_iva", nullable = false)
    private Float precio_con_iva;

    @Column(name = "fecha_alta", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_alta;

    @Column(name = "stock")
    private Integer stock;

    @ManyToOne
    @JoinColumn (name = "proveedor", nullable = false)
    private Proveedor proveedor;

    public Producto(String id, String category, String nombre, String descripcion, Float precio_sin_iva, Float precio_con_iva, Date fecha_alta, Integer stock, Proveedor proveedor) {
        this.id = id;
        this.category = category;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio_sin_iva = precio_sin_iva;
        this.precio_con_iva = precio_con_iva;
        this.fecha_alta = fecha_alta;
        this.stock = stock;
        this.proveedor = proveedor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPrecio_sin_iva() {
        return precio_sin_iva;
    }

    public void setPrecio_sin_iva(Float precio_sin_iva) {
        this.precio_sin_iva = precio_sin_iva;
    }

    public Float getPrecio_con_iva() {
        return precio_con_iva;
    }

    public void setPrecio_con_iva(Float precio_con_iva) {
        this.precio_con_iva = precio_con_iva;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(id, producto.id) && Objects.equals(category, producto.category) && Objects.equals(nombre, producto.nombre) && Objects.equals(descripcion, producto.descripcion) && Objects.equals(precio_sin_iva, producto.precio_sin_iva) && Objects.equals(precio_con_iva, producto.precio_con_iva) && Objects.equals(fecha_alta, producto.fecha_alta) && Objects.equals(stock, producto.stock) && Objects.equals(proveedor, producto.proveedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, nombre, descripcion, precio_sin_iva, precio_con_iva, fecha_alta, stock, proveedor);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio_sin_iva=" + precio_sin_iva +
                ", precio_con_iva=" + precio_con_iva +
                ", fecha_alta=" + fecha_alta +
                ", stock=" + stock +
                ", proveedor=" + proveedor +
                '}';
    }
}
