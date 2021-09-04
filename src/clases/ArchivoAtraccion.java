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
	 * Esto va en la clase
	 * 
	 * @pre No tiene.
	 * @post Se valido el nombre de la Atraccion.
	 * @param nombre Ingresa el parametro leido de una linea del archivo de
	 *               atracciones.
	 * @return Retorna el nombre validado.
	 */
	private String validarNombre(String nombre) {
		try {
			if (nombre == "")
				throw new IllegalArgumentException();
		} catch (IllegalArgumentException excepcionDeNombre) {
			System.err.println("Una de las atracciones leidas tiene un problema en su nombre");
		}
		return nombre;
	}

	/**
	 * @pre No tiene.
	 * @post Se valido que el costo de la Atraccion sea valido y positivo.
	 * @param costo Ingresa el parametro leido de una linea del archivo de
	 *              atracciones.
	 * @return Retorna el costo validado.
	 */
	private double validarCosto(String costo) {
		double valor = 0;
		try {
			valor = Double.parseDouble(costo);
		} catch (NumberFormatException excepcionDeCosto) {
			System.err.println("Una de las atracciones leidas tiene un problema en su costo");
		}
		return valor;
	}

	/**
	 * @pre No tiene.
	 * @post Se valido que el tiempo de la Atraccion sea valido y positivo.
	 * @param tiempo Ingresa el parametro leido de una linea del archivo de
	 *               atracciones.
	 * @return Retorna el tiempo validado.
	 */
	private double validarTiempo(String tiempo) {
		double valor = 0;
		try {
			valor = Double.parseDouble(tiempo);
		} catch (NumberFormatException excepcionDeCosto) {
			System.err.println("Una de las atracciones leidas tiene un problema en su tiempo");
		}
		return valor;
	}

	/**
	 * @pre No tiene.
	 * @post Se valido que el cupo de la Atraccion sea valido y positivo.
	 * @param cupo Ingresa el parametro leido de una linea del archivo de
	 *             atracciones.
	 * @return Retorna el cupo validado.
	 */
	private int validarCupo(String cupo) {
		int valor = 0;
		try {
			valor = Integer.parseInt(cupo);
		} catch (NumberFormatException excepcionDeCosto) {
			System.err.println("Una de las atracciones leidas tiene un problema en su cupo");
		}
		return valor;
	}

	/**
	 * @pre No tiene.
	 * @post Se valido que el tipo de la Atraccion sea valido.
	 * @param tipo Ingresa el parametro leido de una linea del archivo de
	 *             atracciones.
	 * @return Retorna el tipo de atraccion validado.
	 */
	private TipoAtraccion validarTipo(String tipo) {
		// todo este codigo se puede mejorar
		TipoAtraccion tipoDeAtraccion = null;
		try {
			String tipoDeAtraccionDelArchivo = tipo.toUpperCase();
			for (TipoAtraccion indice : TipoAtraccion.values()) {
				if (tipoDeAtraccionDelArchivo == indice.toString()) {
					tipoDeAtraccion = indice;
				}
			}
			if (tipoDeAtraccion == null)
				throw new NullPointerException();
			// aca debería poner la excepcion que haga saltar que existe un error y que sea
			// capturada en el catch, pero no me acuerdo como era, despues lo hago
		} catch (NullPointerException excepcionDeTipoNula) {
			System.err.println("Una de las atracciones leidas tiene un problema en su tipo de atraccion");
		}
		return tipoDeAtraccion;
	}


//    public class UsuarioException extends Exception { 
//    public UsuarioException(String msg) {
//        super(msg);
//    }
//}
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
	public List<Atraccion> crearListaDeAtraccion(String[] nombresDeAtracciones, List<Atraccion> lista) {
		try {
			Iterator<Atraccion> indice = lista.iterator();
			while (indice.hasNext()) {
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
		} catch (IOException excepcion) {
			System.err.println("Hubo un problema al momento de leer las atracciones del archivo de atracciones");
		}
		/**
		 * Este método tiene que buscar las instancias de las atracciones que coincida
		 * con los nombres de atracciones proporcionadas en los nombresDeAtracciones,
		 * para cada uno tiene que validarlo y retornar la nueva lista con las
		 * instancias.
		 */
		return atracciones;
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
				nombre = this.validarNombre(parametros[0]);
				costo = this.validarCosto(parametros[1]);
				tiempo = this.validarTiempo(parametros[2]);
				cupo = this.validarCupo(parametros[3]);
				tipoDeAtraccion = this.validarTipo(parametros[4]);
				atracciones.add(new Atraccion(nombre, tiempo, costo, tipoDeAtraccion, cupo));
			}
		} catch (IOException excepcion) {
			System.err.println("Hubo un problema al momento de leer las atracciones del archivo de atracciones");
		}
		return atracciones;
	}
}