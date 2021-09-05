package clases;

import java.util.List;

public class PromocionAxB extends Promocion {
	private Atraccion atraccionGratis;

	public PromocionAxB(String nombre, TipoAtraccion tipo, List<Atraccion> atracciones, Atraccion atraccionGratis) {
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
	 * @pre
	 * @post
	 * @return La atraccion que la promocion ofrece gratis.
	 */
	public Atraccion getAtraccionGratis() {
		return atraccionGratis;
	}

	/**
	 * @pre
	 * @post
	 * @param atraccionGratis Atraccion que ofrece gratuita la promocion.
	 */
	private void setAtraccionGratis(Atraccion atraccionGratis) {
		this.atraccionGratis = atraccionGratis;
	}

	@Override
	public Base sugerirPromocion(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}
}
