package com.ssd.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class HndlingExceptionController extends ResponseEntityExceptionHandler{
	
	
	
	@ExceptionHandler
	public ResponseEntity<Object> postExcResponseEntity(PostException ex,WebRequest request){
		
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.BAD_REQUEST ) ;
	}
}
