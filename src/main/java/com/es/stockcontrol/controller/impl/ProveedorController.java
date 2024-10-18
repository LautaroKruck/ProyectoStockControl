package com.es.stockcontrol.controller.impl;

import com.es.stockcontrol.controller.api.ProveedorControllerAPI;
import com.es.stockcontrol.model.Proveedor;
import com.es.stockcontrol.model.RespuestaHTTP;
import com.es.stockcontrol.service.ProveedorService;

import java.util.List;

public class ProveedorController implements ProveedorControllerAPI {
    private final ProveedorService proveedorService = new ProveedorService();

    @Override
    public RespuestaHTTP<List<Proveedor>> getTodosProveedores() {
        try {
            List<Proveedor> proveedores = proveedorService.getTodosProveedores();
            return new RespuestaHTTP<>(200, "Operación exitosa", proveedores);
        } catch (Exception e) {
            return new RespuestaHTTP<>(500, "Error al obtener los proveedores: " + e.getMessage());
        }
    }

    @Override
    public RespuestaHTTP<> agregarProveedor(Proveedor proveedor) {
        try {
            proveedorService.agregarProveedor(proveedor);
            return new RespuestaHTTP<>(200, "Proveedor agregado con éxito");
        } catch (Exception e) {
            return new RespuestaHTTP<>(500, "Error al agregadar el proveedor: " + e.getMessage());
        }
    }

    @Override
    public RespuestaHTTP<> actualizarProveedor(Proveedor proveedor) {
        try {
            proveedorService.actualizarProveedor(proveedor);
            return new RespuestaHTTP<>(200, "Proveedor actualizado con éxito");
        } catch (Exception e) {
            return new RespuestaHTTP<>(500, "Error al actualizar el proveedor: " + e.getMessage());
        }
    }

    @Override
    public RespuestaHTTP<> eliminarProveedor(int id) {
        try {
            proveedorService.eliminarProveedor(id);
            return new RespuestaHTTP<>(200, "Proveedor eliminado con éxito");
        } catch (Exception e) {
            return new RespuestaHTTP<>(500, "Error al eliminar el proveedor: " + e.getMessage());
        }

    }

    @Override
    public RespuestaHTTP<List<Proveedor>> getProveedoresProducto(String idProducto) {
        try {
            List<Proveedor> proveedores = proveedorService.obtenerProveedoresPorProducto(idProducto);
            return new RespuestaHTTP<>(200, "Operación exitosa", proveedores);
        } catch (Exception e) {
            return new RespuestaHTTP<>(500, "Error al obtener los proveedores: " + e.getMessage());
        }
    }
}
