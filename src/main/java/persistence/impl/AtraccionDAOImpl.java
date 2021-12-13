package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import model.Atraccion;
import model.TipoDeAtraccion;
import persistence.AtraccionDAO;
import persistence.commons.ConnectionProvider;
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

	public int insert(Atraccion attraction) {
		try {
			String sql = "INSERT INTO ATRACCIONES (ID, NOMBRE, COSTO, TIEMPO, TIPO_ATRACCION, CUPO) VALUES (?, ?, ?, ?, ?,?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			statement.setInt(i++, attraction.getId());
			statement.setString(i++, attraction.getNombre());
			statement.setDouble(i++, attraction.getCosto());
			statement.setDouble(i++, attraction.getTiempo());
			statement.setObject(i++, attraction.getTipo());
			
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int update(Atraccion atraccion) {
		try {
			String updateAtraccion = "UPDATE atracciones SET cupo = ? WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(updateAtraccion);
			statement.setInt(1, atraccion.getCupo());
			statement.setInt(2, atraccion.getId());

			return statement.executeUpdate();
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
			TipoDeAtraccion tipoDeAtraccion = AtraccionDAOImpl.getTipoAtraccion(resultados.getInt(5));
			Integer cupo = resultados.getInt(6);

			return new Atraccion(id, nombre, costoVisita, tiempoPromedio, tipoDeAtraccion, cupo);

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
			return TipoDeAtraccion.valueOf(resultados.getString(1));

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public Atraccion find(Integer id) {
		try {
			String sql = "SELECT * FROM ATRACCIONES WHERE id = ?";
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

		public int delete(Atraccion attraction) {
		try {
			String sql = "DELETE FROM ATRACCIONES WHERE ID = ?";
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
