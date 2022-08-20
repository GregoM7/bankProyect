package com.example.devsuproyect.service;

import com.example.devsuproyect.dto.ClienteDTO;
import com.example.devsuproyect.exceptions.EntityNotFoundException;
import com.example.devsuproyect.exceptions.InvalidIdException;
import com.example.devsuproyect.models.Cliente;
import com.example.devsuproyect.repository.ClienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    @Autowired
    public ObjectMapper mapper;

    public static final String ENTITY_NOT_FOUND_MESSAGE = "No se encontro el cliente con el id indicado";

    public ClienteDTO findById(Integer id) {
        if(id==null || id <= 0) throw new InvalidIdException();
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(ENTITY_NOT_FOUND_MESSAGE));
        return mapDTO(cliente);
    }
    public ClienteDTO create(ClienteDTO clienteDTO) {
        Cliente cliente = mapEntity(clienteDTO);
        Cliente newcliente = clienteRepository.save(cliente);
        return mapDTO(newcliente);
    }
    public void deleteById(Integer id) {
        if(id==null || id <= 0) throw new InvalidIdException();
        clienteRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(ENTITY_NOT_FOUND_MESSAGE));
        clienteRepository.deleteById(id);
    }
    public ClienteDTO update(ClienteDTO clienteDTO) {
        int id = clienteDTO.getClienteId();
        if(id <= 0) throw new InvalidIdException();
        clienteRepository.findById(clienteDTO.getClienteId())
                .orElseThrow(()-> new EntityNotFoundException(ENTITY_NOT_FOUND_MESSAGE));
        Cliente clientesave = clienteRepository.save(mapEntity(clienteDTO));
        return mapDTO(clientesave);
    }
    public List<ClienteDTO> findAll() {
        return clienteRepository.findAll().stream().map(this::mapDTO).collect(Collectors.toList());
    }



    //-----Mapper-----
    public Cliente mapEntity(ClienteDTO clienteDTO) {
        return mapper.convertValue(clienteDTO, Cliente.class);
    }
    public ClienteDTO mapDTO(Cliente cliente) {
        return mapper.convertValue(cliente, ClienteDTO.class);
    }
}
