package com.mitocode.service;

import com.mitocode.dto.ConsultaResumenDTO;
import com.mitocode.dto.FiltroConsultaDTO;
import com.mitocode.model.Consulta;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IConsultaService extends ICRUD <Consulta, Integer> {

    List<Consulta> listarExamenesPorConsulta(@Param("idConsulta") Integer idConsulta);

    List<Consulta> buscar(FiltroConsultaDTO filtro);

    List<Consulta> buscarFecha(FiltroConsultaDTO filtro);

    List<ConsultaResumenDTO> listarResumen();

    byte[] generarReporte() throws Exception ;

}