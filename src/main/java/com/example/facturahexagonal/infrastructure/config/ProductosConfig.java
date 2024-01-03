package com.example.facturahexagonal.infrastructure.config;

import com.example.facturahexagonal.application.service.ProductosService;
import com.example.facturahexagonal.application.usecase.ProductosServiceImpl;
import com.example.facturahexagonal.domain.port.producto.out.ProductoSalida;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductosConfig {

    @Bean
    public ProductosService productosService(ProductoSalida productoSalida)
    {
        return new ProductosService(new ProductosServiceImpl(productoSalida));
    }


}
