package com.example.facturahexagonal.infrastructure.repository.facturacabecera;


import com.example.facturahexagonal.domain.model.FacturaCabecera;
import com.example.facturahexagonal.domain.port.facturacabecera.out.FacturaCabeceraSalida;
import com.example.facturahexagonal.infrastructure.entity.FacturaCabeceraEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
public class FacturaCabeceraJpaRepositoryAdapter implements FacturaCabeceraSalida {

    private final FacturaCabeceraJpaRepository facturaCabeceraJpaRepository;

    public FacturaCabeceraJpaRepositoryAdapter(FacturaCabeceraJpaRepository facturaCabeceraJpaRepository) {
        this.facturaCabeceraJpaRepository = facturaCabeceraJpaRepository;
    }

    @Override
    public List<FacturaCabecera> allCabecera() {
        return facturaCabeceraJpaRepository.findAll().stream().map(FacturaCabeceraEntity::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<FacturaCabecera> getById(Long id) {
        Optional<FacturaCabeceraEntity> cabecera = facturaCabeceraJpaRepository.findById(id);
        return  cabecera.map(FacturaCabeceraEntity::toDomain);
    }

    @Override
    public FacturaCabecera addFacturaCabecera(FacturaCabecera facturaCabecera) {
        FacturaCabeceraEntity facturaCabeceraEntity = FacturaCabeceraEntity.fromModel(facturaCabecera);



        return  facturaCabeceraJpaRepository.save(facturaCabeceraEntity).toDomain();
    }

    @Override
    public Optional<FacturaCabecera> updateFacturaCabecera(FacturaCabecera facturaCabecera, Long id) {

        if (facturaCabeceraJpaRepository.existsById(id))
        {
            FacturaCabeceraEntity facturaCabeceraEntity  = new FacturaCabeceraEntity();
            facturaCabeceraEntity.setCliente_nombre(facturaCabecera.getCliente_nombre());
            facturaCabeceraEntity.setCliente_num_documento(facturaCabecera.getCliente_num_documento());
            facturaCabeceraEntity.setFecha_emision(facturaCabecera.getFecha_emision());
            facturaCabeceraEntity.setTotal(facturaCabecera.getTotal());
            facturaCabeceraEntity.setProductosEntities(FacturaCabeceraEntity.fromModel(facturaCabecera).getProductosEntities());
            facturaCabeceraEntity.setFacturaDetalleEntities(FacturaCabeceraEntity.fromModel(facturaCabecera).getFacturaDetalleEntities());
            return Optional.of(facturaCabeceraJpaRepository.save(facturaCabeceraEntity).toDomain());

        }


        return Optional.empty();
    }

    @Override
    public boolean deleteCabecera(Long id) {
        if ( facturaCabeceraJpaRepository.existsById(id))
        {
            facturaCabeceraJpaRepository.deleteById(id);
            return  true ;
        }
        return false;
    }
}
