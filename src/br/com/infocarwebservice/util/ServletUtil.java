/*
 * InfoCarWebService 1.0 22 de nov de 2016
 * 
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.infocarwebservice.util;import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 * A classe <code>ServletUtil</code> contém as configurações
 * para geração de arquivos XML e Json e envio dos mesmos através
 * do servlet.
 *
 * @author Augusto dos Santos
 * @version 1.0 22 de nov de 2016
 */
public class ServletUtil {

	public static void writeXML(HttpServletResponse response,  String xml) throws IOException {
		if (xml != null) {
			PrintWriter writer = response.getWriter();
			response.setContentType("application/xml;charset=UTF-8");
			writer.write(xml);
			writer.close();
		}
	}
	
	public static void writeJson(HttpServletResponse response,  String json) throws IOException {
		if (json != null) {
			PrintWriter writer = response.getWriter();
			response.setContentType("application/json;charset=UTF-8");
			writer.write(json);
			writer.close();
		}
	}
}
