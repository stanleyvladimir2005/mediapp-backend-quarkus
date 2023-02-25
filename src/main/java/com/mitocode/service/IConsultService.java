package com.mitocode.service;

import com.mitocode.dto.ConsultProductDTO;
import com.mitocode.dto.FilterConsultDTO;
import com.mitocode.model.Consult;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface IConsultService extends ICRUD <Consult, Integer> {

    List<Consult> listExamByConsult(@Param("idConsult") Integer idConsult);

    List<Consult> search(FilterConsultDTO filter);

    List<Consult> searchByDate(FilterConsultDTO filter);

    List<ConsultProductDTO> listProduct();

    byte[] generateReport() throws Exception ;

}