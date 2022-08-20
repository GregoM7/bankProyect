package com.example.devsuproyect.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cuentaId;
    private Integer numeroCuenta;
    private String tipoCuenta;
    private Integer saldoInicial;
    private Boolean estado;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clienteId", nullable = false)
    private Cliente cliente;


    public Cuenta() {
        //No args constructor
    }

    public Cuenta(Integer cuentaId, Integer numeroCuenta, String tipoCuenta, Integer saldoInicial, Boolean estado) {
        this.cuentaId = cuentaId;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldoInicial = saldoInicial;
        this.estado = estado;
    }

    public Integer getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(Integer cuentaId) {
        this.cuentaId = cuentaId;
    }

    public Integer getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Integer numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Integer getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Integer saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
