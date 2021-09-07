package clases;

import java.io.*;
import java.util.*;

public class SistemaDeItinerario {

	public static void lectorDeArchivos() {
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<Atraccion> listaAtracciones = new ArrayList<Atraccion>();
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		ArrayList<Promocion> listaPromociones = new ArrayList<Promocion>();

		try {
			fr = new FileReader("atracciones.csv");
			br = new BufferedReader(fr);
			String lineaActual;
			while ((lineaActual = br.readLine()) != null) {
				//Faltan las excepciones 
				String[] parametros = lineaActual.split("[,]");
				String nombre = parametros[0];
				Double tiempo = Double.parseDouble(parametros[1]);
				Double costo = Double.parseDouble(parametros[2]);
				
				TipoAtraccion tipo;
				for(TipoAtraccion it : TipoAtraccion.values()) {
					if(it.toString().equalsIgnoreCase(parametros[3])) {
					tipo = it;
					}
				}
				
				int cupo = Integer.parseInt(parametros[4]);
				listaAtracciones.add(new Atraccion(nombre, tiempo, costo, tipo, cupo));
			}
			
			// Recorro ek archivo de usuarios,
			fr = new FileReader("usuarios.csv");
			while ((lineaActual = br.readLine()) != null) {
				// Faltan las excepciones 
				String[] parametros = lineaActual.split("[,]");
				String nombre = parametros[0];
				Double tiempo = Double.parseDouble(parametros[1]);
				Double presupuesto = Double.parseDouble(parametros[2]);
				
				TipoAtraccion tipo =  null;
				for(TipoAtraccion it : TipoAtraccion.values()) {
					if(it.toString().equalsIgnoreCase(parametros[3])) {
					tipo = it;
					}
				}
				
				int cupo = Integer.parseInt(parametros[4]);
				listaAtracciones.add(new Atraccion(nombre, tiempo, presupuesto, tipo, cupo));
			}
				

			fr = new FileReader("promociones.csv");
			while ((lineaActual = br.readLine()) != null) {
				//Faltan las excepciones 
				String[] parametros = lineaActual.split("[,]");
				String nombre = parametros[0];
				Double tiempo = Double.parseDouble(parametros[1]);
				Double costo = Double.parseDouble(parametros[2]);
				
				TipoAtraccion tipo =  null;
				for(TipoAtraccion it : TipoAtraccion.values()) {
					if(it.toString().equalsIgnoreCase(parametros[3])) {
					tipo = it;
					}
				}
				
				ArrayList<Atraccion> atracciones = new ArrayList<>();
				for(int i = 4; i < parametros.length; i ++) {
					for(Atraccion itA: listaAtracciones) {
						if(itA.getNombre().equalsIgnoreCase(parametros[i])){
							atracciones.add(itA);
						}
					}
				}
				
				listaPromociones.add(new Promocion(nombre, tiempo, costo, tipo, atracciones));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}