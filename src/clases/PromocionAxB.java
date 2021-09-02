package clases;

import java.util.List;

public class PromocionAxB extends Promocion {
	private int cantidadDeAtracciones;

	public PromocionAxB(String nombre, TipoAtraccion tipo, List<Atraccion> atracciones) {
		super(nombre, tipo, atracciones);
		this.setCantidadDeAtracciones(0);
	}

	/**
	 * @pre No tiene.
	 * @post No tiene.
	 * @return Cantidad de la atracciones que son necesarias comprar para ofrecer la
	 *         promocion.
	 */
	public int getCantidadDeAtracciones() {
		return cantidadDeAtracciones;
	}

	/**
	 * @pre No Tiene.
	 * @post Se actualizo la cantidad de atracciones que deben ser compradas para
	 *       obtener una promocion.
	 * @param cantidadDeAtracciones Numero de atracciones que se cobran para ofrecer
	 *                              una promocion.
	 * @return No tiene.
	 */
	public void setCantidadDeAtracciones(int cantidadDeAtracciones) {
		this.cantidadDeAtracciones = cantidadDeAtracciones;
	}

	@Override
	public Base sugerirPromocion(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
