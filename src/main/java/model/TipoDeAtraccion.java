package model;

public class TipoDeAtraccion {

	private Integer id;
	private String nombre;

	public TipoDeAtraccion(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public TipoDeAtraccion(Integer id, String nombre) {
		this(nombre);
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public Integer getIdTipoAtraccion() {
		return this.id;
	}

	public String getTipoDeAtraccion() {
		return this.nombre;
	}

	public static TipoDeAtraccion valueOf(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getId() {
		return this.id;
	}

}