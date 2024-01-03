package com.example.facturahexagonal.infrastructure.config;

import com.example.facturahexagonal.application.service.FacturaCabeceraService;
import com.example.facturahexagonal.application.usecase.FacturaCabeceraServiceImpl;
import com.example.facturahexagonal.domain.port.facturacabecera.out.FacturaCabeceraSalida;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FacturaCabeceraConfig {

    @Bean
    public FacturaCabeceraService facturaDetalleService(FacturaCabeceraSalida facturaCabeceraSalida)
    {
        return new FacturaCabeceraService(new FacturaCabeceraServiceImpl(facturaCabeceraSalida));
    }

}
