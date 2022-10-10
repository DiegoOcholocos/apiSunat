package com.acme.sunatapi.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acme.sunatapi.repository.FacturaRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.util.*;


@RestController
@RequestMapping(value = "api/dashboard", produces = "application/json")
public class DashboardController {
    private final FacturaRepository facturaData;

    public DashboardController(FacturaRepository facturaData){
        this.facturaData = facturaData;
    } 

    @GetMapping(value = "/montototal", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Map<String, Object>>> productos(){
        return  new ResponseEntity<List<Map<String, Object>>>(
            facturaData.querySumaTotalByMonth(), HttpStatus.OK);
    }
    @GetMapping(value = "/montototalreceptor", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Map<String, Object>>> facturasreceptor(){
        return  new ResponseEntity<List<Map<String, Object>>>(
            facturaData.querySumaTotalByReceptor(), HttpStatus.OK);
    }
    @GetMapping(value = "/totalfacturas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Map<String, Object>>> facturas(){
        return  new ResponseEntity<List<Map<String, Object>>>(
            facturaData.querySumaTotalByMonthFacturas(), HttpStatus.OK);
    }
}