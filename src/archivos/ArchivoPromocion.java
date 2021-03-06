package archivos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import clases.Atraccion;
import clases.Promocion;
import clases.PromocionAbsoluta;
import clases.PromocionAxB;
import clases.PromocionPorcentual;
import clases.TipoAtraccion;
import excepciones.ExcepcionDeBase;
import excepciones.ExcepcionDePromocion;
import excepciones.ExcepcionArchivoDePromocion;
import excepciones.ExcepcionDeAtraccion;

public class ArchivoPromocion {
	private FileReader lectorDeArchivoDePromociones = null;
	private BufferedReader bufferDelLectorDeArchivoDePromociones = null;
	private List<Promocion> promociones = null;

	public ArchivoPromocion(String nombreArchivo, List<Atraccion> lasAtracciones) {
		try {
			lectorDeArchivoDePromociones = new FileReader(nombreArchivo);
			bufferDelLectorDeArchivoDePromociones = new BufferedReader(lectorDeArchivoDePromociones);
			promociones = new ArrayList<Promocion>();
			promociones = this.leerArchivoPromocion(lasAtracciones);
			this.mostrarPorPantalla();
		} catch (FileNotFoundException excepcionDeAperturaDeArchivo) {
			System.err.println("El archivo de promociones: '" + nombreArchivo + "' no fue encontrado");
		}
	}

	/**
	 * @pre No tiene.
	 * @post Mostro por pantalla información de la ejecución del programa, junto con
	 *       todas las promociones registradas.
	 */
	private void mostrarPorPantalla() {
		System.out.println();
		System.out.println("Terminamos leyendo el achivo de Promociones, las promociones leidas son:");
		System.out.println();
		for (Promocion indice : this.getPromociones()) {
			System.out.println(indice.toString());
		}
	}

	/**
	 * @pre No tiene.
	 * @post Retorno una lista con todas las promociones generadas.
	 * @return Retorna la lista con las instancias de promocion que fueron generadas
	 *         a partir del archivo de atracciones.
	 */
	public List<Promocion> getPromociones() {
		return promociones;
	}

