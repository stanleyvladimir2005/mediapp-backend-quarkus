package com.mitocode.serviceImpl;

import com.mitocode.model.Specialty;
import com.mitocode.repo.ISpecialtyRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.ISpecialtyService;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class SpecialtyServiceImpl extends CRUDImpl<Specialty,Integer> implements ISpecialtyService {

	@Inject
	ISpecialtyRepo repo;

	@Override
	protected IGenericRepo<Specialty, Integer> getRepo() {
		return repo;
	}
}