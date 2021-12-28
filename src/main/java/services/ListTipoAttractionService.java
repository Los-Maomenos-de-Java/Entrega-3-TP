package services;

import java.util.LinkedList;
import java.util.List;

import model.Atraccion;
import model.OrdenadorDeOfertas;
import model.TipoDeAtraccion;
import model.Usuario;
import persistence.AtraccionDAO;
import persistence.commons.DAOFactory;

public class ListTipoAttractionService {
	
	private List<TipoDeAtraccion> tipoatracciones = new LinkedList<TipoDeAtraccion>();

	public List<TipoDeAtraccion> list() {

		tipoatracciones.removeAll(tipoatracciones);
		List<TipoDeAtraccion> tipoatracciones = DAOFactory.getTipoAtraccionDAO().findAll();
		return tipoatracciones;
	}
/*
	public Atraccion create(String nombre, Integer costoVisita, Double tiempoPromedio, TipoDeAtraccion tipo,
			Integer cupo) {

		
		Atraccion attraction = new Atraccion(nombre, costoVisita, tiempoPromedio, tipo,  cupo);

		AtraccionDAO attractionDAO = DAOFactory.getAttractionDAO();
		attractionDAO.insert(attraction);
		// XXX: si no devuelve "1", es que hubo mÃ¡s errores

		return attraction;
	}

	public Atraccion update(Integer id, String nombre, Integer costoVisita, double tiempoPromedio, Integer idTipoAtraccion,
			 Integer cupo) {

		AtraccionDAO attractionDAO = DAOFactory.getAttractionDAO();
		Atraccion attraction = attractionDAO.find(id);
		
		TipoDeAtraccion tipoAtraccionDAO = DAOFactory.getTipoAtraccionDAO().find(idTipoAtraccion);
	

		attraction.setNombre(nombre);
		attraction.setCosto(costoVisita);
		attraction.setiempoPromedio(tiempoPromedio);
		attraction.settipoDeAtraccion(tipoAtraccionDAO);
		attraction.setCupo(cupo);

		attractionDAO.update(attraction);

		return attraction;
	}

	public void delete(Integer id) {
		Atraccion attraction = new Atraccion(id, "", 0, 0.0, TipoDeAtraccion.valueOf(1), 0);

		AtraccionDAO attractionDAO = DAOFactory.getAttractionDAO();
		attractionDAO.delete(attraction);
	}

	public Atraccion find(Integer id) {
		return DAOFactory.getAttractionDAO().find(id);
	}
*/
}
	