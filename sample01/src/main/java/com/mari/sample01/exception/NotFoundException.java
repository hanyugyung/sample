package com.mari.sample01.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends SampleException{
	
	public NotFoundException(HttpStatus code, String message) {
		super(code, message);
	}
	
}
