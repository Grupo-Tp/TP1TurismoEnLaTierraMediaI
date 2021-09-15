package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import clases.Atraccion;
import clases.PromocionAxB;
import clases.TipoAtraccion;
import clases.Usuario;

import excepciones.ExcepcionDeAtraccion;
import excepciones.ExcepcionDeBase;
import excepciones.ExcepcionDePromocion;
import excepciones.ExcepcionDeUsuario;

public class TestUsuario {
	List<Atraccion> atracciones;
	String[] nombresDeAtracciones;
	Atraccion moria, mordor, bosqueNegro, minasTirith, laComarca, abismoDeHelm, lothlorein, erebor, esgaroth;
	PromocionAxB promo;
	Usuario eowyn, gandalf, sam, galadriel;
	Usuario nombreInvalido, tiempoInvalido, presupuestoInvalido;

	@Before
	public void setUp() throws ExcepcionDeUsuario, ExcepcionDeBase, ExcepcionDeAtraccion, ExcepcionDePromocion {
		eowyn = new Usuario("Eowyn", 8, 10, TipoAtraccion.AVENTURA);
		gandalf = new Usuario("Gandalf", 5, 100, TipoAtraccion.PAISAJE);
		sam = new Usuario("Sam", 8, 36, TipoAtraccion.DEGUSTACION);
		galadriel = new Usuario("Galadriel", 6, 120, TipoAtraccion.PAISAJE);
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
		atracciones.add(moria);
		atracciones.add(mordor);
		atracciones.add(bosqueNegro);
		nombresDeAtracciones = new String[3];
		nombresDeAtracciones[0] = moria.getNombre();
		nombresDeAtracciones[1] = mordor.getNombre();
		nombresDeAtracciones[2] = bosqueNegro.getNombre();
		promo = new PromocionAxB("Segunda", TipoAtraccion.AVENTURA, nombresDeAtracciones, atracciones,
				nombresDeAtracciones[2]);
	}

	@After
	public void tearDown() {
		moria = null;
		mordor = null;
		bosqueNegro = null;
		eowyn = null;
		gandalf = null;
		sam = null;
		galadriel = null;
		nombreInvalido = null;
		tiempoInvalido = null;
		presupuestoInvalido = null;
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

	@Test
	public void testGetTiempo() {
		assertEquals(8, eowyn.getTiempo(), 0);
		assertEquals(5, gandalf.getTiempo(), 0);
		assertEquals(8, sam.getTiempo(), 0);
		assertEquals(6, galadriel.getTiempo(), 0);
	}

	@Test(expected = ExcepcionDeUsuario.class)
	public void testDeValidacionDeTiempoNegativo() throws ExcepcionDeUsuario {
		tiempoInvalido = new Usuario("Galadriel", -6, 120, TipoAtraccion.PAISAJE);
	}

	@Test(expected = ExcepcionDeUsuario.class)
	public void testDeValidacionDeTiempoCero() throws ExcepcionDeUsuario {
		tiempoInvalido = new Usuario("Galadriel", 0, 120, TipoAtraccion.PAISAJE);
	}

	@Test
	public void testGetPresupuesto() {
		assertEquals(10, eowyn.getPresupuesto(), 0);
		assertEquals(100, gandalf.getPresupuesto(), 0);
		assertEquals(36, sam.getPresupuesto(), 0);
		assertEquals(120, galadriel.getPresupuesto(), 0);
	}

	@Test(expected = ExcepcionDeUsuario.class)
	public void testDeValidacionDePresupuestoNegativo() throws ExcepcionDeUsuario {
		presupuestoInvalido = new Usuario("Galadriel", 6, -120, TipoAtraccion.PAISAJE);
	}

	@Test(expected = ExcepcionDeUsuario.class)
	public void testDeValidacionDePresupuestoCero() throws ExcepcionDeUsuario {
		presupuestoInvalido = new Usuario("Galadriel", 6, 0, TipoAtraccion.PAISAJE);
	}

	@Test
	public void testGetPreferencia() {
		assertEquals(TipoAtraccion.AVENTURA, eowyn.getPreferencia());
		assertEquals(TipoAtraccion.PAISAJE, gandalf.getPreferencia());
		assertEquals(TipoAtraccion.DEGUSTACION, sam.getPreferencia());
		assertEquals(TipoAtraccion.PAISAJE, galadriel.getPreferencia());
	}

	@Test
	public void testDeSugerenciaAceptada() {
		assertTrue(eowyn.aceptarSugerencia(moria, true));
		assertEquals(6, eowyn.getTiempo(), 0);
		assertEquals(0, eowyn.getPresupuesto(), 0);
		assertFalse(eowyn.getItinerario().isEmpty());
		assertTrue((eowyn.getItinerario().get(0)).equals(moria));
	}

	@Test
	public void testDeSugerenciaRechazada() {
		assertFalse(eowyn.aceptarSugerencia(moria, false));
		assertEquals(8, eowyn.getTiempo(), 0);
		assertEquals(10, eowyn.getPresupuesto(), 0);
		assertTrue(eowyn.getItinerario().isEmpty());
	}

	@Test
	public void testDeMostrarItinerarioConUnaAtraccion() {
		eowyn.aceptarSugerencia(moria, true);
		String textoEsperado = "El itinerario programado para Eowyn esta compuesto por los siguientes productos :\n"
				+ "Atraccion llamada Moria\nEl itinerario programado tiene una duracion total de 2.0 horas y un "
				+ "costo total de 10.0 monedas de oro";
		assertEquals(textoEsperado, eowyn.mostrarItinerario());
	}

	@Test
	public void testDeMostrarItinerarioConDosAtracciones() {
		eowyn.aceptarSugerencia(moria, true);
		eowyn.aceptarSugerencia(mordor, true);
		String textoEsperado = "El itinerario programado para Eowyn esta compuesto por los siguientes productos :\n"
				+ "Atraccion llamada Moria\nAtraccion llamada Mordor\n"
				+ "El itinerario programado tiene una duracion total de 5.0 horas y un "
				+ "costo total de 35.0 monedas de oro";
		assertEquals(textoEsperado, eowyn.mostrarItinerario());
	}

	@Test
	public void testDeMostrarItinerarioConUnaPromocion() {
		eowyn.aceptarSugerencia(promo, true);
		String textoEsperado = "El itinerario programado para Eowyn esta compuesto por los siguientes productos :\n"
				+ "Promocion llamada Segunda compuesta por las atracciones Moria, Mordor y Bosque Negro\n"
				+ "El itinerario programado tiene una duracion total de 9.0 horas y un costo total de 35.0 monedas de oro";
		assertEquals(textoEsperado, eowyn.mostrarItinerario());
	}

	@Test
	public void testDeToString() {
		String textoEsperado = "Eowyn, con un tiempo disponible de 8.0, un presupuesto de 10.0 monedas de oro"
				+ " y una preferencia para las atracciones de tipo AVENTURA";
		assertEquals(textoEsperado, eowyn.toString());
	}
}
