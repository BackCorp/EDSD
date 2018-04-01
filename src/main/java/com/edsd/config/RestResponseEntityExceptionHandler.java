package com.edsd.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.edsd.domain.NonLogementEdsdException;
import com.edsd.domain.PrimesEdsdException;
import com.edsd.domain.RappelsSalairesEdsdException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	public RestResponseEntityExceptionHandler() {
        super();
    }

	@ExceptionHandler(value = {PrimesEdsdException.class})
	protected ResponseEntity<Object> handleDuplicatePrimesEDSDnotAllow(PrimesEdsdException ex, WebRequest request) {
	    return ResponseEntity.status(HttpStatus.CONFLICT)
	            .body(handleExceptionInternal(ex, ex.getLocalizedMessage(), new HttpHeaders(), HttpStatus.CONFLICT, request));
	}
	
	@ExceptionHandler(value = {NonLogementEdsdException.class})
	protected ResponseEntity<Object> handleDuplicateNonLogementEDSDnotAllow(NonLogementEdsdException ex, WebRequest request) {
	    return ResponseEntity.status(HttpStatus.CONFLICT)
	            .body(handleExceptionInternal(ex, ex.getLocalizedMessage(), new HttpHeaders(), HttpStatus.CONFLICT, request));
	}
	
	@ExceptionHandler(value = {RappelsSalairesEdsdException.class})
	protected ResponseEntity<Object> handleDuplicateRappelsSalairesEDSDnotAllow(RappelsSalairesEdsdException ex, WebRequest request) {
	    return ResponseEntity.status(HttpStatus.CONFLICT)
	            .body(handleExceptionInternal(ex, ex.getLocalizedMessage(), new HttpHeaders(), HttpStatus.CONFLICT, request));
	}
	
	@ExceptionHandler(value = {DuplicateEdsdNotAllowException.class})
	protected ResponseEntity<Object> handleDuplicateEdsdNotAllow(DuplicateEdsdNotAllowException ex, WebRequest request) {
	    return ResponseEntity.status(HttpStatus.CONFLICT)
	            .body(handleExceptionInternal(ex, ex.getLocalizedMessage(), new HttpHeaders(), HttpStatus.CONFLICT, request));
	}
	
}
