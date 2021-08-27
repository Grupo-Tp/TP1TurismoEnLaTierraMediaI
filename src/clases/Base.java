package clases;

public abstract class Base {

	private String nombre;
	private double tiempo;

	public Base(String nombre, double tiempo) {
		this.setNombre(nombre);
		this.setTiempo(tiempo);
	}

	public Base(String nombre) {
		this(nombre, 0);
	}

	public Base() {
		this("");
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

}
