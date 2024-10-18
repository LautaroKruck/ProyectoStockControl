package com.es.stockcontrol.service;

import com.es.stockcontrol.model.Proveedor;
import com.es.stockcontrol.repository.ProveedorRepository;
import java.util.List;


public class ProveedorService {
    private final ProveedorRepository proveedorRepository = new ProveedorRepository();

    // Método para obtener todos los proveedores
    public List<Proveedor> obtenerTodos() {
        return proveedorRepository.obtenerTodos();
    }

    // Método para agregar un nuevo proveedor
    public void agregarProveedor(Proveedor proveedor) {
        proveedorRepository.agregarProveedor(proveedor);
    }

    // Método para actualizar un proveedor existente
    public void actualizarProveedor(Proveedor proveedor) {
        proveedorRepository.actualizarProveedor(proveedor);
    }

    // Método para eliminar un proveedor por su ID
    public void eliminarProveedor(int id) {
        proveedorRepository.eliminarProveedor(id);
    }

    public List<Proveedor> obtenerProveedoresPorProducto(String idProducto) {
        proveedorRepository.obtenerProveedoresPorProducto(idProducto);
    }
}


