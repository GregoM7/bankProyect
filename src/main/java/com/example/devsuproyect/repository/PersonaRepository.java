package com.example.devsuproyect.repository;

import com.example.devsuproyect.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

}
