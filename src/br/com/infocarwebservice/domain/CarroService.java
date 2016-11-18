/*
 * InfoCarWebService 1.0 18 de nov de 2016
 * 
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.infocarwebservice.domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * A classe <code>CarroService</code> é reponsável por acessar a camada
 * de persistência e permitir acesso a suas funções.
 *
 * @author Augusto dos Santos
 * @version 1.0 18 de nov de 2016
 */
public class CarroService {

	private CarroDAO db = new CarroDAO();

	public List<Carro> getCarros() {
		try {
			List<Carro> carros = db.getCarros();
			return carros;
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Carro>();
		}
	}

	public Carro getCarro(Long id) {
		try {
			return db.getCarroById(id);
		} catch (SQLException e) {
			return null;
		}
	}

	public boolean delete(Long id) {
		try {
			return db.delete(id);
		} catch (SQLException e) {
			return false;
		}
	}

	public boolean save(Carro carro) {
		try {
			db.save(carro);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public List<Carro> findByName(String name) {
		try {
			return db.findByName(name);
		} catch (SQLException e) {
			return null;
		}
	}

	public List<Carro> findByTipo(String tipo) {
		try {
			return db.findByTipo(tipo);
		} catch (SQLException e) {
			return null;
		}
	}
}
