package clases;

import java.util.List;

public class PromocionAbsoluta extends Promocion {
	
	double descuentoAbsoluto;

	public PromocionAbsoluta(List<Atraccion> atracciones, String nombre, double descuentoAbsoluto) {
		super(atracciones, nombre);
		this.descuentoAbsoluto = descuentoAbsoluto;
	}
	
	@Override
	public double calcularCostoDePromocion() {
		return this.calcularCostoDeAtracciones() - descuentoAbsoluto;
	}

	@Override
	public Promocion sugerirPromocion(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
