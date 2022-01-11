package mcs.p3.cities.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ApiException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(ApiException ex, WebRequest request){
		ErrorMessage error = new ErrorMessage(ex.getCode());
		return new ResponseEntity<Object>(error,error.getStatus());
	}
}
