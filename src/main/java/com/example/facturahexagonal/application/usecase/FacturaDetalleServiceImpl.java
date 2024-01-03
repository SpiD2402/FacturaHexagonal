package com.example.facturahexagonal.application.usecase;

import com.example.facturahexagonal.domain.model.FacturaDetalle;
import com.example.facturahexagonal.domain.port.facturadetalle.in.FacturaDetalleEntrada;
import com.example.facturahexagonal.domain.port.facturadetalle.out.FacturaDetalleSalida;

import java.util.List;
import java.util.Optional;

public class FacturaDetalleServiceImpl implements FacturaDetalleEntrada {

    private final FacturaDetalleSalida facturaDetalleSalida;

    public FacturaDetalleServiceImpl(FacturaDetalleSalida facturaDetalleSalida) {
        this.facturaDetalleSalida = facturaDetalleSalida;
    }

    @Override
    public List<FacturaDetalle> allFacturaDetalle() {
        return facturaDetalleSalida.allFacturaDetalle();
    }

    @Override
    public Optional<FacturaDetalle> getById(Long id) {
        return facturaDetalleSalida.getById(id);
    }

    @Override
    public FacturaDetalle addFacturaDetalle(FacturaDetalle facturaDetalle) {
        return facturaDetalleSalida.addFacturaDetalle(facturaDetalle);
    }

    @Override
    public Optional<FacturaDetalle> updateFacuraDetalle(FacturaDetalle facturaDetalle, Long id) {
        return facturaDetalleSalida.updateFacuraDetalle(facturaDetalle,id);
    }

    @Override
    public boolean deleteFacturaDetalle(Long id) {
        return facturaDetalleSalida.deleteFacturaDetalle(id);
    }
}
