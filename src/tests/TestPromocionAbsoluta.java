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

	PromocionAbsoluta absoluta;
	List<Atraccion> atracciones = new ArrayList<>();
	Atraccion moria = null, minasTirith = null, laComarca = null, mordor = null, abismoDeHelm = null;
	Atraccion lothlorein = null, erebor = null, bosqueNegro = null, esgaroth = null;

	@Before
	public void setUp() throws ExcepcionDeBase, ExcepcionDeAtraccion, ExcepcionDePromocion {
		moria = new Atraccion("Moria", 10, 2, TipoAtraccion.AVENTURA, 6);
		minasTirith = new Atraccion("Minas Tirith", 5, 2.5, TipoAtraccion.PAISAJE, 25);
		laComarca = new Atraccion("La Comarca", 3, 6.5, TipoAtraccion.DEGUSTACION, 150);
		mordor = new Atraccion("Mordor", 25, 3, TipoAtraccion.AVENTURA, 4);
		abismoDeHelm = new Atraccion("Abismo de Helm", 5, 2, TipoAtraccion.PAISAJE, 15);
		lothlorein = new Atraccion("Lothlórein", 35, 1, TipoAtraccion.DEGUSTACION, 30);
		erebor = new Atraccion("Erebor", 12, 3, TipoAtraccion.PAISAJE, 32);
		bosqueNegro = new Atraccion("Bosque Negro", 3, 4, TipoAtraccion.AVENTURA, 12);
		esgaroth = new Atraccion("Esgaroth", 20, 3, TipoAtraccion.DEGUSTACION, 50);
		atracciones.add(moria);
		atracciones.add(minasTirith);
		atracciones.add(laComarca);
		atracciones.add(abismoDeHelm);
		atracciones.add(lothlorein);
		absoluta = new PromocionAbsoluta("Primera", TipoAtraccion.AVENTURA, atracciones, 35);
	}

	@Test
	public void testPromocionAbsoluta() {
		//assertEquals(2, absoluta.getAtracciones().size());
		assertEquals("pack degustacion", absoluta.getNombre());
	}

	@Test
	public void testCalcularCostoDePromocion() {
		//assertEquals(36, absoluta.calcularCostoDePromocion(), 0.0);
	}

	@Test
	public void testCalcularTiempoDePromocion() {
		//assertEquals(7.5, absoluta.calcularSumaDeTiempoDeAtracciones(), 0.0);
	}

}
