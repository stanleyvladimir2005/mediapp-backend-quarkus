package com.mitocode.serviceImpl;

import com.mitocode.model.Examen;
import com.mitocode.repo.IExamenRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.IExamenService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ExamenServiceImpl extends CRUDImpl<Examen, Integer> implements IExamenService {

	@Inject
	IExamenRepo repo;

	@Override
	protected IGenericRepo<Examen, Integer> getRepo() {
		return repo;
	}
}