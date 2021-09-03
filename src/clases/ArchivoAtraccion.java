package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArchivoAtraccion {
	private FileReader lectorDeArchivoDeAtracciones = null;
	private BufferedReader bufferDelLectorDeArchivoDeAtracciones = null;
	private String lineaAtraccion = "";
	private List<Atraccion> atracciones;

	public ArchivoAtraccion() {
		try {
			lectorDeArchivoDeAtracciones = new FileReader("atracciones.csv");
			bufferDelLectorDeArchivoDeAtracciones = new BufferedReader(lectorDeArchivoDeAtracciones);
		} catch (IOException excepcion) {
			System.err.println("Hubo un problema al momento de leer el archivo de atracciones");
		}
		atracciones = new ArrayList<Atraccion>();
	}

	public List<Atraccion> leerArchivoAtraccion() {
		try {
			while ((lineaAtraccion = bufferDelLectorDeArchivoDeAtracciones.readLine()) != null) {
				String[] parametros = lineaAtraccion.split(",");
				double costo = 0, tiempo = 0;
				int cupo = 0;
				String tipoDeAtraccionDelArchivo = "";
				TipoAtraccion[] todosLosTiposDeAtraccion = TipoAtraccion.values();
				TipoAtraccion tipoDeAtraccion = null;
				// Este bloque se puede mejorar
				try {
					costo = Double.parseDouble(parametros[1]);
					tiempo = Double.parseDouble(parametros[2]);
					cupo = Integer.parseInt(parametros[3]);
					tipoDeAtraccionDelArchivo = parametros[4].toUpperCase();
					if (tipoDeAtraccionDelArchivo == todosLosTiposDeAtraccion[0].name()) {
						tipoDeAtraccion = TipoAtraccion.AVENTURA;
					} else if (tipoDeAtraccionDelArchivo == todosLosTiposDeAtraccion[1].name()) {
						tipoDeAtraccion = TipoAtraccion.PAISAJE;
					} else if (tipoDeAtraccionDelArchivo == todosLosTiposDeAtraccion[2].name()) {
						tipoDeAtraccion = TipoAtraccion.DEGUSTACION;
					} else {
						// aca debería poner la excepcion que haga saltar que existe un error y que sea
						// capturada en el catch, pero no me acuerdo como era, despues lo hago
					}
				} catch (ArrayIndexOutOfBoundsException excepcionDeArregloFueraDeLimite) {
					// este es el catch que debe capturar la excepcion que esta descrita arriba
					System.err.println("Uno de los usuarios leidos tiene un problema en su preferencia");
				} catch (NumberFormatException excepcionDeCosto) {
					System.err.println("Una de las atracciones leidas tiene un problema en su costo");
				}
				atracciones.add(new Atraccion(parametros[0], tiempo, costo, tipoDeAtraccion, cupo));
			}
		} catch (IOException excepcion) {
			System.err.println("Hubo un problema al momento de leer las atracciones del archivo de atracciones");
		}
		return atracciones;
	}
}
