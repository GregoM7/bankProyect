package com.example.devsuproyect.service;

import com.example.devsuproyect.dto.MovimientosDTO;
import com.example.devsuproyect.exceptions.EntityNotFoundException;
import com.example.devsuproyect.exceptions.InvalidIdException;
import com.example.devsuproyect.models.Movimientos;
import com.example.devsuproyect.repository.MovimientosRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class MovimientosService {

    private final MovimientosRepository movimientosRepository;

    @Autowired
    public MovimientosService(MovimientosRepository movimientosRepository) {
        this.movimientosRepository = movimientosRepository;
    }
    @Autowired
    public ObjectMapper mapper;

    private final String ENTITY_NOT_FOUND_MESSAGE = "No se encontro el movimiento con el id indicado";

    public MovimientosDTO findById(Integer id) {
        if(id==null || id <= 0) throw new InvalidIdException();
        Movimientos movimientos = movimientosRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(ENTITY_NOT_FOUND_MESSAGE));
        return mapDTO(movimientos);
    }
    public MovimientosDTO create(MovimientosDTO movimientosDTO) {
        if(movimientosDTO.getTipoMovimiento().toLowerCase().equals("debito")){
            movimientosDTO.setValor(-movimientosDTO.getValor());
        }
        Movimientos movimientos = mapEntity(movimientosDTO);
        Movimientos newmovimientos = movimientosRepository.save(movimientos);
        return mapDTO(newmovimientos);
    }
    public void deleteById(Integer id) {
        if(id==null || id <= 0) throw new InvalidIdException();
        movimientosRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(ENTITY_NOT_FOUND_MESSAGE));
        movimientosRepository.deleteById(id);
        System.out.println("Movimiento Eliminado");
    }
    public MovimientosDTO update(MovimientosDTO movimientosDTO) {
        int id = movimientosDTO.getMovimientoId();
        if(id <= 0) throw new InvalidIdException();
        movimientosRepository.findById(movimientosDTO.getMovimientoId())
                .orElseThrow(()-> new EntityNotFoundException(ENTITY_NOT_FOUND_MESSAGE));
        Movimientos movimientossave = movimientosRepository.save(mapEntity(movimientosDTO));
        return mapDTO(movimientossave);
    }
    public List<MovimientosDTO> findAll() {
        return movimientosRepository.findAll().stream().map(this::mapDTO).collect(java.util.stream.Collectors.toList());
    }



    //-----Mapper-----//
    public Movimientos mapEntity(MovimientosDTO movimientosDTO) {
        return mapper.convertValue(movimientosDTO, Movimientos.class);
    }
    public MovimientosDTO mapDTO(Movimientos movimientos) {
        return mapper.convertValue(movimientos, MovimientosDTO.class);
    }
}
