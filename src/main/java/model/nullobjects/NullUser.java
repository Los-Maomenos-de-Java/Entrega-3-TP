package model.nullobjects;

import model.Usuario;
import model.TipoDeAtraccion;

public class NullUser extends Usuario {

	public static Usuario build() {
		return new NullUser();
	}
	
	public NullUser() {
		super(0, "", "", 0, 0.0, null, false);
	}
	
	public boolean isNull() {
		return true;
	}
	
}