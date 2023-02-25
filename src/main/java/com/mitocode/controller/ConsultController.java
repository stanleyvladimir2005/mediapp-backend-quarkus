package com.mitocode.controller;

import com.mitocode.dto.ConsultProductDTO;
import com.mitocode.dto.FilterConsultDTO;
import com.mitocode.model.Consult;
import com.mitocode.service.IFileMediaService;
import com.mitocode.service.IConsultService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/v1/consults")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConsultController {
	
	@Inject
	IConsultService service;

	@Inject
	IFileMediaService fileService;

    @GET
	public List<Consult> findAll() {
		return service.findAll();
	}

	@GET
	@Path("/{id}")
	public Consult findById(@PathParam("id") Integer id) throws Exception {
		Consult consults = service.findById(id);
		if (consults == null)
			throw new Exception("ID: " + id);
		return consults;
	}

	@POST
	public Response save(Consult consults) {
		service.save(consults);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Integer id) throws Exception {
		Consult consults = service.findById(id);
		if (consults == null)
			throw new Exception("ID: " +id);
		else
			service.delete(id);
		return Response.ok().build();
	}

	@PUT
	public Response update(Consult consults) {
		service.update(consults);
		return Response.ok().build();
	}

	@POST
	@Path("/search")
	public Response search(FilterConsultDTO filter) {
		List<Consult> consults = null;

		if (filter != null) {
			if (filter.getConsultDate() != null)
				consults = service.searchByDate(filter);
			else
				consults = service.search(filter);
		}
		return Response.ok(consults).build();
	}

	@GET
	@Path("/listProduct")
	public Response listProduct() {
		List<ConsultProductDTO> consults  = service.listProduct();
		return Response.ok(consults).build();
	}

	@GET
	@Path("/readFile/{idFile}")
	public Response leerArchivo(@PathParam("idFile") Integer idFileMedia) {
		byte[] arr = fileService.findById(idFileMedia).getValue();
		return Response.ok(arr).build();
	}
}