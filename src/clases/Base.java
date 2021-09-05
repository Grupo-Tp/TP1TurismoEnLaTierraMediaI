package clases;

public abstract class Base {

	private String nombre;
	private double tiempo;
	private double costo;
	private TipoAtraccion tipo;

	public Base(String nombre, double tiempo, double costo, TipoAtraccion tipo) {
		this.setNombre(nombre);
		this.setTiempo(tiempo);
		this.setCosto(costo);
		this.setTipo(tipo);
	}

	/**
	 * @pre No tiene.
	 * @post No tiene.
	 * @return Nombre de la Atraccion o Promocion.
	 */
	protected String getNombre() {
		return nombre;
	}

	/**
	 * @pre No Tiene.
	 * @post Se actualizo el nombre de la Atraccion o Promocion.
	 * @param nombre Nuevo nombre a actualizar.
	 * @return .
	 */
	private void setNombre(String nombre) {
		if (nombre != "")
			this.nombre = nombre;
		else
			System.err.println(""); // informar que el nombre no puede ser vacio
	}

	/**
	 * @pre No tiene.
	 * @post No tiene.
	 * @return Duración de la Atraccion o Promocion.
	 */
	protected double getTiempo() {
		return tiempo;
	}

	/**
	 * @pre No Tiene.
	 * @post Se actualizo la duracion de la Atraccion o Promocion.
	 * @param tiempo Nueva duración a actualizar.
	 * @return No tiene.
	 */
	public void setTiempo(double tiempo) {
		if (tiempo <= 0)
			this.tiempo = tiempo;
		else
			System.err.println(""); // informar que el tiempo no puede ser negativo
	}

	/**
	 * @pre No tiene.
	 * @post No tiene.
	 * @return Costo de la Atraccion o Promocion.
	 */
	protected double getCosto() {
		return costo;
	}

	/**
	 * @pre No Tiene.
	 * @post Se actualizo el costo de la Atraccion o Promocion.
	 * @param costo Cantidad de monedas que requiere la atraccion o promocion a
	 *              actualizar.
	 * @return No tiene.
	 */
	private void setCosto(double costo) {
		if (costo <= 0)
			this.costo = costo;
		else
			System.err.println(""); // informar que el costo no puede ser negativo
	}

	/**
	 * @pre No tiene.
	 * @post No tiene.
	 * @return Tipo de Atraccion o Promocion.
	 */
	protected TipoAtraccion getTipo() {
		return tipo;
	}

	/**
	 * @pre No Tiene.
	 * @post Se actualizo el tipo de la Atraccion o Promocion.
	 * @param tipo Tipo que requiere la atraccion o promocion a actualizar.
	 * @return No tiene.
	 */
	private void setTipo(TipoAtraccion tipo) {
		this.tipo = tipo;
	}
}
