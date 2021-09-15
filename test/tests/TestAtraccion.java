package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import clases.Atraccion;
import clases.TipoAtraccion;
import excepciones.ExcepcionDeAtraccion;
import excepciones.ExcepcionDeBase;

public class TestAtraccion {
	ArrayList<Atraccion>atracciones;
	Atraccion moria, minasTirith, laComarca, mordor, abismoDeHelm, lothlorein, erebor, bosqueNegro, esgaroth;
	Atraccion nombreInvalido, tiempoInvalido, costoInvalido, cupoInvalido;

	@Before
	public void setUp() throws ExcepcionDeBase, ExcepcionDeAtraccion {
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
	}

	@After
	public void tearDown() {
		moria = null;
		minasTirith = null;
		laComarca = null;
		mordor = null;
		abismoDeHelm = null;
		lothlorein = null;
		erebor = null;
		bosqueNegro = null;
		esgaroth = null;
		nombreInvalido = null;
		tiempoInvalido = null;
		costoInvalido = null;
		cupoInvalido = null;
	}

	@Test
	public void testGetNombre() {
		assertEquals("Moria", moria.getNombre());
		assertEquals("Minas Tirith", minasTirith.getNombre());
		assertEquals("La Comarca", laComarca.getNombre());
		assertEquals("Mordor", mordor.getNombre());
		assertEquals("Abismo de Heml", abismoDeHelm.getNombre());
		assertEquals("Lothlórein", lothlorein.getNombre());
		assertEquals("Erebor", erebor.getNombre());
		assertEquals("Bosque Negro", bosqueNegro.getNombre());
		assertEquals("Esgaroth", esgaroth.getNombre());
	}

	@Test(expected = ExcepcionDeBase.class)
	public void testDeValidacionDeNombre() throws ExcepcionDeBase, ExcepcionDeAtraccion {
		nombreInvalido = new Atraccion("", 6, 120, TipoAtraccion.PAISAJE, 6);
	}

	@Test
	public void testGetTiempo() {
		assertEquals(2, moria.getTiempo(), 0);
		assertEquals(2.5, minasTirith.getTiempo(), 0);
		assertEquals(6.5, laComarca.getTiempo(), 0);
		assertEquals(3, mordor.getTiempo(), 0);
		assertEquals(2, abismoDeHelm.getTiempo(), 0);
		assertEquals(1, lothlorein.getTiempo(), 0);
		assertEquals(3, erebor.getTiempo(), 0);
		assertEquals(4, bosqueNegro.getTiempo(), 0);
		assertEquals(3, esgaroth.getTiempo(), 0);
	}

	@Test(expected = ExcepcionDeBase.class)
	public void testDeValidacionDeTiempoNegativo() throws ExcepcionDeBase, ExcepcionDeAtraccion {
		tiempoInvalido = new Atraccion("Invalido", -6, 120, TipoAtraccion.PAISAJE, 6);

	}

	@Test(expected = ExcepcionDeBase.class)
	public void testDeValidacionDeTiempoCero() throws ExcepcionDeBase, ExcepcionDeAtraccion {
		tiempoInvalido = new Atraccion("Invalido", 0, 120, TipoAtraccion.PAISAJE, 6);
	}

	@Test
	public void testGetCosto() {
		assertEquals(10, moria.getCosto(), 0);
		assertEquals(5, minasTirith.getCosto(), 0);
		assertEquals(3, laComarca.getCosto(), 0);
		assertEquals(25, mordor.getCosto(), 0);
		assertEquals(5, abismoDeHelm.getCosto(), 0);
		assertEquals(35, lothlorein.getCosto(), 0);
		assertEquals(12, erebor.getCosto(), 0);
		assertEquals(3, bosqueNegro.getCosto(), 0);
		assertEquals(50, esgaroth.getCosto(), 0);
	}

	@Test(expected = ExcepcionDeBase.class)
	public void testDeValidacionDeCostoNegativo() throws ExcepcionDeBase, ExcepcionDeAtraccion {
		costoInvalido = new Atraccion("Invalido", 6, -120, TipoAtraccion.PAISAJE, 6);
	}

	@Test(expected = ExcepcionDeBase.class)
	public void testDeValidacionDeCostoCero() throws ExcepcionDeBase, ExcepcionDeAtraccion {
		costoInvalido = new Atraccion("Invalido", 6, 0, TipoAtraccion.PAISAJE, 6);
	}

