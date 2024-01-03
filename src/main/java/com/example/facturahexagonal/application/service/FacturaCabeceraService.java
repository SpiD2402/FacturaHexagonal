package com.example.facturahexagonal.application.service;

import com.example.facturahexagonal.domain.model.FacturaCabecera;
import com.example.facturahexagonal.domain.port.facturacabecera.in.FacturaCabeceraEntrada;

import java.util.List;
import java.util.Optional;

public class FacturaCabeceraService implements FacturaCabeceraEntrada {

    private final FacturaCabeceraEntrada facturaCabeceraEntrada;

    public FacturaCabeceraService(FacturaCabeceraEntrada facturaCabeceraEntrada) {
        this.facturaCabeceraEntrada = facturaCabeceraEntrada;
    }

    @Override
    public List<FacturaCabecera> allCabecera() {
        return facturaCabeceraEntrada.allCabecera();
    }

    @Override
    public Optional<FacturaCabecera> getById(Long id) {
        return facturaCabeceraEntrada.getById(id);
    }

    @Override
    public FacturaCabecera addFacturaCabecera(FacturaCabecera facturaCabecera) {
        return facturaCabeceraEntrada.addFacturaCabecera(facturaCabecera);
    }

    @Override
    public Optional<FacturaCabecera> updateFacturaCabecera(FacturaCabecera facturaCabecera, Long id) {
        return facturaCabeceraEntrada.updateFacturaCabecera(facturaCabecera,id);
    }

    @Override
    public boolean deleteCabecera(Long id) {
        return facturaCabeceraEntrada.deleteCabecera(id);
    }
}
