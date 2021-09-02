package clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class App {

	public static void main(String[] args) {
		File archivoUsuarios = null;
		File archivoAtracciones = null;
		File archivoPromociones = null;
		FileReader lectorDeArchivoDeUsuarios = null;
		FileReader lectorDeArchivoDeAtracciones = null;
		FileReader lectorDeArchivoDePromociones = null;
		BufferedReader bufferDelLectorDeArchivoDeUsuarios = null;
		BufferedReader bufferDelLectorDeArchivoDeAtracciones = null;
		BufferedReader bufferDelLectorDeArchivoDePromociones = null;

		try {
			archivoUsuarios = new File("usuarios.sad");
			archivoAtracciones = new File("atracciones.sad");
			archivoPromociones = new File("promociones.sad");
			lectorDeArchivoDeUsuarios = new FileReader(archivoUsuarios);
			lectorDeArchivoDeAtracciones = new FileReader(archivoAtracciones);
			lectorDeArchivoDePromociones = new FileReader(archivoPromociones);
			bufferDelLectorDeArchivoDeUsuarios = new BufferedReader(bufferDelLectorDeArchivoDeUsuarios);
			bufferDelLectorDeArchivoDeAtracciones = new BufferedReader(bufferDelLectorDeArchivoDeAtracciones);
			bufferDelLectorDeArchivoDePromociones = new BufferedReader(bufferDelLectorDeArchivoDePromociones);
		} catch (IOException excepcion) {
			
		} finally {

		}

	}

}
