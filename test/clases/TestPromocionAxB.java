package clases;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestPromocionAxB {
	
	PromocionAxB axb;
	List<Atraccion> atracciones;
	Atraccion minasTirith;
	Atraccion abismoDeHelm;
	Atraccion erebor;
	
	@Before
	public void setUp() {
		minasTirith = new Atraccion(TipoAtraccion.PAISAJE, 25, 5, "Minas Tirith", 2.5);
		abismoDeHelm = new Atraccion(TipoAtraccion.PAISAJE, 15, 5, "Abismo De Helm", 2);
		erebor = new Atraccion(TipoAtraccion.PAISAJE, 32, 12, "Erebor", 3);
		
		atracciones = new ArrayList<Atraccion>();
		atracciones.add(erebor);
		atracciones.add(minasTirith);
		atracciones.add(abismoDeHelm);
		axb = new PromocionAxB(atracciones, "pack paisajes");
	}

	@Test
	public void testPromocionAxB() {
		assertEquals(3, axb.getAtracciones().size());
		assertEquals("pack paisajes", axb.getNombre());
	}
	
	@Test
	public void testCalcularCostoDePromocion() {
		assertEquals(10, axb.calcularCostoDePromocion(), 0.0);
	}
	
	@Test
	public void testCalcularTiempoDePromocion() {
		assertEquals(7.5, axb.calcularSumaDeTiempoDeAtracciones(), 0.0);
	}

}
