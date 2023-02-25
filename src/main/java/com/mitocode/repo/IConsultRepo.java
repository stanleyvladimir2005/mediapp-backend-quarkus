package com.mitocode.repo;

import com.mitocode.model.Consult;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IConsultRepo extends IGenericRepo <Consult, Integer> {
    @Query("from ConsultExam ce where ce.consult.idConsult = :idConsult")
    List<Consult> listExamByConsult(@Param("idConsult") Integer idConsult);

    @Query("from Consult c where c.patient.dui =:dui or LOWER(c.patient.firstName) like %:fullName% or LOWER(c.patient.lastName) like %:fullName%")
    List<Consult> search(@Param("dui")String dui, @Param("fullName") String fullName);

    @Query("from Consult c where c.consultDate between :consultDate and :dateNext")
    List<Consult> searchByDate(@Param("consultDate") LocalDateTime consultDate, @Param("dateNext") LocalDateTime dateNext);

    @Query(value = "from fn_list()")
    List<Object[]> listProducts();
}