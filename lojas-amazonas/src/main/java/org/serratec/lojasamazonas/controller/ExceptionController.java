package org.serratec.lojasamazonas.controller;

import org.serratec.lojasamazonas.exception.CannotBeChangedException;
import org.serratec.lojasamazonas.exception.EmailException;
import org.serratec.lojasamazonas.exception.InsufficientStockException;
import org.serratec.lojasamazonas.exception.ItemAlreadyExistsException;
import org.serratec.lojasamazonas.exception.ItemNotFoundException;
import org.serratec.lojasamazonas.exception.MayNotBeNullException;
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
	
	@ExceptionHandler(MayNotBeNullException.class)
	public ResponseEntity<String> handleMayNotBeNullException(MayNotBeNullException exception) {
		return ResponseEntity.badRequest().header("x-erro-msg", exception.getMessage()).build();
	}
	
	@ExceptionHandler(ItemAlreadyExistsException.class)
	public ResponseEntity<String> handleItemAlreadyExistsException(ItemAlreadyExistsException exception) {
		return ResponseEntity.badRequest().header("x-erro-msg", exception.getMessage()).build();
	}
	
	@ExceptionHandler(InsufficientStockException.class)
	public ResponseEntity<String> handleInsufficientStockException(InsufficientStockException exception) {
		return ResponseEntity.badRequest().header("x-erro-msg", exception.getMessage()).build();
	}
	
	@ExceptionHandler(CannotBeChangedException.class)
	public ResponseEntity<String> handleCannotBeChangedException(CannotBeChangedException exception) {
		return ResponseEntity.badRequest().header("x-erro-msg", exception.getMessage()).build();
	}
}