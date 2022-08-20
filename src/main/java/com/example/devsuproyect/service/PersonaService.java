package com.example.devsuproyect.service;

import com.example.devsuproyect.dto.PersonaDTO;
import com.example.devsuproyect.exceptions.EntityNotFoundException;
import com.example.devsuproyect.exceptions.InvalidIdException;
import com.example.devsuproyect.models.Persona;
import com.example.devsuproyect.repository.PersonaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaService {

    private PersonaRepository personaRepository;
    @Autowired
    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }
    @Autowired
    public ObjectMapper mapper;

    private final String ENTITY_NOT_FOUND_MESSAGE = "No se encontro la persona con el id indicado";

    public PersonaDTO findById(Integer id) {
        if(id==null || id <= 0) throw new InvalidIdException();
        Persona persona = personaRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(ENTITY_NOT_FOUND_MESSAGE));
        return mapDTO(persona);
    }
    public PersonaDTO create(PersonaDTO personaDTO) {
        Persona persona = mapEntity(personaDTO);
        Persona newpersona = personaRepository.save(persona);
        return mapDTO(newpersona);
    }
    public void deleteById(Integer id) {
        if(id==null || id <= 0) throw new InvalidIdException();
        personaRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(ENTITY_NOT_FOUND_MESSAGE));
        personaRepository.deleteById(id);
        System.out.println("Persona Eliminada");
    }
    public PersonaDTO update(PersonaDTO personaDTO) {
        int id = personaDTO.getId();
        if(id <= 0) throw new InvalidIdException();
        personaRepository.findById(personaDTO.getId())
                .orElseThrow(()-> new EntityNotFoundException(ENTITY_NOT_FOUND_MESSAGE));
        Persona personasave = personaRepository.save(mapEntity(personaDTO));
        return mapDTO(personasave);
    }
    public List<PersonaDTO> findAll() {
        return personaRepository.findAll().stream().map(this::mapDTO).collect(Collectors.toList());
    }

    //-----Mapper-----

    public Persona mapEntity(PersonaDTO personaDTO) {
    return mapper.convertValue(personaDTO, Persona.class);
    }
    public PersonaDTO mapDTO(Persona persona) {
        return mapper.convertValue(persona, PersonaDTO.class);
    }

}
