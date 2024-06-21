package com.mitocode.serviceImpl;

import com.mitocode.dto.ConsultProductDTO;
import com.mitocode.dto.FilterConsultDTO;
import com.mitocode.model.Consult;
import com.mitocode.repo.IConsultRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.IConsultService;
import lombok.val;
import org.springframework.stereotype.Service;
import jakarta.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultServiceImpl extends CRUDImpl<Consult,Integer>  implements IConsultService {

	@Inject
	IConsultRepo consultRepo;

	@Override
	protected IGenericRepo<Consult, Integer> getRepo() {
		return consultRepo;
	}

	@Override
	public List<Consult> listExamByConsult(Integer idConsult) {
		return consultRepo.listExamByConsult(idConsult);
	}

	@Override
	public List<Consult> search(FilterConsultDTO filter) {
		return consultRepo.search(filter.getDui(), filter.getFullName());
	}

	@Override
	public List<Consult> searchByDate(FilterConsultDTO filter) {
		val dateNext = filter.getConsultDate().plusDays(1);
		return consultRepo.searchByDate(filter.getConsultDate(), dateNext);
	}

	@Override
	public List<ConsultProductDTO> listProduct() {
		List<ConsultProductDTO> consults = new ArrayList<>();
		consultRepo.listProducts().forEach( x -> {
			val consultProductDTO = new ConsultProductDTO();
			consultProductDTO.setQuantity(Integer.parseInt(String.valueOf(x[0])));
			consultProductDTO.setConsultDate(String.valueOf(x[1]));
			consults.add(consultProductDTO);
		});
		return consults;
	}
}