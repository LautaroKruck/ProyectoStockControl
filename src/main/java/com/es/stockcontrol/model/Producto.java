package com.es.stockcontrol.model;

import java.util.Date;
import java.util.Objects;

public class Producto {

    private String id;
    private String category;
    private String nombre;
    private String descripcion;
    private Float precio_sin_iva;
    private Float precio_con_iva;
    private Date fecha_alta;
    private Proveedor proveedor;

    public Producto(String id, String category, String nombre, String descripcion, Float precio_sin_iva, Date fecha_alta, Proveedor proveedor, Float precio_con_iva) {
        this.id = id;
        this.category = category;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio_sin_iva = precio_sin_iva;
        this.fecha_alta = fecha_alta;
        this.proveedor = proveedor;
        this.precio_con_iva = precio_con_iva;
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
        return Objects.equals(id, producto.id) && Objects.equals(category, producto.category) && Objects.equals(nombre, producto.nombre) && Objects.equals(descripcion, producto.descripcion) && Objects.equals(precio_sin_iva, producto.precio_sin_iva) && Objects.equals(precio_con_iva, producto.precio_con_iva) && Objects.equals(fecha_alta, producto.fecha_alta) && Objects.equals(proveedor, producto.proveedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, nombre, descripcion, precio_sin_iva, precio_con_iva, fecha_alta, proveedor);
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
                ", proveedor=" + proveedor +
                '}';
    }
}
