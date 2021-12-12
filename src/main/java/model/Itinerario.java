package model;

import java.util.ArrayList;
import java.util.List;

public class Itinerario {
    private List<Ofertable> ofertas = new ArrayList<>();

    public Itinerario(List<Ofertable> ofertasVendidas) {
        ofertas.addAll(ofertasVendidas);
    }

    public void mostrar() {
        System.out.println(this);
    }

    public List<Ofertable> getOfertas() {
        return ofertas;
    }
}