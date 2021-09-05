package clases;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private String nombre;
	private double tiempo;
	private double presupuesto;
	private TipoAtraccion preferencia;
	private List<Base> itinerario;

	public Usuario(String nombre, double tiempo, double presupuesto, TipoAtraccion preferencia) {
		this.setNombre(nombre);
		this.setTiempo(tiempo);
		this.setPresupuesto(presupuesto);
		this.setPreferencia(preferencia);
		this.itinerario = new ArrayList<Base>();
	}

	/**
	 * @pre No tiene.
	 * @post No tiene.
	 * @return El nombre del usuario.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @pre No tiene.
	 * @post Se asigno y valido el nombre del usuario.
	 * @param nombre Nuevo nombre que tendra el usuario.
	 */
	private void setNombre(String nombre) {
		if (nombre != "")
			this.nombre = nombre;
		else
			System.out.println(""); // informar que el nombre es invalido
	}

	/**
	 * @pre No tiene.
	 * @post No tiene.
	 * @return El tiempo disponible del usuario.
	 */
	public double getTiempo() {
		return tiempo;
	}

	/**
	 * @pre No tiene.
	 * @post Se asigno y valido el tiempo disponible del usuario.
	 * @param tiempo Nueva cantidad de tiempo que tendra el usuario.
	 */
	private void setTiempo(double tiempo) {
		if (tiempo > 0)
			this.tiempo = tiempo;
		else
			System.out.println(""); // informar que el tiempo es negativo
	}

	/**
	 * @pre No tiene.
	 * @post No tiene.
	 * @return El presupuesto que tiene el usuario.
	 */
	public double getPresupuesto() {
		return presupuesto;
	}

	/**
	 * @pre No tiene.
	 * @post Se valido y asigno el presupuesto que dispone el usuario.
	 * @param presupuesto Nueva cantidad de dinero que tendra el usuario.
	 */
	private void setPresupuesto(double presupuesto) {
		if (presupuesto > 0)
			this.presupuesto = presupuesto;
		else
			System.out.println(""); // informar que el presupuesto es negativo
	}

	/**
	 * @pre No tiene.
	 * @post No tiene.
	 * @return Tipo de preferencia del usuario.
	 */
	public TipoAtraccion getPreferencia() {
		return preferencia;
	}

	/**
	 * @pre No tiene.
	 * @post Se asigno el tipo de preferencia que tiene el usuario.
	 * @param preferencia Tipo de atraccion que prefiere el usuario.
	 */
	private void setPreferencia(TipoAtraccion preferencia) {
		this.preferencia = preferencia;
	}

	// Debemos corregir este método, ya que debe admitir la posibilidad de que sea
	// aceptada o rechazada por la consola
	/**
	 * @pre No tiene.
	 * @post Se agrego una sugerencia al itinerario si fue aceptada.
	 * @param sugerencia Una promoción o atracción
	 * @return No tiene. Aunque hay que analizar bien
	 */
	public void aceptarSugerencia(Base sugerencia) {
		this.itinerario.add(sugerencia);
	}

	// Este método también se debe analizar bien, ya que debemos definir el
	// formato que usaremos para imprimir y si haremos la impresión desde
	// la aplicacion que ejecuta el prgrama o este modulo
	/**
	 * @pre No tiene.
	 * @post Se imprimio por pantalla el itinerario del usuario.
	 * @return El itinerario del usuario.
	 */
	public String mostrarItinerario() {
		return this.itinerario.toString();
	}

}
