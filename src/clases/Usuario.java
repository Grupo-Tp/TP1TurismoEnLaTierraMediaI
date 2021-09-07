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
	 * @post Se informo si el usuario acepto anteriormente la atraccion.
	 * @param atraccion Atraccion a verificar si se encuentra en nuestro itinerario.
	 * @return Retorna si la tiene o no en su itinerario.
	 */
	public boolean atraccionRecorrida(Atraccion atraccion) {
		List<Base> miItinerario = new ArrayList<Base>();
		List<Atraccion> misAtracciones = new ArrayList<Atraccion>();
		boolean laVisite = false;
		miItinerario = this.getItinerario();
		for (Base baseATratar : miItinerario) {
			if ((baseATratar instanceof Promocion) && !laVisite) {
				Promocion tratarComoPromocion = (Promocion) baseATratar;
				misAtracciones = tratarComoPromocion.getAtracciones();
				if (misAtracciones.contains(atraccion))
					laVisite = true;
			}
			if ((baseATratar instanceof Atraccion) && !laVisite) {
				Atraccion tratarComoAtraccion = (Atraccion) baseATratar;
				if (tratarComoAtraccion.getNombre() == atraccion.getNombre())
					laVisite = true;
			}
		}
		return laVisite;
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
		if (decision.toUpperCase() == "Y") {
			this.tiempo = this.getTiempo() - sugerencia.getTiempo();
			this.presupuesto = this.getPresupuesto() - sugerencia.getCosto();
			this.itinerario.add(sugerencia);
			entradaDeTeclado.close();
			return true;
		} else
			entradaDeTeclado.close();
		return false;
	}

	/**
	 * @pre No tiene.
	 * @post No tiene.
	 * @return Retorna la lista con todo su itinerario
	 */
	public List<Base> getItinerario() {
		return itinerario;
	}

	/**
	 * @pre No tiene.
	 * @post Se imprimio por pantalla el itinerario del usuario.
	 * @return El itinerario del usuario.
	 */
	public String mostrarItinerario() {
		String salida = "El itinerario programado para " + this.getNombre() + " esta compuesto por :";
		return salida + this.itinerario.toString();
	}

}
