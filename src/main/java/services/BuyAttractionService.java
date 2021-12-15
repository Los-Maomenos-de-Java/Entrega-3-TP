package services;

import java.util.HashMap;
import java.util.Map;

import model.Atraccion;
import model.Usuario;
import persistence.AtraccionDAO;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;
import persistence.impl.AtraccionDAOImpl;
import persistence.impl.UsuarioDAOImpl;

public class BuyAttractionService {

	AtraccionDAO atraccionDAO = DAOFactory.getAttractionDAO();
	UsuarioDAOImpl userDAO = DAOFactory.getUserDAO();

	public Map<String, String> buy(Integer userId, Integer attractionId) {
		Map<String, String> errors = new HashMap<String, String>();

		Usuario user = UsuarioDAO.find(userId);
		Atraccion attraction = atraccionDAO.find(attractionId);

		if (!attraction.tieneCupo()) {
			errors.put("attraction", "No hay cupo disponible");
		}
		if (!user.puedeVisitar(attraction)) {
			errors.put("user", "No tienes dinero suficiente, o  No tienes tiempo suficiente");
		}

		if (errors.isEmpty()) {
			user.setOfertasCompradas(attraction);
			

			atraccionDAO.update(attraction);
			userDAO.update(user);
		}

		return errors;

	}

}