package com.mitocode.controller;

import com.mitocode.dto.FilterConsultDTO;
import com.mitocode.model.Consult;
import com.mitocode.service.IFileMediaService;
import com.mitocode.service.IConsultService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.val;
import java.util.List;

@Path("/v1/consults")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConsultController {
	
	@Inject
	IConsultService consultService;

	@Inject
	IFileMediaService fileService;

    @GET
	public List<Consult> findAll() {
		return consultService.findAll();
	}

	@GET
	@Path("/{id}")
	public Consult findById(@PathParam("id") Integer id) throws Exception {
		val consults = consultService.findById(id);
		if (consults == null)
			throw new Exception("ID: " + id);
		return consults;
	}

	@POST
	public Response save(Consult consults) {
		consultService.save(consults);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Integer id) throws Exception {
		val consults = consultService.findById(id);
		if (consults == null)
			throw new Exception("ID: " +id);
		else
			consultService.delete(id);
		return Response.ok().build();
	}

	@PUT
	public Response update(Consult consults) {
		consultService.update(consults);
		return Response.ok().build();
	}

	@POST
	@Path("/search")
	public Response search(FilterConsultDTO filter) {
		List<Consult> consults = null;
		if (filter != null)
            consults = (filter.getConsultDate() != null) ? consultService.searchByDate(filter) : consultService.search(filter);

		return Response.ok(consults).build();
	}

	@GET
	@Path("/listProduct")
	public Response listProduct() {
		val consults  = consultService.listProduct();
		return Response.ok(consults).build();
	}

	@GET
	@Path("/readFile/{idFile}")
	public Response leerArchivo(@PathParam("idFile") Integer idFileMedia) {
		val arr = fileService.findById(idFileMedia).getValue();
		return Response.ok(arr).build();
	}
}