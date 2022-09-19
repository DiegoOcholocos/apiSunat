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
import com.acme.sunatapi.models.Persona;
import com.acme.sunatapi.repository.FacturaRepository;
import com.acme.sunatapi.repository.PersonaRepository;

@RestController
@RequestMapping(value = "api/persona", produces = "application/json")
public class PersonaController {
    private final PersonaRepository personaData;
    private final FacturaRepository facturaData;

    public PersonaController(PersonaRepository personaData, FacturaRepository facturaData) {
        this.personaData = personaData;
        this.facturaData = facturaData;
    }
    // Crear empresa
    @PostMapping(value = "/", produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> create(@RequestBody Persona p){
        personaData.save(p);
        personaData.flush(); // Crear id 
        Persona generada = p;

        List<Factura> listFacturas = p.getFactura();
        listFacturas.stream().forEach(o -> o.setPersona(generada));
        facturaData.saveAllAndFlush(listFacturas);
        return new ResponseEntity<Integer>(p.getId(), HttpStatus.CREATED);

    }
}