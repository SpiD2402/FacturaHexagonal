package com.example.facturahexagonal.infrastructure.config;

import com.example.facturahexagonal.application.service.FacturaDetalleService;
import com.example.facturahexagonal.application.usecase.FacturaDetalleServiceImpl;
import com.example.facturahexagonal.domain.port.facturadetalle.out.FacturaDetalleSalida;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FacturaDetalleConfig {

        @Bean
        public FacturaDetalleService facturaDetalleService (FacturaDetalleSalida facturaDetalleSalida)
        {
             return  new FacturaDetalleService(new FacturaDetalleServiceImpl(facturaDetalleSalida));
        }
}
