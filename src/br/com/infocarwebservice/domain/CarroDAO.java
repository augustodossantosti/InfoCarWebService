/*
 * InfoCarWebService 1.0 18 de nov de 2016
 * 
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.infocarwebservice.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * A classe <code>CarroDAO</code> realiza a persistência e busca
 * de dados referentes aos carros.
 *
 * @author Augusto dos Santos
 * @version 1.0 18 de nov de 2016
 */
public class CarroDAO extends BaseDAO {

	public Carro getCarroById(final long id) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement("select * from carrostb where id=?");
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				Carro carro = createCarro(resultSet);
				resultSet.close();
				return carro;
			}
		} finally {
			if(statement != null) {
				statement.close();
			}
		}
		return null;
	}
	
	public List<Carro> findByName(final String name) throws SQLException {
		List<Carro> carros = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement("select * from carrostb where lower(nome) like ?");
			statement.setString(1, "%" + name.toLowerCase() +"%");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Carro carro = createCarro(resultSet);
				carros.add(carro);
			}
			resultSet.close();
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		return carros;
	}

	public List<Carro> findByTipo(String tipo) throws SQLException {
		List<Carro> carros = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select * from carrostb where tipo = ?");
			stmt.setString(1, tipo);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Carro c = createCarro(rs);
				carros.add(c);
			}
			rs.close();
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return carros;
	}

	public List<Carro> getCarros() throws SQLException {
		List<Carro> carros = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select * from carrostb");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Carro c = createCarro(rs);
				carros.add(c);
			}
			rs.close();
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return carros;
	}

	public Carro createCarro(ResultSet rs) throws SQLException {
		Carro carro = new Carro();
		carro.setId(rs.getLong("id"));
		carro.setNome(rs.getString("nome"));
		carro.setDescricao(rs.getString("descricao"));
		carro.setUrlFoto(rs.getString("url_foto"));
		carro.setUrlVideo(rs.getString("url_video"));
		carro.setLatitude(rs.getString("latitude"));
		carro.setLongitude(rs.getString("longitude"));
		carro.setTipo(rs.getString("tipo"));
		return carro;
	}

	public void save(Carro carro) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			if (carro.getId() == null) {
				stmt = conn
						.prepareStatement(
								"insert into carrostb (nome,descricao,url_foto,url_video,latitude,longitude,tipo) VALUES(?,?,?,?,?,?,?)",
								Statement.RETURN_GENERATED_KEYS);
			} else {
				stmt = conn
						.prepareStatement("update carrostb set nome=?,descricao=?,url_foto=?,url_video=?,latitude=?,longitude=?,tipo=? where id=?");
			}
			stmt.setString(1, carro.getNome());
			stmt.setString(2, carro.getDescricao());
			stmt.setString(3, carro.getUrlFoto());
			stmt.setString(4, carro.getUrlVideo());
			stmt.setString(5, carro.getLatitude());
			stmt.setString(6, carro.getLongitude());
			stmt.setString(7, carro.getTipo());
			if (carro.getId() != null) {
				// Update
				stmt.setLong(8, carro.getId());
			}
			int count = stmt.executeUpdate();
			if (count == 0) {
				throw new SQLException("Erro ao inserir o carro");
			}
			// Se inseriu, ler o id auto incremento
			if (carro.getId() == null) {
				Long id = getGeneratedId(stmt);
				carro.setId(id);
			}
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

	// id gerado com o campo auto incremento
	public static Long getGeneratedId(Statement stmt) throws SQLException {
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			Long id = rs.getLong(1);
			return id;
		}
		return 0L;
	}

	public boolean delete(Long id) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("delete from carrostb where id=?");
			stmt.setLong(1, id);
			int count = stmt.executeUpdate();
			boolean ok = count > 0;
			return ok;
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}
}
