package com.es.stockcontrol.controller.impl;

import com.es.stockcontrol.controller.api.ProductoControllerAPI;
import com.es.stockcontrol.model.Producto;
import com.es.stockcontrol.model.RespuestaHTTP;
import com.es.stockcontrol.service.ProductoService;

import java.util.List;

public class ProductoController implements ProductoControllerAPI {

    private ProductoService service;

    public ProductoController() {

        this.service = new ProductoService();

    }

    @Override
    public RespuestaHTTP<Producto> altaProducto(String categoriaProducto, String nombreProducto, String precioSinIva, String descripcionProducto, String stock, String nombreProveedor, String direccionProveedor) {

        try {

            Producto p = service.altaProducto(categoriaProducto, nombreProducto, precioSinIva, descripcionProducto, stock, nombreProveedor, direccionProveedor);

            return p != null ?
                    new RespuestaHTTP<Producto>(200, "Producto añadido con éxito.", p) :
                    new RespuestaHTTP<Producto>(400, "Bad Request", null) ;

        } catch (Exception e) {

            return new RespuestaHTTP<Producto>(500, "Fatal Internal Error", null);

        }

    }

    @Override
    public RespuestaHTTP<Producto> bajaProducto(String id) {

        try {

            Producto p = service.bajaProducto(id);

            return p != null ?
                    new RespuestaHTTP<Producto>(200, "Producto eliminado con éxito.", p) :
                    new RespuestaHTTP<Producto>(400, "Bad Request", null) ;

        } catch (Exception e) {

            return new RespuestaHTTP<Producto>(500, "Fatal Internal Error", null);

        }

    }

    @Override
    public RespuestaHTTP<Producto> modificarNombreProducto(String id, String nuevoNombre) {

        try {

            Producto p = service.modificarNombreProducto(id, nuevoNombre);

            return p != null ?
                    new RespuestaHTTP<Producto>(200, "Nombre del Producto modificado con éxito.", p) :
                    new RespuestaHTTP<Producto>(400, "Bad Request", null) ;

        } catch (Exception e) {

            return new RespuestaHTTP<Producto>(500, "Fatal Internal Error", null);

        }

    }

    @Override
    public RespuestaHTTP<Producto> modificarStockProducto(String id, String nuevoStock) {

        try {

            Producto p = service.modificarStockProducto(id, nuevoStock);

            return p != null ?
                    new RespuestaHTTP<Producto>(200, "Stock del Producto modificado con éxito.", p) :
                    new RespuestaHTTP<Producto>(400, "Bad Request", null) ;

        } catch (Exception e) {

            return new RespuestaHTTP<Producto>(500, "Fatal Internal Error", null);

        }

    }

    @Override
    public RespuestaHTTP<Producto> getProducto(String id) {

        try {

            Producto p = service.getProducto(id);

            return p != null ?
                    new RespuestaHTTP<Producto>(200, "Producto obtenido con éxito.", p) :
                    new RespuestaHTTP<Producto>(400, "Bad Request", null) ;

        } catch (Exception e) {

            return new RespuestaHTTP<Producto>(500, "Fatal Internal Error", null);

        }

    }

    @Override
    public RespuestaHTTP<List<Producto>> getProductosConStock() {

        try {

            List<Producto> p = service.getProductoConStock();

            return p != null ?
                    new RespuestaHTTP<List<Producto>>(200, "Productos obtenidos con éxito.", p) :
                    new RespuestaHTTP<List<Producto>>(400, "Bad Request", null) ;

        } catch (Exception e) {

            return new RespuestaHTTP<List<Producto>>(500, "Fatal Internal Error", null);

        }

    }

    @Override
    public RespuestaHTTP<List<Producto>> getProductosSinStock() {

        try {

            List<Producto> p = service.getProductoSinStock();

            return p != null ?
                    new RespuestaHTTP<List<Producto>>(200, "Productos obtenidos con éxito.", p) :
                    new RespuestaHTTP<List<Producto>>(400, "Bad Request", null) ;

        } catch (Exception e) {

            return new RespuestaHTTP<List<Producto>>(500, "Fatal Internal Error", null);

        }

    }
}
