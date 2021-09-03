package clases;

import java.io.IOException;

public class ArchivoPromocion {
public ArchivoPromocion() {
	
}
public List<Base> leerArchivoPromocion(){
	while ((lineaPromocion = bufferDelLectorDeArchivoDePromociones.readLine()) != null) {
		String[] parametros = lineaPromocion.split(".");
		double absoluto = 0, descuento = 0;
		String tipoDePromocionDelArchivo = "";
		TipoAtraccion[] todosLosTiposDePromocion = TipoAtraccion.values();
		TipoAtraccion tipoDePromocion = null;
		// Este bloque se puede mejorar
		try {
			absoluto = Double.parseDouble(parametros[1]);
			descuento = Double.parseDouble(parametros[2]);
			tipoDePromocionDelArchivo = parametros[0].toUpperCase();
			if (tipoDePromocionDelArchivo == todosLosTiposDePromocion[0].name()) {
				tipoDePromocion = TipoAtraccion.AVENTURA;
			} else if (tipoDePromocionDelArchivo == todosLosTiposDePromocion[1].name()) {
				tipoDePromocion = TipoAtraccion.PAISAJE;
			} else if (tipoDePromocionDelArchivo == todosLosTiposDePromocion[2].name()) {
				tipoDePromocion = TipoAtraccion.DEGUSTACION;
			} else {
				// aca debería poner la excepcion que haga saltar que existe un error y que sea
				// capturada en el catch, pero no me acuerdo como era, despues lo hago
			}
		} catch (ArrayIndexOutOfBoundsException excepcionDeArregloFueraDeLimite) {
			// este es el catch que debe capturar la excepcion que esta descrita arriba
			System.err.println("Uno de los usuarios leidos tiene un problema en su preferencia");
		} catch (NumberFormatException excepcionDeCosto) {
			System.err.println("Una de las atracciones leidas tiene un problema en su costo");
		}
		promociones.add(new Atraccion(tipoDePromocion, parametros[0]));
	}
} catch (IOException excepcion) {
	System.err.println("Hubo un problema al momento de leerr uno de los archivos");

}
}
}
