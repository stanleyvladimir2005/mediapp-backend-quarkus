package com.mitocode.serviceImpl;

import com.mitocode.model.Exam;
import com.mitocode.repo.IExamRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.IExamService;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class ExamServiceImpl extends CRUDImpl<Exam, Integer> implements IExamService {

	@Inject
	IExamRepo repo;

	@Override
	protected IGenericRepo<Exam, Integer> getRepo() {
		return repo;
	}
}