package clases;

import java.util.List;

public class PromocionAbsoluta extends Promocion {

	double descuentoAbsoluto;

	public PromocionAbsoluta(String nombre, TipoAtraccion tipo, List<Atraccion> atracciones, double descuentoAbsoluto) {
		super(nombre, tipo, atracciones);
		this.descuentoAbsoluto = descuentoAbsoluto;
	}

	@Override
	public Base sugerirPromocion(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
