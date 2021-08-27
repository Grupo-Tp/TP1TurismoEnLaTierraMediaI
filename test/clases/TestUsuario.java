package clases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestUsuario {
	
	Usuario usuario;
	
	@Before
	public void setUp() {
		usuario = new Usuario("Pepe", 2, 100, TipoAtraccion.AVENTURA);
	}
	
	@Test
	public void testGetNombre() {
		assertEquals("Pepe", usuario.getNombre());
	}

}
