package comparadores;

import java.util.Comparator;

import clases.Atraccion;

public class TipoDeAtraccionComparador implements Comparator<Atraccion> {

	@Override
	public int compare(Atraccion atraccionFija, Atraccion atraccionIndice) {
		return atraccionFija.getTipo().name().compareTo(atraccionIndice.getTipo().name());
	}

}
