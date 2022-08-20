package com.example.devsuproyect.service;

import com.example.devsuproyect.dto.ReporteDTO;
import com.example.devsuproyect.exceptions.EntityNotFoundException;
import com.example.devsuproyect.exceptions.InvalidIdException;
import com.example.devsuproyect.models.Reportes;
import com.example.devsuproyect.repository.ReporteObjeto;
import com.example.devsuproyect.repository.ReporteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReporteService {

    private final ReporteRepository reporteRepository;

    @Autowired
    public ReporteService(ReporteRepository reporteRepository) {
        this.reporteRepository = reporteRepository;
    }
    @Autowired
    public ObjectMapper mapper;

    private final String ENTITY_NOT_FOUND_MESSAGE = "No se encontro el reporte con el id indicado";

    public List<ReporteDTO> getReporte (Integer clienteId, String fecha1, String fecha2) {
        List<ReporteObjeto> reportesDTO = reporteRepository.findByClienteAndFecha(clienteId, fecha1, fecha2);
        return reportesDTO.stream().map(this::mapDTOReporte).collect(Collectors.toList());
    }



    ///-----Mapper-----//
    public ReporteDTO mapDTO(Reportes reporte) {
        return mapper.convertValue(reporte, ReporteDTO.class);
    }
    public Reportes mapEntity(ReporteDTO reporteDTO) {
        return mapper.convertValue(reporteDTO, Reportes.class);
    }
    public ReporteDTO mapDTOReporte(ReporteObjeto reporte) {
        return new ReporteDTO(reporte.getFecha(), reporte.getNombre(),reporte.getNumeroCuenta(),reporte.getTipoCuenta(),reporte.getSaldoInicial(),reporte.getEstado(),reporte.getValor());
    }

}
