package clases;

import java.util.ArrayList;
import java.util.List;

import excepciones.ExcepcionDeBase;
import excepciones.ExcepcionDePromocion;

public class PromocionPorcentual extends Promocion {

	double porcentajeDescuento;

	public PromocionPorcentual(String nombre, TipoAtraccion tipo, List<Atraccion> atracciones, double porcentaje)
			throws ExcepcionDeBase, ExcepcionDePromocion {
		super(nombre, calcularTiempo(atracciones), calcularCosto(atracciones, porcentaje), tipo, atracciones);
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
	private static double calcularCosto(List<Atraccion> atracciones, double porcentaje) throws ExcepcionDePromocion {
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
	 * @throws ExcepcionDePromocion Nuestra excepcion de errores.
	 */
	private static double validarPorcentaje(double porcentaje) throws ExcepcionDePromocion {
		if ((porcentaje > 0) && (porcentaje < 100))
			return (1 + (porcentaje / 100));
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
	public void sugerirPromocion(Usuario usuario) {
		List<Atraccion> misAtracciones = new ArrayList<Atraccion>();
		boolean cupo = true, noLaVisito = true;
		misAtracciones = this.getAtracciones();
		double tiempoDeUsusario = usuario.getTiempo();
		double presupuesto = usuario.getPresupuesto();
		for (Atraccion miAtraccion : misAtracciones) {
			cupo = cupo && (miAtraccion.getCupo() >= 1);
			noLaVisito = noLaVisito && (usuario.getAtraccionesDeSuItinerario().contains(miAtraccion));
		}
		if ((this.getTiempo() <= tiempoDeUsusario) && (this.getCosto() <= presupuesto) && cupo && noLaVisito)
			if (usuario.aceptarSugerencia(this))
				this.subirAtraccion();
	}
}
