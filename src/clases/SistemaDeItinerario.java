package clases;

import java.util.ArrayList;
import java.util.List;

public class SistemaDeItinerario {
	
	// el sistema tiene una lista de todas las atracciones y otra lista de las promociones.
	// cada promoción tiene un tipo, no puede tener atracciones de tipos mezclados
	List<Promocion> promociones;
	List<Atraccion> atracciones;
	
	public SistemaDeItinerario() {
		this.promociones = new ArrayList<Promocion>();
		this.atracciones = new ArrayList<Atraccion>();
	}
	
	// agregar promociones y atracciones...
	
	/*
	* devuelve primero la lista de promociones que coinciden con la preferencia del usuario
	* luego la lista de atracciones individuales (no incluidas en las promocionesque hayan sido aceptadas) que coinciden en el siguiente orden:
	*  - mas caras primero
	*  - mayor tiempo luego
	*/
	public void generarRecomendaionesParaUsuario(Usuario usuario) {
		TipoAtraccion preferencia = usuario.getPreferencia();
		double presupuestoDelUsuario = usuario.getPresupuesto();
		double tiempoDeusuario = usuario.getTiempo();
		
		// aca filtro la lista de promociones por el tipo de preferencia y presupuesto del usuario
		List<Promocion> promocionesParaUsuario = this.filtrarYOrdenarPromociones(preferencia, presupuestoDelUsuario, tiempoDeusuario);
		
		for (Promocion promocion: promocionesParaUsuario) {
			// acá se muestra por pantalla
			if (presupuestoDelUsuario > promocion.getCosto()) {
				if (tiempoDeusuario > promocion.getTiempo()) {
					// si el usuario acepta hay que agregarlo a su itinarerio, restarle saldo y reducir el cupo de la atracción
					usuario.aceptarSugerencia(promocion);
					// si no mostrar la próxima
				}
			}
		}
		
		// obtengo las promociones que aceptó
		promocionesDeUsuario = usuario.getItinerario();
		
		// aca filtro la lista de atracciones por el tipo de preferencia del usuario, presupuesto y las promociones que ya tiene
		List<Atraccion> atraccionesParaUsuario =  this.filtrarYOrdenarAtracciones(preferencia, presupuesto, promocionesDeUsuario, tiempoDeusuario);
		
		for (Atraccion atraccion: atraccionesParaUsuario) {
			// acá se muestra por pantalla
			if (presupuestoDelUsuario > atraccion.getCosto()) {
				if (tiempoDeusuario > atraccion.getTiempo()) {
					// si el usuario acepta hay que agregarlo a su itinarerio, restarle saldo y reducir el cupo de la atracción
					usuario.aceptarSugerencia(atraccion);
					// si no mostrar la próxima
				}
			}
		}
		
		// obtener la lista de promociones que no coincidan
		// obtener la lista de actreacciones que no coincidan

		// en realidad va un while para poder repetir hasta que se acabe el tiempo, saldo o cupo...
		
	}
		

}
