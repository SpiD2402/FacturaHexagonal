package com.example.facturahexagonal.infrastructure.entity;

import com.example.facturahexagonal.domain.model.FacturaCabecera;
import com.example.facturahexagonal.domain.model.FacturaDetalle;
import com.example.facturahexagonal.domain.model.Productos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "facturacabecera")
public class FacturaCabeceraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long factura_id;

    private String cliente_nombre;

    private String cliente_num_documento;

    private Date fecha_emision;

    private double total;


    @ManyToMany
    @JoinTable(
            name = "facturadetalle",
            joinColumns =@JoinColumn(name = "factura_id"),
            inverseJoinColumns =@JoinColumn(name = "producto_id")
    )
    private Set<FacturaDetalleEntity> facturaDetalleEntities;

    @ManyToMany
    @JoinTable(
            name = "facturadetalle",
            joinColumns =@JoinColumn(name = "producto_id"),
            inverseJoinColumns =@JoinColumn(name = "factura_id")
    )
    private Set<ProductosEntity> productosEntities;



    public static FacturaCabeceraEntity fromModel(FacturaCabecera facturaCabecera) {
        FacturaCabeceraEntity facturaCabeceraEntity = new FacturaCabeceraEntity();
        facturaCabeceraEntity.setFactura_id(facturaCabecera.getFactura_id());
        facturaCabeceraEntity.setCliente_nombre(facturaCabecera.getCliente_nombre());
        facturaCabeceraEntity.setCliente_num_documento(facturaCabecera.getCliente_num_documento());
        facturaCabeceraEntity.setFecha_emision(facturaCabecera.getFecha_emision());



        facturaCabeceraEntity.setTotal(facturaCabecera.getTotal());

        Set<FacturaDetalle> detalles = facturaCabecera.getFacturaDetalles();

        Set<FacturaDetalleEntity> detallesEntidad = new HashSet<>();
        for(FacturaDetalle detalle : detalles) {
            FacturaDetalleEntity detalleEntidad = FacturaDetalleEntity.fromModel(detalle);
            detallesEntidad.add(detalleEntidad);
        }

        facturaCabeceraEntity.setFacturaDetalleEntities(detallesEntidad);

        Set<Productos> productos = facturaCabecera.getProductos();
        Set<ProductosEntity> productosEntidad = new HashSet<>();
        for (Productos producto : productos)
        {
            ProductosEntity productoEntity = ProductosEntity.fromDomainModel(producto);
            productosEntidad.add(productoEntity);
        }
        facturaCabeceraEntity.setProductosEntities(productosEntidad);



        return facturaCabeceraEntity;
    }


    public FacturaCabecera toDomain()
    {
        FacturaCabecera facturaCabecera = new FacturaCabecera();
        facturaCabecera.setFactura_id(this.factura_id);
        facturaCabecera.setCliente_nombre(this.cliente_nombre);
        facturaCabecera.setCliente_num_documento(this.cliente_num_documento);
        facturaCabecera.setFecha_emision(this.fecha_emision);
        facturaCabecera.setTotal(this.total);
        Set<FacturaDetalleEntity> detallesEntidad = this.getFacturaDetalleEntities();
        Set<FacturaDetalle> detalles = new HashSet<>();
        for(FacturaDetalleEntity detalleEntidad: detallesEntidad) {
            FacturaDetalle detalle = detalleEntidad.toDomain();
            detalles.add(detalle);
        }
        facturaCabecera.setFacturaDetalles(detalles);

        Set<ProductosEntity> productosEntidad = this.getProductosEntities();
        Set<Productos> producto = new HashSet<>();
        for (ProductosEntity productoEntidad : productosEntidad)
        {
            Productos productos = productoEntidad.toDomain();
            producto.add(productos);
        }

        facturaCabecera.setProductos(producto);

        return  facturaCabecera ;
    }




}

















