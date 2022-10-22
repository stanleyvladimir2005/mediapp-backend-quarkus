package com.mitocode.controller;

import com.mitocode.model.Especialidad;
import com.mitocode.service.IEspecialidadService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/v1/especialidades")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EspecialidadController {

	@Inject
	IEspecialidadService service;

	@GET
	public List<Especialidad> listar() {
		return service.listar();
	}

	@GET
	@Path("/{id}")
	public Especialidad listarPorId(@PathParam("id") Integer id) throws Exception {
		Especialidad especialidad = service.listarPorId(id);
		if (especialidad == null)
			throw new Exception("ID: " +id);
		return especialidad;
	}

	@POST
	public Response registrar(Especialidad esp) {
		service.registrar(esp);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response eliminar(@PathParam("id") Integer id) throws Exception {
		Especialidad especialidad = service.listarPorId(id);
		if (especialidad == null)
			throw new Exception("ID: " +id);
		else
			service.eliminar(id);
		return Response.ok().build();
	}

	@PUT
	public Response modificar(Especialidad esp) {
		service.modificar(esp);
		return Response.ok().build();
	}
}