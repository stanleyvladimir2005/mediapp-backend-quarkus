package com.mitocode.serviceImpl;

import com.mitocode.model.Paciente;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IPacienteRepo;
import com.mitocode.service.IPacienteService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PacienteServiceImpl extends CRUDImpl<Paciente, Integer> implements IPacienteService {

    @Inject
    IPacienteRepo repo;

    @Override
    protected IGenericRepo<Paciente, Integer> getRepo() {
        return repo;
    }
}