package com.example.facturahexagonal.infrastructure.repository.producto;

import com.example.facturahexagonal.infrastructure.entity.ProductosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoJpaRepository extends JpaRepository<ProductosEntity,Long> {
}
