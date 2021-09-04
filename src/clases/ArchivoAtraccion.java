package clases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArchivoAtraccion {
	private FileReader lectorDeArchivoDeAtracciones = null;
	private BufferedReader bufferDelLectorDeArchivoDeAtracciones = null;
	private List<Atraccion> atracciones;

	public ArchivoAtraccion(String nombreArchivo) {
		try {
			lectorDeArchivoDeAtracciones = new FileReader(nombreArchivo);
			bufferDelLectorDeArchivoDeAtracciones = new BufferedReader(lectorDeArchivoDeAtracciones);
		} catch (FileNotFoundException excepcion) {
			System.err.println("Hubo un problema al momento de leer el archivo de atracciones");
		}
		atracciones = new ArrayList<Atraccion>();
	}

	/**
	 * @pre No tiene.
	 * @post Se valido que el costo de la Atraccion sea valido y positivo.
	 * @param costo Ingresa el parametro leido de una linea del archivo de
	 *              atracciones.
	 * @return Retorna el costo validado.
	 * @throws ExcepcionDeAtraccion Nuestra excepcion para informar los errores.
	 */
	private double validarCosto(String costo) throws ExcepcionDeAtraccion {
		double valor = 0;
		try {
			valor = Double.parseDouble(costo);
		} catch (NumberFormatException excepcionDeCosto) {
			throw new ExcepcionDeAtraccion("Una de las atracciones leidas tiene un problema en su costo");
		}
		return valor;
	}

	/**
	 * @pre No tiene.
	 * @post Se valido que el tiempo de la Atraccion sea valido y positivo.
	 * @param tiempo Ingresa el parametro leido de una linea del archivo de
	 *               atracciones.
	 * @return Retorna el tiempo validado.
	 * @throws ExcepcionDeAtraccion Nuestra excepcion para informar los errores.
	 */
	private double validarTiempo(String tiempo) throws ExcepcionDeAtraccion {
		double valor = 0;
		try {
			valor = Double.parseDouble(tiempo);
		} catch (NumberFormatException excepcionDeCosto) {
			throw new ExcepcionDeAtraccion("Una de las atracciones leidas tiene un problema en su tiempo");
		}
		return valor;
	}

	/**
	 * @pre No tiene.
	 * @post Se valido que el cupo de la Atraccion sea valido y positivo.
	 * @param cupo Ingresa el parametro leido de una linea del archivo de
	 *             atracciones.
	 * @return Retorna el cupo validado.
	 * @throws ExcepcionDeAtraccion Nuestra excepcion para informar los errores.
	 */
	private int validarCupo(String cupo) throws ExcepcionDeAtraccion {
		int valor = 0;
		try {
			valor = Integer.parseInt(cupo);
		} catch (NumberFormatException excepcionDeCosto) {
			throw new ExcepcionDeAtraccion("Una de las atracciones leidas tiene un problema en su cupo");
		}
		return valor;
	}

	/**
	 * @pre No tiene.
	 * @post Se valido que el tipo de la Atraccion sea valido.
	 * @param tipo Ingresa el parametro leido de una linea del archivo de
	 *             atracciones.
	 * @return Retorna el tipo de atraccion validado.
	 * @throws ExcepcionDeAtraccion Nuestra excepcion para informar los errores.
	 */
	private TipoAtraccion validarTipo(String tipo) throws ExcepcionDeAtraccion {
		TipoAtraccion tipoDeAtraccion = null;
		try {
			String tipoDeAtraccionDelArchivo = tipo.toUpperCase();
			for (TipoAtraccion indice : TipoAtraccion.values()) {
				if (tipoDeAtraccionDelArchivo == indice.toString()) {
					tipoDeAtraccion = indice;
				}
			}
			if (tipoDeAtraccion == null) // Ver si esto se puede mejorar
				throw new NullPointerException();
		} catch (NullPointerException excepcionDeTipoNula) {
			throw new ExcepcionDeAtraccion("Una de las atracciones leidas tiene un problema en su tipo de atraccion");
		}
		return tipoDeAtraccion;
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
	 */
	public static List<Atraccion> crearListaDeAtraccion(String[] nombresDeAtracciones, List<Atraccion> lista) {
		List<Atraccion> retorno = new ArrayList<Atraccion>();
		try {
			for (int cantidad = 0; cantidad <= nombresDeAtracciones.length; cantidad++) {
				Iterator<Atraccion> indice = lista.iterator();
				Atraccion atraccion = null;
				boolean encontre = false;
				while ((indice.hasNext()) && !encontre) {
					atraccion = indice.next();
					if (atraccion.getNombre() == nombresDeAtracciones[cantidad]) {
						retorno.add(atraccion);
						encontre = true;
					}
				}
			}
			// hay que poner las excepciones que hacen falta, la de fuera del arreglo,
			// nullpointerexception, classcastexception y seguro alguna más que no me
			// acuerdo y controlar que salga de ese for, largar una exepciondeatraccion con
			// su mensaje para informar el error
		} catch (Exception excepcion) {
			System.err.println("Hubo un problema al momento de leer las atracciones del archivo de atracciones");
		}
		return retorno;
	}

	/**
	 * @pre No tiene.
	 * @post Se validaron y crearon todas las atracciones contenidas en el archivo
	 *       de atracciones.
	 * @return Retorna una lista con todas las instancias de atracciones creadas.
	 */
	public List<Atraccion> leerArchivoAtraccion() {
		String lineaAtraccion = "";
		try {
			while ((lineaAtraccion = bufferDelLectorDeArchivoDeAtracciones.readLine()) != null) {
				String[] parametros = lineaAtraccion.split(",");
				double costo = 0, tiempo = 0;
				int cupo = 0;
				String nombre = "";
				TipoAtraccion tipoDeAtraccion = null;
				nombre = parametros[0];
				costo = this.validarCosto(parametros[1]);
				tiempo = this.validarTiempo(parametros[2]);
				cupo = this.validarCupo(parametros[3]);
				tipoDeAtraccion = this.validarTipo(parametros[4]);
				atracciones.add(new Atraccion(nombre, tiempo, costo, tipoDeAtraccion, cupo));
			}
		} catch (ExcepcionDeAtraccion exepcionDeValidacion) {
			System.err.println(exepcionDeValidacion.getMessage());
		} catch (IOException excepcion) {
			System.err.println("Hubo un problema al momento de leer las atracciones del archivo de atracciones");
		}
		return atracciones;
	}
}