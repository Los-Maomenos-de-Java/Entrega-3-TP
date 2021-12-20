package persistence;

import model.Atraccion;
import persistence.commons.GenericDAO;

public interface AtraccionDAO extends GenericDAO<Atraccion> {

	
	public int insert(Atraccion atraccion);
	
	public int update(Atraccion atraccion);
	
	public int delete(Atraccion atraccion);

	public Atraccion find(Integer id);

}
