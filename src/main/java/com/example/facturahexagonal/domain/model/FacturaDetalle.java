package com.example.facturahexagonal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class FacturaDetalle {

    private Long detalle_id;


    private Long factura_id;


    private Long producto_id;

    private int cantidad;

    private double precio_unitario;

    private double subtotal;

}
