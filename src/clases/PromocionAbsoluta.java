package clases;

import java.util.ArrayList;
import java.util.List;

import excepciones.ExcepcionDeBase;
import excepciones.ExcepcionDePromocion;

public class PromocionAbsoluta extends Promocion {

	public PromocionAbsoluta(String nombre, TipoAtraccion tipo, List<Atraccion> atracciones, double precioFinal)
			throws ExcepcionDeBase, ExcepcionDePromocion {
		super(nombre, PromocionPorcentual.calcularTiempo(atracciones), precioFinal, tipo, atracciones);
	}

	@Override
	public void sugerirPromocion(Usuario usuario) {
		List<Atraccion> misAtracciones = new ArrayList<Atraccion>();
		boolean cupo = true, noLaVisito = true;
		misAtracciones = this.getAtracciones();
		double tiempoDeUsusario = usuario.getTiempo();
		double presupuesto = usuario.getPresupuesto();
		for (Atraccion miAtraccion : misAtracciones) {
			cupo = cupo && (miAtraccion.getCupo() >= 1);
			noLaVisito = noLaVisito && (usuario.getAtraccionesDeSuItinerario().contains(miAtraccion));
		}
		if ((this.getTiempo() <= tiempoDeUsusario) && (this.getCosto() <= presupuesto) && cupo && noLaVisito)
			usuario.aceptarSugerencia(this);
	}

}
