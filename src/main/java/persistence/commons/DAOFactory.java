package persistence.commons;


import persistence.AtraccionDAO;
import persistence.TipoAtraccionDAO;
import persistence.UsuarioDAO;
import persistence.impl.AtraccionDAOImpl;
import persistence.impl.TipoAtraccionDAOImpl;
import persistence.impl.UsuarioDAOImpl;

public class DAOFactory {

	public static UsuarioDAO getUserDAO() {
		return new UsuarioDAOImpl();
	}
	
	public static AtraccionDAO getAttractionDAO() {
		return new AtraccionDAOImpl();
	}

	public static TipoAtraccionDAO getTipoAtraccionDAO() {
		return new TipoAtraccionDAOImpl();
	}
	

}
