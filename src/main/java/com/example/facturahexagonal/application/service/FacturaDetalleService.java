package com.example.facturahexagonal.application.service;

import com.example.facturahexagonal.domain.model.FacturaDetalle;
import com.example.facturahexagonal.domain.port.facturadetalle.in.FacturaDetalleEntrada;

import java.util.List;
import java.util.Optional;

public class FacturaDetalleService implements FacturaDetalleEntrada {

    private final FacturaDetalleEntrada facturaDetalleEntrada;

    public FacturaDetalleService(FacturaDetalleEntrada facturaDetalleEntrada) {
        this.facturaDetalleEntrada = facturaDetalleEntrada;
    }

    @Override
    public List<FacturaDetalle> allFacturaDetalle() {
        return facturaDetalleEntrada.allFacturaDetalle();
    }

    @Override
    public Optional<FacturaDetalle> getById(Long id) {
        return facturaDetalleEntrada.getById(id);
    }

    @Override
    public FacturaDetalle addFacturaDetalle(FacturaDetalle facturaDetalle) {
        return facturaDetalleEntrada.addFacturaDetalle(facturaDetalle);
    }

    @Override
    public Optional<FacturaDetalle> updateFacuraDetalle(FacturaDetalle facturaDetalle, Long id) {
        return facturaDetalleEntrada.updateFacuraDetalle(facturaDetalle,id);
    }

    @Override
    public boolean deleteFacturaDetalle(Long id) {
        return facturaDetalleEntrada.deleteFacturaDetalle(id);
    }
}
