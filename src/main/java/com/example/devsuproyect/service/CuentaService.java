package com.example.devsuproyect.service;

import com.example.devsuproyect.dto.CuentaDTO;
import com.example.devsuproyect.exceptions.EntityNotFoundException;
import com.example.devsuproyect.exceptions.InvalidIdException;
import com.example.devsuproyect.models.Cuenta;
import com.example.devsuproyect.repository.CuentaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CuentaService {

    private final CuentaRepository cuentaRepository;

    @Autowired
    public CuentaService(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }
    @Autowired
    public ObjectMapper mapper;

    public static final String ENTITY_NOT_FOUND_MESSAGE = "No se encontro la cuenta con el id indicado";

    public CuentaDTO findById(Integer id) {
        if(id==null || id <= 0) throw new InvalidIdException();
        Cuenta cuenta = cuentaRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(ENTITY_NOT_FOUND_MESSAGE));
        return mapDTO(cuenta);
    }
    public CuentaDTO create(CuentaDTO cuentaDTO) {
        Cuenta cuenta = mapEntity(cuentaDTO);
        Cuenta newcuenta = cuentaRepository.save(cuenta);
        return mapDTO(newcuenta);
    }
    public void deleteById(Integer id) {
        if(id==null || id <= 0) throw new InvalidIdException();
        cuentaRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(ENTITY_NOT_FOUND_MESSAGE));
        cuentaRepository.deleteById(id);
        System.out.println("Cuenta Eliminada");
    }
    public CuentaDTO update(CuentaDTO cuentaDTO) {
        int id = cuentaDTO.getCuentaId();
        if(id <= 0) throw new InvalidIdException();
        cuentaRepository.findById(cuentaDTO.getCuentaId())
                .orElseThrow(()-> new EntityNotFoundException(ENTITY_NOT_FOUND_MESSAGE));
        Cuenta cuentasave = cuentaRepository.save(mapEntity(cuentaDTO));
        return mapDTO(cuentasave);
    }
    public List<CuentaDTO> findAll() {
        return cuentaRepository.findAll().stream().map(this::mapDTO).collect(Collectors.toList());
    }


    ///-----Mapper-----

    public Cuenta mapEntity(CuentaDTO cuentaDTO) {
        return mapper.convertValue(cuentaDTO, Cuenta.class);
    }

    public CuentaDTO mapDTO(Cuenta cuenta) {
        return mapper.convertValue(cuenta, CuentaDTO.class);
    }

}
