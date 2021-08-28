package clases;

import java.util.List;

public class PromocionAxB extends Promocion {
	private int cantidadDeAtracciones;
	//Atraccion atraccionDeRegalo; 
	
	/**
	 * @pre la atraccion de regalo ser� la primera de lista de atracciones
	 */
	public PromocionAxB(String nombre, TipoAtraccion tipo, List<Atraccion> atracciones) {
		super(nombre, tipo, atracciones);
		this.setCantidadDeAtracciones(0);
		//this.atraccionDeRegalo = atraccionDeRegalo;
	}
	
	@Override
	public double calcularCostoDePromocion() {
		return this.calcularCostoDeAtracciones() - this.getCostoAtraccionDeRegalo();
	}

	private double getCostoAtraccionDeRegalo() {
		Atraccion atraccionDeRegalo = this.getAtracciones().get(0);
		return atraccionDeRegalo.getCosto();
	}

	@Override
	public Promocion sugerirPromocion(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the cantidadDeAtracciones
	 */
	public int getCantidadDeAtracciones() {
		return cantidadDeAtracciones;
	}

	/**
	 * @param cantidadDeAtracciones the cantidadDeAtracciones to set
	 */
	public void setCantidadDeAtracciones(int cantidadDeAtracciones) {
		this.cantidadDeAtracciones = cantidadDeAtracciones;
	}

}
