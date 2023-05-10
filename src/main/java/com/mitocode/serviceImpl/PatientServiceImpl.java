package com.mitocode.serviceImpl;

import com.mitocode.model.Patient;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IPatientRepo;
import com.mitocode.service.IPatientService;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl extends CRUDImpl<Patient, Integer> implements IPatientService {

    @Inject
    IPatientRepo repo;

    @Override
    protected IGenericRepo<Patient, Integer> getRepo() {
        return repo;
    }
}