package model;

import java.util.List;
import java.util.Objects;

import persistence.impl.AtraccionDAOImpl;

public class Atraccion implements Ofertable {

	private Integer id;
	private String nombre;
	private Integer costoVisita;
	private Double tiempoPromedio;
	private TipoDeAtraccion tipoDeAtraccion;
	private Integer cupo;

	public Atraccion(String nombre, Integer costoVisita, Double tiempoPromedio, TipoDeAtraccion tipoDeAtraccion,
			Integer cupo) {
		super();
		if (costoVisita < 0) {
			throw new Error("Costo Inválido");
		}

		if (tiempoPromedio < 0) {
			throw new Error("Tiempo de visita Inválido");
		}

		if (cupo < 0) {
			throw new Error("Cupo Inválido");
		}

		this.nombre = nombre;
		this.costoVisita = costoVisita;
		this.tiempoPromedio = tiempoPromedio;
		this.tipoDeAtraccion = tipoDeAtraccion;
		this.cupo = cupo;
	}

	public Atraccion(Integer id, String nombre, Integer costoVisita, Double tiempoPromedio,
			TipoDeAtraccion tipoDeAtraccion, Integer cupo) {
		this(nombre, costoVisita, tiempoPromedio, tipoDeAtraccion, cupo);
		this.id = id;
	}

	@Override
	public void serComprada() {
		this.cupo--;
		AtraccionDAOImpl atraccionDAOImpl = new AtraccionDAOImpl();
		atraccionDAOImpl.update(this);
	}

	@Override
	public boolean tieneCupo() {
		return this.cupo > 0;
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public Integer getCosto() {
		return this.costoVisita;
	}

	@Override
	public Double getTiempo() {
		return this.tiempoPromedio;
	}

	@Override
	public Integer getCupo() {
		return this.cupo;
	}

	@Override
	public TipoDeAtraccion getTipo() {
		return this.tipoDeAtraccion;
	}

	@Override
	public List<Atraccion> getAtracciones() {
		return List.of(this);
	}

	@Override
	public boolean esPromocion() {
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Atraccion atraccion = (Atraccion) o;
		return Double.compare(atraccion.costoVisita, costoVisita) == 0
				&& Double.compare(atraccion.tiempoPromedio, tiempoPromedio) == 0 && nombre.equals(atraccion.nombre)
				&& tipoDeAtraccion == atraccion.tipoDeAtraccion && Integer.compare(atraccion.cupo, cupo) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, costoVisita, tiempoPromedio, tipoDeAtraccion, cupo);
	}

	@Override
	public String toString() {
		return "Atraccion {" + "Nombre: " + nombre + ", Costo Visita: " + costoVisita + ", Tiempo Promedio: "
				+ tiempoPromedio + ", Cupo: " + this.getCupo() + ", Tipo de Atraccion=" + tipoDeAtraccion + " }";
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;

	}

	public void setCosto(Integer costoVisita) {
		this.costoVisita = costoVisita;

	}

	public void setiempoPromedio(Double tiempoPromedio) {
		this.tiempoPromedio = tiempoPromedio;
	}

	public void settipoDeAtraccion(TipoDeAtraccion tipoDeAtraccion) {
		this.tipoDeAtraccion = tipoDeAtraccion;

	}

	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}

}