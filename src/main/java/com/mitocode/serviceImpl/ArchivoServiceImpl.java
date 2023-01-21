package com.mitocode.serviceImpl;

import com.mitocode.model.Archivo;
import com.mitocode.repo.IArchivoRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.IArchivoService;
import org.springframework.stereotype.Service;
import javax.inject.Inject;

@Service
public class ArchivoServiceImpl extends CRUDImpl<Archivo, Integer> implements IArchivoService{

	@Inject
	IArchivoRepo repo;

	@Override
	protected IGenericRepo<Archivo, Integer> getRepo(){	return repo;}
}