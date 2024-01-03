package com.example.facturahexagonal.infrastructure.entity;

import com.example.facturahexagonal.domain.model.Productos;
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
@Table(name = "productos")
public class ProductosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long producto_id;

    private String nombre;

    private String descripcion;

    private double precio;

    private int stock;


    public static ProductosEntity  fromDomainModel(Productos productos)
    {
        ProductosEntity productosEntity = new ProductosEntity();
        productosEntity.setProducto_id(productos.getProducto_id());
        productosEntity.setNombre(productos.getNombre());
        productosEntity.setDescripcion(productos.getDescripcion());
        productosEntity.setPrecio(productos.getPrecio());
        productosEntity.setStock(productos.getStock());
        return  productosEntity;
    }


    public Productos toDomain()
    {
        Productos productos = new Productos();
        productos.setProducto_id(this.producto_id);
        productos.setNombre(this.nombre);
        productos.setDescripcion(this.descripcion);
        productos.setPrecio(this.precio);
        productos.setStock(this.stock);

        return  productos;
    }







}
