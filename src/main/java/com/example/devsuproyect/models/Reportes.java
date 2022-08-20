package com.example.devsuproyect.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Reportes {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer reporteId;
        private Date fecha;
        private Integer numeroCuenta;
        private String tipoCuenta;
        private Integer saldoInicial;
        private Boolean estado;
        @OneToMany(mappedBy = "reporte")
        private Set<Movimientos> movimientos;
        private Integer saldoDisponible;

        public Reportes() {
            //No args constructor
        }

        public Integer getReporteId() {
            return reporteId;
        }

        public void setReporteId(Integer reporteId) {
            this.reporteId = reporteId;
        }

        public Date getFecha() {
            return fecha;
        }

        public void setFecha(Date fecha) {
            this.fecha = fecha;
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

    public Set<Movimientos> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(Set<Movimientos> movimientos) {
        this.movimientos = movimientos;
    }

    public Integer getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(Integer saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }
}
