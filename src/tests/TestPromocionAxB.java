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
	List<Atraccion> atracciones, invalidas, conInvalidas;
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

		invalidas = null;
		invalida = null;
		conInvalidas = new ArrayList<Atraccion>();
		atracciones = new ArrayList<Atraccion>();
		atracciones.add(moria);
		atracciones.add(mordor);
		atracciones.add(bosqueNegro);
		promo = new PromocionAxB("Segunda", TipoAtraccion.AVENTURA, atracciones, bosqueNegro);
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
		assertEquals(bosqueNegro, promo.getAtraccionGratis());
	}

	@Test(expected = ExcepcionDePromocion.class)
	public void testDeAtraccionGratisNulaConExcepcionDePromocion()
			throws ExcepcionDeBase, ExcepcionDePromocion, ExcepcionDeAtraccion {
		atraccionInvalida = new PromocionAxB("Segunda", TipoAtraccion.AVENTURA, atracciones, invalida);
		assertNull(atraccionInvalida);
	}

	@Test(expected = ExcepcionDeBase.class)
	public void testDeAtraccionesNulasConExcepcionDeBase()
			throws ExcepcionDeBase, ExcepcionDePromocion, NullPointerException, ExcepcionDeAtraccion {
		atraccionInvalida = new PromocionAxB("Segunda", TipoAtraccion.AVENTURA, conInvalidas, moria);
		assertNull(atraccionInvalida);
	}

	@Test(expected = ExcepcionDeAtraccion.class)
	public void testDeAtraccionesNulasYAtraccionGratisNulaConExcepcionDeAtraccion()
			throws ExcepcionDeBase, ExcepcionDePromocion, ExcepcionDeAtraccion {
		atraccionInvalida = new PromocionAxB("Segunda", TipoAtraccion.AVENTURA, invalidas, invalida);
		assertNull(atraccionInvalida);
	}

	@Test
	public void testDeGetAtracciones() {
		assertEquals(atracciones, promo.getAtracciones());
	}

	@Test
	public void testSubirAtraccion() {
		promo.subirAtraccion();

		assertEquals(5, moria.getCupo(), 0);
		assertEquals(3, mordor.getCupo(), 0);
		assertEquals(11, bosqueNegro.getCupo(), 0);
	}

	@Test
	public void testDeToString() {
		String test = "Segunda, que incluye a las atracciones de Moria, Mordor y Bosque Negro que son de tipo AVENTURA, "
				+ "con un costo de 35.0 monedas de oro, un tiempo necesario para recorrerlas de 9.0 horas";
		assertEquals(test, promo.toString());
	}
}
