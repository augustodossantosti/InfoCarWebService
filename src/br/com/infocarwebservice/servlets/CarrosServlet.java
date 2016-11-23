/*
 * InfoCarWebService 1.0 21 de nov de 2016
 * 
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.infocarwebservice.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.infocarwebservice.domain.Carro;
import br.com.infocarwebservice.domain.CarroService;
import br.com.infocarwebservice.util.RegexUtil;
import br.com.infocarwebservice.util.ServletUtil;

/**
 * A calsse <code>CarrosServlet</code> contém as configurações do
 * servlet que trata as operações realcionadas com os veículos cadastrados, 
 * incluindo o tratamento das requisições http.
 *
 * @author Augusto dos Santos
 * @version 1.0 21 de nov de 2016
 */
@WebServlet("/carros/*")
public class CarrosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CarroService carroService = new CarroService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestUri = req.getRequestURI();
		Long id = RegexUtil.mathId(requestUri);
		
		if(id != null) {
			Carro carro = carroService.getCarro(id);
			
			if(carro != null) {
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				String json = gson.toJson(carro);
				ServletUtil.writeJson(resp, json);
			} else {
				resp.sendError(404, "Carro não encontrado");
			}
		} else {
			List<Carro> carros = carroService.getCarros();
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String jsonGoogle = gson.toJson(carros);
			ServletUtil.writeJson(resp, jsonGoogle);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Carro carro = getCarroFromRequest(req);
		carroService.save(carro);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(carro);
		ServletUtil.writeJson(resp, json);
	}
	
	private Carro getCarroFromRequest(HttpServletRequest request) {
		Carro carro = new Carro();
		String id = request.getParameter("id");
		if(id != null) {
			carro = carroService.getCarro(Long.parseLong(id));
		}
		
		carro.setNome(request.getParameter("nome"));
		carro.setDescricao(request.getParameter("descricao"));
		carro.setUrlFoto(request.getParameter("url_foto"));
		carro.setUrlVideo(request.getParameter("url_video"));
		carro.setLatitude(request.getParameter("latitude"));
		carro.setLongitude(request.getParameter("longitude"));
		carro.setTipo(request.getParameter("tipo"));
		
		return carro;
	}
	
}
