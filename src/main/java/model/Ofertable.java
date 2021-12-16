package model;

import java.util.List;

public interface Ofertable {
    String getNombre();

    Integer getCosto();

    Double getTiempo();

    Integer getCupo();

    TipoDeAtraccion getTipo();

    List<Atraccion> getAtracciones();

    boolean esPromocion();

    void serComprada();

    boolean tieneCupo();

	Integer getId();

	Boolean esAtraccion();
}