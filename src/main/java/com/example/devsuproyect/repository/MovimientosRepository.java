package com.example.devsuproyect.repository;

import com.example.devsuproyect.models.Movimientos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientosRepository extends JpaRepository<Movimientos, Integer> {

}

