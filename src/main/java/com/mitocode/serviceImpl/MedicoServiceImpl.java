package com.mitocode.serviceImpl;

import com.mitocode.model.Medico;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IMedicoRepo;
import com.mitocode.service.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoServiceImpl extends CRUDImpl<Medico, Integer>implements IMedicoService{

	@Autowired
	IMedicoRepo repo;

	@Override
	protected IGenericRepo<Medico, Integer> getRepo() {
		return repo;
	}
}