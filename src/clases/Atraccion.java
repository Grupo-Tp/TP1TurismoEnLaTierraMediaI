package clases;

public class Atraccion extends Base {

	private int cupo;

	public Atraccion(String nombre, double tiempo, double costo, TipoAtraccion tipo, int cupo) {
		super(nombre, tiempo, costo, tipo);
		this.setCupo(cupo);
	}

	/**
	 * @pre No tiene.
	 * @post No tiene.
	 * @return Cupo disponible de la Atraccion.
	 */
	public int getCupo() {
		return cupo;
	}

	/**
	 * @pre No Tiene.
	 * @post Se actualizo el cupo de la Atraccion.
	 * @param cupo Cantidad de cupo de la atraccion a actualizar.
	 * @return No tiene.
	 */
	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	/**
	 * Definir como vamos a implementar el esto toString, dado que lo pense para
	 * definir el itinerario que se utiliza en la clase usuario, pero no la realize
	 * aún
	 */
	@Override
	public String toString() {
		return "Atraccion [nombre= " + super.getNombre() + ", costo= " + super.getCosto() + ", tiempo= " + super.getTiempo()
				+ ", cupo= " + cupo + ", tipo= " + super.getTipo().toString() + "]";
	}

}
