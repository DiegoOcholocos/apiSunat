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

import com.acme.sunatapi.models.DetalleImpuesto;
import com.acme.sunatapi.models.Empresa;
import com.acme.sunatapi.repository.DetalleImpuestoRepository;
import com.acme.sunatapi.repository.EmpresaRepository;

@RestController
@RequestMapping(value = "api/empresa", produces = "application/json")
public class EmpresaController {
    private final EmpresaRepository empresaData;
    private final DetalleImpuestoRepository detalleImpuestoData;
    public EmpresaController(EmpresaRepository empresaData,
    DetalleImpuestoRepository detalleImpuestoData ){
        this.empresaData = empresaData;
        this.detalleImpuestoData = detalleImpuestoData;
        
    }
    // Crear empresa
   @PostMapping(value = "/", produces =MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Integer> create(@RequestBody Empresa em){
       empresaData.save(em);
       empresaData.flush(); // Crear id 
        Empresa generada = em;
        List<DetalleImpuesto> listItems = em.getDetalleImpuesto();
        listItems.stream().forEach(o -> o.setEmpresa(generada));
        detalleImpuestoData.saveAllAndFlush(listItems);
        return new ResponseEntity<Integer>(em.getId(), HttpStatus.CREATED);
       
   }
    //Obtener empresa
    @GetMapping(value = "/{ruc}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empresa> findByNumber(@PathVariable BigInteger ruc)
   {
       Optional<Empresa> optionEmpresa = empresaData.findByRuc(ruc);
       if(optionEmpresa.isPresent()) {
           Empresa empresa = optionEmpresa.get();
           List<DetalleImpuesto> detalleImpuestos = detalleImpuestoData.findItemsByEmpresa(empresa);
           empresa.setDetalleImpuesto(detalleImpuestos);
           return new ResponseEntity<Empresa>(empresa, HttpStatus.OK);
       }else{
           return new ResponseEntity<Empresa>(HttpStatus.NOT_FOUND);
       }

    }
    // actualizar empresa 
    //borrar empresa 
}