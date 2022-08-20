package com.example.devsuproyect.ServiceTest;

import com.example.devsuproyect.dto.ClienteDTO;
import com.example.devsuproyect.dto.CuentaDTO;
import com.example.devsuproyect.models.Cliente;
import com.example.devsuproyect.service.ClienteService;
import com.example.devsuproyect.service.CuentaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class ClienteServiceTest {
    public ClienteService clienteService;
    @Autowired
    public ObjectMapper mapper;
    @Autowired
    public void setclienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Test
    void create() {
        ClienteDTO clienteDTO = new ClienteDTO("Jose Perez","Masculino",25,302450,"calle3",234553,"1234",true);
        ClienteDTO newCliente =clienteService.create(clienteDTO);
        assertNotNull(newCliente);
        assertTrue(newCliente.getClienteId() > 0);
    }
    @Test
    void deleteById() {
        ClienteDTO clienteDTO= new ClienteDTO("Jose Perez","Masculino",25,302450,"calle3",234553,"1234",true);
        clienteDTO=clienteService.create(clienteDTO);
        assertNotNull(clienteDTO);
        clienteService.deleteById(clienteDTO.getClienteId());
        ClienteDTO dt= null;
        try {
            dt = clienteService.findById(clienteDTO.getClienteId());
        }
        catch (Exception e){
            assertTrue(e.getMessage().contains(clienteService.ENTITY_NOT_FOUND_MESSAGE));
        }
        assertNull(dt);
    }
}
