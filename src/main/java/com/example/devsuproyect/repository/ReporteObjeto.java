package com.example.devsuproyect.repository;

import java.util.Date;

public interface ReporteObjeto {

    //Select m.fecha as fecha, c.nombre as nombre, cu.numero_cuenta as numeroCuenta, cu.tipo_cuenta as tipoCuenta, cu.saldo_inicial as saldoInicial, cu.estado as estado, m.valor as valor, m.saldo_disponible as saldoDisponible
    Date getFecha();
    String getNombre();
    Integer getNumeroCuenta();
    String getTipoCuenta();
    Integer getSaldoInicial();
    Boolean getEstado();
    Integer getValor();
}
