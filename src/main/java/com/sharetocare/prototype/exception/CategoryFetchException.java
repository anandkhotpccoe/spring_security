package com.sharetocare.prototype.exception;

public class CategoryFetchException extends RuntimeException {

	/**
	 --Way 1
	 	--Extending the Runtime Exception
	 */
	private static final long serialVersionUID = 1L;
	
	public CategoryFetchException(String info)
	{
		super(info);
	}

}
