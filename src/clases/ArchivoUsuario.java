package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ArchivoUsuario {
	private FileReader lectorDeArchivoDeUsuarios = null;
	private BufferedReader bufferDelLectorDeArchivoDeUsuarios = null;
	private String lineaUsuario = "";
	private List<Usuario> usuarios = new ArrayList<Usuario>();

	public ArchivoUsuario() {

	}

	public List<Usuario> leerArchivoUsuario(){
		try {
			lectorDeArchivoDeUsuarios = new FileReader("usuarios.sad");
			bufferDelLectorDeArchivoDeUsuarios = new BufferedReader(bufferDelLectorDeArchivoDeUsuarios);
			while ((lineaUsuario = bufferDelLectorDeArchivoDeUsuarios.readLine()) != null) {
				String[] parametros = lineaUsuario.split(".");
				double presupuesto = 0, tiempo = 0;
				String preferenciaDelArchivo = "";
				TipoAtraccion[] todasLasPreferencias = TipoAtraccion.values();
				TipoAtraccion preferencia = null;
				try {
					try {
					if(parametros[0]=="") {
						throw new RuntimeException();
					}}catch(RuntimeException excepcionDeNombre) {
						System.err.println("");}
					try {
						System.out.println("");
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
	}
}
