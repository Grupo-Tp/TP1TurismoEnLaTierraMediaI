package clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comparadores.NombreDeAtraccionComparador;
import comparadores.PrecioYTiempoDeAtraccionComparador;
import comparadores.TiempoDeAtraccionComparador;
import comparadores.TipoDeAtraccionComparador;
import comparadores.TipoDeAtraccionDeLaPromocionComparador;

public class SugerirProducto {
	private List<Usuario> usuarios = null;
	private List<Promocion> promociones = null;
	private List<Atraccion> atracciones = null;

	public SugerirProducto(List<Usuario> losUsuarios, List<Promocion> lasPromociones, List<Atraccion> lasAtracciones) {
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
	 */
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	/**
	 * @return the promociones
	 */
	public List<Promocion> getPromociones() {
		return promociones;
	}

	/**
	 * @param promociones the promociones to set
	 */
	public void setPromociones(List<Promocion> promociones) {
		this.promociones = promociones;
	}

	/**
	 * @return the atracciones
	 */
	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

	/**
	 * @param atracciones the atracciones to set
	 */
	public void setAtracciones(List<Atraccion> atracciones) {
		this.atracciones = atracciones;
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
	 * @post Se sugieron todas las promociones posibles para todos los usuarios
	 *       registrados.
	 */
	public void sugerirPromocion() {
		for (Usuario usuario : this.getUsuarios()) {
			List<Promocion> promocionesOrdenadas = new ArrayList<Promocion>();
			promocionesOrdenadas = this.ordenarPromociones(usuario);
			for (Promocion laPromocion : promocionesOrdenadas) {
				boolean tieneCupo = true, noLaVisito = true,
						tieneTiempo = laPromocion.getTiempo() <= usuario.getTiempo(),
						tienePresupuesto = laPromocion.getCosto() <= usuario.getPresupuesto();
				for (Atraccion atraccionesDeLaPromocion : laPromocion.getAtracciones()) {
					tieneCupo = tieneCupo && (atraccionesDeLaPromocion.getCupo() >= 1);
					noLaVisito = noLaVisito
							&& (!this.getAtraccionesDeSuItinerario(usuario).contains(atraccionesDeLaPromocion));
				}
				if (tieneCupo && tieneTiempo && tienePresupuesto && noLaVisito)
					if (usuario.aceptarSugerencia(laPromocion))
						laPromocion.subirAtraccion();
			}
		}
	}

	/**
	 * @pre No tiene.
	 * @post Se ordeno la lista de promociones.
	 * @param usuario Usuario que contiene la preferencia del tipo de atraccion a
	 *                ordenar.
	 * @return Lista con las promociones ordenadas segun la preferencia del usuario.
	 */
	private List<Promocion> ordenarPromociones(Usuario usuario) {
		List<Promocion> promocionesOrdenadas = new ArrayList<Promocion>();
		List<Promocion> promocionesRestantes = new ArrayList<Promocion>();
		for (Promocion aTratar : this.getPromociones()) {
			if (aTratar.getTipo().equals(usuario.getPreferencia()))
				promocionesOrdenadas.add(aTratar);
			else
				promocionesRestantes.add(aTratar);
		}
		this.ordenarPromocionesPorTipo(promocionesRestantes);
		for (Promocion aAgregar : promocionesRestantes) {
			promocionesOrdenadas.add(aAgregar);
		}
		this.setPromociones(promocionesOrdenadas);
		return this.getPromociones();
	}

	/**
	 * @pre No tiene.
	 * @post Se sugirieron todas las atracciones posibles a todos los usuarios
	 *       registrados.
	 */
	public void sugerirAtraccion() {
		for (Usuario usuario : this.getUsuarios()) {
			this.ordenarAtraccionesPorPrecioYTiempo(this.getAtracciones());
			for (Atraccion laAtraccion : this.getAtracciones()) {
				boolean tieneCupo = laAtraccion.getCupo() >= 1,
						tieneTiempo = laAtraccion.getTiempo() <= usuario.getTiempo(),
						tienePresupuesto = laAtraccion.getCosto() <= usuario.getPresupuesto(),
						noLaVisito = !this.getAtraccionesDeSuItinerario(usuario).contains(laAtraccion);
				if (tieneCupo && tieneTiempo && tienePresupuesto && noLaVisito)
					if (usuario.aceptarSugerencia(laAtraccion))
						laAtraccion.subirAtraccion();
			}
		}
	}

	public void ordenarPromocionesPorTipo(List<Promocion> promociones) {
		Collections.sort(promociones, new TipoDeAtraccionDeLaPromocionComparador());
	}

	public void ordenarAtraccionesPorTipo(List<Atraccion> atracciones) {
		Collections.sort(atracciones, new TipoDeAtraccionComparador());
	}

	public void ordenarAtraccionesPorPrecioYTiempo(List<Atraccion> atracciones) {
		Collections.sort(atracciones, new PrecioYTiempoDeAtraccionComparador());
	}

	public void ordenarAtraccionesPorTiempo(List<Atraccion> atracciones) {
		Collections.sort(atracciones, new TiempoDeAtraccionComparador());
	}

	public void ordenarAtraccionesPorNombre(List<Atraccion> atracciones) {
		Collections.sort(atracciones, new NombreDeAtraccionComparador());
	}

}
