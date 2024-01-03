package com.example.facturahexagonal.infrastructure.controller;

import com.example.facturahexagonal.application.service.FacturaCabeceraService;
import com.example.facturahexagonal.domain.model.FacturaCabecera;

import com.example.facturahexagonal.infrastructure.entity.FacturaCabeceraEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/facturacabecera")
public class FacturaCabeceraController {

    private final FacturaCabeceraService facturaCabeceraService;


    public FacturaCabeceraController(FacturaCabeceraService facturaCabeceraService) {
        this.facturaCabeceraService = facturaCabeceraService;
    }

    @GetMapping
    public List<FacturaCabecera>allCabecera()
{
        return facturaCabeceraService.allCabecera();
}
    @PostMapping
    public ResponseEntity<FacturaCabecera> addCabecera (@RequestBody FacturaCabecera facturaCabecera)
    {
        FacturaCabecera facturaCabecera1 =facturaCabeceraService.addFacturaCabecera(facturaCabecera);
        return  new ResponseEntity<>(facturaCabecera1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<FacturaCabecera> getById(@PathVariable Long id)
    {
       Optional<FacturaCabecera> facturaCabeceraEntity = facturaCabeceraService.getById(id);

       if(facturaCabeceraEntity.isPresent())
       {
           return  new ResponseEntity<>(facturaCabeceraEntity.get(),HttpStatus.OK);
       }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCabecera(@PathVariable Long id)
    {
        if(facturaCabeceraService.deleteCabecera(id))
        {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public  ResponseEntity <FacturaCabecera> updateCabecera(@PathVariable Long id,@RequestBody FacturaCabecera facturaCabecera)
    {

         facturaCabeceraService.updateFacturaCabecera(facturaCabecera,id);
         return new ResponseEntity<>(HttpStatus.OK);

    }



}
