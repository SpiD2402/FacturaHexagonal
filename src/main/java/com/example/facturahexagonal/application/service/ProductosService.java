package com.example.facturahexagonal.application.service;

import com.example.facturahexagonal.domain.model.Productos;
import com.example.facturahexagonal.domain.port.producto.in.ProductoEntrada;

import java.util.List;
import java.util.Optional;

public class ProductosService implements ProductoEntrada {

    private final ProductoEntrada productoEntrada;

    public ProductosService(ProductoEntrada productoEntrada) {
        this.productoEntrada = productoEntrada;
    }

    @Override
    public List<Productos> allProductos() {
        return productoEntrada.allProductos();
    }

    @Override
    public Optional<Productos> getById(Long id) {
        return productoEntrada.getById(id);
    }

    @Override
    public Productos addProductos(Productos productos) {
        return productoEntrada.addProductos(productos);
    }

    @Override
    public Optional <Productos> updateProductos(Productos productos, Long id) {
        return productoEntrada.updateProductos(productos,id);
    }

    @Override
    public boolean deleteProductos(Long id) {
        return productoEntrada.deleteProductos(id);
    }
}
