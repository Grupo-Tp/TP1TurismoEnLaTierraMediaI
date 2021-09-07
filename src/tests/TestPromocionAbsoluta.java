package clases;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestPromocionAbsoluta {
	
	PromocionAbsoluta absoluta;
	List<Atraccion> atracciones;
	Atraccion lothlorien;
	Atraccion laComarca;
	
	@Before
	public void setUp() {
		lothlorien = new Atraccion(TipoAtraccion.DEGUSTACION, 30, 35, "Lothlorien", 1);
		laComarca = new Atraccion(TipoAtraccion.DEGUSTACION, 150, 3, "La Comarcar", 6.5);
		
		atracciones = new ArrayList<Atraccion>();
		atracciones.add(lothlorien);
		atracciones.add(laComarca);
		absoluta = new PromocionAbsoluta(atracciones, "pack degustacion", 2);
	}

	@Test
	public void testPromocionAbsoluta() {
		assertEquals(2, absoluta.getAtracciones().size());
		assertEquals("pack degustacion", absoluta.getNombre());
	}
	
	@Test
	public void testCalcularCostoDePromocion() {
		assertEquals(36, absoluta.calcularCostoDePromocion(), 0.0);
	}
	
	@Test
	public void testCalcularTiempoDePromocion() {
		assertEquals(7.5, absoluta.calcularSumaDeTiempoDeAtracciones(), 0.0);
	}

}
