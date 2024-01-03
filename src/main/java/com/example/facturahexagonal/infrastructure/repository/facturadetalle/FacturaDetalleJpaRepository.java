package com.example.facturahexagonal.infrastructure.repository.facturadetalle;

import com.example.facturahexagonal.infrastructure.entity.FacturaDetalleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaDetalleJpaRepository extends JpaRepository<FacturaDetalleEntity,Long> {
}
