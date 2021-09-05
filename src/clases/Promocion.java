package clases;

import java.util.List;

public abstract class Promocion extends Base {
	private List<Atraccion> atracciones;

	public Promocion(String nombre, double tiempo, double costo, TipoAtraccion tipo, List<Atraccion> atracciones) {
		super(nombre, tiempo, costo, tipo);
		this.setAtracciones(atracciones);
	}

	/**
	 * @pre No Tiene.
	 * @post Se suguirio una promocion posible para un usuario determinado.
	 * @param usuario Usuario para el cual se crea la promocion determinada.
	 * @return Una Promocion para un Usuario.
	 */
	protected abstract Base sugerirPromocion(Usuario usuario);

	/**
	 * @pre No tiene.
	 * @post No tiene.
	 * @return Lista con las atracciones que incluye la promocion.
	 */
	protected List<Atraccion> getAtracciones() {
		return atracciones;
	}

	/**
	 * @pre No Tiene.
	 * @post Se actualizo la lista con las atracciones disponibles.
	 * @param atracciones Lista con atracciones disponibles.
	 * @return No tiene.
	 */
	private void setAtracciones(List<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}
}
