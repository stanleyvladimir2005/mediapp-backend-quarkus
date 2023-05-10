package com.mitocode.serviceImpl;

import com.mitocode.model.FileMedia;
import com.mitocode.repo.IMediaFileRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.IFileMediaService;
import org.springframework.stereotype.Service;
import jakarta.inject.Inject;

@Service
public class FileMediaServiceImpl extends CRUDImpl<FileMedia, Integer> implements IFileMediaService {

	@Inject
	IMediaFileRepo repo;

	@Override
	protected IGenericRepo<FileMedia, Integer> getRepo(){	return repo;}
}