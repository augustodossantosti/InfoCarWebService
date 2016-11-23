/*
 * InfoCarWebService 1.0 22 de nov de 2016
 * 
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.infocarwebservice.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 *
 * @author Augusto dos Santos
 * @version 1.0 22 de nov de 2016
 */
public class RegexUtil {

	private static final Pattern regexAll = Pattern.compile("/carros");
	private static final Pattern regexById = Pattern.compile("/carros/([0-9]*)");
	
	public static Long mathId(String requestUri) {
		Matcher matcher = regexById.matcher(requestUri);
		if(matcher.find() && matcher.groupCount() > 0) {
			String s = matcher.group(1);
			if(s != null && s.trim().length() > 0) {
				Long id = Long.parseLong(s);
				return id;
			}
		}
		return null;
	}
	
	public boolean matchAll(String requestUti) {
		Matcher matcher = regexAll.matcher(requestUti);
		if(matcher.find()) {
			return true;
		}
		return false;
	}
}
