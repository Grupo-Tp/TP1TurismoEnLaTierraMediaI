package clases;

import java.util.List;

public class PromocionPorcentual extends Promocion {

	double porcentajeDescuento;

	public PromocionPorcentual(TipoAtraccion tipo, List<Atraccion> atracciones, double porcentaje) {
		super(tipo, atracciones);
		this.porcentajeDescuento = porcentaje;
	}

	/**
	 * @pre No tiene.
	 * @post No tiene.
	 * @return Cantidad de descuento en porcentaje que tiene la promocion.
	 */
	public double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	@Override
	public Base sugerirPromocion(Usuario usuario) {
		return null;

	}

}
