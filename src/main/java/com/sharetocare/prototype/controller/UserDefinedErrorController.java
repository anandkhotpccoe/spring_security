package com.sharetocare.prototype.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sharetocare.prototype.exception.CategoryDeleteException;
import com.sharetocare.prototype.model.ErrorResponse;

@RestController
@ControllerAdvice
public class UserDefinedErrorController  extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler(CategoryDeleteException.class)
	public final ResponseEntity<ErrorResponse> handleCategoryDeleteException(CategoryDeleteException ex, WebRequest webRequest)
	{
		ErrorResponse errorResponse = new ErrorResponse("Anand", webRequest.getDescription(false));
		
		
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
	}

	
	
}
