package com.es.stockcontrol.controller.api;

import com.es.stockcontrol.model.Proveedor;
import com.es.stockcontrol.model.RespuestaHTTP;

import java.util.List;

public interface ProveedorControllerAPI {

    // Obtener todos los proveedores
    RespuestaHTTP<List<Proveedor>> obtenerTodos();

    // Agregar un proveedor
    RespuestaHTTP<Void> agregarProveedor(Proveedor proveedor);

    // Actualizar un proveedor
    RespuestaHTTP<Void> actualizarProveedor(Proveedor proveedor);

    // Eliminar un proveedor por su ID
    RespuestaHTTP<Void> eliminarProveedor(int id);

    // Obtener los proveedores de un producto por su ID
    RespuestaHTTP<List<Proveedor>> getProveedoresProducto(String idProducto);
}
