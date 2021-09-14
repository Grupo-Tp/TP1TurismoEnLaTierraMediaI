package clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import comparadores.NombreDeAtraccionComparador;
import comparadores.PrecioYTiempoDeAtraccionComparador;
import comparadores.TiempoDeAtraccionComparador;
import comparadores.TipoDeAtraccionComparador;
import comparadores.TipoDeAtraccionDeLaPromocionComparador;

public class SugerirProducto {
	private List<Usuario> usuarios = null;
	private List<Promocion> promociones = null;
	private List<Atraccion> atracciones = null;
	private Scanner teclado;

	public SugerirProducto(List<Usuario> losUsuarios, List<Promocion> lasPromociones, List<Atraccion> lasAtracciones) {
		this.setUsuarios(losUsuarios);
		this.setPromociones(lasPromociones);
		this.setAtracciones(lasAtracciones);
		teclado = new Scanner(System.in);
	}

	/**
	 * 
	 */
	public void mostrarPorPantalla() {
		System.out.println();
		System.out.println("Comenzamos a sugerir productos a los usuarios");
		for (Usuario usuario : this.getUsuarios()) {
			System.out.println();
			System.out.println("Usuario: " + usuario.getNombre());
			this.sugerirPromocionConPreferencia(usuario);
			System.out.println();
		}
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
	private void setUsuarios(List<Usuario> usuarios) {
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
	private void setPromociones(List<Promocion> promociones) {
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
	private void setAtracciones(List<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}

	/**
	 * @pre No tiene.
	 * @post No tiene.
	 * @return Retorna la lista con todas las atracciones incluidas en su itinerario
	 */
	public ArrayList<String> getAtraccionesDeSuItinerario(Usuario usuario) {
		ArrayList<String> retorno = new ArrayList<String>();
		for (Base baseATratar : usuario.getItinerario()) {
			if (baseATratar instanceof PromocionAxB) {
				PromocionAxB tratarComoPromocionAxB = (PromocionAxB) baseATratar;
				for (String nombre : tratarComoPromocionAxB.getNombresDeAtracciones()) {
					retorno.add(nombre);
				}
			}
			if (baseATratar instanceof PromocionAbsoluta) {
				PromocionAbsoluta tratarComoPromocionAbsoluta = (PromocionAbsoluta) baseATratar;
				for (String nombre : tratarComoPromocionAbsoluta.getNombresDeAtracciones()) {
					retorno.add(nombre);
				}
			}
			if (baseATratar instanceof PromocionPorcentual) {
				PromocionPorcentual tratarComoPromocionPorcentual = (PromocionPorcentual) baseATratar;
				for (String nombre : tratarComoPromocionPorcentual.getNombresDeAtracciones()) {
					retorno.add(nombre);
				}
			}
			if (baseATratar instanceof Atraccion) {
				Atraccion tratarComoAtraccion = (Atraccion) baseATratar;
				retorno.add(tratarComoAtraccion.getNombre());
			}
		}
		return retorno;
	}

	/**
	 * 
	 * @param usuario
	 * @param atraccionDeLaPromocion
	 * @return
	 */
	private boolean laVisito(Usuario usuario, String atraccionDeLaPromocion) {
		boolean retorno = true;
		for (String atraccionDeUsuario : this.getAtraccionesDeSuItinerario(usuario)) {
			retorno &= !atraccionDeUsuario.equals(atraccionDeLaPromocion);
		}
		return retorno;
	}

	/**
	 * @pre No Tiene.
	 * @post Se sugieron todas las promociones posibles para todos los usuarios
	 *       registrados.
	 * @param usuario
	 */
	public void sugerirPromocionConPreferencia(Usuario usuario) {
		for (Promocion laPromocion : this.getPromociones()) {
			boolean tieneCupo = true, noLaVisito = true;
			for (String atraccionDeLaPromocion : laPromocion.getNombresDeAtracciones()) {
				tieneCupo = tieneCupo
						&& (Atraccion.buscarAtraccionPorNombre(atraccionDeLaPromocion, atracciones).getCupo() >= 1);
				noLaVisito &= this.laVisito(usuario, atraccionDeLaPromocion);
			}
			if ((usuario.getPreferencia() == laPromocion.getTipo()) && tieneCupo
					&& (laPromocion.getTiempo() <= usuario.getTiempo())
					&& (laPromocion.getCosto() <= usuario.getPresupuesto()) && noLaVisito)
				if (usuario.aceptarSugerencia(laPromocion, this.respuesta(laPromocion)))
					this.subirPromocion(laPromocion);
		}
		this.sugerirPromocionSinPreferencia(usuario);
	}

	/**
	 * 
	 * @param laPromo Promocion que se muestra para tomar una decision.
	 * @return La desicion traducida a un boolean.
	 */
	private boolean respuesta(Promocion laPromo) {
		System.out.println("Si esea aceptar la promocion " + laPromo.toString());
		System.out.println("Presione \"1\", de lo contario presione cualquier otro numero");
		int respuesta = 0;
		respuesta = teclado.nextInt();
		return respuesta == 1;
	}

	/**
	 * 
	 * @param laPromocion
	 */
	private void subirPromocion(Promocion laPromocion) {
		for (String atraccion : laPromocion.getNombresDeAtracciones()) {
			Atraccion.buscarAtraccionPorNombre(atraccion, this.getAtracciones()).subirAtraccion();
		}
	}

	/**
	 * @pre No Tiene.
	 * @post Se sugieron todas las promociones posibles para todos los usuarios
	 *       registrados.
	 * @param usuario
	 */
	public void sugerirPromocionSinPreferencia(Usuario usuario) {
		for (Promocion laPromocion : this.getPromociones()) {
			boolean tieneCupo = true, noLaVisito = true;
			for (String atraccionDeLaPromocion : laPromocion.getNombresDeAtracciones()) {
				tieneCupo = tieneCupo
						&& (Atraccion.buscarAtraccionPorNombre(atraccionDeLaPromocion, atracciones).getCupo() >= 1);
				noLaVisito = noLaVisito && this.laVisito(usuario, atraccionDeLaPromocion);
			}
			if (tieneCupo && (laPromocion.getTiempo() <= usuario.getTiempo())
					&& (laPromocion.getCosto() <= usuario.getPresupuesto()) && noLaVisito)
				if (usuario.aceptarSugerencia(laPromocion, this.respuesta(laPromocion)))
					this.subirPromocion(laPromocion);
		}
		this.sugerirAtraccion(usuario);
	}

	/**
	 * @pre No tiene.
	 * @post Se sugirieron todas las atracciones posibles a todos los usuarios
	 *       registrados.
	 * @param usuario
	 */
	public void sugerirAtraccion(Usuario usuario) {
		this.ordenarAtraccionesPorPrecioYTiempo(this.getAtracciones());
		for (Atraccion laAtraccion : this.getAtracciones()) {
			if (laAtraccion.getCupo() >= 1 && laAtraccion.getTiempo() <= usuario.getTiempo()
					&& laAtraccion.getCosto() <= usuario.getPresupuesto()
					&& this.laVisito(usuario, laAtraccion.getNombre()))
				if (usuario.aceptarSugerencia(laAtraccion, this.respuesta(laAtraccion)))
					laAtraccion.subirAtraccion();
		}
	}

	/**
	 * 
	 * @param laAtraccion Atraccion que se muestra para tomar una decision.
	 * @return La desicion traducida a un boolean.
	 */
	private boolean respuesta(Atraccion laAtraccion) {
		System.out.println("Si esea aceptar la atraccion " + laAtraccion.toString());
		System.out.println("Presione \"1\", de lo contrario precione cualquier otro numero");
		int respuesta = 0;
		respuesta = teclado.nextInt();
		return respuesta == 1;
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
