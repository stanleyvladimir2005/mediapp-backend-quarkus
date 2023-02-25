package com.mitocode.serviceImpl;

import com.mitocode.model.Specialty;
import com.mitocode.repo.ISpecialtyRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.ISpecialtyService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SpecialtyServiceImpl extends CRUDImpl<Specialty,Integer> implements ISpecialtyService {

	@Inject
	ISpecialtyRepo repo;

	@Override
	protected IGenericRepo<Specialty, Integer> getRepo() {
		return repo;
	}
}