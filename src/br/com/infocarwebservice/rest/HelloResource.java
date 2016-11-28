/*
 * InfoCarWebService 1.0 28 de nov de 2016
 * 
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.infocarwebservice.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

/**
 * 
 *
 * @author Augusto dos Santos
 * @version 1.0 28 de nov de 2016
 */
@Path("/hello")
public class HelloResource {

	@GET
	public String get() {
		return "HTTP GET";
	}
	
	@POST
	public String post() {
		return "HTTP POST";
	}
	
	@PUT
	public String put() {
		return "HTTP PUT";
	}
	
	@DELETE
	public String delete() {
		return "HTTP DELETE";
	}
}
