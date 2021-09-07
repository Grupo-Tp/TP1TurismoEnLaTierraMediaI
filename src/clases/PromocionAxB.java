package clases;

import java.util.ArrayList;
import java.util.List;

import excepciones.ExcepcionDeBase;
import excepciones.ExcepcionDePromocion;

public class PromocionAxB extends Promocion {
	private Atraccion atraccionGratis;

	public PromocionAxB(String nombre, TipoAtraccion tipo, List<Atraccion> atracciones, Atraccion atraccionGratis)
			throws ExcepcionDeBase, ExcepcionDePromocion {
		super(nombre, PromocionPorcentual.calcularTiempo(atracciones), calcularCosto(atracciones), tipo, atracciones);
		this.setAtraccionGratis(atraccionGratis);
	}

	/**
	 * @pre No tiene.
	 * @post Se calculo el costo de todas las atracciones.
	 * @param atracciones Lista de atracciones que incluye la promocion.
	 * @return Costo total de todas las atracciones.
	 */
	protected static double calcularCosto(List<Atraccion> atracciones) {
		double costo = 0;
		for (Atraccion atraccion : atracciones) {
			costo += atraccion.getCosto();
		}
		return costo;
	}

	/**
	 * @pre No tiene.
	 * @post No tiene.
	 * @return La atraccion que la promocion ofrece gratis.
	 */
	public Atraccion getAtraccionGratis() {
		return atraccionGratis;
	}

	/**
	 * @pre No tiene.
	 * @post Se asigno la atraccion que es gratiuta en esta promocion.
	 * @param atraccionGratis Atraccion que ofrece gratuita la promocion.
	 * @throws ExcepcionDePromocion Nuestra excepcion de Promocion.
	 */
	private void setAtraccionGratis(Atraccion atraccionGratis) throws ExcepcionDePromocion {
		if (atraccionGratis != null)
			this.atraccionGratis = atraccionGratis;
		else
			throw new ExcepcionDePromocion("asignar su promocion gratis, ya que esta es nula o esta vacia");
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
			usuario.aceptarSugerencia(this);
	}
}
