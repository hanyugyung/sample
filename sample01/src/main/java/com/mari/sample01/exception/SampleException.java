package com.mari.sample01.exception;

import org.springframework.http.HttpStatus;

public class SampleException extends RuntimeException {
	
	private HttpStatus code;
	
	public SampleException(HttpStatus code, String message) {
		super(message);
		this.code = code;
	}
	
	public void setCode(HttpStatus code) {
		this.code = code;
	}
	
	public HttpStatus getCode() {
		return this.code;
	}
}
