package com.es.stockcontrol.controller.api;

import com.es.stockcontrol.model.Proveedor;
import com.es.stockcontrol.model.RespuestaHTTP;

import java.util.List;

public interface ProveedorControllerAPI {

    // Obtener todos los proveedores
    RespuestaHTTP<List<Proveedor>> getTodosProveedores();

    // Agregar un proveedor
    RespuestaHTTP<Proveedor> agregarProveedor(Proveedor proveedor);  // Cambiado de Void a Proveedor

    // Actualizar un proveedor
    RespuestaHTTP<Proveedor> actualizarProveedor(Proveedor proveedor);  // Cambiado de Void a Proveedor

    // Eliminar un proveedor por su ID
    RespuestaHTTP<Void> eliminarProveedor(int id);

    // Obtener los proveedores de un producto por su ID
    RespuestaHTTP<List<Proveedor>> getProveedoresProducto(String idProducto);
}
