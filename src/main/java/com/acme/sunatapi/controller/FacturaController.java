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

// import com.acme.sunatapi.models.DetalleImpuesto;
// import com.acme.sunatapi.repositories.DetalleImpuestoRepository;
import com.acme.sunatapi.models.Empresa;
import com.acme.sunatapi.models.Factura;
import com.acme.sunatapi.models.Orden;
import com.acme.sunatapi.models.Servicio;
import com.acme.sunatapi.repository.EmpresaRepository;
import com.acme.sunatapi.repository.FacturaRepository;
import com.acme.sunatapi.repository.OrdenRepository;
import com.acme.sunatapi.repository.PersonaRepository;
import com.acme.sunatapi.repository.ServicioRepository;

@RestController
@RequestMapping(value = "api/factura", produces = "application/json")
public class FacturaController {
    private final FacturaRepository facturaData;
    private final OrdenRepository ordenData;

    public FacturaController(FacturaRepository facturaData, OrdenRepository ordenData) {
        this.facturaData = facturaData;
        this.ordenData = ordenData;
    }

    // Crear empresa
    @PostMapping(value = "/", produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> create(@RequestBody Factura f){
        facturaData.save(f);
        facturaData.flush(); // Crear id 
        Factura generada = f;
        List<Orden> listOrdenes = f.getOrden();
        listOrdenes.stream().forEach(o -> o.setFactura(generada));
        ordenData.saveAllAndFlush(listOrdenes);
        return new ResponseEntity<Integer>(f.getId(), HttpStatus.CREATED);
        
    }

}