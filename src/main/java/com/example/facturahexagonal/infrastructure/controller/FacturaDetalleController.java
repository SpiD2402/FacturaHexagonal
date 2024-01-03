package com.example.facturahexagonal.infrastructure.controller;

import com.example.facturahexagonal.application.service.FacturaDetalleService;
import com.example.facturahexagonal.domain.model.FacturaDetalle;
import com.example.facturahexagonal.domain.model.Productos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/facturadetalle")
public class FacturaDetalleController {

    private final FacturaDetalleService facturaDetalleService;


    public FacturaDetalleController(FacturaDetalleService facturaDetalleService) {
        this.facturaDetalleService = facturaDetalleService;
    }
    @GetMapping
    public ResponseEntity<List<FacturaDetalle>> allFacturaDetalle()
    {
        return new ResponseEntity<>(facturaDetalleService.allFacturaDetalle(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FacturaDetalle> addProductos(@RequestBody FacturaDetalle facturaDetalle)
    {
        FacturaDetalle facturaDetalle1 = facturaDetalleService.addFacturaDetalle(facturaDetalle);

        return new ResponseEntity<>(facturaDetalle1,HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public  ResponseEntity<FacturaDetalle> getById(@PathVariable Long id)
    {
        Optional<FacturaDetalle> facturaDetalle = facturaDetalleService.getById(id);

        if(facturaDetalle.isPresent())
        {
            return  new ResponseEntity<>(facturaDetalle.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFacturaDetalle(@PathVariable Long id)
    {
        if(facturaDetalleService.deleteFacturaDetalle(id))
        {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public  ResponseEntity <FacturaDetalle> updateFacturaDetalle(@PathVariable Long id,@RequestBody FacturaDetalle facturaDetalle)
    {

        facturaDetalleService.updateFacuraDetalle(facturaDetalle,id);
        return new ResponseEntity<>(HttpStatus.OK);

    }














}
