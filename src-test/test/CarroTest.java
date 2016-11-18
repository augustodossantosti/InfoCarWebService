/*
 * InfoCarWebService 1.0 18 de nov de 2016
 * 
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.com.infocarwebservice.domain.Carro;
import br.com.infocarwebservice.domain.CarroService;

/**
 * A classe <code>CarroTest</code> contém os testes de unidade referentes
 * as funções de persistência dos Carros.
 *
 * @author Augusto dos Santos
 * @version 1.0 18 de nov de 2016
 */
public class CarroTest {

	private CarroService carroService = new CarroService();

	@Test
	public void testListaCarros() {
		List<Carro> carros = carroService.getCarros();
		assertNotNull(carros);
		assertTrue(carros.size() > 0);
		Carro tucker = carroService.findByName("Tucker 1948").get(0);
		assertEquals("Tucker 1948", tucker.getNome());
		Carro ferrari = carroService.findByName("Ferrari FF").get(0);
		assertEquals("Ferrari FF", ferrari.getNome());
		Carro bugatti = carroService.findByName("Bugatti Veyron").get(0);
		assertEquals("Bugatti Veyron", bugatti.getNome());
	}

}
