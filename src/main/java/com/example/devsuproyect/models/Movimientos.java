package com.example.devsuproyect.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Movimientos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movimientoId;
    private Date fecha;
    private String tipoMovimiento;
    private Integer valor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuenta_id")
    private Cuenta cuenta;
    @ManyToOne()
    @JoinColumn(name = "reporte_id", nullable = true)
    private Reportes reporte;

    public Movimientos() {
        //No args constructor
    }

    public Movimientos(Integer movimientoId, String tipoMovimiento, Integer valor, Date fecha) {
        this.movimientoId = movimientoId;
        this.tipoMovimiento = tipoMovimiento;
        this.valor = valor;

        this.fecha = fecha;
    }

    public Integer getMovimientoId() {
        return movimientoId;
    }

    public void setMovimientoId(Integer movimientoId) {
        this.movimientoId = movimientoId;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }


    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Reportes getReporte() {
        return reporte;
    }

    public void setReporte(Reportes reporte) {
        this.reporte = reporte;
    }
}
