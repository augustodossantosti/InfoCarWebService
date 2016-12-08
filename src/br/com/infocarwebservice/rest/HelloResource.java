/*
 * InfoCarWebService 1.0 28 de nov de 2016
 * 
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.infocarwebservice.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.infocarwebservice.domain.Response;

/**
 * 
 *
 * @author Augusto dos Santos
 * @version 1.0 28 de nov de 2016
 */
@Path("/hello")
public class HelloResource {

	@GET
	@Consumes(MediaType.TEXT_HTML)
	@Produces(MediaType.TEXT_HTML+ ";charset=utf-8")
	public String helloHTML() {
		return "<b>Olá Mundo HTML!</b>";
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String helloTextPlain() {
		return "Olá mundo Texto!";
	}
	
	@GET
	@Consumes({MediaType.APPLICATION_XML, MediaType.TEXT_XML})
	@Produces({MediaType.APPLICATION_XML, MediaType.TEXT_XML})
	public Response helloXML() {
		return Response.Ok("Olá mundo XML!");
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response helloJson() {
		return Response.Ok("Olá mundo JSON!");
	}
	
}
