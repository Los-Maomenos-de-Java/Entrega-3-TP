package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.TipoDeAtraccion;
import persistence.TipoAtraccionDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class TipoAtraccionDAOImpl implements TipoAtraccionDAO {

	@Override
	public List<TipoDeAtraccion> findAll() {
		try {
			String sql = "SELECT * FROM tipos_de_atraccion";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<TipoDeAtraccion> tipos_atraccion = new LinkedList<>();
			while (resultados.next()) {
				tipos_atraccion.add(toTipoAtraccion(resultados));
			}

			return tipos_atraccion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Integer getIdTipoAtraccion(String tipoAtraccion) {
		try {
			String sql = "SELECT id " + "FROM \"tipos_de_atraccion\" " + "WHERE nombre = ?;";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, tipoAtraccion);
			ResultSet resultado = statement.executeQuery();
			

			Integer id_tipoatraccion = null;
			if (resultado.next()) {
				id_tipoatraccion = resultado.getInt("id");
			}
			
			return id_tipoatraccion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	@Override
	public TipoDeAtraccion find(Integer id_tipoatraccion) {
		try {
			String sql = "SELECT * FROM tipos_de_atraccion WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, id_tipoatraccion);
			ResultSet resultado = statement.executeQuery();

			TipoDeAtraccion tipoAtraccion = null;
			if (resultado.next()) {
				tipoAtraccion = toTipoAtraccion(resultado);
			}

			return tipoAtraccion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private TipoDeAtraccion toTipoAtraccion(ResultSet resultados) {
		try {
			return new TipoDeAtraccion(resultados.getInt("id"), resultados.getString("nombre"));

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insert(TipoDeAtraccion tipoDeAtraccion) {
		try {
			String sql = "INSERT INTO tipos_de_atraccion VALUES (?)";

			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, tipoDeAtraccion.getNombre());

			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(TipoDeAtraccion t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(TipoDeAtraccion t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TipoDeAtraccion findByName(String tipo) {
		try {
			String sql = "SELECT * FROM tipos_de_atraccion WHERE nombre = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, tipo);
			ResultSet resultado = statement.executeQuery();

			TipoDeAtraccion tipoAtraccion = null;
			if (resultado.next()) {
				tipoAtraccion = toTipoAtraccion(resultado);
			}

			return tipoAtraccion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}

	@Override
	public TipoDeAtraccion findById(String tipoAtraccion) {
		// TODO Auto-generated method stub
		return null;
	}

}