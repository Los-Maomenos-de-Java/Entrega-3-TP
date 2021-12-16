package services;

import model.Usuario;
import model.nullobjects.NullUser;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;


public class CuentaUsuarioService {
	
	public Usuario encontrarPorId(Integer ide) {
		UsuarioDAO userDao = DAOFactory.getUserDAO();
    	Usuario CuentaUsuario = userDao.find(ide);
    	
    	
    	
    	if (CuentaUsuario.isNull() ) {
    		CuentaUsuario = NullUser.build();
    	}
    	
    	
    	return CuentaUsuario;
	}


	
	

}