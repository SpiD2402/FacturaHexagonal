package com.example.facturahexagonal.application.usecase;

import com.example.facturahexagonal.domain.model.Productos;
import com.example.facturahexagonal.domain.port.producto.in.ProductoEntrada;
import com.example.facturahexagonal.domain.port.producto.out.ProductoSalida;

import java.util.List;
import java.util.Optional;

public class ProductosServiceImpl implements ProductoEntrada
{

    private final ProductoSalida productoSalida;

    public ProductosServiceImpl(ProductoSalida productoSalida) {
        this.productoSalida = productoSalida;
    }

    @Override
    public List<Productos> allProductos() {
        return productoSalida.allProductos();
    }

    @Override
    public Optional<Productos> getById(Long id) {
        return productoSalida.getById(id);
    }

    @Override
    public Productos addProductos(Productos productos) {
        return productoSalida.addProductos(productos);
    }

    @Override
    public Optional <Productos> updateProductos(Productos productos, Long id) {
        return productoSalida.updateProductos(productos,id);
    }

    @Override
    public boolean deleteProductos(Long id) {
        return productoSalida.deleteProductos(id);
    }
}
