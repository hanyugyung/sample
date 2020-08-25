package com.mari.sample01.exception;

import org.springframework.http.HttpStatus;

import com.mari.sample01.data.CmError;

import lombok.Getter;

@Getter
public class SampleException extends RuntimeException {
	
	private HttpStatus status;
	private String cmCode;
	
	public SampleException(CmError error) {
		super(error.getMessage());
		this.status = error.getStatus();
		this.cmCode = error.getCmCode();
	}
	
	public SampleException(HttpStatus status, String cmCode, String message) {
		super(message);
		this.status = status;
		this.cmCode = cmCode;
	}
}
