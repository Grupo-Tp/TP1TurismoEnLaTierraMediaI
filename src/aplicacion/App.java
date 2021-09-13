package aplicacion;

import archivos.ArchivoAtraccion;
import archivos.ArchivoPromocion;
import archivos.ArchivoUsuario;
import clases.Atraccion;
import clases.Promocion;
import clases.SugerirProducto;
import clases.Usuario;

public class App {
	public static void main(String[] args) {
		String archivoUsuario = "/home/tioliban/usuarios.csv", archivoAtracciones = "/home/tioliban/atracciones.csv",
				archivoPromociones = "/home/tioliban/promociones.csv";
		ArchivoUsuario losUsuarios = new ArchivoUsuario(archivoUsuario);
		ArchivoAtraccion lasAtracciones = new ArchivoAtraccion(archivoAtracciones);
		ArchivoPromocion lasPromociones = new ArchivoPromocion(archivoPromociones, lasAtracciones.getAtracciones());
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
		SugerirProducto laOfertaDeProductos = new SugerirProducto(losUsuarios.getUsuarios(),
				lasPromociones.getPromociones(), lasAtracciones.getAtracciones());
		System.out.println();
		System.out.println("Comenzamos a sugerir productos a los usuarios");
		System.out.println();
		laOfertaDeProductos.sugerirPromocion();
		System.out.println();
		System.out.println("Comenzamos a generar los archivos con la información por cada usuario");
		System.out.println();
		losUsuarios.generarArchivoUsuario();
		System.out.println();
		System.out.println("La creación de archivos ha finalizado con éxito y el programa termina su ejecución");
		System.out.println();
	}

}
