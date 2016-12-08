/*
 * InfoCarWebService 1.0 28 de nov de 2016
 * 
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.infocarwebservice.rest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.jettison.JettisonFeature; 


/**
 * A classe <code>MyApplication</code> cont�m as configura��es
 * do Jerswy.
 *
 * @author Augusto dos Santos
 * @version 1.0 28 de nov de 2016
 */
public class MyApplication extends Application {

	/**
	 * Indica ao Jersey o pacote onde est�o localizadas as
	 * classes do web service que devem ser escaneadas em
	 * busca de anota��es que determinar�o os m�todos a serem
	 * chamados a cada tipo de requisi��o.
	 */
	@Override
	public Map<String, Object> getProperties() {
		Map<String, Object> properties = new HashMap<>();
		properties.put("jersey.config.server.provider.packages", "br.com.infocarwebservice");
		return properties;
	}
	
}
