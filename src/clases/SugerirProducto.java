package clases;

import java.util.ArrayList;
import java.util.List;

public class SugerirProducto {
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private List<Promocion> promociones = new ArrayList<Promocion>();
	private List<Atraccion> atracciones = new ArrayList<Atraccion>();

	public SugerirProducto(List<Usuario> losUsuarios, List<Promocion> lasPromociones, List<Atraccion> lasAtracciones) {
		this.usuarios = losUsuarios;
		this.promociones = lasPromociones;
		this.atracciones = lasAtracciones;
	}

	/**
	 * @pre No Tiene.
	 * @post Se suguirio una promocion posible para un usuario determinado.
	 * @param usuario Usuario para el cual se crea la promocion determinada.
	 * @return Una Promocion para un Usuario.
	 */
	public void sugerirPromocion(Usuario usuario) {
		List<Atraccion> misAtracciones = new ArrayList<Atraccion>();
		boolean cupo = true, noLaVisito = true;
		misAtracciones = this.getAtracciones();
		double tiempoDeUsusario = usuario.getTiempo();
		double presupuesto = usuario.getPresupuesto();
		for (Atraccion miAtraccion : misAtracciones) {
			cupo = cupo && (miAtraccion.getCupo() >= 1);
			noLaVisito = noLaVisito && (this.getAtraccionesDeSuItinerario(usuario).contains(miAtraccion));
			}
		if ((this.getTiempo() <= tiempoDeUsusario) && (this.getCosto() <= presupuesto) && cupo && noLaVisito)
			if (usuario.aceptarSugerencia(this))
				this.subirAtraccion();
	}

	/**
	 * @pre No tiene.
	 * @post No tiene.
	 * @return Retorna la lista con todas las atracciones incluidas en su itinerario
	 */
	public List<Atraccion> getAtraccionesDeSuItinerario(Usuario usuario) {
		List<Atraccion> retorno = new ArrayList<Atraccion>();
		List<Base> miItinerario = new ArrayList<Base>();
		miItinerario = usuario.getItinerario();
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
	 * @post Suguiere esta atraccion al usuario si éste cumple con las condiciones
	 *       impuestas por la consigna.
	 * @param usuario
	 */
	public void sugerirAtraccion(Usuario usuario) {
		if (this.getTiempo() <= usuario.getTiempo() && this.getCosto() <= usuario.getPresupuesto()
				&& this.getCupo() >= 1 && usuario.getItinerario().contains(this))
			if (usuario.aceptarSugerencia(this))
				this.subirAtraccion();
	}

}
