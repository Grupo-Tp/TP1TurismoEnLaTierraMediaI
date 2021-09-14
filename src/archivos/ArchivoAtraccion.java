package archivos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import clases.Atraccion;
import clases.TipoAtraccion;
import excepciones.ExcepcionArchivoDeAtraccion;
import excepciones.ExcepcionDeBase;
import excepciones.ExcepcionDeAtraccion;

public class ArchivoAtraccion {
	private FileReader lectorDeArchivoDeAtracciones = null;
	private BufferedReader bufferDelLectorDeArchivoDeAtracciones = null;
	private List<Atraccion> atracciones = null;

	public ArchivoAtraccion(String nombreArchivo) {
		try {
			lectorDeArchivoDeAtracciones = new FileReader(nombreArchivo);
			bufferDelLectorDeArchivoDeAtracciones = new BufferedReader(lectorDeArchivoDeAtracciones);
			atracciones = new ArrayList<Atraccion>();
			this.atracciones = this.leerArchivoAtraccion();
			this.mostrarPorPantalla();
		} catch (FileNotFoundException excepcionDeAperturaDeArchivo) {
			System.err.println("El archivo de atracciones: '" + nombreArchivo + "' no fue encontrado.");
		}
	}

	/**
	 * @pre No tiene.
	 * @post Mostro por pantalla información de la ejecución del programa, junto con
	 *       todas las atracciones registradas.
	 */
	private void mostrarPorPantalla() {
		System.out.println();
		System.out.println("Continuamos leyendo el achivo de Atracciones, las atracciones leidas son:");
		System.out.println();
		for (Atraccion indice : this.getAtracciones()) {
			System.out.println(indice);
		}
	}

	/**
	 * @pre No tiene.
	 * @post Se retorno una lista con las atracciones generadas.
	 * @return Retorna la lista con las instancias de atraccion que fueron generadas
	 *         a partir del archivo de atracciones.
	 */
	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

	/**
	 * @pre No tiene.
	 * @post Se valido que el costo de la Atraccion sea valido.
	 * @param costo Ingresa el parametro leido de una linea del archivo de
	 *              atracciones.
	 * @return Retorna el costo validado.
	 * @throws ExcepcionArchivoDeAtraccion Informó la existencia de un error en el
	 *                                     costo leido de la atraccion, ya que no se
	 *                                     lo pudo convertir a un valor numérico
	 *                                     real.
	 */
	private double validarCosto(String costo) throws ExcepcionArchivoDeAtraccion {
		double valor = 0;
		try {
			valor = Double.parseDouble(costo);
		} catch (NumberFormatException excepcionDeCosto) {
			throw new ExcepcionArchivoDeAtraccion("costo, el valor leido es: " + costo);
		}
		return valor;
	}

	/**
	 * @pre No tiene.
	 * @post Se valido que el tiempo de la Atraccion sea valido.
	 * @param tiempo Ingresa el parametro leido de una linea del archivo de
	 *               atracciones.
	 * @return Retorna el tiempo validado.
	 * @throws ExcepcionArchivoDeAtraccion Informó la existencia de un error en el
	 *                                     tiempo leido de la atraccion, ya que no
	 *                                     se pudo convertir en un valor numérico
	 *                                     real.
	 */
	private double validarTiempo(String tiempo) throws ExcepcionArchivoDeAtraccion {
		double valor = 0;
		try {
			valor = Double.parseDouble(tiempo);
		} catch (NumberFormatException excepcionDeTiempo) {
			throw new ExcepcionArchivoDeAtraccion("tiempo, el valor leido es: " + tiempo);
		}
		return valor;
	}

	/**
	 * @pre No tiene.
	 * @post Se valido que el cupo de la Atraccion sea valido y positivo.
	 * @param cupo Ingresa el parametro leido de una linea del archivo de
	 *             atracciones.
	 * @return Retorna el cupo validado.
	 * @throws ExcepcionArchivoDeAtraccion Informó la existencia de un error en el
	 *                                     cupo leido de la atraccion, ya que no se
	 *                                     pudo convertir en un valor numérico
	 *                                     entero.
	 */
	private int validarCupo(String cupo) throws ExcepcionArchivoDeAtraccion {
		int valor = 0;
		try {
			valor = Integer.parseInt(cupo);
		} catch (NumberFormatException excepcionDeCosto) {
			throw new ExcepcionArchivoDeAtraccion("cupo, el valor leido es: " + cupo);
		}
		return valor;
	}

