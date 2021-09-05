package excepciones;

/**
 * Excepcion para manejar los errores en nuestro trabajo practico, con el
 * archivo de atracciones, segun como esta propuesto en la clase de excepciones,
 * teniamos pensado hacer una por cada tipo de error, pero al final por
 * cuestiones de tiempo usaremos esta para todas las excepciones de las
 * atracciones e iremos cambiando el mensaje que imprime en cada ocacion.
 * 
 * @author tioliban
 *
 */
@SuppressWarnings("serial")
public class ExcepcionArchivoDeAtraccion extends Exception {
	public ExcepcionArchivoDeAtraccion(String mensaje) {
		super(mensaje);
	}
}
