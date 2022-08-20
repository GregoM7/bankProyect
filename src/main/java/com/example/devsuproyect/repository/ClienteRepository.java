package com.example.devsuproyect.repository;

import com.example.devsuproyect.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    //@Query(value = "Select * from cliente as c join cuenta cu on cu.cliente_id = c.cliente_id join cuenta_x_movimientos cm on cm.cuenta_id = cu.cuenta_id join movimientos m on cm.movimiento_id = m.movimiento_id where c.cliente_id =  and m.fecha between  and ", nativeQuery = true)
}

