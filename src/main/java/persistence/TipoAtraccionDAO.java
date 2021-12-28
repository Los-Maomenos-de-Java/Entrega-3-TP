package persistence;
import model.TipoDeAtraccion;
import persistence.commons.GenericDAO;

public interface TipoAtraccionDAO extends GenericDAO<TipoDeAtraccion> {

	public abstract Integer getIdTipoAtraccion(String tipoAtraccion);

	public abstract TipoDeAtraccion find(Integer id);

	public abstract int insert(TipoDeAtraccion tipoDeAtraccion);

	public abstract TipoDeAtraccion findByName(String tipo);

	public abstract TipoDeAtraccion findById(String tipoAtraccion);

}
