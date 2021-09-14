package clases;

import java.util.List;

import excepciones.ExcepcionDeAtraccion;
import excepciones.ExcepcionDeBase;
import excepciones.ExcepcionDePromocion;

public class PromocionPorcentual extends Promocion {

	double porcentajeDescuento;

	public PromocionPorcentual(String nombre, TipoAtraccion tipo, String[] nombresDeAtracciones,
			List<Atraccion> atracciones, double porcentaje)
			throws ExcepcionDeBase, ExcepcionDePromocion, ExcepcionDeAtraccion {
		super(nombre, calcularTiempo(atracciones, nombresDeAtracciones),
				calcularCosto(atracciones, nombresDeAtracciones, porcentaje), tipo, nombresDeAtracciones, atracciones);
		this.setPorcentajeDescuento(porcentaje);
	}

	/**
	 * @pre No tiene.
	 * @post Se calculo el costo de todas las atracciones y aplico el descuento.
	 * @param atracciones Lista de atracciones que incluye la promocion.
	 * @return Costo total de todas las atracciones con el porcentaje de descuento
	 *         aplicado.
	 * @throws ExcepcionDePromocion Nuestra excepcion de errores.
	 */
	private static double calcularCosto(List<Atraccion> atracciones, String[] nombresDeAtracciones, double porcentaje)
			throws ExcepcionDePromocion {
		double costo = 0;
		for (String atraccion : nombresDeAtracciones) {
			costo += Atraccion.buscarAtraccionPorNombre(atraccion, atracciones).getCosto();
		}
		return costo * validarPorcentaje(porcentaje);
	}

	/**
	 * @pre No tiene.
	 * @post Se valido que el porcentaje de descuento.
	 * @param porcentaje Valor que de descuento que tiene la promocion.
	 * @return El porcentaje de descuento de la promocion.
	 * @throws ExcepcionDePromocion Nuestra excepcion de errores.
	 */
	private static double validarPorcentaje(double porcentaje) throws ExcepcionDePromocion {
		if ((porcentaje > 0) && (porcentaje < 100))
			return (1 - (porcentaje / 100));
		else {
			throw new ExcepcionDePromocion(
					"asignar su porcentaje de descuento, ya que este es invalido: " + porcentaje);
		}
	}

	/**
	 * @pre No tiene.
	 * @post Se calculo la duracion de todas las atracciones.
	 * @param atracciones Lista de atracciones que incluye la promocion.
	 * @return Duracion total de todas las atracciones que incluye la promocion.
	 * @throws ExcepcionDeAtraccion Nuestra excepcion de errores.
	 */
	protected static double calcularTiempo(List<Atraccion> atracciones, String[] nombresDeAtracciones)
			throws ExcepcionDeAtraccion {
		double tiempo = 0;
		if (atracciones != null && nombresDeAtracciones != null && nombresDeAtracciones.length > 1)
			for (String atraccion : nombresDeAtracciones) {
				tiempo += Atraccion.buscarAtraccionPorNombre(atraccion, atracciones).getTiempo();
			}
		else
			throw new ExcepcionDeAtraccion(
					"calcular el tiempo necesario para recorrer la promocion, ya que la lista de atracciones es nula");
		return tiempo;
	}

	/**
	 * @pre No tiene.
	 * @post No tiene.
	 * @return Cantidad de descuento en porcentaje que tiene la promocion.
	 */
	public double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	/**
	 * @pre No Tiene.
	 * @post Se actualizo el porcentaje de descuento del costo de las atracciones
	 *       contenidas en la promocion.
	 * @param porcentaje Monto con el porcentaje de descuento.
	 * @return No tiene.
	 * @throws ExcepcionDePromocion Nuestra excepcion de error.
	 */
	private void setPorcentajeDescuento(double porcentaje) throws ExcepcionDePromocion {
		if ((porcentaje > 0) && (porcentaje < 100))
			this.porcentajeDescuento = porcentaje;
		else {
			throw new ExcepcionDePromocion(
					"asignar su porcentaje de descuento, ya que este es invalido: " + porcentaje);
		}
	}

	@Override
	public String imprimir() {
		String retorno = "";
		retorno += this.getNombresDeAtracciones().get(0) + " y ";
		retorno += this.getNombresDeAtracciones().get(1);
		return retorno;
	}

	@Override
	public String toString() {
		return this.getNombre() + ", que incluye a las atracciones de " + this.imprimir() + " que son de tipo "
				+ this.getTipo().toString() + ", con un costo de " + this.getCosto()
				+ " monedas de oro, un tiempo necesario para recorrerlas de " + super.getTiempo() + " horas";
	}
}
