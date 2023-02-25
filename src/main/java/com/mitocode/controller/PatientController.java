package com.mitocode.controller;

import com.mitocode.model.Patient;
import com.mitocode.service.IPatientService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/v1/patients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PatientController {

    @Inject
    IPatientService service;

    @GET
    public List<Patient> findAll() {
       return service.findAll();
    }

    @GET
    @Path("/{id}")
    public Patient findById(@PathParam("id") Integer id) throws Exception {
      Patient paciente = service.findById(id);
      if (paciente == null)
         throw new Exception("ID: " +id);
      return paciente;
    }

    @POST
    public Response save (Patient pac) {
       service.save(pac);
       return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id) throws Exception {
       Patient paciente = service.findById(id);
       if (paciente == null)
          throw new Exception("ID: " +id);
       else
          service.delete(id);
       return Response.ok().build();
    }

    @PUT
    public Response update(Patient pac) {
       service.update(pac);
       return Response.ok().build();
    }
}