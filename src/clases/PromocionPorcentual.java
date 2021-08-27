package clases;

import java.util.List;

public class PromocionPorcentual extends Promocion {
	
	double porcentajeDescuento;

	public PromocionPorcentual(List<Atraccion> atracciones, String nombre, double porcentaje) {
		super(atracciones, nombre);
		this.porcentajeDescuento = porcentaje;
	}
	
	@Override
	public double calcularCostoDePromocion() {
		double costoTotal = this.calcularCostoDeAtracciones();
		return costoTotal - costoTotal * porcentajeDescuento;
	}

	@Override
	public Promocion sugerirPromocion(Usuario usuario) {
		return null;
		
	}

}
