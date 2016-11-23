/*
 * InfoCarWebService 1.0 21 de nov de 2016
 * 
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.infocarwebservice.util;

import java.io.IOException;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.stream.XMLStreamWriter;

import org.codehaus.jettison.mapped.MappedNamespaceConvention;
import org.codehaus.jettison.mapped.MappedXMLStreamWriter;

import br.com.infocarwebservice.domain.Carro;
import br.com.infocarwebservice.domain.ListaCarros;

/**
 * A casse <code>JAXBUtil</code> contém as configurações
 * para geração de arquivos XML.
 *
 * @author Augusto dos Santos
 * @version 1.0 21 de nov de 2016
 */
public class JAXBUtil {

	private static JAXBUtil instance;
	private static JAXBContext context;
	
	public static JAXBUtil getInstance() {
		return instance;
	}
	
	static {
		try {
			context = JAXBContext.newInstance(ListaCarros.class, Carro.class);
		} catch (JAXBException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public static String toXML(Object object) throws IOException {
		try {
			StringWriter writer = new StringWriter();
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(object, writer);
			String xml = writer.toString();
			return xml;
			
		} catch (JAXBException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public static String toJson(Object object) {
		try {
			StringWriter writer = new StringWriter();
			Marshaller marshaller = context.createMarshaller();
			MappedNamespaceConvention con = new MappedNamespaceConvention();
			XMLStreamWriter xmlStreamWriter = new MappedXMLStreamWriter(con, writer);
			marshaller.marshal(object, xmlStreamWriter);
			String json = writer.toString();
			return json;
		} catch(JAXBException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
