package comparadores;

import java.util.Comparator;

import clases.Atraccion;

public class PrecioDeAtraccionComparador implements Comparator<Atraccion> {

	@Override
	public int compare(Atraccion atraccionFija, Atraccion atraccionIndice) {
		return (int) atraccionFija.getCosto() + (int) atraccionIndice.getCosto();
	}

}
