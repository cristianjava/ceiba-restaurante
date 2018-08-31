package co.com.ceiba.restaurante.negocio.exception;

public class RestauranteException extends RuntimeException {

	private static final long serialVersionUID = -7540495326499143641L;

	public RestauranteException(String message) {
		super(message);
	}

	public RestauranteException(Exception e) {
		super(e);
	}
}
