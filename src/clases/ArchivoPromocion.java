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

	public ArchivoPromocion() {
		try {
			lectorDeArchivoDePromociones = new FileReader("promociones.csv");
			bufferDelLectorDeArchivoDePromociones = new BufferedReader(lectorDeArchivoDePromociones);
		} catch (FileNotFoundException excepcion) {
			System.err.println("Hubo un problema al momento de leer el archivo de promociones");
		}
		promociones = new ArrayList<Base>();
	}

	/**
	 * @pre No tiene.
	 * @post Se valido que el tipo de la Atraccion sea valido.
	 * @param tipo Ingresa el parametro leido de una linea del archivo de
	 *             atracciones.
	 * @return Retorna el tipo de atraccion validado.
	 */
	private TipoAtraccion validarTipoDeAtraccion(String tipo) {
		// todo este codigo se puede mejorar
		TipoAtraccion tipoDePromocion = null;
		try {
			String tipoDePromocionDelArchivo = tipo.toUpperCase();
			try {
				if (tipoDePromocionDelArchivo == "")
					throw new IllegalArgumentException();
			} catch (IllegalArgumentException excepcionDeTipoVacia) {
				System.err.println("Una de las promociones leidas tiene su tipo de promocion vacia");
			}
			for (TipoAtraccion indice : TipoAtraccion.values()) {
				if (tipoDePromocionDelArchivo == indice.toString()) {
					tipoDePromocion = indice;
				}
			}
			if (tipoDePromocion == null)
				throw new NullPointerException();
			// aca debería poner la excepcion que haga saltar que existe un error y que sea
			// capturada en el catch, pero no me acuerdo como era, despues lo hago
		} catch (NullPointerException excepcionDeTipoNula) {
			System.err.println("Una de las promociones leidas tiene un problema en su tipo de promocion");
		}
		return tipoDePromocion;
	}

	/**
	 * @pre No tiene.
	 * @post Se valido que el costo de la Atraccion sea valido y positivo.
	 * @param costo Ingresa el parametro leido de una linea del archivo de
	 *              atracciones.
	 * @return Retorna el costo validado.
	 */
	private double validarPrecioFinal(String monto) {
		double valor = 0;
		try {
			valor = Double.parseDouble(monto);
			if (valor <= 0)
				throw new IllegalArgumentException();
		} catch (NumberFormatException excepcionDeMonto) {
			System.err.println("Una de las promociones absolutas leidas tiene un problema en su monto final");
		} catch (IllegalArgumentException excepcionMenorIgualCero) {
			System.err.println("Una de las promociones absolutas leidas tiene un monto final menor o igual que cero");
		}
		return valor;
	}

	/**
	 * @pre No tiene.
	 * @post Se valido que el costo de la Atraccion sea valido y positivo.
	 * @param costo Ingresa el parametro leido de una linea del archivo de
	 *              atracciones.
	 * @return Retorna el costo validado.
	 */
	private double validarProcentajeDeDescuento(String monto) {
		double valor = 0;
		try {
			valor = Double.parseDouble(monto);
			if ((valor <= 0) || (valor >= 100))
				throw new IllegalArgumentException("Porcentaje de descuento incorrecto: " + valor);
		} catch (NumberFormatException excepcionDeMonto) {
			System.err.println("Una de las promociones porcentuales leidas tiene un problema en su porcentaje de descuento");
		} catch (IllegalArgumentException excepcionMenorIgualCero) {
			System.err.println("Una de las promociones porcentuales leidas tiene porcentaje de descuento invalido");
		}
		return valor;
	}

	private Promocion crearInstancia(String tipo, String valor) {
		Promocion promocion = null;
		try {
			if (tipo == "")
				throw new IllegalArgumentException();
			switch (tipo) {
			case "Porcentaje": {
				promocion = new PromocionPorcentual(this.validarProcentajeDeDescuento(valor));
				break;
			}
			case "AxB": {
				promocion = new PromocionAxB();
				break;
			}
			case "Absoluta": {
				promocion = new PromocionAbsoluta(this.validarPrecioFinal(valor));
				break;
			}
			default:
				throw new IllegalArgumentException("Tipo de promocion incorrecta: " + tipo);
			}

		} catch (IllegalArgumentException excepcionDeTipoVacio) {
			System.err.println("Una de las promociones leidas tiene un problema en su tipo de promocion");
		}
		return promocion;
	}

	private String validarNombre(String nombre) {
		try {
			if (nombre == "")
				throw new IllegalArgumentException();
		} catch (IllegalArgumentException excepcionDeNombre) {
			System.err.println("Una de las atracciones leidas tiene un problema en su nombre");
		}
		return nombre;
	}

	public List<Base> leerArchivoPromocion() {
		try {
			while ((lineaPromocion = bufferDelLectorDeArchivoDePromociones.readLine()) != null) {
				String[] parametros = lineaPromocion.split(",");
				Atraccion[] atraccion = null;
				Promocion promocion = null;
				TipoAtraccion tipoDeAtraccionDeLaPromocion = null;
				// Este bloque se puede mejorar
				try {
					tipoDeAtraccionDeLaPromocion = this.validarTipoDeAtraccion(parametros[0]);
					promocion = this.crearInstancia(parametros[1], parametros[5]);
				} catch (NumberFormatException excepcionDeCosto) {
					System.err.println("Una de las atracciones leidas tiene un problema en su costo");
				}
				promociones.add(promocion);
			}
		} catch (IOException excepcion) {
			System.err.println("Hubo un problema al momento de leerr uno de los archivos");
		}
		return promociones;
	}
}
