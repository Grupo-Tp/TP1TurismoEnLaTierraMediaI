package clases;

import java.util.ArrayList;
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
	 * @pre No tiene.
	 * @post No tiene.
	 * @return Retorna la lista con todas las atracciones incluidas en su itinerario
	 */
	public List<Atraccion> getAtraccionesDeSuItinerario(Usuario usuario) {
		List<Atraccion> retorno = new ArrayList<Atraccion>();
		List<Base> miItinerario = new ArrayList<Base>();
		miItinerario = usuario.getItinerario();
		for (Base baseATratar : miItinerario) {
			if (baseATratar instanceof Promocion) {
				Promocion tratarComoPromocion = (Promocion) baseATratar;
				retorno.addAll(tratarComoPromocion.getAtracciones());
			}
			if (baseATratar instanceof Atraccion) {
				Atraccion tratarComoAtraccion = (Atraccion) baseATratar;
				retorno.add(tratarComoAtraccion);
			}
		}
		return retorno;
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
	protected void subirAtraccion() {
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
	public String imprimir() {
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
