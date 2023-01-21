package com.mitocode.controller;

import com.mitocode.dto.ConsultaResumenDTO;
import com.mitocode.dto.FiltroConsultaDTO;
import com.mitocode.model.Archivo;
import com.mitocode.model.Consulta;
import com.mitocode.service.IArchivoService;
import com.mitocode.service.IConsultaService;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@Path("/v1/consultas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConsultaController {
	
	@Inject
	IConsultaService service;

	@Inject
	IArchivoService serviceArchivo;

    @GET
	public List<Consulta> listar() {
		return service.listar();
	}

	@GET
	@Path("/{id}")
	public Consulta listarId(@PathParam("id") Integer id) throws Exception {
		Consulta consulta = service.listarPorId(id);
		if (consulta == null)
			throw new Exception("ID: " + id);
		return consulta;
	}

	@POST
	public Response registrar(Consulta consulta) {
		service.registrar(consulta);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response eliminar(@PathParam("id") Integer id) throws Exception {
		Consulta consulta = service.listarPorId(id);
		if (consulta == null)
			throw new Exception("ID: " +id);
		else
			service.eliminar(id);
		return Response.ok().build();
	}

	@PUT
	public Response modificar(Consulta consulta) {
		service.modificar(consulta);
		return Response.ok().build();
	}

	@POST
	@Path("/buscar")
	public Response buscar(FiltroConsultaDTO filtro) {
		List<Consulta> consultas = null;

		if (filtro != null) {
			if (filtro.getFechaConsulta() != null)
				consultas = service.buscarFecha(filtro);
			else
				consultas = service.buscar(filtro);
		}
		return Response.ok(consultas).build();
	}

	@GET
	@Path("/listarResumen")
	public Response listarResumen() {
		List<ConsultaResumenDTO> consultas  = service.listarResumen();
		return Response.ok(consultas).build();
	}

	@GET
	@Path("/generarReporte")
	public Response generarReporte() throws Exception {
		byte[] data = service.generarReporte();
		return  Response.ok(data).build();
	}

	@POST
	@Path("/guardarArchivo")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	public Response guardarArchivo(MultipartForm file) throws IOException {
		Archivo ar = new Archivo();
		/*ar.setFiletype(file.getContentType());
		ar.setFilename(file.getName());
		ar.setValue(file.getBytes());*/
		serviceArchivo.registrar(ar);
		return Response.ok().build();
	}

	@GET
	@Path("/leerArchivo/{idArchivo}")
	public Response leerArchivo(@PathParam("idArchivo") Integer idArchivo) {
		byte[] arr = serviceArchivo.listarPorId(idArchivo).getValue();
		return Response.ok(arr).build();
	}
}