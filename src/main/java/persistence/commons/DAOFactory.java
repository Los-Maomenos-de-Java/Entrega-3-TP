package persistence.commons;


import persistence.AtraccionDAO;
import persistence.impl.AtraccionDAOImpl;
import persistence.impl.UsuarioDAOImpl;

public class DAOFactory {

	public static UsuarioDAOImpl getUserDAO() {
		return new UsuarioDAOImpl();
	}
	
	public static AtraccionDAO getAttractionDAO() {
		return new AtraccionDAOImpl();
	}
}
