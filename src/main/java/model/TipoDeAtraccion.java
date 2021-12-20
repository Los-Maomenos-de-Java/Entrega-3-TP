package model;

public class TipoDeAtraccion {

	private Integer id;
	private String nombre;

	public TipoDeAtraccion(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
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

}