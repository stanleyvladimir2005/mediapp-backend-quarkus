package com.mitocode.controller;

import com.mitocode.model.Exam;
import com.mitocode.service.IExamService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/v1/exams")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExamController {

	@Inject
	IExamService service;

	@GET
	public List<Exam> findAll() {
		return service.findAll();
	}

	@GET
	@Path("/{id}")
	public Exam findById(@PathParam("id") Integer id) throws Exception {
		Exam exam = service.findById(id);
		if (exam == null)
			throw new Exception("ID: " +id);
		return exam;
	}

	@POST
	public Response save(Exam exa) {
		service.save(exa);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Integer id) throws Exception {
		Exam exam = service.findById(id);
		if (exam == null)
			throw new Exception("ID: " +id);
		else
			service.delete(id);
		return Response.ok().build();
	}

	@PUT
	public Response update(Exam exa) {
		service.update(exa);
		return Response.ok().build();
	}
}