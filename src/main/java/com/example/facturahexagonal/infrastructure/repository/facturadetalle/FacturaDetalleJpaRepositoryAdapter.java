package com.example.facturahexagonal.infrastructure.repository.facturadetalle;

import com.example.facturahexagonal.domain.model.FacturaDetalle;
import com.example.facturahexagonal.domain.port.facturadetalle.out.FacturaDetalleSalida;
import com.example.facturahexagonal.infrastructure.entity.FacturaDetalleEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class FacturaDetalleJpaRepositoryAdapter implements FacturaDetalleSalida {


    private final FacturaDetalleJpaRepository facturaDetalleJpaRepository;

    public FacturaDetalleJpaRepositoryAdapter(FacturaDetalleJpaRepository facturaDetalleJpaRepository) {
        this.facturaDetalleJpaRepository = facturaDetalleJpaRepository;
    }

    @Override
    public List<FacturaDetalle> allFacturaDetalle() {
        return facturaDetalleJpaRepository.findAll().stream().map(FacturaDetalleEntity::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<FacturaDetalle> getById(Long id) {
        return facturaDetalleJpaRepository.findById(id).map(FacturaDetalleEntity::toDomain);
    }

    @Override
    public FacturaDetalle addFacturaDetalle(FacturaDetalle facturaDetalle) {
        FacturaDetalleEntity facturaDetalleEntity = FacturaDetalleEntity.fromModel(facturaDetalle);


        return facturaDetalleJpaRepository.save(facturaDetalleEntity).toDomain();
    }

    @Override
    public Optional<FacturaDetalle> updateFacuraDetalle(FacturaDetalle facturaDetalle, Long id) {

        if(facturaDetalleJpaRepository.existsById(id))
        {
            FacturaDetalleEntity facturaDetalleEntity = FacturaDetalleEntity.fromModel(facturaDetalle);
            return  Optional.of(facturaDetalleJpaRepository.save(facturaDetalleEntity).toDomain());
        }


        return Optional.empty();
    }

    @Override
    public boolean deleteFacturaDetalle(Long id) {
        if (facturaDetalleJpaRepository.existsById(id))
        {
            facturaDetalleJpaRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
