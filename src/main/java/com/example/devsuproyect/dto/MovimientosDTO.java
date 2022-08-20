package com.example.devsuproyect.dto;

import com.example.devsuproyect.models.Cuenta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovimientosDTO {
    private Integer movimientoId;
    private String tipoMovimiento;
    private Integer valor;
    private Date fecha;
    private Cuenta cuenta;
}
