package com.es.stockcontrol.service;

import com.es.stockcontrol.model.Proveedor;
import com.es.stockcontrol.repository.ProveedorRepository;

import java.util.List;

public class ProveedorService {

    private final ProveedorRepository proveedorRepository;

    public ProveedorService() {
        this.proveedorRepository = new ProveedorRepository();
    }

    // Obtener todos los proveedores
    public List<Proveedor> getTodosProveedores() {
        return proveedorRepository.getTodosProveedores();
    }

    // Agregar un nuevo proveedor
    public Proveedor agregarProveedor(Proveedor proveedor) {

        // Validación del nombre y la dirección del proveedor

        if (proveedor.getNombre().length() > 50 || proveedor.getNombre().isEmpty()) {
            return null;
        }

        if (proveedor.getDireccion().isEmpty()) {
            return null;
        }

        // Persistir el proveedor en la base de datos
        proveedorRepository.agregarProveedor(proveedor);
        return proveedor;
    }


    // Obtener los proveedores por producto
    public List<Proveedor> obtenerProveedoresPorProducto(String idProducto) {
        if (idProducto == null || idProducto.isEmpty()) {
            return null;
        }

        return proveedorRepository.obtenerProveedoresPorProducto(idProducto);
    }

    // Obtener un proveedor por su ID
    public Proveedor getProveedor(int id) {
        return proveedorRepository.getProveedor(id);
    }
}
