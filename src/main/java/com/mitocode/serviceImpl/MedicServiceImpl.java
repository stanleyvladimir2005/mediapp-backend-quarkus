package com.mitocode.serviceImpl;

import com.mitocode.model.Medic;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IMedicRepo;
import com.mitocode.service.IMedicService;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class MedicServiceImpl extends CRUDImpl<Medic, Integer>implements IMedicService {

	@Inject
	IMedicRepo repo;

	@Override
	protected IGenericRepo<Medic, Integer> getRepo() {
		return repo;
	}
}