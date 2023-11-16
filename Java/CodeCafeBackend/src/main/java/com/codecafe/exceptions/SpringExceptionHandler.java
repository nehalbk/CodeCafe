package com.codecafe.exceptions;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SpringExceptionHandler extends ResponseEntityExceptionHandler{
	@Autowired
	ExceptionsRepo repo;
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		
		ExceptionDetails errorDetails=new ExceptionDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		repo.save(errorDetails);
		return new ResponseEntity<Object>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);	
	}
	
//	@ExceptionHandler(OrderNotFoundException.class)
//	public final ResponseEntity<Object> handleOrderNotFoundException(Exception ex) throws Exception {
//		
//		ExceptionDetails errorDetails=new ExceptionDetails(LocalDateTime.now(),ex.getMessage(),"Error in order");
//		repo.save(errorDetails);
//		return new ResponseEntity<Object>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);	
//	}
}
