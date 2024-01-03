package com.example.facturahexagonal.infrastructure.repository.producto;

import com.example.facturahexagonal.domain.model.Productos;
import com.example.facturahexagonal.domain.port.producto.out.ProductoSalida;
import com.example.facturahexagonal.infrastructure.entity.ProductosEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductoJpaRepositoryAdapter implements ProductoSalida {

    private final ProductoJpaRepository productoJpaRepository;

    public ProductoJpaRepositoryAdapter(ProductoJpaRepository productoJpaRepository) {
        this.productoJpaRepository = productoJpaRepository;
    }

    @Override
    public List<Productos> allProductos() {
        return productoJpaRepository.findAll().stream().map(ProductosEntity::toDomain).collect(Collectors.toList());
    }


    @Override
    public Optional<Productos> getById(Long id) {
        return productoJpaRepository.findById(id).map(ProductosEntity::toDomain);
    }
    @Override
    public Productos addProductos(Productos productos) {
        return productoJpaRepository.save(ProductosEntity.fromDomainModel(productos)).toDomain();
    }

    @Override
    public Optional <Productos> updateProductos(Productos productos, Long id) {
        if (productoJpaRepository.existsById(id))
        {
            ProductosEntity productosEntity =ProductosEntity.fromDomainModel(productos);
            return Optional.of(productoJpaRepository.save(productosEntity).toDomain());
        }

        return  Optional.empty();
    }

    @Override
    public boolean deleteProductos(Long id) {

        if (productoJpaRepository.existsById(id))
        {
            productoJpaRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
