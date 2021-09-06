package clases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import excepciones.ExcepcionDeBase;
import excepciones.ExcepcionDePromocion;

public class PromocionAbsoluta extends Promocion {

	public PromocionAbsoluta(String nombre, TipoAtraccion tipo, List<Atraccion> atracciones, double precioFinal)
			throws ExcepcionDeBase, ExcepcionDePromocion {
		super(nombre, PromocionPorcentual.calcularTiempo(atracciones), precioFinal, tipo, atracciones);
	}

	@Override
	public Base sugerirPromocion(Usuario usuario) {
		List<Atraccion> misAtracciones = new ArrayList<Atraccion>();
		List<Atraccion> atraccionesDeLaPromocion = new ArrayList<Atraccion>();
		List<Base> itinerario = new ArrayList<Base>();
		double tiempoDeUsusario = 0, presupuesto = 0;
		boolean cupo = false, laVisito = false;
		TipoAtraccion preferencia = null;
		misAtracciones = this.getAtracciones();
		itinerario = usuario.getItinerario();
		tiempoDeUsusario = usuario.getTiempo();
		presupuesto = usuario.getPresupuesto();
		preferencia = usuario.getPreferencia();
		for (Atraccion miAtraccion : misAtracciones) {
			laVisito = usuario.atraccionRecorrida(miAtraccion);
			if (miAtraccion.getCupo() >= 1) {
				cupo = true;
			} else
				cupo = false;
		}

		if ((this.getTiempo() <= tiempoDeUsusario) && (this.getCosto() <= presupuesto) && cupo && !laVisito) {
			if (!itinerario.isEmpty()) {

				return this;
			} else
				return this;
		}
		return this;
	}

}
