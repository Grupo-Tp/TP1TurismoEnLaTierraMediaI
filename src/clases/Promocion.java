package clases;

import java.util.List;

public abstract class Promocion extends Base {
	private List<Atraccion> atracciones;

	public Promocion(String nombre, TipoAtraccion tipo, List<Atraccion> atracciones) {
		super(nombre, 0, 0, tipo);
		this.setAtracciones(atracciones);
		this.setCosto(this.calcularCostoDePromocion());
		this.setTiempo(this.calcularSumaDeTiempoDeAtracciones());
	}

	/**
	 * @pre No Tiene.
	 * @post Se suguirio una promocion posibles para un usuario determinado.
	 * @param usuario Usuario para el cual se crea la promocion determinada.
	 * @return Una Promocion para un Usuario.
	 */
	public abstract Base sugerirPromocion(Usuario usuario);

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
	 */
	public void setAtracciones(List<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}

	/**
	 * @pre No Tiene.
	 * @post Se agrego una atraccion a la lista de atracciones disponibles.
	 * @param atraccion Atraccion disponible para ser usada en una promocion o
	 *                  sugerencia.
	 * @return No tiene.
	 */
	public void anadirAtraccion(Atraccion atraccion) {
		this.atracciones.add(atraccion);
	}

	public abstract double calcularCostoDePromocion();

	// sum costo atracciones > costo de promocion
	public double calcularCostoDeAtracciones() {
		double costoTotal = 0;
		for (Atraccion atraccion : this.getAtracciones()) {
			costoTotal += atraccion.getCosto();
		}
		return costoTotal;
	}

	public double calcularSumaDeTiempoDeAtracciones() {
		double tiempoTotal = 0;
		for (Atraccion atraccion : this.getAtracciones()) {
			tiempoTotal += atraccion.getTiempo();
		}
		return tiempoTotal;
	}
}
