package com.example.devsuproyect.controller;

import com.example.devsuproyect.dto.ClienteDTO;
import com.example.devsuproyect.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;
    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("{clienteId}")
    public ClienteDTO getCliente(@PathVariable("clienteId") Integer clienteId) {
        return clienteService.findById(clienteId);
    }
    @PostMapping()
    public ClienteDTO postCliente(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.create(clienteDTO);
    }
    @PutMapping()
    public ClienteDTO putCliente(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.update(clienteDTO);
    }
    @DeleteMapping("/{clienteId}")
    public ResponseEntity<String> deleteCliente(@PathVariable("clienteId") Integer clienteId) {
        clienteService.deleteById(clienteId);
        return ResponseEntity.ok("Cliente eliminado");
    }

    @GetMapping()
    public List<ClienteDTO> getAllClientes() {
        return clienteService.findAll();
    }
}
