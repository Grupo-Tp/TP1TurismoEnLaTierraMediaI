package turismo;

public class Atraccion {
	
	String nombre;
	String tipo;
	double costo;
	double tiempoEnHoras;
	int cupo;
	int cupoOcupado = 0;
	
	public Atraccion(String nombre, double costo, double tiempoEnHoras, int cupo, String tipo) {
		this.nombre = nombre;
		this.costo = costo;
		this.tiempoEnHoras = tiempoEnHoras;
		this.cupo = cupo;
		this.tipo = tipo;
	}
	
	public double getCosto() {
		return this.costo;
	}
	
	String getTipo() {
		return this.tipo;
	}
	
	double getTiempoEnHoras() {
		return this.tiempoEnHoras;
	}
	
	boolean atraccionDisponible() {
		return this.cupo - this.cupoOcupado > 0;
	}

}
