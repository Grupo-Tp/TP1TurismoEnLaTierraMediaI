package clases;

import java.util.ArrayList;
import java.util.List;

import excepciones.ExcepcionDeUsuario;

public class Usuario {

	private String nombre;
	private double tiempo;
	private double presupuesto;
	private TipoAtraccion preferencia;
	private List<Base> itinerario;

	public Usuario(String nombre, double tiempo, double presupuesto, TipoAtraccion preferencia)
			throws ExcepcionDeUsuario {
		this.setNombre(nombre);
		this.setTiempo(tiempo);
		this.setPresupuesto(presupuesto);
		this.setPreferencia(preferencia);
		this.itinerario = new ArrayList<Base>();
	}

	/**
	 * @pre No tiene.
	 * @post Retorno el nombre del usuario.
	 * @return El nombre del usuario.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @pre No tiene.
	 * @post Se asigno y valido el nombre del usuario.
	 * @param nombre Nuevo nombre que tendra el usuario.
	 * @throws ExcepcionDeUsuario Informo la existencia de un error al momento de
	 *                            asignar el nombre del usuario, ya que posee un
	 *                            valor invalido.
	 */
	private void setNombre(String nombre) throws ExcepcionDeUsuario {
		if (nombre != "")
			this.nombre = nombre;
		else
			throw new ExcepcionDeUsuario("asignar el nombre, ya que este se encuentra vacio");
	}

	/**
	 * @pre No tiene.
	 * @post Retorno el tiempo disponible del usuario.
	 * @return El tiempo disponible del usuario.
	 */
	public double getTiempo() {
		return tiempo;
	}

	/**
	 * @pre No tiene.
	 * @post Se asigno y valido el tiempo disponible del usuario.
	 * @param tiempo Nueva cantidad de tiempo que tendra el usuario.
	 * @throws ExcepcionDeUsuario Informo la existencia de un error al momento de
	 *                            asignar el tiempo del usuario, ya que posee un
	 *                            valor invalido.
	 */
	private void setTiempo(double tiempo) throws ExcepcionDeUsuario {
		if (tiempo > 0)
			this.tiempo = tiempo;
		else
			throw new ExcepcionDeUsuario("asignar el tiempo disponible, ya que este es invalido: " + tiempo);
	}

	/**
	 * @pre No tiene.
	 * @post Retorno el presupuesto del usuario.
	 * @return El presupuesto que tiene el usuario.
	 */
	public double getPresupuesto() {
		return presupuesto;
	}

	/**
	 * @pre No tiene.
	 * @post Se valido y asigno el presupuesto que dispone el usuario.
	 * @param presupuesto Nueva cantidad de dinero que tendra el usuario.
	 * @throws ExcepcionDeUsuario Informo la existencia de un error al momento de
	 *                            asignar el presupuesto del usuario, ya que posee
	 *                            un valor invalido.
	 */
	private void setPresupuesto(double presupuesto) throws ExcepcionDeUsuario {
		if (presupuesto > 0)
			this.presupuesto = presupuesto;
		else
			throw new ExcepcionDeUsuario("asignar el presupuesto disponible, ya que este es invalido: " + presupuesto);
	}

	/**
	 * @pre No tiene.
	 * @post Retorno la preferencia de atracciones que tiene el usuario.
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

	/**
	 * @pre No tiene.
	 * @post Se agrego una sugerencia al itinerario si fue aceptada.
	 * @param sugerencia Una promoción o atracción.
	 * @param decision   Un verdadero o falso, según haya sido la desicion ingresada
	 *                   por consola.
	 * @return Retorna un verdadero o falso, para informarle a la atraccion o
	 *         promocion que la sugerencia fue aceptada.
	 */
	public boolean aceptarSugerencia(Base sugerencia, boolean decision) {
		if (decision) {
			this.tiempo -= sugerencia.getTiempo();
			this.presupuesto -= sugerencia.getCosto();
			this.itinerario.add(sugerencia);
			return decision;
		} else
			return decision;
	}

	/**
	 * @pre No tiene.
	 * @post Retorno una lista con los productos que acepto el usuario.
	 * @return Itinerario del usuario.
	 */
	public List<Base> getItinerario() {
		return itinerario;
	}

	/**
	 * @pre No tiene.
	 * @post Se genero un resumen del itinerario del usuario.
	 * @return El itinerario del usuario resumido en un string.
	 */
	public String mostrarItinerario() {
		String salida = "El itinerario programado para " + this.getNombre()
				+ " esta compuesto por los siguientes productos :\n";
		double tiempoTotal = 0, costoTotal = 0;
		for (Base baseATratar : this.getItinerario()) {
			if (baseATratar instanceof Promocion) {
				Promocion tratarComoPromocion = (Promocion) baseATratar;
				tiempoTotal += tratarComoPromocion.getTiempo();
				costoTotal += tratarComoPromocion.getCosto();
				salida += "Promocion llamada " + tratarComoPromocion.getNombre() + " compuesta por las atracciones "
						+ tratarComoPromocion.imprimir() + "\n";
			}
			if (baseATratar instanceof Atraccion) {
				Atraccion tratarComoAtraccion = (Atraccion) baseATratar;
				tiempoTotal += tratarComoAtraccion.getTiempo();
				costoTotal += tratarComoAtraccion.getCosto();
				salida += "Atraccion llamada " + tratarComoAtraccion.getNombre() + "\n";
			}
		}
		salida = salida + "El itinerario programado tiene una duracion total de " + tiempoTotal
				+ " horas y un costo total de " + costoTotal + " monedas de oro";
		return salida;
	}

	@Override
	public String toString() {
		return this.getNombre() + ", con un tiempo disponible de " + this.getTiempo() + ", un presupuesto de "
				+ this.getPresupuesto() + " monedas de oro y una preferencia para las atracciones de tipo "
				+ this.getPreferencia().toString();
	}

}
