package clases;

import java.util.List;

public class PromocionAxB extends Promocion {
	
	//Atraccion atraccionDeRegalo; 
	
	/**
	 * @pre la atraccion de regalo será la primera de lista de atracciones
	 */
	public PromocionAxB(List<Atraccion> atracciones, String nombre) {
		super(atracciones, nombre);
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

}
