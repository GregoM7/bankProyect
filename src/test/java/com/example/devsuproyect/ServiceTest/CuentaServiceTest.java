package com.example.devsuproyect.ServiceTest;

import com.example.devsuproyect.dto.ClienteDTO;
import com.example.devsuproyect.dto.CuentaDTO;
import com.example.devsuproyect.dto.ReporteDTO;
import com.example.devsuproyect.exceptions.EntityNotFoundException;
import com.example.devsuproyect.models.Cliente;
import com.example.devsuproyect.models.Cuenta;
import com.example.devsuproyect.models.Reportes;
import com.example.devsuproyect.service.ClienteService;
import com.example.devsuproyect.service.CuentaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CuentaServiceTest {

    public CuentaService cuentaService;
    public ClienteService clienteService;
    @Autowired
    public ObjectMapper mapper;
    @Autowired
    public void setCuentaService(CuentaService cuentaService, ClienteService clienteService) {
        this.cuentaService = cuentaService;
        this.clienteService = clienteService;
    }
    private Cliente cliente;


    @BeforeAll
    void setUp() {
        ClienteDTO clienteDTO = new ClienteDTO("Jose Perez","Masculino",25,302450,"calle3",234553,"1234",true);
        cliente = mapEntity(clienteService.create(clienteDTO));
        System.out.println(cliente.getClienteId());
        assertNotNull(cliente);
        assertTrue(cliente.getClienteId() > 0);
    }
    @Test
    void create() {
        CuentaDTO cuentaDTO = new CuentaDTO(2134,"Ahorro",1000,true,cliente);
        cuentaDTO = cuentaService.create(cuentaDTO);
        assertNotNull(cuentaDTO);
        assertTrue(cuentaDTO.getCuentaId() > 0);
    }
    @Test
    void deleteById() {
        CuentaDTO cuentaDTO= new CuentaDTO(2134,"Ahorro",1000,true,cliente);
        cuentaDTO=cuentaService.create(cuentaDTO);
        assertNotNull(cuentaDTO);
        cuentaService.deleteById(cuentaDTO.getCuentaId());
        CuentaDTO dt= null;
        try {
            dt = cuentaService.findById(cuentaDTO.getCuentaId());
        }
        catch (Exception e){
            assertTrue(e.getMessage().contains(CuentaService.ENTITY_NOT_FOUND_MESSAGE));
        }
        assertNull(dt);
    }


    //--Mappers--//

    public Cliente mapEntity(ClienteDTO clienteDTO) {
        return mapper.convertValue(clienteDTO, Cliente.class);
    }
}
