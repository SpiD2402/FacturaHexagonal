package com.example.facturahexagonal.domain.port.facturacabecera.in;

import com.example.facturahexagonal.domain.model.FacturaCabecera;

import java.util.List;
import java.util.Optional;

public interface FacturaCabeceraEntrada {

    List<FacturaCabecera> allCabecera();

    Optional<FacturaCabecera> getById(Long id);

    FacturaCabecera addFacturaCabecera (FacturaCabecera facturaCabecera);

    Optional<FacturaCabecera> updateFacturaCabecera (FacturaCabecera facturaCabecera, Long id);

    boolean deleteCabecera (Long id);




}
