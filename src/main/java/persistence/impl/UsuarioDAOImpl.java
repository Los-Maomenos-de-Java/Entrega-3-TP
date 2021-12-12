package persistence.impl;

import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;
import model.TipoDeAtraccion;
import model.Usuario;
import model.nullobjects.NullUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class UsuarioDAOImpl {
    private static UsuarioDAOImpl instance;

    public static UsuarioDAOImpl getInstance() {
        if (instance == null) {
            instance = new UsuarioDAOImpl();
        }
        return instance;
    }

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
            TipoDeAtraccion tipo_atraccion_preferida = AtraccionDAOImpl.getTipoAtraccion(resultados.getInt(6));
            boolean admin = resultados.getBoolean(7);

            Usuario usuario = new Usuario(id, nombre, password, presupuesto, tiempo_disponible, tipo_atraccion_preferida, admin);

            usuario.setOfertasCompradas(ItinerarioDAOImpl.getInstance().itinerarioDe(usuario).getOfertas());

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
}