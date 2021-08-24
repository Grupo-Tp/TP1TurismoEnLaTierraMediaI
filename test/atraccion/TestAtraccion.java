package atraccion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import turismo.Atraccion;

class TestAtraccion {
	
	Atraccion atraccion;
	
	@BeforeEach
	public void setUp() {
		atraccion = new Atraccion("Moria", 10, 2, 6, "Aventura");
	}

	@Test
	public void testGetCosto() {
		assertEquals(10, atraccion.getCosto());
	}
	
	@AfterEach
	public void teardown() {
		atraccion = null;
	}

}
