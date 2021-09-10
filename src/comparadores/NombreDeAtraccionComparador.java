package comparadores;

import java.util.Comparator;

import clases.Atraccion;

public class NombreDeAtraccionComparador implements Comparator<Atraccion> {

	@Override
	public int compare(Atraccion atraccionFija, Atraccion atraccionIndice) {
		return atraccionFija.getNombre().compareTo(atraccionIndice.getNombre());
	}

}
