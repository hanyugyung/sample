package com.mari.sample01.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class SampleException extends RuntimeException {
	
	private HttpStatus status;
	private String cmCode;
	
	public SampleException(HttpStatus status, String cmCode, String message) {
		super(message);
		this.status = status;
		this.cmCode = cmCode;
	}
}
