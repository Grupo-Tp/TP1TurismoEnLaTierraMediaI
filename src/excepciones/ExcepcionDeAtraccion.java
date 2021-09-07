package excepciones;

/**
 * Excepcion para manejar los errores en nuestro trabajo practico, con las
 * atracciones, segun como esta propuesto en la clase de excepciones, teniamos
 * pensado hacer una por cada tipo de error, pero al final por cuestiones de
 * tiempo usaremos esta para todas las excepciones de las promociones e iremos
 * cambiando el mensaje que imprime en cada ocacion.
 * 
 * @author tioliban
 *
 */
@SuppressWarnings("serial")
public class ExcepcionDeAtraccion extends Exception {
	public ExcepcionDeAtraccion(String mensaje) {
		super(mensaje);
	}
}
