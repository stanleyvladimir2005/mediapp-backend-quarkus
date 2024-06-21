package com.mitocode.controller;

import com.mitocode.model.Medic;
import com.mitocode.service.IMedicService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.val;

import java.util.List;

@Path("/v1/medics")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MedicController {
	
	@Inject
	IMedicService medicService;

	@GET
	public List<Medic> findAll() {
		return medicService.findAll();
	}

	@GET
	@Path("/{id}")
	public Medic C(@PathParam("id") Integer id) throws Exception {
		val medic = medicService.findById(id);
		if (medic == null)
			throw new Exception("ID: " +id);
		return medic;
	}

	@POST
	public Response save(Medic med) {
		medicService.save (med);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Integer id) throws Exception {
		val medic = medicService.findById(id);
		if (medic == null)
			throw new Exception("ID: " +id);
		else
			medicService.delete(id);
		return Response.ok().build();
	}

	@PUT
	public Response update(Medic med) {
		medicService.update(med);
		return Response.ok().build();
	}
}