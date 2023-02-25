package com.mitocode.controller;

import com.mitocode.model.Medic;
import com.mitocode.service.IMedicService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/v1/medics")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MedicController {
	
	@Inject
	IMedicService service;

	@GET
	public List<Medic> findAll() {
		return service.findAll();
	}

	@GET
	@Path("/{id}")
	public Medic C(@PathParam("id") Integer id) throws Exception {
		Medic medic = service.findById(id);
		if (medic == null)
			throw new Exception("ID: " +id);
		return medic;
	}

	@POST
	public Response save(Medic med) {
		service.save (med);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Integer id) throws Exception {
		Medic medic = service.findById(id);
		if (medic == null)
			throw new Exception("ID: " +id);
		else
			service.delete(id);
		return Response.ok().build();
	}

	@PUT
	public Response update(Medic med) {
		service.update(med);
		return Response.ok().build();
	}
}