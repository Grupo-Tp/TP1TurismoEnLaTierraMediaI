package clases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestUsuario {
	
	Usuario eowyn;
	Usuario gandalf;
	Usuario sam;
	Usuario galadriel;
	
	@Before
	public void setUp() {
		eowyn = new Usuario("Eowyn", 8, 10, TipoAtraccion.AVENTURA);
		gandalf = new Usuario("Gandalf", 5, 100, TipoAtraccion.PAISAJE);
		sam = new Usuario("Sam", 8, 36, TipoAtraccion.DEGUSTACION);
		galadriel = new Usuario("Galadriel", 6, 120, TipoAtraccion.PAISAJE);
	}
	
	@Test
	public void testGetNombre() {
		assertEquals("Eowyn", eowyn.getNombre());
		assertEquals("Gandalf", gandalf.getNombre());
		assertEquals("Sam", sam.getNombre());
		assertEquals("Galadriel", galadriel.getNombre());
	}

}
