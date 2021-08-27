package clases;

import java.util.ArrayList;

public class Usuario {
	
	String nombre;
	double tiempo;
	double presupuesto;
	TipoAtraccion preferencia;
	ArrayList<Promocion> itinerario = new ArrayList<Promocion>();
	
	public Usuario(String nombre, double tiempo, double presupuesto, TipoAtraccion preferencia) {
		this.nombre = nombre;
		this.tiempo = tiempo;
		this.presupuesto = presupuesto;
		this.preferencia = preferencia;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getTiempo() {
		return tiempo;
	}
	
	public double getPresupuesto() {
		return presupuesto;
	}
	
	public void aceptarSugerencia(Promocion sugerencia) {
		this.itinerario.add(sugerencia);
	}
	
	public String mostrarItinerario() {
		return this.itinerario.toString();
	}
	
}
