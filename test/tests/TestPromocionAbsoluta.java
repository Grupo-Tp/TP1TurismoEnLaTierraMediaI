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
		nombresDeAtracciones[0] = lothlorein.getNombre();
		nombresDeAtracciones[1] = laComarca.getNombre();
		absoluta = new PromocionAbsoluta("Tercera", TipoAtraccion.DEGUSTACION, nombresDeAtracciones, atracciones, 36);
	}

	@Test(expected = ExcepcionDePromocion.class)
	public void testDeTipoDeAtracciones() throws ExcepcionDeBase, ExcepcionDePromocion, ExcepcionDeAtraccion {
		nombresDeAtracciones[1] = erebor.getNombre();
		invalida = new PromocionAbsoluta("Tercera", TipoAtraccion.DEGUSTACION, nombresDeAtracciones, atracciones, 36);
	}

	@Test(expected = ExcepcionDeAtraccion.class)
	public void testDeNombresDeAtraccionesVacia() throws ExcepcionDeBase, ExcepcionDePromocion, ExcepcionDeAtraccion {
		nombresDeAtracciones = null;
		invalida = new PromocionAbsoluta("Tercera", TipoAtraccion.DEGUSTACION, nombresDeAtracciones, atracciones, 36);
	}

	@Test
	public void testDeToString() {
		String test = "Tercera, que incluye a las atracciones de Lothlórein y La Comarca que son de tipo DEGUSTACION, "
				+ "con un costo de 36.0 monedas de oro, un tiempo necesario para recorrerlas de 7.5 horas";
		assertEquals(test, absoluta.toString());
	}
}
