package com.mitocode.controller;

import com.mitocode.model.Specialty;
import com.mitocode.service.ISpecialtyService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.val;

import java.util.List;

@Path("/v1/specialtys")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SpecialtyController {

	@Inject
	ISpecialtyService specialtyService;

	@GET
	public List<Specialty> findAll() {
		return specialtyService.findAll();
	}

	@GET
	@Path("/{id}")
	public Specialty findById(@PathParam("id") Integer id) throws Exception {
		val specialty = specialtyService.findById(id);
		if (specialty == null)
			throw new Exception("ID: " +id);
		return specialty;
	}

	@POST
	public Response save(Specialty esp) {
		specialtyService.save(esp);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Integer id) throws Exception {
		Specialty specialty = specialtyService.findById(id);
		if (specialty == null)
			throw new Exception("ID: " +id);
		else
			specialtyService.delete(id);
		return Response.ok().build();
	}

	@PUT
	public Response update(Specialty esp) {
		specialtyService.update(esp);
		return Response.ok().build();
	}
}