	/**
	 * @pre No tiene.
	 * @post Se valido que el tipo de la Atraccion sea valido.
	 * @param tipo Ingresa el parametro leido de una linea del archivo de
	 *             atracciones.
	 * @return Retorna el tipo de atraccion validado.
	 * @throws ExcepcionArchivoDeAtraccion Informó la existencia de un error en el
	 *                                     tipo de atraccion leido, ya que no se
	 *                                     pudo convertir en un enumerado de tipo
	 *                                     TipoAtraccion.
	 */
	private TipoAtraccion validarTipo(String tipo) throws ExcepcionArchivoDeAtraccion {
		TipoAtraccion retorno = null;
		try {
			switch (tipo.toUpperCase()) {
			case "AVENTURA": {
				retorno = TipoAtraccion.AVENTURA;
				break;
			}
			case "DEGUSTACION": {
				retorno = TipoAtraccion.DEGUSTACION;
				break;
			}
			case "PAISAJE": {
				retorno = TipoAtraccion.PAISAJE;
				break;
			}
			default:
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException excepcionDeTipoNula) {
			throw new ExcepcionArchivoDeAtraccion("tipo de atraccion, el valor leido es: " + tipo);
		}
		return retorno;
	}

	/**
	 * @pre No tiene.
	 * @post Se validaron y crearon todas las atracciones contenidas en el archivo
	 *       de atracciones.
	 * @return Retorna una lista con todas las instancias de atraccion creadas.
	 */
	private List<Atraccion> leerArchivoAtraccion() {
		try {
			String lineaAtraccion = "";
			while ((lineaAtraccion = bufferDelLectorDeArchivoDeAtracciones.readLine()) != null) {
				String[] parametros = lineaAtraccion.split(",");
				double costo = 0, tiempo = 0;
				int cupo = 0;
				String nombre = "";
				TipoAtraccion tipoDeAtraccion = null;
				nombre = parametros[0];
				try {
					costo = this.validarCosto(parametros[1]);
					tiempo = this.validarTiempo(parametros[2]);
					cupo = this.validarCupo(parametros[3]);
					tipoDeAtraccion = this.validarTipo(parametros[4]);
					atracciones.add(new Atraccion(nombre, tiempo, costo, tipoDeAtraccion, cupo));
				} catch (ExcepcionArchivoDeAtraccion exepcionDeValidacion) {
					System.err.println("La atraccion " + nombre + " reporta un error al momento de "
							+ exepcionDeValidacion.getMessage());
				} catch (ExcepcionDeBase excepcionDeConstructorBase) {
					System.err.println("La atraccion " + nombre + " reporta un error al momento de "
							+ excepcionDeConstructorBase.getMessage());
				} catch (ExcepcionDeAtraccion excepcionDeConstructorDeAtraccion) {
					System.err.println("La atraccion " + nombre + " reporta un error al momento de "
							+ excepcionDeConstructorDeAtraccion.getMessage());
				}
			}
		} catch (ArrayIndexOutOfBoundsException excepcionDeFueraDeLosLimitesDeLosParametros) {
			System.err.println(
					"Hubo un problema al momento de leer una lidea de las atracciones del archivo de atracciones: \n"
							+ excepcionDeFueraDeLosLimitesDeLosParametros.getMessage());
		} catch (NoSuchElementException excepcionDeLecturaDeLineaDelArchivo) {
			System.err.println(
					"Hubo un problema al momento de leer una linea de las atracciones del archivo de atracciones: \n"
							+ excepcionDeLecturaDeLineaDelArchivo.getMessage());
		} catch (IllegalStateException excepcion) {
			System.err.println("Hubo un problema, ya que se ha cerrado el archivo de usuarios de forma inesperada: \n"
					+ excepcion.getMessage());
		} catch (IOException excepcionDeLecturaDeLineaDelArchivo) {
			System.err.println(
					"Hubo un problema al momento de leer una linea de las atracciones del archivo de atracciones: "
							+ excepcionDeLecturaDeLineaDelArchivo.getMessage());
		}
		return atracciones;
	}
}