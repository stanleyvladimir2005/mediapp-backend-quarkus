package com.mitocode.serviceImpl;

import com.mitocode.dto.ConsultProductDTO;
import com.mitocode.dto.FilterConsultDTO;
import com.mitocode.model.Consult;
import com.mitocode.repo.IConsultRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.IConsultService;
import org.springframework.stereotype.Service;
import jakarta.inject.Inject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultServiceImpl extends CRUDImpl<Consult,Integer>  implements IConsultService {

	@Inject
	IConsultRepo repo;

	@Override
	protected IGenericRepo<Consult, Integer> getRepo() {
		return repo;
	}

	@Override
	public List<Consult> listExamByConsult(Integer idConsult) {
		return repo.listExamByConsult(idConsult);
	}

	@Override
	public List<Consult> search(FilterConsultDTO filter) {
		return repo.search(filter.getDui(), filter.getFullName());
	}

	@Override
	public List<Consult> searchByDate(FilterConsultDTO filter) {
		LocalDateTime dateNext = filter.getConsultDate().plusDays(1);
		return repo.searchByDate(filter.getConsultDate(), dateNext);
	}

	@Override
	public List<ConsultProductDTO> listProduct() {
		List<ConsultProductDTO> consults = new ArrayList<>();
		repo.listProducts().forEach( x -> {
			ConsultProductDTO cr = new ConsultProductDTO();
			cr.setQuantity(Integer.parseInt(String.valueOf(x[0])));
			cr.setConsultDate(String.valueOf(x[1]));
			consults.add(cr);
		});
		return consults;
	}
}