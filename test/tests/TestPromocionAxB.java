package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import clases.Atraccion;
import clases.PromocionAxB;
import clases.TipoAtraccion;
import excepciones.ExcepcionDeAtraccion;
import excepciones.ExcepcionDeBase;
import excepciones.ExcepcionDePromocion;

public class TestPromocionAxB {

	PromocionAxB promo;
	String[] nombresDeAtracciones;
	List<String> nombres;
	List<Atraccion> atracciones;
	Atraccion moria, minasTirith, laComarca, mordor, abismoDeHelm, lothlorein, erebor, bosqueNegro, esgaroth;
	PromocionAxB atraccionInvalida, tiempoInvalido, costoInvalido, cupoInvalido;
	Atraccion invalida;

	@Before
	public void setUp() throws ExcepcionDeBase, ExcepcionDeAtraccion, ExcepcionDePromocion {
		moria = new Atraccion("Moria", 2, 10, TipoAtraccion.AVENTURA, 6);
		minasTirith = new Atraccion("Minas Tirith", 2.5, 5, TipoAtraccion.PAISAJE, 25);
		laComarca = new Atraccion("La Comarca", 6.5, 3, TipoAtraccion.DEGUSTACION, 150);
		mordor = new Atraccion("Mordor", 3, 25, TipoAtraccion.AVENTURA, 4);
		abismoDeHelm = new Atraccion("Abismo de Heml", 2, 5, TipoAtraccion.PAISAJE, 15);
		lothlorein = new Atraccion("Lothlórein", 1, 35, TipoAtraccion.DEGUSTACION, 30);
		erebor = new Atraccion("Erebor", 3, 12, TipoAtraccion.PAISAJE, 32);
		bosqueNegro = new Atraccion("Bosque Negro", 4, 3, TipoAtraccion.AVENTURA, 12);
		esgaroth = new Atraccion("Esgaroth", 3, 50, TipoAtraccion.DEGUSTACION, 20);
		invalida = null;
		atracciones = new ArrayList<Atraccion>();
		atracciones.add(abismoDeHelm);
		atracciones.add(bosqueNegro);
		atracciones.add(erebor);
		atracciones.add(esgaroth);
		atracciones.add(lothlorein);
		atracciones.add(laComarca);
		atracciones.add(minasTirith);
		atracciones.add(mordor);
		atracciones.add(moria);
		nombresDeAtracciones = new String[3];
		nombresDeAtracciones[0] = moria.getNombre();
		nombresDeAtracciones[1] = mordor.getNombre();
		nombresDeAtracciones[2] = bosqueNegro.getNombre();
		nombres = new ArrayList<String>();
		nombres.add(moria.getNombre());
		nombres.add(mordor.getNombre());
		nombres.add(bosqueNegro.getNombre());
		promo = new PromocionAxB("Segunda", TipoAtraccion.AVENTURA, nombresDeAtracciones, atracciones,
				bosqueNegro.getNombre());
	}

	@After
	public void tearDown() {
		moria = null;
		minasTirith = null;
		laComarca = null;
		mordor = null;
		abismoDeHelm = null;
		lothlorein = null;
		erebor = null;
		bosqueNegro = null;
		esgaroth = null;
		atraccionInvalida = null;
		tiempoInvalido = null;
		costoInvalido = null;
		cupoInvalido = null;
		atracciones = null;
		promo = null;
	}

	@Test
	public void testDeGetAtraccionGratis() {
		assertEquals(bosqueNegro.getNombre(), promo.getAtraccionGratis());
	}

	@Test(expected = ExcepcionDePromocion.class)
	public void testDeAtraccionGratisNulaConExcepcionDePromocion()
			throws ExcepcionDeBase, ExcepcionDePromocion, ExcepcionDeAtraccion {
		atraccionInvalida = new PromocionAxB("Segunda", TipoAtraccion.AVENTURA, nombresDeAtracciones, atracciones,
				"invalida");
	}

	@Test(expected = ExcepcionDeAtraccion.class)
	public void testDeAtraccionesNulasYAtraccionGratisNulaConExcepcionDeAtraccion()
			throws ExcepcionDeBase, ExcepcionDePromocion, ExcepcionDeAtraccion {
		atraccionInvalida = new PromocionAxB("Segunda", TipoAtraccion.AVENTURA, nombresDeAtracciones, null, null);
	}

	@Test
	public void testDeGetAtracciones() {
		assertEquals(nombres, promo.getNombresDeAtracciones());
	}

	@Test
	public void testDeToString() {
		String test = "Segunda, que incluye a las atracciones de Moria, Mordor y Bosque Negro que son de tipo AVENTURA, "
				+ "con un costo de 35.0 monedas de oro, un tiempo necesario para recorrerlas de 9.0 horas";
		assertEquals(test, promo.toString());
	}
}
