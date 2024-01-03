package com.example.facturahexagonal.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacturaCabecera {


    private Long factura_id;

    private String cliente_nombre;

    private String cliente_num_documento;

    private Date fecha_emision;

    private double total;

    private Set<FacturaDetalle> facturaDetalles;

    private Set<Productos> productos;



}
