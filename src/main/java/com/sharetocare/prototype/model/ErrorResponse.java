package com.sharetocare.prototype.model;

public class ErrorResponse {
	
	
	
	private String info;
	
	private String trace;

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getTrace() {
		return trace;
	}

	public void setTrace(String trace) {
		this.trace = trace;
	}

	public ErrorResponse(String info, String trace) {
		super();
		this.info = info;
		this.trace = trace;
	}
	
	
	
	
	
	

}
