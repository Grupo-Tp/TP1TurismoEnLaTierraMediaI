package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import clases.Atraccion;
import clases.Promocion;
import clases.PromocionAbsoluta;
import clases.PromocionAxB;
import clases.PromocionPorcentual;
import clases.SugerirProducto;
import clases.TipoAtraccion;
import clases.Usuario;

public class TestSugerirProducto {

	Usuario eowyn, gandalf, sam, galadriel;
	List<Usuario> usuarios;
	Atraccion moria, minasTirith, laComarca, mordor, abismoDeHelm, lothlorein, erebor, bosqueNegro, esgaroth;
	List<Atraccion> atracciones, atraccionesPrimera, atraccionesSegunda, atraccionesTercera, atraccionesCuarta,
			atraccionesQuinta;
	PromocionPorcentual primera, cuarta;
	PromocionAbsoluta tercera;
	PromocionAxB segunda, quinta;
	List<Promocion> promociones;
	SugerirProducto sistema;

	@Before
	public void setUp() throws Exception {
		usuarios = new ArrayList<Usuario>();
		eowyn = new Usuario("Eowyn", 8, 10, TipoAtraccion.AVENTURA);
		gandalf = new Usuario("Gandalf", 5, 100, TipoAtraccion.PAISAJE);
		sam = new Usuario("Sam", 8, 36, TipoAtraccion.DEGUSTACION);
		galadriel = new Usuario("Galadriel", 6, 120, TipoAtraccion.PAISAJE);
		usuarios.add(eowyn);
		usuarios.add(gandalf);
		usuarios.add(sam);
		usuarios.add(galadriel);
		atracciones = new ArrayList<Atraccion>();
		moria = new Atraccion("Moria", 2, 10, TipoAtraccion.AVENTURA, 6);
		minasTirith = new Atraccion("Minas Tirith", 2.5, 5, TipoAtraccion.PAISAJE, 25);
		laComarca = new Atraccion("La Comarca", 6.5, 3, TipoAtraccion.DEGUSTACION, 150);
		mordor = new Atraccion("Mordor", 3, 25, TipoAtraccion.AVENTURA, 4);
		abismoDeHelm = new Atraccion("Abismo de Heml", 2, 5, TipoAtraccion.PAISAJE, 15);
		lothlorein = new Atraccion("Lothlórein", 1, 35, TipoAtraccion.DEGUSTACION, 30);
		erebor = new Atraccion("Erebor", 3, 12, TipoAtraccion.PAISAJE, 32);
		bosqueNegro = new Atraccion("Bosque Negro", 4, 3, TipoAtraccion.AVENTURA, 12);
		esgaroth = new Atraccion("Esgaroth", 3, 50, TipoAtraccion.DEGUSTACION, 20);
		atracciones.add(moria);
		atracciones.add(minasTirith);
		atracciones.add(laComarca);
		atracciones.add(mordor);
		atracciones.add(abismoDeHelm);
		atracciones.add(lothlorein);
		atracciones.add(erebor);
		atracciones.add(bosqueNegro);
		atracciones.add(esgaroth);
		atraccionesPrimera = new ArrayList<Atraccion>();
		atraccionesSegunda = new ArrayList<Atraccion>();
		atraccionesTercera = new ArrayList<Atraccion>();
		atraccionesCuarta = new ArrayList<Atraccion>();
		atraccionesQuinta = new ArrayList<Atraccion>();
		atraccionesPrimera.add(bosqueNegro);
		atraccionesPrimera.add(mordor);
		atraccionesSegunda.add(moria);
		atraccionesSegunda.add(mordor);
		atraccionesSegunda.add(bosqueNegro);
		atraccionesTercera.add(lothlorein);
		atraccionesTercera.add(laComarca);
		atraccionesCuarta.add(lothlorein);
		atraccionesCuarta.add(esgaroth);
		atraccionesQuinta.add(minasTirith);
		atraccionesQuinta.add(abismoDeHelm);
		atraccionesQuinta.add(erebor);
		promociones = new ArrayList<Promocion>();
		primera = new PromocionPorcentual("Primera", TipoAtraccion.AVENTURA, atraccionesPrimera, 20);
		segunda = new PromocionAxB("Segunda", TipoAtraccion.AVENTURA, atraccionesSegunda, bosqueNegro);
		tercera = new PromocionAbsoluta("Tercera", TipoAtraccion.DEGUSTACION, atraccionesTercera, 36);
		cuarta = new PromocionPorcentual("Cuarta", TipoAtraccion.DEGUSTACION, atraccionesCuarta, 25);
		quinta = new PromocionAxB("Quinta", TipoAtraccion.PAISAJE, atraccionesQuinta, erebor);
		promociones.add(primera);
		promociones.add(segunda);
		promociones.add(tercera);
		promociones.add(cuarta);
		promociones.add(quinta);
		sistema = new SugerirProducto(usuarios, promociones, atracciones);
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
		moria = null;
		minasTirith = null;
		laComarca = null;
		mordor = null;
		abismoDeHelm = null;
		lothlorein = null;
		erebor = null;
		bosqueNegro = null;
		esgaroth = null;
		usuarios = null;
		atracciones = null;
		atraccionesPrimera = null;
		atraccionesSegunda = null;
		atraccionesTercera = null;
		atraccionesCuarta = null;
		atraccionesQuinta = null;
		primera = null;
		segunda = null;
		tercera = null;
		cuarta = null;
		quinta = null;
		promociones = null;
		sistema = null;
	}

	@Test
	public void testDeLosGets() {
		assertEquals(usuarios, sistema.getUsuarios());
		assertEquals(promociones, sistema.getPromociones());
		assertEquals(atracciones, sistema.getAtracciones());
	}

	@Test
	public void testDeGetAtraccionesDeSuItinerario() {
		eowyn.aceptarSugerencia(bosqueNegro, true);
		eowyn.aceptarSugerencia(mordor, true);
		assertEquals(atraccionesPrimera, sistema.getAtraccionesDeSuItinerario(eowyn));
	}
}
