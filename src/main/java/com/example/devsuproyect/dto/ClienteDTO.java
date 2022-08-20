package com.example.devsuproyect.dto;

import lombok.Data;

@Data
public class ClienteDTO {
    private String nombre;
    private String genero;
    private Integer edad;
    private Integer identificacion;
    private String direccion;
    private Integer telefono;
    private Integer clienteId;
    private String contrasenia;
    private Boolean estado;

    public ClienteDTO() {
        //No args constructor
    }

    public ClienteDTO(String nombre, String genero, Integer edad, Integer identificacion, String direccion, Integer telefono, String contrasenia, Boolean estado) {
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
        this.estado = estado;
    }

    public ClienteDTO(String nombre, String genero, Integer edad, Integer identificacion, String direccion, Integer telefono, Integer clienteId, String contrasenia, Boolean estado) {
       this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.clienteId = clienteId;
        this.contrasenia = contrasenia;
        this.estado = estado;
    }

}
