package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import model.Atraccion;
import model.Ofertable;
import model.TipoDeAtraccion;
import persistence.AtraccionDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.DAOFactory;
import persistence.commons.MissingDataException;

public class AtraccionDAOImpl implements AtraccionDAO {

	public List<Atraccion> findAll() {
		try {
			String allAtracciones = "SELECT * FROM atracciones";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(allAtracciones);
			ResultSet resultados = statement.executeQuery();

			List<Atraccion> atracciones = new LinkedList<>();
			while (resultados.next()) {
				atracciones.add(toAtraccion(resultados));
			}

			return atracciones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insert(Atraccion attraction) {
		try {
			String sql = "INSERT INTO ATRACCIONES (nombre, costoVisita, tiempoPromedio, tipoDeAtraccion, cupo) VALUES (?, ?, ?, ?,?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			statement.setString(i++, attraction.getNombre());
			statement.setInt(i++, attraction.getCosto());
			statement.setDouble(i++, attraction.getTiempo());
			statement.setInt(i++, attraction.getTipo().getId());
			statement.setInt(i++, attraction.getCupo());

			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(Atraccion attraction) {
		try {
			String sql = "UPDATE atracciones SET nombre = ?, costoVisita = ?, tiempoPromedio = ?, tipoDeAtraccion = ?, cupo = ? WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			statement.setString(i++, attraction.getNombre());
			statement.setInt(i++, attraction.getCosto());
			statement.setDouble(i++, attraction.getTiempo());
			statement.setInt(i++, attraction.getTipo().getId());
			statement.setInt(i++, attraction.getCupo());
			statement.setInt(i++, attraction.getId());

			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Atraccion toAtraccion(ResultSet resultados) {
		try {
			Integer id = resultados.getInt(1);
			String nombre = resultados.getString(2);
			Integer costoVisita = resultados.getInt(3);
			Double tiempoPromedio = resultados.getDouble(4);
			Integer cupo = resultados.getInt(6);
			TipoDeAtraccion tipoAtraccion = DAOFactory.getTipoAtraccionDAO().find(id);

			return new Atraccion(id, nombre, costoVisita, tiempoPromedio, tipoAtraccion, cupo);

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public static TipoDeAtraccion getTipoAtraccion(int id) {
		try {
			String idTipoAtraccion = "SELECT nombre FROM tipos_de_atraccion WHERE id = ?";

			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(idTipoAtraccion);
			statement.setInt(1, id);

			ResultSet resultados = statement.executeQuery();
			TipoDeAtraccion resultados2 = (TipoDeAtraccion) resultados.getObject(1);
			return resultados2;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public Integer getIdTipoAtraccionPorNombre(String nombre) {
		try {
			String idTipoAtraccion = "SELECT id FROM tipos_de_atraccion WHERE nombre = ?";

			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(idTipoAtraccion);
			statement.setObject(1, nombre);

			ResultSet resultados = statement.executeQuery();
			return resultados.getInt(1);

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public Atraccion find(Integer id) {
		try {
			String sql = "SELECT * FROM atracciones WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet resultados = statement.executeQuery();

			Atraccion attraction = null;
			if (resultados.next()) {
				attraction = toAtraccion(resultados);
			}

			return attraction;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(Atraccion attraction) {
		try {
			String sql = "DELETE FROM atracciones WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, attraction.getId());
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

}
