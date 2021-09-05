package clases;

import excepciones.ExcepcionDeBase;

public abstract class Base {

	private String nombre;
	private double tiempo;
	private double costo;
	private TipoAtraccion tipo;

	public Base(String nombre, double tiempo, double costo, TipoAtraccion tipo) throws ExcepcionDeBase {
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
	 * @return .
	 * @throws ExcepcionDeBase Nuestra excepcion de errores.
	 */
	private void setNombre(String nombre) throws ExcepcionDeBase {
		if (nombre != "")
			this.nombre = nombre;
		else
			throw new ExcepcionDeBase("asignar el nombre, ya que este se encuentra vacio");
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
	 * @throws ExcepcionDeBase Nuestra excepcion de errores.
	 */
	public void setTiempo(double tiempo) throws ExcepcionDeBase {
		if (tiempo <= 0)
			this.tiempo = tiempo;
		else
			throw new ExcepcionDeBase("asignar el tiempo, ya que este es invalido: " + tiempo);
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
	 * @throws ExcepcionDeBase Nuestra excepcion para informar un error.
	 */
	private void setCosto(double costo) throws ExcepcionDeBase {
		if (costo <= 0)
			this.costo = costo;
		else
			throw new ExcepcionDeBase("asignar el costo, ya que este es invalido: " + costo);
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
