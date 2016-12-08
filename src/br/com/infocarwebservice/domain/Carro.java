/*
 * InfoCarWebService 1.0 18 de nov de 2016
 * 
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.infocarwebservice.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * A classe <code>Carro</code> é uma entidade que representa cada
 * carro a ser persistido no banco.
 *
 * @author Augusto dos Santos
 * @version 1.0 18 de nov de 2016
 */
@XmlRootElement
public class Carro implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private String tipo;
	private String descricao;
	private String urlFoto;
	private String urlVideo;
	private String latitude;
	private String longitude;
	
	public Long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getUrlFoto() {
		return urlFoto;
	}
	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
	
	public String getUrlVideo() {
		return urlVideo;
	}
	
	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}
	
	public String getLatitude() {
		return latitude;
	}
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String getLongitude() {
		return longitude;
	}
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	@Override
	public String toString() {
		return "Carro [id= " + id + ", tipo: " + tipo + ", nome: " + nome
				+ ", descricao: " + descricao;
	}
	
}
