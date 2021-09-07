package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import clases.TipoAtraccion;
import clases.Usuario;
import excepciones.ExcepcionDeUsuario;

public class TestUsuario {

	Usuario eowyn = null, gandalf = null, sam = null, galadriel = null;
	Usuario nombreInvalido = null, tiempoInvalido = null, presupuestoInvalido = null;

	@Before
	public void setUp() throws ExcepcionDeUsuario {
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

	@Test(expected = ExcepcionDeUsuario.class)
	public void testDeValidacionDeNombre() throws ExcepcionDeUsuario {
		nombreInvalido = new Usuario("", 6, 120, TipoAtraccion.PAISAJE);
	}

	@Test(expected = ExcepcionDeUsuario.class)
	public void testDeValidacionDeTiempoNegativo() throws ExcepcionDeUsuario {
		tiempoInvalido = new Usuario("Galadriel", -6, 120, TipoAtraccion.PAISAJE);
	}

	@Test(expected = ExcepcionDeUsuario.class)
	public void testDeValidacionDeTiempoCero() throws ExcepcionDeUsuario {
		tiempoInvalido = new Usuario("Galadriel", 0, 120, TipoAtraccion.PAISAJE);
	}
	@Test(expected = ExcepcionDeUsuario.class)
	public void testDeValidacionDePresupuestoNegativo() throws ExcepcionDeUsuario {
		presupuestoInvalido = new Usuario("Galadriel", 6, -120, TipoAtraccion.PAISAJE);
	}

	@Test(expected = ExcepcionDeUsuario.class)
	public void testDeValidacionDePresupuestoCero() throws ExcepcionDeUsuario {
		presupuestoInvalido = new Usuario("Galadriel", 6, 0, TipoAtraccion.PAISAJE);
	}
}
