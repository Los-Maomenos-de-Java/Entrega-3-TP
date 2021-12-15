package services;

import java.util.List;

import model.Atraccion;
import model.Boleteria;
import model.Ofertable;
import model.TipoDeAtraccion;
import model.Usuario;
import persistence.AtraccionDAO;
import persistence.commons.DAOFactory;


public class AttractionService {

	public List<Ofertable> list(Usuario user2) {
		Boleteria boleteria = new Boleteria();
		return boleteria.ofertasOrdenadasPara(user2);
	}
	
	public Atraccion create(Integer id, String nombre, Integer costoVisita, Double tiempoPromedio, TipoDeAtraccion tipoDeAtraccion,
			Integer cupo) {

		Atraccion attraction = new Atraccion(id, nombre, costoVisita, tiempoPromedio, tipoDeAtraccion, cupo);

		AtraccionDAO attractionDAO = DAOFactory.getAttractionDAO();
		attractionDAO.insert(attraction);
		// XXX: si no devuelve "1", es que hubo mÃ¡s errores

		return attraction;
	}

	public Atraccion update(Integer id, String nombre, Integer costoVisita, double tiempoPromedio,
			TipoDeAtraccion tipoDeAtraccion, Integer cupo) {

		AtraccionDAO attractionDAO = DAOFactory.getAttractionDAO();
		Atraccion attraction = attractionDAO.find(id);
		
		attraction.setNombre(nombre);
		attraction.setCosto(costoVisita);
		attraction.setiempoPromedio(tiempoPromedio);
		attraction.settipoDeAtraccion(tipoDeAtraccion);
		attraction.setCupo(cupo);

		attractionDAO.update(attraction);

		return attraction;
	}

	public void delete(Integer id) {
		Atraccion attraction = new Atraccion(id, "", 0, 0.0, TipoDeAtraccion.valueOf("TERROR"), 0);

		AtraccionDAO attractionDAO = DAOFactory.getAttractionDAO();
		attractionDAO.delete(attraction);
	}


	public Atraccion find(Integer id) {
		return DAOFactory.getAttractionDAO().find(id);
	}





}