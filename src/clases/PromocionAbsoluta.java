package clases;

import java.util.List;

import excepciones.ExcepcionDeAtraccion;
import excepciones.ExcepcionDeBase;
import excepciones.ExcepcionDePromocion;

public class PromocionAbsoluta extends Promocion {

	public PromocionAbsoluta(String nombre, TipoAtraccion tipo, String[] nombresDeAtracciones,
			List<Atraccion> atracciones, double precioFinal)
			throws ExcepcionDeBase, ExcepcionDePromocion, ExcepcionDeAtraccion {
		super(nombre, PromocionPorcentual.calcularTiempo(atracciones, nombresDeAtracciones), precioFinal, tipo,
				nombresDeAtracciones, atracciones);
	}

	@Override
	public String imprimir() {
		String retorno = "";
		retorno += this.getNombresDeAtracciones().get(0) + " y ";
		retorno += this.getNombresDeAtracciones().get(1);
		return retorno;
	}

	@Override
	public String toString() {
		return this.getNombre() + ", que incluye a las atracciones de " + this.imprimir() + " que son de tipo "
				+ this.getTipo().toString() + ", con un costo de " + this.getCosto()
				+ " monedas de oro, un tiempo necesario para recorrerlas de " + super.getTiempo() + " horas";
	}
}