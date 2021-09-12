package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import clases.Atraccion;
import clases.PromocionAbsoluta;
import clases.TipoAtraccion;
import excepciones.ExcepcionDeAtraccion;
import excepciones.ExcepcionDeBase;
import excepciones.ExcepcionDePromocion;

public class TestPromocionAbsoluta {

	PromocionAbsoluta absoluta, invalida;
	List<Atraccion> atracciones = new ArrayList<>();
	Atraccion moria = null, laComarca = null, lothlorein = null;

	@Before
	public void setUp() throws ExcepcionDeBase, ExcepcionDeAtraccion, ExcepcionDePromocion {
		moria = new Atraccion("Moria", 2, 10, TipoAtraccion.AVENTURA, 6);
		laComarca = new Atraccion("La Comarca", 6.5, 3, TipoAtraccion.DEGUSTACION, 150);
		lothlorein = new Atraccion("Lothlórein", 1, 35, TipoAtraccion.DEGUSTACION, 30);
		atracciones.add(laComarca);
		atracciones.add(lothlorein);
		absoluta = new PromocionAbsoluta("Primera", TipoAtraccion.DEGUSTACION, atracciones, 36);
	}

	@Test(expected = ExcepcionDePromocion.class)
	public void testDeTipoDeAtracciones() throws ExcepcionDeBase, ExcepcionDePromocion, ExcepcionDeAtraccion {
		atracciones.add(moria);
		invalida = new PromocionAbsoluta("Primera", TipoAtraccion.DEGUSTACION, atracciones, 36);
	}

	@Test
	public void testDeToString() {
		String test = "Primera, que incluye a las atracciones de La Comarca y Lothlórein que son de tipo DEGUSTACION, "
				+ "con un costo de 36.0 monedas de oro, un tiempo necesario para recorrerlas de 7.5 horas";
		assertEquals(test, absoluta.toString());
	}
}
