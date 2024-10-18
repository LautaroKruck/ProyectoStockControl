package com.es.stockcontrol.service;

import com.es.stockcontrol.model.Producto;
import com.es.stockcontrol.repository.ProductoRepository;

import java.util.List;

public class ProductoService {

    private ProductoRepository repository;

    public ProductoService() {

        this.repository = new ProductoRepository();

    }

    public Producto getProducto(String idProducto) {

        return repository.getProducto(idProducto);

    }

    public List<Producto> getProductoConStock() {

        return repository.getProductoConStock();

    }

    public List<Producto> getProductoSinStock() {

        return repository.getProductoSinStock();

    }

    public Producto altaProducto(String categoriaProducto, String nombreProducto, Float precioSinIva, String descripcionProducto, String nombreProveedor, String direccionProveedor) {



        return repository.altaProducto();

    }
}
