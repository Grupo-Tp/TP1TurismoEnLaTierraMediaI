package clases;

import java.util.List;

public class PromocionAxB extends Promocion {

	public PromocionAxB(TipoAtraccion tipo, List<Atraccion> atracciones) {
		super(tipo, atracciones);
	}

	public PromocionAxB() {
		this(null, null);
	}

	@Override
	public Base sugerirPromocion(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
