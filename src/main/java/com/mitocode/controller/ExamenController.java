package com.mitocode.controller;

import com.mitocode.model.Examen;
import com.mitocode.service.IExamenService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/v1/examenes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExamenController {

	@Inject
	IExamenService service;

	@GET
	public List<Examen> listar() {
		return service.listar();
	}

	@GET
	@Path("/{id}")
	public Examen listarPorId(@PathParam("id") Integer id) throws Exception {
		Examen examen = service.listarPorId(id);
		if (examen == null)
			throw new Exception("ID: " +id);
		return examen;
	}

	@POST
	public Response registrar(Examen exa) {
		service.registrar(exa);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response eliminar(@PathParam("id") Integer id) throws Exception {
		Examen examen = service.listarPorId(id);
		if (examen == null)
			throw new Exception("ID: " +id);
		else
			service.eliminar(id);
		return Response.ok().build();
	}

	@PUT
	public Response modificar(Examen exa) {
		service.modificar(exa);
		return Response.ok().build();
	}
}