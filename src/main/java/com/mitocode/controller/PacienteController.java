package com.mitocode.controller;

import com.mitocode.model.Paciente;
import com.mitocode.service.IPacienteService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/v1/pacientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PacienteController {

    @Inject
    IPacienteService service;

    @GET
    public List<Paciente> listar() {
       return service.listar();
    }

    @GET
    @Path("/{id}")
    public Paciente listarPorId(@PathParam("id") Integer id) throws Exception {
      Paciente paciente = service.listarPorId(id);
      if (paciente == null)
         throw new Exception("ID: " +id);
      return paciente;
    }

    @POST
    public Response registrar(Paciente pac) {
       service.registrar(pac);
       return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Integer id) throws Exception {
       Paciente paciente = service.listarPorId(id);
       if (paciente == null)
          throw new Exception("ID: " +id);
       else
          service.eliminar(id);
       return Response.ok().build();
    }

    @PUT
    public Response modificar(Paciente pac) {
       service.modificar(pac);
       return Response.ok().build();
    }
}