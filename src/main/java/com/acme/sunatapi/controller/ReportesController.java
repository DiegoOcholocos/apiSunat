package com.acme.sunatapi.controller;

import java.io.OutputStream;


import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import net.sf.jasperreports.engine.*;

@Controller
public class ReportesController {
    private JdbcTemplate jdbcTemplate;
    private ResourceLoader resourceLoader;

    public ReportesController(JdbcTemplate jdbcTemplate, ResourceLoader resourceLoader){
        this.jdbcTemplate = jdbcTemplate;
        this.resourceLoader = resourceLoader;
    }

    @GetMapping("/jasper/repfacturas")
    public void generateReporteVentas(HttpServletResponse response)  {
        response.setContentType("application/x-download");
        response.setHeader("Content-Disposition", 
            String.format("attachment; filename=\"facturas.pdf\""));
        try {
            OutputStream out = response.getOutputStream();
            Resource resource = resourceLoader.getResource("classpath:./reports/ReportesFacturas.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(resource.getInputStream());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, 
                    jdbcTemplate.getDataSource().getConnection());
            JasperExportManager.exportReportToPdfStream(jasperPrint, out);

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}