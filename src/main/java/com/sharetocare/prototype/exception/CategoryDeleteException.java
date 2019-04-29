package com.sharetocare.prototype.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryDeleteException  extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public CategoryDeleteException(String info)
	{
		super(info);
	}
	
	
	

}
