package com.mitocode.serviceImpl;

import com.mitocode.model.Patient;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IPatientRepo;
import com.mitocode.service.IPatientService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PatientServiceImpl extends CRUDImpl<Patient, Integer> implements IPatientService {

    @Inject
    IPatientRepo repo;

    @Override
    protected IGenericRepo<Patient, Integer> getRepo() {
        return repo;
    }
}