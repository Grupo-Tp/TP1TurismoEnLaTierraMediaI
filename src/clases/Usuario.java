package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
	 * @throws ExcepcionDeUsuario Excepcion que informa un error.
	 */
	private void setNombre(String nombre) throws ExcepcionDeUsuario {
		if (nombre != "")
			this.nombre = nombre;
		else
			throw new ExcepcionDeUsuario("asignar el nombre, ya que este se encuentra vacio");
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
	 * @throws ExcepcionDeUsuario Excepcion que informa un error.
	 */
	private void setTiempo(double tiempo) throws ExcepcionDeUsuario {
		if (tiempo > 0)
			this.tiempo = tiempo;
		else
			throw new ExcepcionDeUsuario("asignar el tiempo disponible, ya que este es invalido: " + tiempo);
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
	 * @throws ExcepcionDeUsuario Excepcion que informa un error.
	 */
	private void setPresupuesto(double presupuesto) throws ExcepcionDeUsuario {
		if (presupuesto > 0)
			this.presupuesto = presupuesto;
		else
			throw new ExcepcionDeUsuario("asignar el presupuesto disponible, ya que este es invalido: " + presupuesto);
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

	/**
	 * @pre No tiene.
	 * @post Se agrego una sugerencia al itinerario si fue aceptada.
	 * @param sugerencia Una promoción o atracción
	 * @return No tiene. Aunque hay que analizar bien
	 */
	public boolean aceptarSugerencia(Base sugerencia) {
		String decision = "";
		Scanner entradaDeTeclado = new Scanner(System.in);
		System.out.println("Si desea aceptar la sugerencia presione \"y\" de lo contrario presione \\\"n\\\"");
		decision = entradaDeTeclado.nextLine();
		while ((decision.toUpperCase() != "Y") || (decision.toUpperCase() != "N")) {
			System.out.println("Por favor introduzca una decision valida");
			System.out.println("Para aceptar presione \"y\" de lo contrario \"n\"");
			decision = entradaDeTeclado.nextLine();
		}
		entradaDeTeclado.close();
		if (decision.toUpperCase() == "Y") {
			this.tiempo = this.getTiempo() - sugerencia.getTiempo();
			this.presupuesto = this.getPresupuesto() - sugerencia.getCosto();
			this.itinerario.add(sugerencia);
			return true;
		} else
			return false;
	}

	/**
	 * @pre No tiene.
	 * @post No tiene.
	 * @return Retorna la lista con todas las atracciones incluidas en su itinerario
	 */
	public List<Atraccion> getAtraccionesDeSuItinerario() {
		List<Atraccion> retorno = new ArrayList<Atraccion>();
		List<Base> miItinerario = new ArrayList<Base>();
		miItinerario = this.itinerario;
		for (Base baseATratar : miItinerario) {
			if (baseATratar instanceof Promocion) {
				Promocion tratarComoPromocion = (Promocion) baseATratar;
				retorno.addAll(tratarComoPromocion.getAtracciones());
			}
			if (baseATratar instanceof Atraccion) {
				Atraccion tratarComoAtraccion = (Atraccion) baseATratar;
				retorno.add(tratarComoAtraccion);
			}
		}
		return retorno;
	}

	/**
	 * @pre No tiene.
	 * @post Se imprimio por pantalla el itinerario del usuario.
	 * @return El itinerario del usuario.
	 */
	public String mostrarItinerario() {
		String salida = "El itinerario programado para " + this.getNombre()
				+ " esta compuesto por los siguientes productos :\n";
		double tiempoTotal = 0, costoTotal = 0;
		List<Base> miItinerario = new ArrayList<Base>();
		for (Base baseATratar : miItinerario) {
			if (baseATratar instanceof Promocion) {
				Promocion tratarComoPromocion = (Promocion) baseATratar;
				tiempoTotal += tratarComoPromocion.getTiempo();
				costoTotal += tratarComoPromocion.getCosto();
				salida = salida + "Promocion llamada " + tratarComoPromocion.getNombre()
						+ " compuesta por las atracciones " + tratarComoPromocion.imprimir() + "\n";
			}
			if (baseATratar instanceof Atraccion) {
				Atraccion tratarComoAtraccion = (Atraccion) baseATratar;
				tiempoTotal += tratarComoAtraccion.getTiempo();
				costoTotal += tratarComoAtraccion.getCosto();
				salida = salida + "Atraccion llamada " + tratarComoAtraccion.getNombre() + "\n";
			}
			salida = salida + "El itinerario programado tiene una duracion total de " + tiempoTotal
					+ " horas y un costo total de " + costoTotal + " monedas de oro";
		}
		return salida;
	}

	@Override
	public String toString() {
		return this.getNombre() + ", con un tiempo disponible de " + this.getTiempo() + ", un presupuesto de "
				+ this.getPresupuesto() + " monedas de oro y una preferencia para las atracciones de tipo "
				+ this.getPreferencia().toString();
	}

}
