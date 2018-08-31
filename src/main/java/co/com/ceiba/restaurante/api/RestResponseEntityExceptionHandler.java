package co.com.ceiba.restaurante.api;

import java.util.logging.Logger;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.com.ceiba.restaurante.negocio.exception.RestauranteException;
import co.com.ceiba.restaurante.negocio.service.impl.PlatoServiceImpl;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOGGER  = Logger.getLogger(PlatoServiceImpl.class.getName());
	
	@ExceptionHandler({ RestauranteException.class })
	public ResponseEntity<Object> handleAccessDeniedException(Exception ex, WebRequest request) {
		return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ Throwable.class })
	public ResponseEntity<Object> handleAccesTecnicalExceptioon(Exception ex, WebRequest request) {
		LOGGER .info(ex.toString());
		return new ResponseEntity<>("Se presentó un error comuniquese con el administrador del sistema", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
