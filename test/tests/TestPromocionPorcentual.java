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
	String[] nombresDeAtracciones;
	List<Atraccion> atracciones = new ArrayList<>();
	Atraccion moria, minasTirith, laComarca, mordor, abismoDeHelm, lothlorein, erebor, bosqueNegro, esgaroth;

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
		nombresDeAtracciones = new String[2];
		nombresDeAtracciones[0] = moria.getNombre();
		nombresDeAtracciones[1] = mordor.getNombre();
		promo = new PromocionPorcentual("Segunda", TipoAtraccion.AVENTURA, nombresDeAtracciones, atracciones, 35);
	}


	@Test
	public void testDeGetPorcentajeDeDescuento() {
		assertEquals(35, promo.getPorcentajeDescuento(), 0);
	}

	@Test(expected = ExcepcionDePromocion.class)
	public void testDePorcentajeInvalidoCero() throws ExcepcionDeBase, ExcepcionDePromocion, ExcepcionDeAtraccion {
		invalida = new PromocionPorcentual("Segunda", TipoAtraccion.AVENTURA, nombresDeAtracciones, atracciones, 0);
	}

	@Test(expected = ExcepcionDePromocion.class)
	public void testDePorcentajeInvalidoNegativo() throws ExcepcionDeBase, ExcepcionDePromocion, ExcepcionDeAtraccion {
		invalida = new PromocionPorcentual("Segunda", TipoAtraccion.AVENTURA, nombresDeAtracciones, atracciones, -10);
	}

	@Test(expected = ExcepcionDePromocion.class)
	public void testDePorcentajeInvalidoMayorACien()
			throws ExcepcionDeBase, ExcepcionDePromocion, ExcepcionDeAtraccion {
		invalida = new PromocionPorcentual("Segunda", TipoAtraccion.AVENTURA, nombresDeAtracciones, atracciones, 110);
	}

	@Test(expected = ExcepcionDePromocion.class)
	public void testDePorcentajeInvaCien() throws ExcepcionDeBase, ExcepcionDePromocion, ExcepcionDeAtraccion {
		invalida = new PromocionPorcentual("Segunda", TipoAtraccion.AVENTURA, nombresDeAtracciones, atracciones, 100);
	}

	@Test
	public void testDeToString() {
		String test = "Segunda, que incluye a las atracciones de Moria y Mordor que son de tipo AVENTURA, "
				+ "con un costo de 22.75 monedas de oro, un tiempo necesario para recorrerlas de 5.0 horas";
		assertEquals(test, promo.toString());
	}
}
