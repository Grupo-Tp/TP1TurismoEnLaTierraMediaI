package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import clases.Atraccion;
import clases.TipoAtraccion;
import excepciones.ExcepcionDeAtraccion;
import excepciones.ExcepcionDeBase;

public class TestAtraccion {
	Atraccion moria = null, minasTirith = null, laComarca = null, mordor = null, abismoDeHelm = null, lothlorein = null,
			erebor = null, bosqueNegro = null, esgaroth = null;
	Atraccion nombreInvalido = null, tiempoInvalido = null, costoInvalido = null, cupoInvalido;

	@Before
	public void setUp() throws ExcepcionDeBase, ExcepcionDeAtraccion {
		moria = new Atraccion("Moria",2,10,TipoAtraccion.AVENTURA,6);
		minasTirith = new Atraccion("Minas Tirith",2.5,5,TipoAtraccion.PAISAJE,25);
		laComarca = new Atraccion("La Comarca",6.5,3,TipoAtraccion.DEGUSTACION,150);
		mordor = new Atraccion("Mordor",3,25,TipoAtraccion.AVENTURA,4);
		abismoDeHelm = new Atraccion("Abismo de Heml",2,5,TipoAtraccion.PAISAJE,15);
		lothlorein = new Atraccion("Lothlórein",1,35,TipoAtraccion.DEGUSTACION,30);
		erebor = new Atraccion("Erebor",3,12,TipoAtraccion.PAISAJE,32);
		bosqueNegro = new Atraccion("Bosque Negro",4,3,TipoAtraccion.AVENTURA,12);
		esgaroth = new Atraccion("Esgaroth",3,50,TipoAtraccion.DEGUSTACION,20);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