	/**
	 * @pre No tiene.
	 * @post Se valido que el tipo de la Atraccion sea valido.
	 * @param tipo Ingresa el parametro leido de una linea del archivo de
	 *             atracciones.
	 * @return Retorna el tipo de atraccion validado.
	 * @throws ExcepcionArchivoDePromocion Informó la existencia de un error en el
	 *                                     tipo de atraccion contenida en la
	 *                                     promocion que fue leido, ya que no se
	 *                                     pudo convertir en un enumerado de tipo
	 *                                     TipoAtraccion.
	 */
	private TipoAtraccion validarTipoDePromocion(String tipo) throws ExcepcionArchivoDePromocion {
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
			throw new ExcepcionArchivoDePromocion("su tipo de promocion, el valor leido es: " + tipo);
		}
		return retorno;
	}

	/**
	 * @pre No tiene.
	 * @post Se valido que el costo de la Atraccion sea valido.
	 * @param costo Ingresa el parametro leido de una linea del archivo de
	 *              atracciones.
	 * @return Retorna el costo validado.
	 * @throws ExcepcionArchivoDePromocion Informó la existencia de un error en el
	 *                                     precio final leido de la promocion, ya
	 *                                     que no se lo pudo convertir a un valor
	 *                                     numérico real.
	 */
	private double validarPrecioFinal(String monto) throws ExcepcionArchivoDePromocion {
		double valor = 0;
		try {
			valor = Double.parseDouble(monto);
		} catch (NumberFormatException excepcionDeMonto) {
			throw new ExcepcionArchivoDePromocion("monto, el valor leido es: " + monto);
		}
		return valor;
	}

	/**
	 * @pre No tiene.
	 * @post Se valido que el costo de la Atraccion sea valido.
	 * @param costo Ingresa el parametro leido de una linea del archivo de
	 *              atracciones.
	 * @return Retorna el costo validado.
	 * @throws ExcepcionArchivoDePromocion Informó la existencia de un error en el
	 *                                     porcentaje de descuento leido de la
	 *                                     promocion, ya que no se lo pudo convertir
	 *                                     a un valor numérico real.
	 */
	private double validarProcentajeDeDescuento(String monto) throws ExcepcionArchivoDePromocion {
		double valor = 0;
		try {
			valor = Double.parseDouble(monto);
		} catch (NumberFormatException excepcionDeMonto) {
			throw new ExcepcionArchivoDePromocion("porcentaje de descuento, el valor leido es: " + monto);
		}
		return valor;
	}

	/**
	 * @pre No tiene.
	 * @post Se validaron y crearon todas las promociones contenidas en el archivo
	 *       de atracciones.
	 * @return Retorna una lista con todas las instancias de promocion creadas.
	 */
	private List<Promocion> leerArchivoPromocion(List<Atraccion> atracciones) {
		try {
			String lineaPromocion = "";
			while ((lineaPromocion = bufferDelLectorDeArchivoDePromociones.readLine()) != null) {
				String[] parametros = lineaPromocion.split(",");
				Promocion promocion = null;
				TipoAtraccion tipoDeAtraccionDeLaPromocion = null;
				String[] nombresDeAtraccionesDeLaPromocion = null;
				String nombre = "";
				try {
					nombre = parametros[0];
					tipoDeAtraccionDeLaPromocion = this.validarTipoDePromocion(parametros[1]);
					switch (parametros[2]) {
					case "Porcentaje": {
						nombresDeAtraccionesDeLaPromocion = new String[2];
						nombresDeAtraccionesDeLaPromocion[0] = parametros[3];
						nombresDeAtraccionesDeLaPromocion[1] = parametros[4];
						double porcentaje = this.validarProcentajeDeDescuento(parametros[5]);
						promocion = new PromocionPorcentual(nombre, tipoDeAtraccionDeLaPromocion,
								nombresDeAtraccionesDeLaPromocion, atracciones, porcentaje);
						break;
					}
					case "AxB": {
						nombresDeAtraccionesDeLaPromocion = new String[3];
						nombresDeAtraccionesDeLaPromocion[0] = parametros[3];
						nombresDeAtraccionesDeLaPromocion[1] = parametros[4];
						nombresDeAtraccionesDeLaPromocion[2] = parametros[5];
						promocion = new PromocionAxB(nombre, tipoDeAtraccionDeLaPromocion,
								nombresDeAtraccionesDeLaPromocion, atracciones, parametros[5]);
						break;
					}
					case "Absoluta": {
						nombresDeAtraccionesDeLaPromocion = new String[2];
						nombresDeAtraccionesDeLaPromocion[0] = parametros[3];
						nombresDeAtraccionesDeLaPromocion[1] = parametros[4];
						double monto = this.validarPrecioFinal(parametros[5]);
						promocion = new PromocionAbsoluta(nombre, tipoDeAtraccionDeLaPromocion,
								nombresDeAtraccionesDeLaPromocion, atracciones, monto);
						break;
					}
					default:
						throw new ExcepcionArchivoDePromocion(
								"tipo de promocion, ya que el valor leido es: " + parametros[2]);
					}
				} catch (ArrayIndexOutOfBoundsException excepcionDeFueraDeLosLimites) {
					System.err.println("Hemos encontrado un error en una promocion, ya que esta tiene una "
							+ "cantidad de parametros incorrecta");
				} catch (ExcepcionDeAtraccion excepcionDeCreacionDeListaDeAtraccionesQueIncluyeLaPromocion) {
					System.err.println(
							"La promocion: " + parametros[0] + " tubo un error al momento de generarse, ya que "
									+ excepcionDeCreacionDeListaDeAtraccionesQueIncluyeLaPromocion.getMessage());
				} catch (ExcepcionArchivoDePromocion excepcionDeValidacion) {
					System.err.println(
							"Una de las promociones leidas tiene un problema en " + excepcionDeValidacion.getMessage());
				} catch (ExcepcionDeBase excepcionDeConstructorDeBase) {
					System.err.println("Una de las promociones presenta un error al momento de leer el "
							+ excepcionDeConstructorDeBase.getMessage());
				} catch (ExcepcionDePromocion exepcionDeConstructorDePromocion) {
					System.err.println("Una de las promociones presenta un error al momento de leer el "
							+ exepcionDeConstructorDePromocion.getMessage());
				}
				promociones.add(promocion);
			}
		} catch (NoSuchElementException excepcionDeLecturaDeLineaDelArchivo) {
			System.err.println(
					"Hubo un problema al momento de leer una linea de las promociones del archivo de promociones: \n"
							+ excepcionDeLecturaDeLineaDelArchivo.getMessage());
		} catch (IllegalStateException excepcion) {
			System.err.println("Hubo un problema, ya que se ha cerrado el archivo de usuarios de forma inesperada: \n"
					+ excepcion.getMessage());
		} catch (IOException excepcionDeLecturaDeLineaDelArchivo) {
			System.err.println(
					"Hubo un problema al momento de leer una linea de las promociones del archivo de promociones: "
							+ excepcionDeLecturaDeLineaDelArchivo.getMessage());
		}
		return promociones;
	}
}
