package clases;

import java.util.List;

import excepciones.ExcepcionDeAtraccion;
import excepciones.ExcepcionDeBase;
import excepciones.ExcepcionDePromocion;

public class PromocionAxB extends Promocion {
	private Atraccion atraccionGratis;

	public PromocionAxB(String nombre, TipoAtraccion tipo, List<Atraccion> atracciones, Atraccion atraccionGratis)
			throws ExcepcionDeBase, ExcepcionDePromocion, ExcepcionDeAtraccion {
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
		for (int indice = 0; indice < atracciones.size() - 1; indice++) {
			costo += atracciones.get(indice).getCosto();
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
	public String imprimir() {
		String retorno = "";
		retorno += this.getAtracciones().get(0).getNombre() + ", ";
		retorno += this.getAtracciones().get(1).getNombre() + " y ";
		retorno += this.getAtracciones().get(2).getNombre();
		return retorno;
	}

	@Override
	public String toString() {
		return this.getNombre() + ", que incluye a las atracciones de " + this.imprimir() + " que son de tipo "
				+ this.getTipo().toString() + ", con un costo de " + this.getCosto()
				+ " monedas de oro, un tiempo necesario para recorrerlas de " + super.getTiempo() + " horas";
	}
}
