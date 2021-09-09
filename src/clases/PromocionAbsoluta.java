package clases;

import java.util.List;

import excepciones.ExcepcionDeBase;
import excepciones.ExcepcionDePromocion;

public class PromocionAbsoluta extends Promocion {

	public PromocionAbsoluta(String nombre, TipoAtraccion tipo, List<Atraccion> atracciones, double precioFinal)
			throws ExcepcionDeBase, ExcepcionDePromocion {
		super(nombre, PromocionPorcentual.calcularTiempo(atracciones), precioFinal, tipo, atracciones);
	}

	@Override
	public String imprimir() {
		String retorno = "";
		retorno += this.getAtracciones().get(0).getNombre() + " y ";
		retorno += this.getAtracciones().get(1).getNombre();
		return retorno;
	}

	@Override
	public String toString() {
		return this.getNombre() + ", que incluye a las atracciones de " + this.imprimir() + "que son de tipo "
				+ this.getTipo().toString() + ", con un costo de " + this.getCosto()
				+ " monedas de oro, un tiempo necesario para recorrerlas de " + super.getTiempo() + " horas";
	}
}