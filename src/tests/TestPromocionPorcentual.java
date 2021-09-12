package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import clases.Atraccion;
import clases.PromocionPorcentual;
import clases.TipoAtraccion;
import excepciones.ExcepcionDeAtraccion;
import excepciones.ExcepcionDeBase;
import excepciones.ExcepcionDePromocion;

public class TestPromocionPorcentual {

	PromocionPorcentual promo, invalida;
	List<Atraccion> atracciones;
	Atraccion moria, mordor;

	@Before
	public void setUp() throws ExcepcionDeBase, ExcepcionDeAtraccion, ExcepcionDePromocion {
		moria = new Atraccion("Moria", 2, 10, TipoAtraccion.AVENTURA, 6);
		mordor = new Atraccion("Mordor", 3, 25, TipoAtraccion.AVENTURA, 4);

		invalida = null;
		atracciones = new ArrayList<Atraccion>();
		atracciones.add(moria);
		atracciones.add(mordor);
		promo = new PromocionPorcentual("Segunda", TipoAtraccion.AVENTURA, atracciones, 35);
	}

	@Test
	public void testDeGetPorcentajeDeDescuento() {
		assertEquals(35, promo.getPorcentajeDescuento(), 0);
	}

	@Test(expected = ExcepcionDePromocion.class)
	public void testDePorcentajeInvalidoCero() throws ExcepcionDeBase, ExcepcionDePromocion, ExcepcionDeAtraccion {
		invalida = new PromocionPorcentual("Segunda", TipoAtraccion.AVENTURA, atracciones, 0);
	}

	@Test(expected = ExcepcionDePromocion.class)
	public void testDePorcentajeInvalidoNegativo() throws ExcepcionDeBase, ExcepcionDePromocion, ExcepcionDeAtraccion {
		invalida = new PromocionPorcentual("Segunda", TipoAtraccion.AVENTURA, atracciones, -10);
	}

	@Test(expected = ExcepcionDePromocion.class)
	public void testDePorcentajeInvalidoMayorACien()
			throws ExcepcionDeBase, ExcepcionDePromocion, ExcepcionDeAtraccion {
		invalida = new PromocionPorcentual("Segunda", TipoAtraccion.AVENTURA, atracciones, 110);
	}

	@Test(expected = ExcepcionDePromocion.class)
	public void testDePorcentajeInvaCien() throws ExcepcionDeBase, ExcepcionDePromocion, ExcepcionDeAtraccion {
		invalida = new PromocionPorcentual("Segunda", TipoAtraccion.AVENTURA, atracciones, 100);
	}

	@Test
	public void testDeToString() {
		String test = "Segunda, que incluye a las atracciones de Moria y Mordor que son de tipo AVENTURA, "
				+ "con un costo de 22.75 monedas de oro, un tiempo necesario para recorrerlas de 5.0 horas";
		assertEquals(test, promo.toString());
	}
}
