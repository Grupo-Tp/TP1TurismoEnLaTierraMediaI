package clases;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestPromocionPorcentual {
	
	PromocionPorcentual porcentual;
	List<Atraccion> atracciones;
	Atraccion bosqueNegro;
	Atraccion mordor;
	
	@Before
	public void setUp() {
		bosqueNegro = new Atraccion(TipoAtraccion.AVENTURA, 12, 3, "Bosque Negro", 4);
		mordor = new Atraccion(TipoAtraccion.AVENTURA, 4, 25, "Mordor", 3);
		
		atracciones = new ArrayList<Atraccion>();
		atracciones.add(bosqueNegro);
		atracciones.add(mordor);
		porcentual = new PromocionPorcentual(atracciones, "pack aventura", 20);
	}

	@Test
	public void testPromocionPorcentual() {
		assertEquals(2, porcentual.getAtracciones().size());
		assertEquals("pack aventura", porcentual.getNombre());
	}
	
	@Test
	public void testCalcularCostoDePromocion() {
		assertEquals(22.4, porcentual.calcularCostoDePromocion(), 0.0);
	}

}
