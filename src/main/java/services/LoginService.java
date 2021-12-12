package services;

import model.Usuario;
import model.nullobjects.NullUser;
import persistence.commons.DAOFactory;
import persistence.impl.UsuarioDAOImpl;

public class LoginService {

	public Usuario login(String username, String password) {
		UsuarioDAOImpl userDao = DAOFactory.getUserDAO();
    	Usuario user = userDao.findByUsername(username);
    	
    	
    	
    	if (user.isNull() || !user.checkPassword(password)) {
    		user = NullUser.build();
    	}
    	
    	
    	return user;
	}
	
}

