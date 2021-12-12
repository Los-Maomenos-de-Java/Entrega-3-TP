package persistence.commons;


import persistence.impl.AtraccionDAOImpl;
import persistence.impl.UsuarioDAOImpl;

public class DAOFactory {

	public static UsuarioDAOImpl getUserDAO() {
		return new UsuarioDAOImpl();
	}
	
	public static AtraccionDAOImpl getAttractionDAO() {
		return new AtraccionDAOImpl();
	}
}
