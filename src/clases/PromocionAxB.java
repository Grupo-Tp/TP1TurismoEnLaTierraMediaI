package clases;

import java.util.List;

import excepciones.ExcepcionDeAtraccion;
import excepciones.ExcepcionDeBase;
import excepciones.ExcepcionDePromocion;

public class PromocionAxB extends Promocion {
	private String atraccionGratis;

	public PromocionAxB(String nombre, TipoAtraccion tipo, String[] nombresDeAtracciones, List<Atraccion> atracciones,
			String atraccionGratis) throws ExcepcionDeBase, ExcepcionDePromocion, ExcepcionDeAtraccion {
		super(nombre, PromocionPorcentual.calcularTiempo(atracciones, nombresDeAtracciones),
				calcularCosto(atracciones, nombresDeAtracciones), tipo, nombresDeAtracciones, atracciones);
		this.setAtraccionGratis(atraccionGratis);
	}

	/**
	 * @pre No tiene.
	 * @post Se calculo el costo de todas las atracciones contenidas en los nombres
	 *       de atracciones.
	 * @param atracciones          Lista de atracciones que incluye la promocion.
	 * @param nombresDeAtracciones Nombres de atracciones a calcular su costo
	 * @return Costo total de todas las atracciones contenidas en los nombres de las
	 *         atracciones.
	 */
	protected static double calcularCosto(List<Atraccion> atracciones, String[] nombresDeAtracciones) {
		double costo = 0;
		String gratis = "";
		for (String atraccion : nombresDeAtracciones) {
			costo += Atraccion.buscarAtraccionPorNombre(atraccion, atracciones).getCosto();
			gratis = atraccion;
		}
		costo -= Atraccion.buscarAtraccionPorNombre(gratis, atracciones).getCosto();
		return costo;
	}

	/**
	 * @pre No tiene.
	 * @post Retorno el nombrede la traccion gratis.
	 * @return La atraccion que la promocion ofrece gratis.
	 */
	public String getAtraccionGratis() {
		return atraccionGratis;
	}

	/**
	 * @pre No tiene.
	 * @post Se asigno el nombte de la atraccion que es gratiuta en esta promocion.
	 * @param atraccionGratis Atraccion que ofrece gratuita la promocion.
	 * @throws ExcepcionDePromocion Informo la existencia de un error al momento de
	 *                              asignar el el nombre de la atraccion, ya que
	 *                              esta no se encuentra en la lista de atracciones.
	 */
	private void setAtraccionGratis(String atraccionGratis) throws ExcepcionDePromocion {
		if (this.getNombresDeAtracciones().contains(atraccionGratis))
			this.atraccionGratis = atraccionGratis;
		else
			throw new ExcepcionDePromocion(
					"asignar su promocion gratis, ya que esta no se encuentra en la lista de atracciones que incluye la promocion");
	}

	@Override
	public String imprimir() {
		String retorno = "";
		retorno += this.getNombresDeAtracciones().get(0) + ", ";
		retorno += this.getNombresDeAtracciones().get(1) + " y ";
		retorno += this.getNombresDeAtracciones().get(2);
		return retorno;
	}

	@Override
	public String toString() {
		return this.getNombre() + ", que incluye a las atracciones de " + this.imprimir() + " que son de tipo "
				+ this.getTipo().toString() + ", con un costo de " + this.getCosto()
				+ " monedas de oro, un tiempo necesario para recorrerlas de " + super.getTiempo() + " horas";
	}
}
