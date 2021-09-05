package clases;

import java.util.List;

public class PromocionAbsoluta extends Promocion {

	double descuentoAbsoluto;

	public PromocionAbsoluta(String nombre, TipoAtraccion tipo, List<Atraccion> atracciones, double descuentoAbsoluto) {
		super(nombre, PromocionPorcentual.calcularTiempo(atracciones), PromocionAxB.calcularCosto(atracciones), tipo,
				atracciones);
		this.setDescuentoAbsoluto(descuentoAbsoluto);
	}

	public double getDescuentoAbsoluto() {
		return descuentoAbsoluto;
	}

	private void setDescuentoAbsoluto(double descuentoAbsoluto) {
		if(descuentoAbsoluto<0)
			this.descuentoAbsoluto = descuentoAbsoluto;
		else
			System.out.println(""); // informar que el valor absoluto es negativo
	}

	@Override
	public Base sugerirPromocion(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
