package com.mitocode.controller;

import com.mitocode.model.Specialty;
import com.mitocode.service.ISpecialtyService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/v1/specialtys")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SpecialtyController {

	@Inject
	ISpecialtyService service;

	@GET
	public List<Specialty> findAll() {
		return service.findAll();
	}

	@GET
	@Path("/{id}")
	public Specialty findById(@PathParam("id") Integer id) throws Exception {
		Specialty especialidad = service.findById(id);
		if (especialidad == null)
			throw new Exception("ID: " +id);
		return especialidad;
	}

	@POST
	public Response save(Specialty esp) {
		service.save(esp);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Integer id) throws Exception {
		Specialty especialidad = service.findById(id);
		if (especialidad == null)
			throw new Exception("ID: " +id);
		else
			service.delete(id);
		return Response.ok().build();
	}

	@PUT
	public Response update(Specialty esp) {
		service.update(esp);
		return Response.ok().build();
	}
}