package com.example.facturahexagonal.infrastructure.controller;

import com.example.facturahexagonal.application.service.ProductosService;
import com.example.facturahexagonal.domain.model.FacturaCabecera;
import com.example.facturahexagonal.domain.model.Productos;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductosController {


    private final ProductosService productosService;


    public ProductosController(ProductosService productosService) {
        this.productosService = productosService;
    }

    @GetMapping
    public ResponseEntity <List<Productos>> allProductos()
    {
         return new ResponseEntity<>(productosService.allProductos(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Productos> addProductos(@RequestBody Productos productos)
    {
        Productos productos1 = productosService.addProductos(productos);

        return new ResponseEntity<>(productos1,HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public  ResponseEntity<Productos> getById(@PathVariable Long id)
    {
        Optional<Productos> productos = productosService.getById(id);

        if(productos.isPresent())
        {
            return  new ResponseEntity<>(productos.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProdutos(@PathVariable Long id)
    {
        if(productosService.deleteProductos(id))
        {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public  ResponseEntity <Productos> updateCabecera(@PathVariable Long id,@RequestBody Productos productos)
    {

        productosService.updateProductos(productos,id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
