package com.example.facturahexagonal.domain.port.producto.in;


import com.example.facturahexagonal.domain.model.Productos;

import java.util.List;
import java.util.Optional;

public interface ProductoEntrada {

    List<Productos> allProductos();

    Optional<Productos> getById(Long id);

    Productos addProductos (Productos productos);

    Optional <Productos> updateProductos (Productos productos, Long id);

    boolean deleteProductos (Long id);




}
