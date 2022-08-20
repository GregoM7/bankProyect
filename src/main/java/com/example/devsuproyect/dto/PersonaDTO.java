package com.example.devsuproyect.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PersonaDTO {
    private Integer id;
    private String nombre;
    private String genero;
    private Integer edad;
    private Integer identificacion;
    private String direccion;
    private Integer telefono;


}