	@Test
	public void testGetPreferencia() {
		assertEquals(TipoAtraccion.AVENTURA, moria.getTipo());
		assertEquals(TipoAtraccion.PAISAJE, minasTirith.getTipo());
		assertEquals(TipoAtraccion.DEGUSTACION, laComarca.getTipo());
		assertEquals(TipoAtraccion.AVENTURA, mordor.getTipo());
		assertEquals(TipoAtraccion.PAISAJE, abismoDeHelm.getTipo());
		assertEquals(TipoAtraccion.DEGUSTACION, lothlorein.getTipo());
		assertEquals(TipoAtraccion.PAISAJE, erebor.getTipo());
		assertEquals(TipoAtraccion.AVENTURA, bosqueNegro.getTipo());
		assertEquals(TipoAtraccion.DEGUSTACION, esgaroth.getTipo());
	}

	@Test
	public void testGetCupo() {
		assertEquals(6, moria.getCupo(), 0);
		assertEquals(25, minasTirith.getCupo(), 0);
		assertEquals(150, laComarca.getCupo(), 0);
		assertEquals(4, mordor.getCupo(), 0);
		assertEquals(15, abismoDeHelm.getCupo(), 0);
		assertEquals(30, lothlorein.getCupo(), 0);
		assertEquals(32, erebor.getCupo(), 0);
		assertEquals(12, bosqueNegro.getCupo(), 0);
		assertEquals(20, esgaroth.getCupo(), 0);
	}

	@Test(expected = ExcepcionDeAtraccion.class)
	public void testDeValidacionDeCupoNegativo() throws ExcepcionDeBase, ExcepcionDeAtraccion {
		cupoInvalido = new Atraccion("Invalido", 6, 120, TipoAtraccion.PAISAJE, -6);
	}

	@Test(expected = ExcepcionDeAtraccion.class)
	public void testDeValidacionDeCupoCero() throws ExcepcionDeBase, ExcepcionDeAtraccion {
		cupoInvalido = new Atraccion("Invalido", 6, 120, TipoAtraccion.PAISAJE, 0);
	}

	@Test
	public void testDeSubirAtraccion() {
		moria.subirAtraccion();
		minasTirith.subirAtraccion();
		laComarca.subirAtraccion();
		mordor.subirAtraccion();
		abismoDeHelm.subirAtraccion();
		lothlorein.subirAtraccion();
		erebor.subirAtraccion();
		bosqueNegro.subirAtraccion();
		esgaroth.subirAtraccion();

		assertEquals(5, moria.getCupo(), 0);
		assertEquals(24, minasTirith.getCupo(), 0);
		assertEquals(149, laComarca.getCupo(), 0);
		assertEquals(3, mordor.getCupo(), 0);
		assertEquals(14, abismoDeHelm.getCupo(), 0);
		assertEquals(29, lothlorein.getCupo(), 0);
		assertEquals(31, erebor.getCupo(), 0);
		assertEquals(11, bosqueNegro.getCupo(), 0);
		assertEquals(19, esgaroth.getCupo(), 0);
	}

	@Test
	public void testDeBuscarAtraccionPorNombre() {
		assertEquals(moria,Atraccion.buscarAtraccionPorNombre(moria.getNombre(), atracciones));
		assertEquals(minasTirith,Atraccion.buscarAtraccionPorNombre(minasTirith.getNombre(), atracciones));
		assertEquals(laComarca,Atraccion.buscarAtraccionPorNombre(laComarca.getNombre(), atracciones));
		assertEquals(mordor,Atraccion.buscarAtraccionPorNombre(mordor.getNombre(), atracciones));
		assertEquals(abismoDeHelm,Atraccion.buscarAtraccionPorNombre(abismoDeHelm.getNombre(), atracciones));
		assertEquals(lothlorein,Atraccion.buscarAtraccionPorNombre(lothlorein.getNombre(), atracciones));
		assertEquals(erebor,Atraccion.buscarAtraccionPorNombre(erebor.getNombre(), atracciones));
		assertEquals(bosqueNegro,Atraccion.buscarAtraccionPorNombre(bosqueNegro.getNombre(), atracciones));
		assertEquals(esgaroth,Atraccion.buscarAtraccionPorNombre(esgaroth.getNombre(), atracciones));
	}

	@Test
	public void testDeToString() {
		String textoEsperado = "Moria, con un costo de 10.0 monedas de oro,"
				+ " un tiempo necesario para recorrerlo de 2.0 horas, un cupo de 6 usuarios "
				+ "y su tipo de atraccion es AVENTURA";
		assertEquals(textoEsperado, moria.toString());
	}
}
