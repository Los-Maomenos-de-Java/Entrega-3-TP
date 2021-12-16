package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import utils.Crypt;

public class Usuario {
	private String nombre;
	private Integer id;
	private String password;
	private double presupuestoActual;
	private double tiempoDisponible;
	private final double PRESUPUESTO_INICIAL;
	private final double TIEMPO_INICIAL;
	private TipoDeAtraccion tipoDeAtraccionPreferida;
	private List<Ofertable> ofertasCompradas = new ArrayList<>();
	private Boolean admin;

	public Usuario(Integer id, String nombre, String password, double presupuestoActual, double tiempoDisponible,
			TipoDeAtraccion tipoDeAtraccionPreferida, boolean admin) {

		super();
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		if (presupuestoActual < 0) {
			throw new Error("Presupuesto Inválido");
		}
		if (tiempoDisponible < 0) {
			throw new Error("Tiempo Disponible Inválido");
		}
		this.PRESUPUESTO_INICIAL = presupuestoActual;
		this.TIEMPO_INICIAL = tiempoDisponible;
		this.presupuestoActual = PRESUPUESTO_INICIAL;
		this.tiempoDisponible = TIEMPO_INICIAL;
		this.tipoDeAtraccionPreferida = tipoDeAtraccionPreferida;
		this.admin = admin;
	}

	public String comprarOferta(Ofertable ofertable) {
		presupuestoActual -= ofertable.getCosto();
		tiempoDisponible -= ofertable.getTiempo();
		ofertasCompradas.add(ofertable);
		return ofertasCompradas.toString();

	}

	public List<Ofertable> getOfertasCompradas() {
		return this.ofertasCompradas;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public Boolean isAdmin() {
		return this.admin;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", id=" + id + ", password=" + password + ", presupuestoActual="
				+ presupuestoActual + ", tiempoDisponible=" + tiempoDisponible + ", PRESUPUESTO_INICIAL="
				+ PRESUPUESTO_INICIAL + ", TIEMPO_INICIAL=" + TIEMPO_INICIAL + ", tipoDeAtraccionPreferida="
				+ tipoDeAtraccionPreferida + ", ofertasCompradas=" + ofertasCompradas + ", admin=" + admin + "]";
	}

	public String getPassword() {
		return password;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = Crypt.hash(password);
	}

	public boolean checkPassword(String password) {
		return Crypt.match(password, this.password);
	}

	public boolean isNull() {
		return false;
	}

	public boolean puedeVisitar(Ofertable ofertable) {
		return this.tiempoDisponible >= ofertable.getTiempo() && this.presupuestoActual >= ofertable.getCosto();
	}

	public String getNombre() {
		return nombre;
	}

	public double getPresupuestoActual() {
		return presupuestoActual;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public double getPresupuestoInicial() {
		return this.PRESUPUESTO_INICIAL;
	}

	public double getTiempoInicial() {
		return this.TIEMPO_INICIAL;
	}

	public TipoDeAtraccion getTipoDeAtraccionPreferida() {
		return this.tipoDeAtraccionPreferida;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Usuario that = (Usuario) o;
		return nombre.equals(that.nombre) && Double.compare(presupuestoActual, that.presupuestoActual) == 0
				&& Double.compare(tiempoDisponible, that.tiempoDisponible) == 0
				&& tipoDeAtraccionPreferida.equals(that.tipoDeAtraccionPreferida);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, presupuestoActual, tiempoDisponible, tipoDeAtraccionPreferida);
	}

	public Integer getId() {
		return id;
	}

	public List<Ofertable> setOfertasCompradas(List<Ofertable> ofertasCompradas) {
		this.ofertasCompradas.addAll(ofertasCompradas);
		return ofertasCompradas;
	}

}