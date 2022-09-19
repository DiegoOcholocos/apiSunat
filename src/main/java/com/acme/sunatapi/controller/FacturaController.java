package com.acme.sunatapi.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acme.sunatapi.models.Factura;


import com.acme.sunatapi.repository.FacturaRepository;



@RestController
@RequestMapping(value = "api/factura", produces = "application/json")
public class FacturaController {
    private final FacturaRepository facturaData;


    public FacturaController(FacturaRepository facturaData) {
        this.facturaData = facturaData;

    }

    // Crear empresa
    @PostMapping(value = "/", produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BigInteger> create(@RequestBody Factura f){
        facturaData.save(f);
        facturaData.flush(); // Crear id 
        // Factura generada = f;
        return new ResponseEntity<BigInteger>(f.getNumeroFactura(), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{numeroFactura}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Factura> findBynumFactura(@PathVariable BigInteger numeroFactura){
        Optional<Factura> optFactura =facturaData.findByNumFactura(numeroFactura);
        if(optFactura.isPresent()){
            Factura factura = optFactura.get();
            return new ResponseEntity<Factura>(factura,HttpStatus.OK);
        }else{
            return new ResponseEntity<Factura>(HttpStatus.NOT_FOUND);
        }   
    }
}