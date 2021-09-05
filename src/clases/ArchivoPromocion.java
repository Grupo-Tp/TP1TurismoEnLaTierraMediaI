package clases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArchivoPromocion {
	private FileReader lectorDeArchivoDePromociones = null;
	private BufferedReader bufferDelLectorDeArchivoDePromociones = null;
	private String lineaPromocion = "";
	private List<Base> promociones;

	public ArchivoPromocion(String nombreArchivo) {
		try {
			lectorDeArchivoDePromociones = new FileReader(nombreArchivo);
			bufferDelLectorDeArchivoDePromociones = new BufferedReader(lectorDeArchivoDePromociones);
			promociones = new ArrayList<Base>();
		} catch (FileNotFoundException excepcionDeAperturaDeArchivo) {
			System.err.println("El archivo de promociones: '" + nombreArchivo + "' no fue encontrado");
		}
	}

	/**
	 * @pre No tiene.
	 * @post Se valido que el tipo de la Atraccion sea valido.
	 * @param tipo Ingresa el parametro leido de una linea del archivo de
	 *             atracciones.
	 * @return Retorna el tipo de atraccion validado.
	 * @throws ExcepcionDePromocion Nuestra excepcion para informar los errores.
	 */
	private TipoAtraccion validarTipoDePromocion(String tipo) throws ExcepcionDePromocion {
		TipoAtraccion tipoDePromocion = null;
		try {
			String tipoDePromocionDelArchivo = tipo.toUpperCase();
			for (TipoAtraccion indice : TipoAtraccion.values()) {
				if (tipoDePromocionDelArchivo == indice.toString()) {
					tipoDePromocion = indice;
				}
			}
			if (tipoDePromocion == null)
				throw new NullPointerException();
		} catch (NullPointerException excepcionDeTipoNula) {
			throw new ExcepcionDePromocion("tipo de promocion, el valor leido es: " + tipo);
		}
		return tipoDePromocion;
	}

	/**
	 * @pre No tiene.
	 * @post Se valido que el costo de la Atraccion sea valido y positivo.
	 * @param costo Ingresa el parametro leido de una linea del archivo de
	 *              atracciones.
	 * @return Retorna el costo validado.
	 * @throws ExcepcionDePromocion Nuestra excepcion para informar los errores.
	 */
	private double validarPrecioFinal(String monto) throws ExcepcionDePromocion {
		double valor = 0;
		try {
			valor = Double.parseDouble(monto);
		} catch (NumberFormatException excepcionDeMonto) {
			throw new ExcepcionDePromocion("monto, el valor leido es: " + monto);
		}
		return valor;
	}

	/**
	 * @pre No tiene.
	 * @post Se valido que el costo de la Atraccion sea valido y positivo.
	 * @param costo Ingresa el parametro leido de una linea del archivo de
	 *              atracciones.
	 * @return Retorna el costo validado.
	 * @throws ExcepcionDePromocion Nuestra excepcion para informar los errores.
	 */
	private double validarProcentajeDeDescuento(String monto) throws ExcepcionDePromocion {
		double valor = 0;
		try {
			valor = Double.parseDouble(monto);
		} catch (NumberFormatException excepcionDeMonto) {
			throw new ExcepcionDePromocion("porcentaje de descuento, el valor leido es: " + monto);
		}
		return valor;
	}

	public List<Base> leerArchivoPromocion() {
		try {
			while ((lineaPromocion = bufferDelLectorDeArchivoDePromociones.readLine()) != null) {
				String[] parametros = lineaPromocion.split(",");
				List<Atraccion> atraccionesDeLaPromocion = new ArrayList<Atraccion>();
				Promocion promocion = null;
				TipoAtraccion tipoDeAtraccionDeLaPromocion = null;
				String[] nombresDeAtraccionesDeLaPromocion = null;
				String nombre = "";
				try {
					tipoDeAtraccionDeLaPromocion = this.validarTipoDePromocion(parametros[1]);
					nombre = parametros[0];
					switch (parametros[2]) {
					case "Porcentaje": {
						nombresDeAtraccionesDeLaPromocion = new String[1];
						nombresDeAtraccionesDeLaPromocion[0] = parametros[4];
						nombresDeAtraccionesDeLaPromocion[1] = parametros[5];
						atraccionesDeLaPromocion = ArchivoAtraccion
								.crearListaDeAtraccion(nombresDeAtraccionesDeLaPromocion, atraccionesDeLaPromocion);
						double porcentaje = this.validarProcentajeDeDescuento(parametros[6]);
						promocion = new PromocionPorcentual(nombre, tipoDeAtraccionDeLaPromocion,
								atraccionesDeLaPromocion, porcentaje);
						break;
					}
					case "AxB": {
						nombresDeAtraccionesDeLaPromocion = new String[2];
						nombresDeAtraccionesDeLaPromocion[0] = parametros[4];
						nombresDeAtraccionesDeLaPromocion[1] = parametros[5];
						nombresDeAtraccionesDeLaPromocion[2] = parametros[6];
						atraccionesDeLaPromocion = ArchivoAtraccion
								.crearListaDeAtraccion(nombresDeAtraccionesDeLaPromocion, atraccionesDeLaPromocion);
						Atraccion atraccionGratuita = atraccionesDeLaPromocion.get(2);
						promocion = new PromocionAxB(nombre, tipoDeAtraccionDeLaPromocion, atraccionesDeLaPromocion,
								atraccionGratuita);
						break;
					}
					case "Absoluta": {
						nombresDeAtraccionesDeLaPromocion = new String[1];
						nombresDeAtraccionesDeLaPromocion[0] = parametros[4];
						nombresDeAtraccionesDeLaPromocion[1] = parametros[5];
						atraccionesDeLaPromocion = ArchivoAtraccion
								.crearListaDeAtraccion(nombresDeAtraccionesDeLaPromocion, atraccionesDeLaPromocion);
						double monto = this.validarPrecioFinal(parametros[6]);
						promocion = new PromocionAbsoluta(nombre, tipoDeAtraccionDeLaPromocion,
								atraccionesDeLaPromocion, monto);
						break;
					}
					default:
						throw new ExcepcionDePromocion("tipo de promocion, el valor leido es: " + parametros[2]);
					}
				} catch (ExcepcionDeAtraccion excepcionDeCreacionDeListaDeAtraccionesQueIncluyeLaPromocion) {
					System.err.println("La promocion: " + parametros[0] + " tubo un error al momento de generarse, ya que "
							+ excepcionDeCreacionDeListaDeAtraccionesQueIncluyeLaPromocion.getMessage());
				} catch (ExcepcionDePromocion excepcionDeValidacion) {
					System.err.println("Una de las promociones leidas tiene un problema en su "
							+ excepcionDeValidacion.getMessage());
				}
				promociones.add(promocion);
			}
		} catch (IOException excepcionDeLecturaDeLineaDelArchivo) {
			System.err.println(
					"Hubo un problema al momento de leer una linea de las promociones del archivo de promociones: "
							+ excepcionDeLecturaDeLineaDelArchivo.getMessage());
		}
		return promociones;
	}
}
