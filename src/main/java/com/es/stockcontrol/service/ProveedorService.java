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

    // Actualizar un proveedor existente
    public Proveedor actualizarProveedor(Proveedor proveedor) {
        // Validación del nombre y la dirección
        if (proveedor.getNombre().length() > 50 || proveedor.getNombre().isEmpty()) {
            return null;
        }

        if (proveedor.getDireccion().isEmpty()) {
            return null;
        }

        // Actualizar el proveedor en la base de datos
        proveedorRepository.actualizarProveedor(proveedor);
        return proveedor;
    }

    // Eliminar un proveedor por su ID
    public boolean eliminarProveedor(int id) {
        Proveedor proveedor = proveedorRepository.getProveedor(id);

        if (proveedor != null) {
            proveedorRepository.eliminarProveedor(id);
            return true;
        }

        return false;
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
