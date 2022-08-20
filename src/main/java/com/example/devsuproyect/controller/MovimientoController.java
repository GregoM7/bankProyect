package com.example.devsuproyect.controller;

import com.example.devsuproyect.dto.CuentaDTO;
import com.example.devsuproyect.dto.MovimientosDTO;
import com.example.devsuproyect.exceptions.SaldoInsuficienteException;
import com.example.devsuproyect.service.CuentaService;
import com.example.devsuproyect.service.MovimientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {


    private MovimientosService movimientoService;
    private CuentaService cuentaService;
    @Autowired
    public MovimientoController(MovimientosService movimientoService, CuentaService cuentaService) {
        this.movimientoService = movimientoService;
        this.cuentaService = cuentaService;
    }

    @GetMapping("{movimientoId}")
    public MovimientosDTO getMovimiento(@PathVariable("movimientoId") Integer movimientoId) {
        return movimientoService.findById(movimientoId);
    }
    @PostMapping()
    public MovimientosDTO postMovimiento(@RequestBody MovimientosDTO movimientosDTO) {
       String tipoMovimiento =  movimientosDTO.getTipoMovimiento().toLowerCase();
       CuentaDTO cuentaActualizar = cuentaService.findById(movimientosDTO.getCuenta().getCuentaId());
        if(cuentaActualizar.getSaldoInicial() < movimientosDTO.getValor() && tipoMovimiento.equals("debito")) {
            throw new SaldoInsuficienteException("No hay saldo disponible");
        } else if (cuentaActualizar.getSaldoInicial() > movimientosDTO.getValor() && tipoMovimiento.equals("debito")){
            cuentaActualizar.setSaldoInicial(cuentaActualizar.getSaldoInicial() - movimientosDTO.getValor());
        } else if (tipoMovimiento.equals("credito")){
            cuentaActualizar.setSaldoInicial(cuentaActualizar.getSaldoInicial() + movimientosDTO.getValor());
        }
        cuentaService.update(cuentaActualizar);
        return movimientoService.create(movimientosDTO);
    }
    @PutMapping()
    public MovimientosDTO putMovimiento(@RequestBody MovimientosDTO movimientosDTO) {
        return movimientoService.update(movimientosDTO);
    }
    @DeleteMapping("/{movimientoId}")
    public ResponseEntity<String> deleteMovimiento(@PathVariable("movimientoId") Integer movimientoId) {
        movimientoService.deleteById(movimientoId);
        return ResponseEntity.ok("Movimiento eliminado");
    }
    @GetMapping
    public List<MovimientosDTO> getAllMovimientos() {
        return movimientoService.findAll();
    }


}
