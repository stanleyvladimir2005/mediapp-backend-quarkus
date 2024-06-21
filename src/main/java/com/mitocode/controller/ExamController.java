package com.mitocode.controller;

import com.mitocode.model.Exam;
import com.mitocode.service.IExamService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.val;
import java.util.List;

@Path("/v1/exams")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExamController {

	@Inject
	IExamService examService;

	@GET
	public List<Exam> findAll() {
		return examService.findAll();
	}

	@GET
	@Path("/{id}")
	public Exam findById(@PathParam("id") Integer id) throws Exception {
		val exam = examService.findById(id);
		if (exam == null)
			throw new Exception("ID: " +id);
		return exam;
	}

	@POST
	public Response save(Exam exa) {
		examService.save(exa);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Integer id) throws Exception {
		val exam = examService.findById(id);
		if (exam == null)
			throw new Exception("ID: " +id);
		else
			examService.delete(id);
		return Response.ok().build();
	}

	@PUT
	public Response update(Exam exa) {
		examService.update(exa);
		return Response.ok().build();
	}
}