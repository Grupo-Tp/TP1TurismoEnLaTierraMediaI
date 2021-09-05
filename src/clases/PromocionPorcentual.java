package clases;

import java.util.List;

public class PromocionPorcentual extends Promocion {

	double porcentajeDescuento;

	public PromocionPorcentual(String nombre, TipoAtraccion tipo, List<Atraccion> atracciones, double porcentaje) {
		super(nombre, calcularTiempo(atracciones), calcularCosto(atracciones, porcentaje), tipo, atracciones);
		this.setPorcentajeDescuento(porcentaje);
	}

	/**
	 * @pre No tiene.
	 * @post Se calculo el costo de todas las atracciones y aplico el descuento.
	 * @param atracciones Lista de atracciones que incluye la promocion.
	 * @return Costo total de todas las atracciones con el porcentaje de descuento
	 *         aplicado.
	 */
	private static double calcularCosto(List<Atraccion> atracciones, double porcentaje) {
		double costo = 0;
		for (Atraccion atraccion : atracciones) {
			costo += atraccion.getCosto();
		}
		return costo * validarPorcentaje(porcentaje);
	}

	/**
	 * @pre No tiene.
	 * @post Se valido que el porcentaje de descuento.
	 * @param porcentaje Valor que de descuento que tiene la promocion.
	 * @return El porcentaje de descuento de la promocion.
	 */
	private static double validarPorcentaje(double porcentaje) {
		if ((porcentaje > 0) && (porcentaje < 100))
			return (1 + (porcentaje / 100));
		else {
			System.out.println(""); // informar
			return 0;
		}
	}

	/**
	 * @pre No tiene.
	 * @post Se calculo la duracion de todas las atracciones.
	 * @param atracciones Lista de atracciones que incluye la promocion.
	 * @return Duracion total de todas las atracciones que incluye la promocion.
	 */
	protected static double calcularTiempo(List<Atraccion> atracciones) {
		double tiempo = 0;
		for (Atraccion atraccion : atracciones) {
			tiempo += atraccion.getTiempo();
		}
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
	 */
	private void setPorcentajeDescuento(double porcentaje) {
		this.porcentajeDescuento = porcentaje;
	}

	@Override
	public Base sugerirPromocion(Usuario usuario) {
		return null;

	}

}
