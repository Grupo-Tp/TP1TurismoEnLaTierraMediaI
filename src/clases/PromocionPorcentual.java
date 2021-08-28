package clases;

import java.util.List;

public class PromocionPorcentual extends Promocion {

	double porcentajeDescuento;

	public PromocionPorcentual(String nombre, TipoAtraccion tipo, List<Atraccion> atracciones, double porcentaje) {
		super(nombre, tipo, atracciones);
		this.porcentajeDescuento = 1 + (porcentaje / 100);
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
