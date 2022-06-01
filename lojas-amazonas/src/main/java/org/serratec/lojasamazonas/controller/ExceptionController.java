package org.serratec.lojasamazonas.controller;

import org.serratec.lojasamazonas.exception.EmailException;
import org.serratec.lojasamazonas.exception.ItemNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity<String> handleItemNotFoundException(ItemNotFoundException exception) {
		return ResponseEntity.notFound().header("x-erro-msg", exception.getMessage()).build();
	}
	
	@ExceptionHandler(EmailException.class)
	public ResponseEntity<String> handleEmailException(EmailException exception) {		
	      return ResponseEntity.badRequest().header("x-erro-msg", exception.getMessage()).build();
	   }
}
