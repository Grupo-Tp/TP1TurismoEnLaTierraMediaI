package clases;

import java.util.List;

import excepciones.ExcepcionDeBase;
import excepciones.ExcepcionDePromocion;

public abstract class Promocion extends Base {
	private List<Atraccion> atracciones;

	public Promocion(String nombre, double tiempo, double costo, TipoAtraccion tipo, List<Atraccion> atracciones)
			throws ExcepcionDeBase, ExcepcionDePromocion {
		super(nombre, tiempo, costo, tipo);
		this.setAtracciones(atracciones);
	}

	/**
	 * @pre No Tiene.
	 * @post Se suguirio una promocion posible para un usuario determinado.
	 * @param usuario Usuario para el cual se crea la promocion determinada.
	 * @return Una Promocion para un Usuario.
	 */
	public abstract void sugerirPromocion(Usuario usuario);

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
	 * @throws ExcepcionDePromocion Nuestra excepcion de error.
	 */
	private void setAtracciones(List<Atraccion> atracciones) throws ExcepcionDePromocion {
		if (atracciones != null)
			this.atracciones = atracciones;
		else
			throw new ExcepcionDePromocion("asignar la lista de atracciones, ya que esta es nula o esta vacia");
	}

	private String imprimir() {
		String retorno = "";
		for (Atraccion indice : this.getAtracciones()) {
			retorno += indice.getNombre() + ", ";
		}
		return retorno;
	}

	@Override
	public String toString() {
		return this.getNombre() + ", que incluye a las atracciones de " + this.imprimir() + "que son de tipo "
				+ this.getTipo().toString() + ", con un costo de " + this.getCosto()
				+ " monedas de oro, un tiempo necesario para recorrerlas de " + super.getTiempo() + " horas";
	}

}
