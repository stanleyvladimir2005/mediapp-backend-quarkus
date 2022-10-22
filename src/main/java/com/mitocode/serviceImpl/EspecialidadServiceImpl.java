package com.mitocode.serviceImpl;

import com.mitocode.model.Especialidad;
import com.mitocode.repo.IEspecialidadRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.IEspecialidadService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class EspecialidadServiceImpl extends CRUDImpl<Especialidad,Integer> implements IEspecialidadService {

	@Inject
	IEspecialidadRepo repo;
	
	@Override
	protected IGenericRepo<Especialidad, Integer> getRepo() {
		return repo;
	}
}