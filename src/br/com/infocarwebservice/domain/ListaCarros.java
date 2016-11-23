/*
 * InfoCarWebService 1.0 21 de nov de 2016
 * 
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.infocarwebservice.domain;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A classe <code>ListaCarros</code> encapsula a lista de carros
 * cadastrados na aplicaão, permitindo a geração de um arquivo
 * XML com as informações de cada carro.
 *
 * @author Augusto dos Santos
 * @version 1.0 21 de nov de 2016
 */
@XmlRootElement(name="carros")
public class ListaCarros implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Carro> carros;
	
	public void setCarros(final List<Carro> carros) {
		this.carros = carros;
	}
	
	@XmlElement(name="carro")
	public List<Carro> getCarros() {
		return carros;
	}

	@Override
	public String toString() {
		return "ListaCarros [carros = " + carros + " ]";
	}
	
}
