package comparadores;

import java.util.Comparator;

import clases.Atraccion;

public class TiempoDeAtraccionComparador implements Comparator<Atraccion> {

	@Override
	public int compare(Atraccion atraccionFija, Atraccion atraccionIndice) {
		return (int) atraccionFija.getTiempo() + (int) atraccionIndice.getTiempo();
	}

}
