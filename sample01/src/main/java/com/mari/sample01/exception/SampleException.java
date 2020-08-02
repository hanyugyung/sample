package com.mari.sample01.exception;

import org.springframework.http.HttpStatus;

public class SampleException extends RuntimeException {
	
	private HttpStatus code;
	
	public SampleException(String message) {
		super(message);
	}
	
	public void setCode(HttpStatus code) {
		this.code = code;
	}
	
	public HttpStatus getCode() {
		return this.code;
	}
}
