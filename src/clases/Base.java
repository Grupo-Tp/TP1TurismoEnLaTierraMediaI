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
	public String getNombre() {
		return nombre;
	}

	/**
	 * @pre No Tiene.
	 * @post Se actualizo el nombre de la Atraccion o Promocion.
	 * @param nombre Nuevo nombre a actualizar.
	 * @return No tiene.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @pre No tiene.
	 * @post No tiene.
	 * @return Duración de la Atraccion o Promocion.
	 */
	public double getTiempo() {
		return tiempo;
	}

	/**
	 * @pre No Tiene.
	 * @post Se actualizo la duracion de la Atraccion o Promocion.
	 * @param tiempo Nueva duración a actualizar.
	 * @return No tiene.
	 */
	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
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

}
