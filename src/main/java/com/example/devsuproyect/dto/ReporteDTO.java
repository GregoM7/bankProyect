package com.example.devsuproyect.dto;


import com.example.devsuproyect.models.Cliente;
import com.example.devsuproyect.models.Movimientos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReporteDTO {
    private Date fecha;
    private String nombre;
    private Integer numeroCuenta;
    private String tipoCuenta;
    private Integer saldoInicial;
    private Boolean estado;
    private Integer valor;

}
