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
		Atraccion bosqueNegro = new Atraccion("Bosque Negro", 4.0, 3.0, TipoAtraccion.AVENTURA, 12);
		Atraccion mordor = new Atraccion("Mordor", 3.0, 25.0, TipoAtraccion.AVENTURA, 4);
		Atraccion lothlorien = new Atraccion("Lothlorien", 1.0, 35.0, TipoAtraccion.DEGUSTACION, 30);
		Atraccion laComarca = new Atraccion("La comarca", 6.5, 3.0, TipoAtraccion.DEGUSTACION, 150);
		Atraccion minasTirith = new Atraccion("Minas Tirith", 2.5, 5.0, TipoAtraccion.PAISAJE, 25);
		Atraccion abismoDeHelm = new Atraccion("Abismo De Helm", 2.0, 5.0, TipoAtraccion.PAISAJE, 15);
		Atraccion erebor = new Atraccion("Erebor", 3.0, 12.0, TipoAtraccion.PAISAJE, 32);
		Atraccion moria = new Atraccion("Moria", 2.0, 10.0, TipoAtraccion.AVENTURA, 6);
		
		//promociones
		List<Atraccion> atraccionesPorc = new ArrayList<Atraccion>();
		atraccionesPorc.add(bosqueNegro);
		atraccionesPorc.add(mordor);
		atraccionesPorc.add(moria);
		PromocionPorcentual porcentual = new PromocionPorcentual( "pack aventura", TipoAtraccion.AVENTURA, atraccionesPorc, 20.0);
		
		List<Atraccion> atraccionesAbs = new ArrayList<Atraccion>();
		atraccionesAbs.add(lothlorien);
		atraccionesAbs.add(laComarca);
		PromocionAbsoluta absoluta = new PromocionAbsoluta( "pack degustacion", TipoAtraccion.DEGUSTACION, atraccionesAbs, 2.0);
		
		List<Atraccion> atraccionesAxB = new ArrayList<Atraccion>();
		atraccionesAxB.add(erebor);
		atraccionesAxB.add(minasTirith);
		atraccionesAxB.add(abismoDeHelm);
		PromocionAxB axb = new PromocionAxB( "pack paisajes", TipoAtraccion.PAISAJE, atraccionesAxB);
		
		//uso
		// agregar promociones y atracciones al sistema
		
		//sistema.generarRecomendacionesParaUsuario(sam);
	}

}
