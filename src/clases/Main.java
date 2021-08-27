package clases;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
	
		//usuarios
		Usuario eowyn = new Usuario("Eowyn", 8, 10, TipoAtraccion.AVENTURA);
		Usuario gandalf = new Usuario("Gandalf", 5, 100, TipoAtraccion.PAISAJE);
		Usuario sam = new Usuario("Sam", 8, 36, TipoAtraccion.DEGUSTACION);
		Usuario galadriel = new Usuario("Galadriel", 6, 120, TipoAtraccion.PAISAJE);
		
		//atracciones
		Atraccion bosqueNegro = new Atraccion(TipoAtraccion.AVENTURA, 12, 3, "Bosque Negro", 4);
		Atraccion mordor = new Atraccion(TipoAtraccion.AVENTURA, 4, 25, "Mordor", 3);
		Atraccion lothlorien = new Atraccion(TipoAtraccion.DEGUSTACION, 30, 35, "Lothlorien", 1);
		Atraccion laComarca = new Atraccion(TipoAtraccion.DEGUSTACION, 150, 3, "La Comarcar", 6.5);
		Atraccion minasTirith = new Atraccion(TipoAtraccion.PAISAJE, 25, 5, "Minas Tirith", 2.5);
		Atraccion abismoDeHelm = new Atraccion(TipoAtraccion.PAISAJE, 15, 5, "Abismo De Helm", 2);
		Atraccion erebor = new Atraccion(TipoAtraccion.PAISAJE, 32, 12, "Erebor", 3);
		
		//promociones
		List<Atraccion> atraccionesPorc = new ArrayList<Atraccion>();
		atraccionesPorc.add(bosqueNegro);
		atraccionesPorc.add(mordor);
		PromocionPorcentual porcentual = new PromocionPorcentual(atraccionesPorc, "pack aventura", 20);
		
		List<Atraccion> atraccionesAbs = new ArrayList<Atraccion>();
		atraccionesAbs.add(lothlorien);
		atraccionesAbs.add(laComarca);
		PromocionAbsoluta absoluta = new PromocionAbsoluta(atraccionesAbs, "pack degustacion", 2);
		
		List<Atraccion> atraccionesAxB = new ArrayList<Atraccion>();
		atraccionesAxB.add(erebor);
		atraccionesAxB.add(minasTirith);
		atraccionesAxB.add(abismoDeHelm);
		PromocionAxB axb = new PromocionAxB(atraccionesAxB, "pack paisajes");
		
		//uso
		// agregar promociones y atracciones al sistema
		
		//sistema.generarRecomendacionesParaUsuario(sam);
	}

}
