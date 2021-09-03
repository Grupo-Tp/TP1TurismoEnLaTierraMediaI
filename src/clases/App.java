package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {

		FileReader lectorDeArchivoDeUsuarios = null, lectorDeArchivoDeAtracciones = null,
				lectorDeArchivoDePromociones = null;
		BufferedReader bufferDelLectorDeArchivoDeUsuarios = null, bufferDelLectorDeArchivoDeAtracciones = null,
				bufferDelLectorDeArchivoDePromociones = null;
		String lineaUsuario="", lineaAtraccion="", lineaPromocion="";
		List<Usuario> usuarios = new ArrayList<Usuario>();
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		List<Base> promociones = new ArrayList<Base>();

		try {

			lectorDeArchivoDeUsuarios = new FileReader("usuarios.csv");
			lectorDeArchivoDeAtracciones = new FileReader("atracciones.csv");
			lectorDeArchivoDePromociones = new FileReader("promociones.csv");
			bufferDelLectorDeArchivoDeUsuarios = new BufferedReader(bufferDelLectorDeArchivoDeUsuarios);
			bufferDelLectorDeArchivoDeAtracciones = new BufferedReader(bufferDelLectorDeArchivoDeAtracciones);
			bufferDelLectorDeArchivoDePromociones = new BufferedReader(bufferDelLectorDeArchivoDePromociones);

			while ((lineaUsuario = bufferDelLectorDeArchivoDeUsuarios.readLine()) != null) {
				String[] parametros = lineaUsuario.split(",");
				double presupuesto = 0, tiempo = 0;
				String preferenciaDelArchivo = "";
				TipoAtraccion[] todasLasPreferencias = TipoAtraccion.values();
				TipoAtraccion preferencia = null;
				try {
					try {
					if(parametros[0]=="") {
						throw new RuntimeException();
					}}catch(RuntimeException excepcionDeNombre) {
						System.err.}try {
					}
					// Este bloque se puede mejorar
					preferenciaDelArchivo = parametros[1].toUpperCase();
					if (preferenciaDelArchivo == todasLasPreferencias[0].name()) {
						preferencia = TipoAtraccion.AVENTURA;
					} else if (preferenciaDelArchivo == todasLasPreferencias[1].name()) {
						preferencia = TipoAtraccion.PAISAJE;
					} else if (preferenciaDelArchivo == todasLasPreferencias[2].name()) {
						preferencia = TipoAtraccion.DEGUSTACION;
					} else {
						throw new RuntimeException();
					}
					// Aquí finaliza el bloque que se puede mejorar
				} catch (RuntimeException excepcionDePreferencias) {
					// este es el catch que debe capturar la excepcion que esta descrita arriba
					System.err.println("Uno de los usuarios leidos tiene un problema en su preferencia");
				}
				try {
					presupuesto = Double.parseDouble(parametros[2]);
				} catch (NumberFormatException excepcionDePresupuestoYTiempo) {

				}
				try {
					tiempo = Double.parseDouble(parametros[3]);
				} catch (NumberFormatException excepcionDePresupuestoYTiempo) {
					System.err.println("Uno de los usuarios leidos tiene un problema en su presupuesto o tiempo");
				}
				usuarios.add(new Usuario(parametros[0], tiempo, presupuesto, preferencia));
			}
			while ((lineaAtraccion = bufferDelLectorDeArchivoDeAtracciones.readLine()) != null) {
				String[] parametros = lineaAtraccion.split(".");
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
			while ((lineaPromocion = bufferDelLectorDeArchivoDePromociones.readLine()) != null) {
				String[] parametros = lineaPromocion.split(".");
				double absoluto = 0, descuento = 0;
				String tipoDePromocionDelArchivo = "";
				TipoAtraccion[] todosLosTiposDePromocion = TipoAtraccion.values();
				TipoAtraccion tipoDePromocion = null;
				// Este bloque se puede mejorar
				try {
					absoluto = Double.parseDouble(parametros[1]);
					descuento = Double.parseDouble(parametros[2]);
					tipoDePromocionDelArchivo = parametros[0].toUpperCase();
					if (tipoDePromocionDelArchivo == todosLosTiposDePromocion[0].name()) {
						tipoDePromocion = TipoAtraccion.AVENTURA;
					} else if (tipoDePromocionDelArchivo == todosLosTiposDePromocion[1].name()) {
						tipoDePromocion = TipoAtraccion.PAISAJE;
					} else if (tipoDePromocionDelArchivo == todosLosTiposDePromocion[2].name()) {
						tipoDePromocion = TipoAtraccion.DEGUSTACION;
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
				promociones.add(new Atraccion(tipoDePromocion, parametros[0]));
			}
		} catch (IOException excepcion) {
			System.err.println("Hubo un problema al momento de leerr uno de los archivos");

		}

	}

}
