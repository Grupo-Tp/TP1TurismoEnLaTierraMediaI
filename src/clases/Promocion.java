package clases;

import java.util.List;

public abstract class Promocion extends Base {
	private List<Atraccion> atracciones;
	private double costo;

	public Promocion(List<Atraccion> atracciones, String nombre) {
		super(nombre, 0);
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
	public abstract Promocion sugerirPromocion(Usuario usuario);

	/**
	 * @pre No tiene.
	 * @post No tiene.
	 * @return Costo de la Promocion.
	 */
	public double getCosto() {
		return costo;
	}

	/**
	 * @pre No Tiene.
	 * @post Se actualizo el costo de la Promocion.
	 * @param costo Precio que tendra el costo de la Promocion a actualizar.
	 * @return No tiene.
	 */
	public void setCosto(double costo) {
		this.costo = costo;
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
	 * @post Se actualizo la lista con las atracciones que incluye la Promocion.
	 * @param atracciones Lista con atracciones que incluye la Promocion.
	 * @return No tiene.
	 */
	public void setAtracciones(List<Atraccion> atracciones) {
		this.atracciones = atracciones;
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
