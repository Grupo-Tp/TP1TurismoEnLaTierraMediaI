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
		this.nombre = nombre;
		this.tiempo = tiempo;
		this.presupuesto = presupuesto;
		this.preferencia = preferencia;
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
	 * @post No tiene.
	 * @return El tiempo disponible del usuario.
	 */
	public double getTiempo() {
		return tiempo;
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
	 * @post No tiene.
	 * @return Tipo de preferencia del usuario.
	 */
	public TipoAtraccion getPreferencia() {
		return preferencia;
	}
	
	/**
	 * @pre No tiene.
	 * @post No tiene.
	 * @return Tipo el itinerario del usuario.
	 */
	public List<Base> getItinerario() {
		return itinerario;
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
