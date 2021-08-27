package clases;

import java.util.List;

public class PromocionAxB extends Promocion {
	
	Atraccion atraccionDeRegalo; 
	
	/**
	 * @pre atraccionDeRegalo debe estar dentro de la lista de atracciones de la promocion
	 */
	public PromocionAxB(List<Atraccion> atracciones, String nombre, Atraccion atraccionDeRegalo) {
		super(atracciones, nombre);
		this.atraccionDeRegalo = atraccionDeRegalo;
	}
	
	@Override
	public double calcularCostoDePromocion() {
		return this.calcularCostoDeAtracciones() - atraccionDeRegalo.getCosto();
	}

	@Override
	public Promocion sugerirPromocion(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
