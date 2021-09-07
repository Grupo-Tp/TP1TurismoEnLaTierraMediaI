package archivos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import clases.TipoAtraccion;
import clases.Usuario;
import excepciones.ExcepcionArchivoDeUsuario;
import excepciones.ExcepcionDeUsuario;

public class ArchivoUsuario {
	private FileReader lectorDeArchivoDeUsuarios = null;
	private BufferedReader bufferDelLectorDeArchivoDeUsuarios = null;
	private List<Usuario> usuarios = new ArrayList<Usuario>();

	public ArchivoUsuario(String nombreArchivo) {
		try {
			lectorDeArchivoDeUsuarios = new FileReader(nombreArchivo);
			bufferDelLectorDeArchivoDeUsuarios = new BufferedReader(lectorDeArchivoDeUsuarios);
			usuarios = new ArrayList<Usuario>();
			this.usuarios = this.leerArchivoUsuario();
		} catch (FileNotFoundException excepcionDeAperturaDeArchivo) {
			System.err.println("El archivo de usuarios: '" + nombreArchivo + "' no fue encontrado.");
		}
	}

	/**
	 * @pre No tiene.
	 * @post No tiene.
	 * @return Retorna la lista con las instancias de usuarios que fueron generadas
	 *         a partir del archivo de usuarios.
	 */
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * @pre No tiene.
	 * @post Se valido que el presupuesto del Usuario sea valido.
	 * @param presupuesto Ingresa el parametro leido de una linea del archivo de
	 *                    atracciones.
	 * @return Retorna el costo validado.
	 * @throws ExcepcionArchivoDeUsuario Nuestra excepcion para informar los
	 *                                   errores.
	 */
	private double validarPresupuesto(String presupuesto) throws ExcepcionArchivoDeUsuario {
		double valor = 0;
		try {
			valor = Double.parseDouble(presupuesto);
		} catch (NumberFormatException excepcionDeCosto) {
			throw new ExcepcionArchivoDeUsuario("presupuesto, el valor leido es: " + presupuesto);
		}
		return valor;
	}

	/**
	 * @pre No tiene.
	 * @post Se valido que el tiempo del Usuario sea valido.
	 * @param tiempo Ingresa el parametro leido de una linea del archivo de
	 *               atracciones.
	 * @return Retorna el tiempo validado.
	 * @throws ExcepcionArchivoDeUsuario Nuestra excepcion para informar los
	 *                                   errores.
	 */
	private double validarTiempo(String tiempo) throws ExcepcionArchivoDeUsuario {
		double valor = 0;
		try {
			valor = Double.parseDouble(tiempo);
		} catch (NumberFormatException excepcionDeCosto) {
			throw new ExcepcionArchivoDeUsuario("tiempo, el valor leido es: " + tiempo);
		}
		return valor;
	}

	/**
	 * @pre No tiene.
	 * @post Se valido que la preferencia del Usuario sea valida.
	 * @param preferencia Ingresa el parametro leido de una linea del archivo de
	 *                    atracciones.
	 * @return Retorna el tipo de atraccion validado.
	 * @throws ExcepcionArchivoDeUsuario Nuestra excepcion para informar los
	 *                                   errores.
	 */
	private TipoAtraccion validarPreferencia(String preferencia) throws ExcepcionArchivoDeUsuario {
		TipoAtraccion retorno = null;
		try {
			switch (preferencia.toUpperCase()) {
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
			throw new ExcepcionArchivoDeUsuario("su preferencia de atraccion, el valor leido es: " + preferencia);
		}
		return retorno;
	}

	/**
	 * @pre No tiene.
	 * @post Se validaron y crearon todos los usuarios contenidos en el archivo de
	 *       usuarios.
	 * @return Retorna una lista con todas las instancias de usuario creados.
	 */
	public List<Usuario> leerArchivoUsuario() {
		try {
			String lineaUsuario = "";
			while ((lineaUsuario = bufferDelLectorDeArchivoDeUsuarios.readLine()) != null) {
				String[] parametros = lineaUsuario.split(",");
				double presupuesto = 0, tiempo = 0;
				TipoAtraccion preferencia = null;
				String nombre = parametros[0];
				try {
					preferencia = this.validarPreferencia(parametros[1]);
					presupuesto = this.validarPresupuesto(parametros[2]);
					tiempo = this.validarTiempo(parametros[3]);
					usuarios.add(new Usuario(nombre, tiempo, presupuesto, preferencia));
				} catch (ExcepcionArchivoDeUsuario excepcionDeValidacion) {
					System.err.println("El usuario " + nombre + " reporta un error al momento de leer el "
							+ excepcionDeValidacion.getMessage());
				} catch (ExcepcionDeUsuario excepcionDeConstructorDeUsuario) {
					System.err.println(" El usuario " + nombre + " reporta un error al momento de leer el"
							+ excepcionDeConstructorDeUsuario.getMessage());
				}
			}
		} catch (IOException excepcion) {
			System.err.println("Hubo un problema al momento de leerr uno de los archivos");
		}
		return usuarios;
	}
}