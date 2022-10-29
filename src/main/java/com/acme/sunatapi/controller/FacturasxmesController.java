package com.acme.sunatapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
@Controller
public class FacturasxmesController {
   

    private static final String VIEW_DASHBOARD ="Facturas por mes"; 
    private static final String VIEW_GRAF ="GraficoDeReceptores"; 
    private static final String VIEW_GRAFICO ="GraficoDeFacturas";
    private static final String VIEW_TABLE ="Table";

    @GetMapping("app/Facturas por mes")
    public String Facturasx(Model model) {
        return VIEW_DASHBOARD;
    }

    @GetMapping("app/GraficoDeReceptores")
    public String graficos(Model model) {
        return VIEW_GRAF;
    }

    @GetMapping("app/GraficoDeFacturas")
    public String GDF(Model model) {
        return VIEW_GRAFICO;
    }

    @GetMapping("app/Table")
    public String Table(Model model) {
        return VIEW_TABLE;
    }

    
}
