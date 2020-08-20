package com.mari.sample01.data;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

/**
 * @apiNote sample common code
 *
 */

@Getter
@Setter
public class SampleCmCode {
	
	private HttpStatus status;
	private String cmCode;
	private String apiUrl;
	private String message;
	
	public SampleCmCode() {
	}
	
	public SampleCmCode(HttpStatus status, String apiUrl, String message) {
		this.status = status;
		this.apiUrl = apiUrl;
		this.message = message;
	}
	
	public SampleCmCode(HttpStatus status, String cmCode, String apiUrl, String message) {
		this.status = status;
		this.cmCode = cmCode;
		this.apiUrl = apiUrl;
		this.message = message;
	}
}
