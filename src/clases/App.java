package clases;

import java.util.Iterator;
import java.util.Scanner;

import archivos.ArchivoUsuario;

public class App {

	public static void main(String[] args) {
		Scanner entradaDeTeclado = new Scanner(System.in);
		String ruta = "/home/tioliban/eclipse-workspace/TP1TurismoEnLaTierraMediaI/src/clases/usuarios.csv";
		System.out.println("Bienvenido, acontinuacion inicia la ejecucion de nuestro sistema:");
		System.out.println("Comenzamos leyendo el achivo de Usuarios, por favor escriba la ruta donde se encuentra");
		ruta = entradaDeTeclado.nextLine();
		
		entradaDeTeclado.close();
	}

}
