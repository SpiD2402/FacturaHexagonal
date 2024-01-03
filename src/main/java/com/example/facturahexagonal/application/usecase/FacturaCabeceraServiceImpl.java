package com.example.facturahexagonal.application.usecase;

import com.example.facturahexagonal.domain.model.FacturaCabecera;
import com.example.facturahexagonal.domain.port.facturacabecera.in.FacturaCabeceraEntrada;
import com.example.facturahexagonal.domain.port.facturacabecera.out.FacturaCabeceraSalida;

import java.util.List;
import java.util.Optional;

public class FacturaCabeceraServiceImpl implements FacturaCabeceraEntrada {

    private final FacturaCabeceraSalida facturaCabeceraSalida;

    public FacturaCabeceraServiceImpl(FacturaCabeceraSalida facturaCabeceraSalida) {
        this.facturaCabeceraSalida = facturaCabeceraSalida;
    }

    @Override
    public List<FacturaCabecera> allCabecera() {
        return facturaCabeceraSalida.allCabecera();
    }

    @Override
    public Optional<FacturaCabecera> getById(Long id) {
        return facturaCabeceraSalida.getById(id);
    }

    @Override
    public FacturaCabecera addFacturaCabecera(FacturaCabecera facturaCabecera) {
        return facturaCabeceraSalida.addFacturaCabecera(facturaCabecera);
    }

    @Override
    public Optional<FacturaCabecera> updateFacturaCabecera(FacturaCabecera facturaCabecera, Long id) {
        return facturaCabeceraSalida.updateFacturaCabecera(facturaCabecera,id);
    }

    @Override
    public boolean deleteCabecera(Long id) {
      return   facturaCabeceraSalida.deleteCabecera(id);
    }
}
