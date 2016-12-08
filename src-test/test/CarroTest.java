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
	
	@Test
	public void testarSalvarDeletarCarro() {
		Carro carro = new Carro();
		carro.setNome("Teste nome");
		carro.setTipo("Teste tipo");
		carro.setDescricao("Teste desc");
		carro.setUrlFoto("url foto aqui");
		carro.setUrlVideo("url video aqui");
		carro.setLatitude("lat");
		carro.setLongitude("long");
		carroService.save(carro);
		
		Long id = carro.getId();
		assertNotNull(id);
		
		carro = carroService.getCarro(id);
		assertEquals("Teste nome", carro.getNome());
		assertEquals("Teste tipo", carro.getTipo());
		assertEquals("Teste desc", carro.getDescricao());
		assertEquals("url foto aqui", carro.getUrlFoto());
		assertEquals("url video aqui", carro.getUrlVideo());
		assertEquals("lat", carro.getLatitude());
		assertEquals("long", carro.getLongitude());
		
		carro.setNome("Teste UPDATE");
		carroService.save(carro);
		carro = carroService.getCarro(id);
		assertEquals("Teste UPDATE", carro.getNome());
		
		carroService.delete(id);
		carro = carroService.getCarro(id);
		assertNull(carro);
	}

}
