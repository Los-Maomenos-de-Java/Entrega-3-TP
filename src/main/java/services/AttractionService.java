package services;

import java.util.List;

import model.Atraccion;
import model.TipoDeAtraccion;
import persistence.commons.DAOFactory;
import persistence.impl.AtraccionDAOImpl;

public class AttractionService {

	public List<Atraccion> list() {
		return DAOFactory.getAttractionDAO().findAll();
	}

	public Atraccion create(Integer id, String nombre, Double costoVisita, Double tiempoPromedio,
			TipoDeAtraccion tipoDeAtraccion, Integer cupo) {

		Atraccion attraction = new Atraccion(id, nombre, costoVisita, tiempoPromedio, tipoDeAtraccion, cupo);

		AtraccionDAOImpl attractionDAO = DAOFactory.getAttractionDAO();
		attractionDAO.insert(attraction);
		// XXX: si no devuelve "1", es que hubo mÃ¡s errores

		return attraction;
	}

	public Atraccion update(int id, String nombre, double costoVisita, double tiempoPromedio,
			TipoDeAtraccion tipoDeAtraccion, int cupo) {

		AtraccionDAOImpl attractionDAO = DAOFactory.getAttractionDAO();
		Atraccion attraction = attractionDAO.find(id);

		attraction.setNombre(nombre);
		attraction.setCosto(costoVisita);
		attraction.setiempoPromedio(tiempoPromedio);
		attraction.settipoDeAtraccion(tipoDeAtraccion);

		attractionDAO.update(attraction);

		return attraction;
	}

	public void delete(Integer id) {
		Atraccion attraction = new Atraccion(id, null, null, null, null, null);

		AtraccionDAOImpl attractionDAO = DAOFactory.getAttractionDAO();
		attractionDAO.delete(attraction);
	}





}