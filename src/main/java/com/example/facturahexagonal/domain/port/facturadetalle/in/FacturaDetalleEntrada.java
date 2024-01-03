package com.example.facturahexagonal.domain.port.facturadetalle.in;

import com.example.facturahexagonal.domain.model.FacturaDetalle;


import java.util.List;
import java.util.Optional;

public interface FacturaDetalleEntrada {

    List<FacturaDetalle> allFacturaDetalle();

    Optional<FacturaDetalle> getById(Long id);

    FacturaDetalle addFacturaDetalle (FacturaDetalle facturaDetalle);

    Optional <FacturaDetalle> updateFacuraDetalle (FacturaDetalle facturaDetalle, Long id);

    boolean deleteFacturaDetalle (Long id);


}
