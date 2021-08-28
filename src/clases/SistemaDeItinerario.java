package clases;

import java.util.ArrayList;
import java.util.List;

public class SistemaDeItinerario {

	// el sistema tiene una lista de todas las atracciones y otra lista de las
	// promociones.
	// cada promoción tiene un tipo, no puede tener atracciones de tipos mezclados
	List<Promocion> promociones;
	List<Atraccion> atracciones;

	public SistemaDeItinerario() {
		this.promociones = new ArrayList<Promocion>();
		this.atracciones = new ArrayList<Atraccion>();
	}

	// agregar promociones y atracciones...

	/*
	 * devuelve primero la lista de promociones que coinciden con la preferencia del
	 * usuario luego la lista de atracciones individuales (no incluidas en las
	 * promocionesque hayan sido aceptadas) que coinciden en el siguiente orden: -
	 * mas caras primero - mayor tiempo luego
	 */
	public void generarRecomendacionesParaUsuario(Usuario usuario) {
		TipoAtraccion preferencia = usuario.getPreferencia();
		double presupuestoDelUsuario = usuario.getPresupuesto();
		double tiempoDeusuario = usuario.getTiempo();

		// obtengo las promociones que aceptó
		List<Promocion> itinerarioDeUsuario = usuario.getItinerario();

		while (presupuestoDelUsuario > 0) {
			while (tiempoDeusuario > 0) {
				// promociones que coinciden
				List<Promocion> promocionesParaUsuario = this.filtrarYOrdenarPromociones(preferencia,
						presupuestoDelUsuario, itinerarioDeUsuario, tiempoDeusuario);
				
				for (Promocion promocion : promocionesParaUsuario) {
					// acá se muestra por pantalla
					if (presupuestoDelUsuario > promocion.getCosto()) {
						if (tiempoDeusuario > promocion.getTiempo()) {
							// si el usuario acepta hay que agregarlo a su itinarerio, restarle saldo y
							// reducir el cupo de la atracción
							usuario.aceptarSugerencia(promocion);
							// si no mostrar la próxima
						}
					}
				}

				// atracciones que coinciden
				List<Atraccion> atraccionesParaUsuario = this.filtrarYOrdenarAtracciones(preferencia,
						presupuestoDelUsuario, itinerarioDeUsuario, tiempoDeusuario);
				
				for (Atraccion atraccion : atraccionesParaUsuario) {
					// acá se muestra por pantalla
					if (presupuestoDelUsuario > atraccion.getCosto()) {
						if (tiempoDeusuario > atraccion.getTiempo()) {
							// si el usuario acepta hay que agregarlo a su itinarerio, restarle saldo y
							// reducir el cupo de la atracción
							usuario.aceptarSugerencia(atraccion);
							// si no mostrar la próxima
						}
					}
				}

				// promociones que no coinciden
				List<Promocion> promocionesNoCoincidentes = new ArrayList<>(promociones);
				promocionesNoCoincidentes.removeAll(promocionesParaUsuario);
				
				for (Promocion promocion : promocionesNoCoincidentes) {
					// acá se muestra por pantalla
					if (presupuestoDelUsuario > promocion.getCosto()) {
						if (tiempoDeusuario > promocion.getTiempo()) {
							// si el usuario acepta hay que agregarlo a su itinarerio, restarle saldo y
							// reducir el cupo de la atracción
							usuario.aceptarSugerencia(promocion);
							// si no mostrar la próxima
						}
					}
				}

				// atracciones que no coinciden
				List<Promocion> atraccionesNoCoincidentes = new ArrayList<>(atracciones);
				atraccionesNoCoincidentes.removeAll(atraccionesParaUsuario);
				
				for (Promocion atraccion : atraccionesNoCoincidentes) {
					// acá se muestra por pantalla
					if (presupuestoDelUsuario > atraccion.getCosto()) {
						if (tiempoDeusuario > atraccion.getTiempo()) {
							// si el usuario acepta hay que agregarlo a su itinarerio, restarle saldo y
							// reducir el cupo de la atracción
							usuario.aceptarSugerencia(atraccion);
							// si no mostrar la próxima
						}
					}
				}

			}
		}

	}

}
