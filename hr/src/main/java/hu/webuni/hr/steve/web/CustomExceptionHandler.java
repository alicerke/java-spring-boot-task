package hu.webuni.hr.steve.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyError> handleValidationError(MethodArgumentNotValidException e, WebRequest web) {
		MyError myError = new MyError(e.getMessage(), 400);
		myError.setMessage("Not Valid");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(myError);
	}
}
