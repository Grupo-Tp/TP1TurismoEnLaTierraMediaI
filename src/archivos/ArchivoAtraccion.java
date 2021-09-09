package archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import clases.Atraccion;
import clases.TipoAtraccion;
import excepciones.ExcepcionArchivoDeAtraccion;
import excepciones.ExcepcionDeBase;
import excepciones.ExcepcionDeAtraccion;

public class ArchivoAtraccion {
	private Scanner lectorDeArchivo = null;
	private List<Atraccion> atracciones = null;

	public ArchivoAtraccion(String nombreArchivo) {
		try {
			lectorDeArchivo = new Scanner(new File(nombreArchivo));
			atracciones = new ArrayList<Atraccion>();
			this.atracciones = this.leerArchivoAtraccion();
		} catch (FileNotFoundException excepcionDeAperturaDeArchivo) {
			System.err.println("El archivo de atracciones: '" + nombreArchivo + "' no fue encontrado.");
		}
	}

	/**
	 * @pre No tiene.
	 * @post No tiene.
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
	 * @throws ExcepcionArchivoDeAtraccion Nuestra excepcion para informar los
	 *                                     errores.
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
	 * @throws ExcepcionArchivoDeAtraccion Nuestra excepcion para informar los
	 *                                     errores.
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
	 * @throws ExcepcionArchivoDeAtraccion Nuestra excepcion para informar los
	 *                                     errores.
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
	 * @throws ExcepcionArchivoDeAtraccion Nuestra excepcion para informar los
	 *                                     errores.
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
	 * @post Se creo una nueva lista con las instancias de las atracciones
	 *       nombradas.
	 * @param nombresDeAtracciones Arreglo con los nombres de las instancias de las
	 *                             atracciones a buscar en la lista de atracciones
	 *                             prorporcionada.
	 * @param lista                Lista con las instancias de las atracciones.
	 * @return Retorna una lista con las instancias de atracciones que forman parte
	 *         de la promocion.
	 * @throws ExcepcionDeAtraccion Nuestra excepcion para informar errores.
	 */
	public static List<Atraccion> crearListaDeAtraccion(String[] nombresDeAtracciones, List<Atraccion> lista)
			throws ExcepcionDeAtraccion {
		List<Atraccion> retorno = new ArrayList<Atraccion>();
		try {
			for (int cantidad = 0; cantidad < nombresDeAtracciones.length; cantidad++) {
				Iterator<Atraccion> indice = lista.iterator();
				boolean encontre = false;
				while (indice.hasNext() && !encontre) {
					Atraccion atraccion = indice.next();
					if (atraccion.getNombre().equals(nombresDeAtracciones[cantidad])) {
						retorno.add(atraccion);
						encontre = true;
					}
				}
			}
			if (retorno.size() != nombresDeAtracciones.length)
				throw new ArrayIndexOutOfBoundsException();
		} catch (NullPointerException excepcionDeAgregarUnaAtraccionNula) {
			throw new ExcepcionDeAtraccion("se ha intentado agregar una atraccion nula.");
		} catch (ClassCastException excepcionDeAgregarUnObjetoQueNoEsAtraccion) {
			throw new ExcepcionDeAtraccion("se ha intentado agregar algo que no es una atraccion.");
		} catch (NoSuchElementException excepcionDeSiguienteElementoDeLista) {
			throw new ExcepcionDeAtraccion("ha habido un problema con la lista de atracciones proporcionada.");
		} catch (ArrayIndexOutOfBoundsException excepcionDeFueraDeLosLimitesDelArreglo) {
			throw new ExcepcionDeAtraccion(
					"ha habido un problema con los nombres de las atracciones que incluye la promocion.");
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
			while (lectorDeArchivo.hasNext()) {
				lineaAtraccion = lectorDeArchivo.next();
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
			lectorDeArchivo.close();
		} catch (NoSuchElementException excepcionDeLecturaDeLineaDelArchivo) {
			System.err.println(
					"Hubo un problema al momento de leer una linea de las atracciones del archivo de atracciones: \n"
							+ excepcionDeLecturaDeLineaDelArchivo.getMessage());
		} catch (IllegalStateException excepcion) {
			System.err.println("Hubo un problema, ya que se ha cerrado el archivo de usuarios de forma inesperada: \n"
					+ excepcion.getMessage());
		}
		return atracciones;
	}
}