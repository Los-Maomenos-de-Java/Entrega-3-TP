package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import model.Atraccion;
import model.Boleteria;
import model.Promocion;
import model.PromocionAbsoluta;
import model.PromocionAxB;
import model.PromocionPorcentual;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class PromocionDAOImpl {
	private static PromocionDAOImpl instance;

	public static PromocionDAOImpl getInstance() {
		if (instance == null) {
			instance = new PromocionDAOImpl();
		}
		return instance;
	}

	public List<Promocion> findAll() {
		try {
			String allPromociones = "SELECT * FROM promociones";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(allPromociones);
			ResultSet resultados = statement.executeQuery();

			List<Promocion> promociones = new LinkedList<>();
			while (resultados.next()) {
				promociones.add(toPromocion(resultados));
			}
			return promociones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Promocion toPromocion(ResultSet resultados) {
		try {
			Promocion promocionAAgregar = null;

			int id = resultados.getInt(1);
			String nombre = resultados.getString(2);
			int tipo = resultados.getInt(3);
			LinkedList<Atraccion> atracciones = atraccionesPorPromocion(id);

			if (tipo == 1) {
				double descuento = resultados.getDouble(4);
				promocionAAgregar = new PromocionAbsoluta(id, nombre, descuento);

				for (Atraccion atraccion : atracciones) {
					promocionAAgregar.agregarAtraccion(atraccion);
				}
			}

			if (tipo == 2) {
				double descuento = resultados.getDouble(4);
				promocionAAgregar = new PromocionPorcentual(id, nombre, descuento);

				for (Atraccion atraccion : atracciones) {
					promocionAAgregar.agregarAtraccion(atraccion);
				}
			}

			if (tipo == 3) {
				String[] atraccionesGratisString = resultados.getString(4).split(",");
				Atraccion[] atraccionesGratis = new Atraccion[atraccionesGratisString.length];

				for (int i = 0; i < atraccionesGratisString.length; i++) {
					atraccionesGratis[i] = (Atraccion) Boleteria
							.obtenerOfertablePorId(Integer.parseInt(atraccionesGratisString[i]), false);
				}

				promocionAAgregar = new PromocionAxB(id, nombre, atraccionesGratis);

				for (Atraccion atraccion : atracciones) {
					promocionAAgregar.agregarAtraccion(atraccion);
				}
			}

			return promocionAAgregar;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private LinkedList<Atraccion> atraccionesPorPromocion(int idPromocion) {
		try {
			String idAtraccionesPorPromocion = "SELECT id_atraccion FROM atracciones_en_promocion WHERE id_promocion = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(idAtraccionesPorPromocion);
			statement.setInt(1, idPromocion);

			ResultSet resultados = statement.executeQuery();
			LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();

			while (resultados.next()) {
				atracciones.add((Atraccion) Boleteria.obtenerOfertablePorId(resultados.getInt(1), false));
			}

			return atracciones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
}