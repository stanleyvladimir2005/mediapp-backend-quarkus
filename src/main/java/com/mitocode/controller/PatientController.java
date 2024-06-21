package com.mitocode.controller;

import com.mitocode.model.Patient;
import com.mitocode.service.IPatientService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.val;

import java.util.List;

@Path("/v1/patients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PatientController {

    @Inject
    IPatientService patientService;

    @GET
    public List<Patient> findAll() {
       return patientService.findAll();
    }

    @GET
    @Path("/{id}")
    public Patient findById(@PathParam("id") Integer id) throws Exception {
        val patient = patientService.findById(id);
      if (patient == null)
         throw new Exception("ID: " +id);
      return patient;
    }

    @POST
    public Response save (Patient pac) {
       patientService.save(pac);
       return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id) throws Exception {
       val patient = patientService.findById(id);
       if (patient == null)
          throw new Exception("ID: " +id);
       else
           patientService.delete(id);
       return Response.ok().build();
    }

    @PUT
    public Response update(Patient pac) {
       patientService.update(pac);
       return Response.ok().build();
    }
}