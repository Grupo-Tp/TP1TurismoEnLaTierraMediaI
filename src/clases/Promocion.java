package clases;

import java.util.List;

import excepciones.ExcepcionDeBase;
import excepciones.ExcepcionDePromocion;

public abstract class Promocion extends Base {
	private List<Atraccion> atracciones = null;

	public Promocion(String nombre, double tiempo, double costo, TipoAtraccion tipo, List<Atraccion> atracciones)
			throws ExcepcionDeBase, ExcepcionDePromocion {
		super(nombre, tiempo, costo, tipo);
		this.setAtracciones(atracciones);
	}

	/**
	 * @pre No tiene.
	 * @post No tiene.
	 * @return Lista con las atracciones que incluye la promocion.
	 */
	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

	/**
	 * @pre No Tiene.
	 * @post Se actualizo la lista con las atracciones disponibles.
	 * @param atracciones Lista con atracciones disponibles.
	 * @return No tiene.
	 * @throws ExcepcionDePromocion Nuestra excepcion de error.
	 */
	private void setAtracciones(List<Atraccion> atracciones) throws ExcepcionDePromocion {
		if (atracciones != null) {
			boolean validar = true;
			for (Atraccion indice : atracciones) {
				validar = validar && (this.getTipo() == indice.getTipo());
			}
			if (validar)
				this.atracciones = atracciones;
			else
				throw new ExcepcionDePromocion(
						"asignar la lista de atracciones, ya que el tipo de atraccion de una o más atracciones"
								+ " no coincide con el tipo de atracciones de la promocion");
		} else
			throw new ExcepcionDePromocion("asignar la lista de atracciones, ya que esta es nula o esta vacia");
	}

	/**
	 * @pre No tiene.
	 * @post Se redujo en uno el cupo de todas las atracciones que componen la
	 *       promocion.
	 */
	public void subirAtraccion() {
		for (Atraccion indice : this.getAtracciones()) {
			indice.subirAtraccion();
		}
	}

	/**
	 * @pre No tiene.
	 * @post Busco y recupero los nombres de las atracciones que componen la
	 *       promocion.
	 * @return String con los nombres de las atracciones que la componen.
	 */
	public abstract String imprimir();

}
