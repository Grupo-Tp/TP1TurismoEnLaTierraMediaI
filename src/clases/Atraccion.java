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
	protected int getCupo() {
		return cupo;
	}

	/**
	 * @pre No Tiene.
	 * @post Se actualizo el cupo de la Atraccion.
	 * @param cupo Cantidad de cupo de la atraccion a actualizar.
	 * @return No tiene.
	 */
	private void setCupo(int cupo) {
		if (cupo > 0)
			this.cupo = cupo;
		else
			System.out.println("");// informar error en el cupo de la atraccion
	}

	/**
	 * Definir como vamos a implementar el esto toString, dado que lo pense para
	 * definir el itinerario que se utiliza en la clase usuario, pero no la realize
	 * aún
	 */
	@Override
	public String toString() {
		return "Atraccion [nombre= " + super.getNombre() + ", costo= " + super.getCosto() + ", tiempo= "
				+ super.getTiempo() + ", cupo= " + this.getCupo() + ", tipo= " + super.getTipo().toString() + "]";
	}

}
