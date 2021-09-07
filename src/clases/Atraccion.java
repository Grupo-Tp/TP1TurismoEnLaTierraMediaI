package clases;

import excepciones.ExcepcionDeAtraccion;
import excepciones.ExcepcionDeBase;

public class Atraccion extends Base {

	private int cupo;

	public Atraccion(String nombre, double tiempo, double costo, TipoAtraccion tipo, int cupo)
			throws ExcepcionDeBase, ExcepcionDeAtraccion {
		super(nombre, tiempo, costo, tipo);
		this.setCupo(cupo);
	}

	/**
	 * @pre No tiene.
	 * @post No tiene.
	 * @return Cupo disponible de la Atraccion.
	 */
	protected int getCupo() {
		return cupo;
	}

	/**
	 * @pre No Tiene.
	 * @post Se actualizo el cupo de la Atraccion.
	 * @param cupo Cantidad de cupo de la atraccion a actualizar.
	 * @return No tiene.
	 * @throws ExcepcionDeAtraccion Nuestra excepcion de error.
	 */
	private void setCupo(int cupo) throws ExcepcionDeAtraccion {
		if (cupo > 0)
			this.cupo = cupo;
		else
			throw new ExcepcionDeAtraccion("asignar el cupo, ya que este es invalido: " + cupo);
	}

	/**
	 * @pre No tiene.
	 * @post Se redujo en uno el cupo disponible de la atraccion,
	 */
	public void subirAtraccion() {
		this.cupo--;
	}

	/**
	 * @pre No tiene.
	 * @post Suguiere esta atraccion al usuario si éste cumple con las condiciones
	 *       impuestas por la consigna.
	 * @param usuario
	 */
	public void sugerirAtraccion(Usuario usuario) {
		if (this.getTiempo() <= usuario.getTiempo() && this.getCosto() <= usuario.getPresupuesto()
				&& this.getCupo() >= 1 && usuario.getAtraccionesDeSuItinerario().contains(this))
			if (usuario.aceptarSugerencia(this))
				this.subirAtraccion();
	}

	/**
	 * Definir como vamos a implementar el esto toString, dado que lo pense para
	 * definir el itinerario que se utiliza en la clase usuario, pero no la realize
	 * aún
	 */
	@Override
	public String toString() {
		return this.getNombre() + ", con un costo de " + this.getCosto()
				+ " monedas de oro, un tiempo necesario para recorrerlo de " + super.getTiempo() + " horas, un cupo de "
				+ this.getCupo() + " usuarios y su tipo de atraccion es " + this.getTipo().toString();
	}

}
