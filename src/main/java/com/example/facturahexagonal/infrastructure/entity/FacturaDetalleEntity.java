package com.example.facturahexagonal.infrastructure.entity;

import com.example.facturahexagonal.domain.model.FacturaDetalle;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "facturadetalle")
public class FacturaDetalleEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detalle_id;

    @JsonIgnore
    private Long factura_id;

    @JsonIgnore
    private Long producto_id;

    private int cantidad;

    private double precio_unitario;

    private double subtotal;


    public static FacturaDetalleEntity fromModel(FacturaDetalle facturaDetalle)
    {
        FacturaDetalleEntity facturaDetalleEntity = new FacturaDetalleEntity();
        facturaDetalleEntity.setDetalle_id(facturaDetalle.getDetalle_id());
        facturaDetalleEntity.setFactura_id(facturaDetalle.getFactura_id());
        facturaDetalleEntity.setProducto_id(facturaDetalle.getProducto_id());
        facturaDetalleEntity.setCantidad(facturaDetalle.getCantidad());
        facturaDetalleEntity.setPrecio_unitario(facturaDetalle.getPrecio_unitario());
        facturaDetalleEntity.setSubtotal(facturaDetalle.getCantidad() * facturaDetalle.getPrecio_unitario());
        return facturaDetalleEntity;
    }

    public FacturaDetalle  toDomain()
    {
        FacturaDetalle facturaDetalle = new FacturaDetalle();
        facturaDetalle.setDetalle_id(this.detalle_id);
        facturaDetalle.setFactura_id(this.factura_id);
        facturaDetalle.setProducto_id(this.producto_id);
        facturaDetalle.setCantidad(this.cantidad);
        facturaDetalle.setPrecio_unitario(this.precio_unitario);
        facturaDetalle.setSubtotal(this.cantidad* this.precio_unitario);

        return facturaDetalle;
    }


}
