package com.example.devsuproyect.repository;

import com.example.devsuproyect.dto.ReporteDTO;
import com.example.devsuproyect.models.Reportes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReporteRepository extends JpaRepository<Reportes,Integer> {

    @Query(value = "Select m.fecha as fecha, c.nombre as nombre, cu.numero_cuenta as numeroCuenta, cu.tipo_cuenta as tipoCuenta, cu.saldo_inicial as saldoInicial, cu.estado as estado, m.valor as valor from cliente as c join cuenta cu on cu.cliente_id = c.cliente_id join movimientos m on m.cuenta_id = cu.cuenta_id where c.cliente_id = ?1 and m.fecha between ?2 and ?3", nativeQuery = true)
    List<ReporteObjeto> findByClienteAndFecha(Integer cliente_id, String fecha_inicio, String fecha_fin);
}
