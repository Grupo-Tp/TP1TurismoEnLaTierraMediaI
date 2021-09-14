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
	List<Atraccion> atracciones;
	List<String> atraccionesPrimera, atraccionesSegunda, atraccionesTercera, atraccionesCuarta, atraccionesQuinta;
	String[] primeras, segundas, terceras, cuartas, quintas;
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
		atraccionesPrimera = new ArrayList<String>();
		atraccionesSegunda = new ArrayList<String>();
		atraccionesTercera = new ArrayList<String>();
		atraccionesCuarta = new ArrayList<String>();
		atraccionesQuinta = new ArrayList<String>();
		atraccionesPrimera.add(bosqueNegro.getNombre());
		atraccionesPrimera.add(mordor.getNombre());
		atraccionesSegunda.add(moria.getNombre());
		atraccionesSegunda.add(mordor.getNombre());
		atraccionesSegunda.add(bosqueNegro.getNombre());
		atraccionesTercera.add(lothlorein.getNombre());
		atraccionesTercera.add(laComarca.getNombre());
		atraccionesCuarta.add(lothlorein.getNombre());
		atraccionesCuarta.add(esgaroth.getNombre());
		atraccionesQuinta.add(minasTirith.getNombre());
		atraccionesQuinta.add(abismoDeHelm.getNombre());
		atraccionesQuinta.add(erebor.getNombre());
		primeras = new String[2];
		primeras[0] = bosqueNegro.getNombre();
		primeras[1] = mordor.getNombre();
		segundas = new String[3];
		segundas[0] = moria.getNombre();
		segundas[1] = mordor.getNombre();
		segundas[2] = bosqueNegro.getNombre();
		terceras = new String[2];
		terceras[0] = lothlorein.getNombre();
		terceras[1] = laComarca.getNombre();
		cuartas = new String[2];
		cuartas[0] = lothlorein.getNombre();
		cuartas[1] = esgaroth.getNombre();
		quintas = new String[3];
		quintas[0] = minasTirith.getNombre();
		quintas[1] = abismoDeHelm.getNombre();
		quintas[2] = erebor.getNombre();
		promociones = new ArrayList<Promocion>();
		primera = new PromocionPorcentual("Primera", TipoAtraccion.AVENTURA, primeras, atracciones, 20);
		segunda = new PromocionAxB("Segunda", TipoAtraccion.AVENTURA, segundas, atracciones, bosqueNegro.getNombre());
		tercera = new PromocionAbsoluta("Tercera", TipoAtraccion.DEGUSTACION, terceras, atracciones, 36);
		cuarta = new PromocionPorcentual("Cuarta", TipoAtraccion.DEGUSTACION, cuartas, atracciones, 25);
		quinta = new PromocionAxB("Quinta", TipoAtraccion.PAISAJE, quintas, atracciones, erebor.getNombre());
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
	@Test
	public void testDeSugerirPromocionConPreferencia() {
		
	}
}
