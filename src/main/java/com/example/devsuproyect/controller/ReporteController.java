package com.example.devsuproyect.controller;

import com.example.devsuproyect.dto.ReporteDTO;
import com.example.devsuproyect.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reporte")
public class ReporteController {

    private final ReporteService reporteService;

    @Autowired
    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @GetMapping()
    public ResponseEntity<List<ReporteDTO>> getReporte(@RequestParam String fecha1, @RequestParam String fecha2, @RequestParam Integer clienteId) {
        return ResponseEntity.ok(reporteService.getReporte(clienteId, fecha1, fecha2));
    }

}
