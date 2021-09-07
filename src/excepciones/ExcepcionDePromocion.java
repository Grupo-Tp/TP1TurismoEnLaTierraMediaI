package excepciones;

/**
 * Excepcion para manejar los errores en nuestro trabajo practico, con las
 * promociones, segun como esta propuesto en la clase de excepciones, teniamos
 * pensado hacer una por cada tipo de error, pero al final por cuestiones de
 * tiempo usaremos esta para todas las excepciones de las promociones e iremos
 * cambiando el mensaje que imprime en cada ocacion.
 * 
 * @author tioliban
 *
 */
@SuppressWarnings("serial")
public class ExcepcionDePromocion extends Exception {
	public ExcepcionDePromocion(String mensaje) {
		super(mensaje);
	}
}
