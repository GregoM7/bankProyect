package com.example.devsuproyect.dto;

import com.example.devsuproyect.models.Cliente;
import com.example.devsuproyect.models.Movimientos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuentaDTO {
    private Integer cuentaId;
    private Integer numeroCuenta;
    private String tipoCuenta;
    private Integer saldoInicial;
    private Boolean estado;
    private Cliente cliente;

    public CuentaDTO(Integer numeroCuenta, String tipoCuenta, Integer saldoInicial, Boolean estado, Cliente cliente) {
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldoInicial = saldoInicial;
        this.estado = estado;
        this.cliente = cliente;
    }
}

