package com.example.devsuproyect.controller;


import com.example.devsuproyect.dto.CuentaDTO;
import com.example.devsuproyect.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    public final CuentaService cuentaService;

    @Autowired
    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping("{cuentaId}")
    public CuentaDTO getCuenta(@PathVariable("cuentaId") Integer cuentaId) {
        return cuentaService.findById(cuentaId);
    }
    @PostMapping()
    public CuentaDTO postCuenta(@RequestBody CuentaDTO cuentaDTO) {
        return cuentaService.create(cuentaDTO);
    }
    @PutMapping()
    public CuentaDTO putCuenta(@RequestBody CuentaDTO cuentaDTO) {
        return cuentaService.update(cuentaDTO);
    }
    @DeleteMapping("/{cuentaId}")
    public ResponseEntity<String> deleteCuenta(@PathVariable("cuentaId") Integer cuentaId) {
        cuentaService.deleteById(cuentaId);
        return ResponseEntity.ok("Cuenta eliminada");
    }
    @GetMapping
    public List<CuentaDTO> getAllCuentas() {
        return cuentaService.findAll();
    }



}
