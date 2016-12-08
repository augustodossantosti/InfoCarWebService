/*
 * InfoCarWebService 1.0 8 de dez de 2016
 * 
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.infocarwebservice.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 *
 * @author Augusto dos Santos
 * @version 1.0 8 de dez de 2016
 */
@XmlRootElement
public class Response {
	
	private String status;
	private String msg;
	
	public static Response Ok(String msg) {
		Response response = new Response();
		response.setStatus("OK");
		response.setMsg(msg);
		return response;
	}
	
	public static Response error(String msg) {
		Response response = new Response();
		response.setStatus("ERROR");
		response.setMsg(msg);
		return response;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
