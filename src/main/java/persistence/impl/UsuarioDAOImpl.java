package persistence.impl;

import persistence.UsuarioDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.DAOFactory;
import persistence.commons.MissingDataException;
import model.TipoDeAtraccion;
import model.Usuario;
import model.nullobjects.NullUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {

	public List<Usuario> findAll() {
		try {
			String sql = "SELECT * FROM usuarios";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Usuario> usuarios = new LinkedList<>();
			while (resultados.next()) {
				usuarios.add(toUsuario(resultados));
			}

			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Usuario toUsuario(ResultSet resultados) {
		try {
			Integer id = resultados.getInt(1);
			String nombre = resultados.getString(2);
			String password = resultados.getString(3);
			double presupuesto = resultados.getDouble(4);
			double tiempo_disponible = resultados.getDouble(5);
			boolean admin = resultados.getBoolean(6);
			TipoDeAtraccion tipoAtraccion = DAOFactory.getTipoAtraccionDAO().find(resultados.getInt("id"));


			Usuario usuario = new Usuario(id, nombre, password, presupuesto, tiempo_disponible,
					tipoAtraccion, admin);

			

			return usuario;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}

	public int update(Usuario usuario) {
		try {
			String updateUsuario = "UPDATE usuarios SET presupuesto = ?, tiempo_disponible = ?  WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(updateUsuario);
			statement.setDouble(1, usuario.getPresupuestoActual());
			statement.setDouble(2, usuario.getTiempoDisponible());
			statement.setInt(3, usuario.getId());

			return statement.executeUpdate();
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public Usuario findByUsername(String username) {
		try {
			String sql = "SELECT * FROM usuarios WHERE nombre = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet resultados = statement.executeQuery();

			Usuario user = NullUser.build();

			if (resultados.next()) {
				user = toUsuario(resultados);
			}

			return user;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public Usuario find(Integer id) {
		try {
			String sql = "SELECT * FROM USUARIOS WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();

			Usuario user = NullUser.build();

			if (resultados.next()) {
				user = toUsuario(resultados);
			}

			return user;
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
	public int insert(Usuario t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Usuario t) {
		// TODO Auto-generated method stub
		return 0;
	}

}