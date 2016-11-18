/*
 * InforCarWebService 1.0 18 de nov de 2016
 * 
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.infocarwebservice.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * A calsse <code>BaseDAO</code> contém as configurações necessárias
 * para realizar a conexão com o banco de dados.
 *
 * @author Augusto dos Santos
 * @version 1.0 18 de nov de 2016
 */
public class BaseDAO {

	public BaseDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	protected Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost/carros";
		Connection connection = DriverManager.getConnection(url, "carros", "carros123");
		return connection;
	}
	
	public static void main(String[] args) throws SQLException {
		BaseDAO db = new BaseDAO();
		Connection connection = db.getConnection();
		System.out.println(connection);
	}
}
