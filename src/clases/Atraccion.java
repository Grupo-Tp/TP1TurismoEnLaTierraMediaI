package clases;

public class Atraccion extends Base {

	private TipoAtraccion tipo;
	private int cupo;
	private double costo;

	public Atraccion() {
		this.setTipo(TipoAtraccion.AVENTURA);
		this.setCupo(0);
		this.setCosto(0);
	}

	/**
	 * @pre No tiene.
	 * @post No tiene.
	 * @return Tipo de Atraccion.
	 */
	public TipoAtraccion getTipo() {
		return tipo;
	}

	/**
	 * @pre No Tiene.
	 * @post Se actualizo el tipo de Atraccion.
	 * @param tipo Tipo de atraccion a actualizar.
	 * @return No tiene.
	 */
	public void setTipo(TipoAtraccion tipo) {
		this.tipo = tipo;
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
	 * @pre No tiene.
	 * @post No tiene.
	 * @return Costo de la Atraccion.
	 */
	public double getCosto() {
		return costo;
	}

	/**
	 * @pre No Tiene.
	 * @post Se actualizo el costo de la Atraccion.
	 * @param costo Cantidad de monedas que requiere la atraccion a actualizar.
	 * @return No tiene.
	 */
	public void setCosto(double costo) {
		this.costo = costo;
	}

	/**
	 * Definir como vamos a implementar el esto toString, dado que lo pense para
	 * definir el itinerario que se utiliza en la clase usuario, pero no la realize
	 * aún
	 */
	@Override
	public String toString() {
		return "Atraccion [tipo=" + tipo + ", cupo=" + cupo + ", costo=" + costo + "]";
	}

}
