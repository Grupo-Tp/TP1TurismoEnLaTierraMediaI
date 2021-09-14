package clases;

import java.util.ArrayList;
import java.util.List;

import excepciones.ExcepcionDeBase;
import excepciones.ExcepcionDePromocion;

public abstract class Promocion extends Base {
	private ArrayList<String> nombresDeAtracciones;

	public Promocion(String nombre, double tiempo, double costo, TipoAtraccion tipo, String[] nombresDeAtracciones,
			List<Atraccion> atracciones) throws ExcepcionDeBase, ExcepcionDePromocion {
		super(nombre, tiempo, costo, tipo);
		this.setNombresDeAtracciones(nombresDeAtracciones, atracciones);
	}

	/**
	 * @pre No tiene
	 * @post Retorno la lista con los nombres de atracciones que incluye la
	 *       promocion.
	 * @return the nombresDeAtracciones
	 */
	public ArrayList<String> getNombresDeAtracciones() {
		return nombresDeAtracciones;
	}

	/**
	 * @pre No tiene.
	 * @post Se actualizó los nombres de las atracciones que incluye la promocion.
	 * @param nombresDeAtracciones Nombres de atracciones a actualizar.
	 * @throws ExcepcionDePromocion Informo la existencia de un error al momento de
	 *                              asignar los nombres de las atracciones que
	 *                              incluye la promocion, ya que alguna de ellas
	 *                              tiene un tipo de atraccion que no coincide con
	 *                              el tipo de atracciones contenida en la
	 *                              promocion.
	 */
	private void setNombresDeAtracciones(String[] nombresDeAtracciones, List<Atraccion> atracciones)
			throws ExcepcionDePromocion {
		boolean validar = true;
		ArrayList<String> retorno = new ArrayList<String>();
		if (nombresDeAtracciones.length > 1) {
			for (String nombre : nombresDeAtracciones) {
				validar = validar
						&& this.getTipo() == Atraccion.buscarAtraccionPorNombre(nombre, atracciones).getTipo();
			}
			if (validar)
				for (String nombre : nombresDeAtracciones) {
					retorno.add(nombre);
				}
			if (nombresDeAtracciones.length == retorno.size())
				this.nombresDeAtracciones = retorno;
			else
				throw new ExcepcionDePromocion(
						"asignar la lista de atracciones, ya que el tipo de atraccion de una o más atracciones"
								+ " no coincide con el tipo de atracciones de la promocion");
		} else
			throw new ExcepcionDePromocion("asignar la lista de atracciones ya que la lista de atracciones esta vacía");
	}

	/**
	 * @pre No tiene.
	 * @post Se recuperó el nombre de todas las atracciones contenidas en la
	 *       promocion.
	 * @return String con los nombres de las atracciones que la componen.
	 */
	public abstract String imprimir();

}
