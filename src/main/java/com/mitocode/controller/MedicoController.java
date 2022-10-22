package com.mitocode.controller;

import com.mitocode.model.Medico;
import com.mitocode.service.IMedicoService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/v1/medicos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MedicoController {
	
	@Inject
	IMedicoService service;

	@GET
	public List<Medico> listar() {
		return service.listar();
	}

	@GET
	@Path("/{id}")
	public Medico listarPorId(@PathParam("id") Integer id) throws Exception {
		Medico medico = service.listarPorId(id);
		if (medico == null)
			throw new Exception("ID: " +id);
		return medico;
	}

	@POST
	public Response registrar(Medico med) {
		service.registrar(med);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response eliminar(@PathParam("id") Integer id) throws Exception {
		Medico medico = service.listarPorId(id);
		if (medico == null)
			throw new Exception("ID: " +id);
		else
			service.eliminar(id);
		return Response.ok().build();
	}

	@PUT
	public Response modificar(Medico med) {
		service.modificar(med);
		return Response.ok().build();
	}
}