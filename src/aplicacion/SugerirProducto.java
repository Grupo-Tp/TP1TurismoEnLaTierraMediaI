package aplicacion;

import java.util.ArrayList;
import java.util.List;

import clases.Atraccion;
import clases.Base;
import clases.Promocion;
import clases.Usuario;
import excepciones.ExcepcionDeAtraccion;
import excepciones.ExcepcionDePromocion;
import excepciones.ExcepcionDeUsuario;

public class SugerirProducto {
	private List<Usuario> usuarios = null;
	private List<Promocion> promociones = null;
	private List<Atraccion> atracciones = null;

	public SugerirProducto(List<Usuario> losUsuarios, List<Promocion> lasPromociones, List<Atraccion> lasAtracciones)
			throws ExcepcionDeUsuario, ExcepcionDePromocion, ExcepcionDeAtraccion {
		this.setUsuarios(losUsuarios);
		this.setPromociones(lasPromociones);
		this.setAtracciones(lasAtracciones);
	}

	/**
	 * @return the usuarios
	 */
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios the usuarios to set
	 * @throws ExcepcionDeUsuario
	 */
	public void setUsuarios(List<Usuario> usuarios) throws ExcepcionDeUsuario {
		if (!usuarios.isEmpty())
			this.usuarios = usuarios;
		else
			throw new ExcepcionDeUsuario("la lista de usuarios esta vacia");
	}

	/**
	 * @return the promociones
	 */
	public List<Promocion> getPromociones() {
		return promociones;
	}

	/**
	 * @param promociones the promociones to set
	 * @throws ExcepcionDePromocion
	 */
	public void setPromociones(List<Promocion> promociones) throws ExcepcionDePromocion {
		if (!promociones.isEmpty())
			this.promociones = promociones;
		else
			throw new ExcepcionDePromocion("la lista de promociones esta vacia");
	}

	/**
	 * @return the atracciones
	 */
	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

	/**
	 * @param atracciones the atracciones to set
	 * @throws ExcepcionDeAtraccion
	 */
	public void setAtracciones(List<Atraccion> atracciones) throws ExcepcionDeAtraccion {
		if (!atracciones.isEmpty())
			this.atracciones = atracciones;
		else
			throw new ExcepcionDeAtraccion("la lista de atracciones esta vacia");
	}

	/**
	 * @pre No tiene.
	 * @post No tiene.
	 * @return Retorna la lista con todas las atracciones incluidas en su itinerario
	 */
	public List<Atraccion> getAtraccionesDeSuItinerario(Usuario usuario) {
		List<Atraccion> retorno = new ArrayList<Atraccion>();
		for (Base baseATratar : usuario.getItinerario()) {
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
	 * @pre No Tiene.
	 * @post Se suguirio una promocion posible para un usuario determinado.
	 * @return Una Promocion para un Usuario.
	 */
	public void sugerirPromocion(Usuario usuario, Promocion promocion) {
		boolean cupo = true, noLaVisito = true;
		double tiempoDeUsusario = usuario.getTiempo();
		double presupuesto = usuario.getPresupuesto();
		for (Atraccion miAtraccion : this.getAtracciones()) {
			cupo = cupo && (miAtraccion.getCupo() >= 1);
			noLaVisito = noLaVisito && (this.getAtraccionesDeSuItinerario(usuario).contains(miAtraccion));
		}
		if ((promocion.getTiempo() <= tiempoDeUsusario) && (promocion.getCosto() <= presupuesto) && cupo && noLaVisito)
			if (usuario.aceptarSugerencia(promocion))
				promocion.subirAtraccion();
	}

	/**
	 * @pre No tiene.
	 * @post Suguiere esta atraccion al usuario si éste cumple con las condiciones
	 *       impuestas por la consigna.
	 * @param usuario
	 */
	public void sugerirAtraccion(Usuario usuario, Atraccion atraccion) {
		if (atraccion.getTiempo() <= usuario.getTiempo() && atraccion.getCosto() <= usuario.getPresupuesto()
				&& atraccion.getCupo() >= 1 && !usuario.getItinerario().contains(atraccion))
			if (usuario.aceptarSugerencia(atraccion))
				atraccion.subirAtraccion();
	}

}
