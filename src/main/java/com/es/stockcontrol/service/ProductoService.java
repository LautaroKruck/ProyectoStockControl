package com.es.stockcontrol.service;

import com.es.stockcontrol.model.Producto;
import com.es.stockcontrol.model.Proveedor;
import com.es.stockcontrol.repository.ProductoRepository;

import java.util.Date;
import java.util.List;

public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService() {

        this.repository = new ProductoRepository();

    }

    public Producto getProducto(String idProducto) {

        //Comprobamos que el ID del producto tiene la longitud adecuada y que no es null
        if (idProducto.length() > 9 || idProducto.isEmpty()) {

            return null;

        }

        return repository.getProducto(idProducto);

    }

    public List<Producto> getProductoConStock() {

        return repository.getProductoConStock();

    }

    public List<Producto> getProductoSinStock() {

        return repository.getProductoSinStock();

    }

    public Producto altaProducto(String categoriaProducto, String nombreProducto, String precioSinIva, String descripcionProducto, String stock, String nombreProveedor, String direccionProveedor) {

        //categoriaProducto no puede tener longitud mayor de 50 ni ser null
        if (categoriaProducto.length() > 50 || categoriaProducto.isEmpty()) {

            return null;

        }

        //nombreProducto no puede tener longitud mayor de 50 ni ser null
        if (nombreProducto.length() > 50 || nombreProducto.isEmpty()) {

            return null;

        }

        //nombreProveedor no puede tener longitud mayor de 50 ni ser null
        if (nombreProveedor.length() > 50 || nombreProveedor.isEmpty()) {

            return null;

        }

        //Comprobamos que precioConIva puede pasarse a Float y despues calculamos el precioConIva
        float precioConIva = 0.0F;

        float precioSinIvaF;

        try {

            precioSinIvaF = Float.parseFloat(precioSinIva);

        } catch (NumberFormatException | NullPointerException e) {

            return null;

        }

        final double IVA = 1.21;

        precioConIva = (float) (precioSinIvaF * IVA);

        //El ID es las tres primeras letras de la categoria + las tres primeras del nombre + las tres primeras del nombre del proveedor
        String idProducto = categoriaProducto.substring(0, 3) + nombreProducto.substring(0, 3) + nombreProveedor.substring(0, 3);

        //Fecha de hoy
        Date fechaAlta = new Date();

        //Comprobamos que stock puede pasarse a Int
        int stockI;

        try {

            stockI = Integer.parseInt(stock);

        } catch (NumberFormatException | NullPointerException e) {

            return null;

        }

        Proveedor pr = new Proveedor(nombreProveedor, direccionProveedor);

        Producto p = new Producto(idProducto, categoriaProducto, nombreProducto, descripcionProducto, precioSinIvaF, precioConIva, fechaAlta, stockI, pr);

        return repository.altaProducto(p);

    }

    public Producto bajaProducto(String idProducto) {

        //Comprobamos que el ID del producto tiene la longitud adecuada y que no es null
        if (idProducto.length() > 9 || idProducto.isEmpty()) {

            return null;

        }

        return repository.bajaProducto(idProducto);

    }

    public Producto modificarNombreProducto(String idProducto, String nuevoNombre) {

        //Comprobamos que el ID del producto tiene la longitud adecuada y que no es null
        if (idProducto.length() > 9 || idProducto.isEmpty()) {

            return null;

        }

        //nuevoNombre no puede tener longitud mayor de 50 ni ser null
        if (nuevoNombre.length() > 50 || nuevoNombre.isEmpty()) {

            return null;

        }

        return repository.modificarNombreProducto(idProducto, nuevoNombre);

    }

    public Producto modificarStockProducto(String idProducto, String nuevoStock) {

        //Comprobamos que el ID del producto tiene la longitud adecuada y que no es null
        if (idProducto.length() > 9 || idProducto.isEmpty()) {

            return null;

        }

        //Comprobamos que stock puede pasarse a Int
        int stockI;

        try {

            stockI = Integer.parseInt(nuevoStock);

        } catch (NumberFormatException | NullPointerException e) {

            return null;

        }

        return repository.modificarStockProducto(idProducto, stockI);

    }
}
