package clases;

import java.util.Scanner;

import archivos.ArchivoAtraccion;
import archivos.ArchivoPromocion;
import archivos.ArchivoUsuario;

public class App {

	public static void main(String[] args) {
		Scanner entradaDeTeclado = new Scanner(System.in);
		String archivoUsuario = "usuarios.csv", archivoAtracciones = "atracciones.csv",
				archivoPromociones = "promociones.csv";
		ArchivoUsuario losUsuarios = new ArchivoUsuario(archivoUsuario);
		ArchivoAtraccion lasAtracciones = new ArchivoAtraccion(archivoAtracciones);
		ArchivoPromocion lasPromociones = new ArchivoPromocion(archivoPromociones,lasAtracciones.getAtracciones());
		System.out.println("Bienvenido, acontinuacion inicia la ejecucion de nuestro sistema:");
		System.out.println("Comenzamos leyendo el achivo de Usuarios, los usuarios leidos son:");
		System.out.println();
		for (Usuario indice : losUsuarios.getUsuarios()) {
			System.out.println(indice);
		}
		System.out.println();
		System.out.println("Continuamos leyendo el achivo de Atracciones, las atracciones leidas son:");
		System.out.println();
		for (Atraccion indice : lasAtracciones.getAtracciones()) {
			System.out.println(indice);
		}
		System.out.println();
		System.out.println("Terminamos leyendo el achivo de Promociones, las promociones leidas son:");
		System.out.println();
		for (Promocion indice : lasPromociones.getPromociones()) {
			System.out.println(indice.toString());
		}
		//textoDeEntrada = entradaDeTeclado.nextLine();

		entradaDeTeclado.close();
	}

}
