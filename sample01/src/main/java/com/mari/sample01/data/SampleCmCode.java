package com.mari.sample01.data;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

/**
 * @apiNote sample common code
 * @author mari
 *
 */

@Getter
@Setter
public class SampleCmCode {
	
	private int code;
	private String apiUrl;
	private String message;
	
	public SampleCmCode() {
	}
	
	public SampleCmCode(int code, String apiUrl, String message) {
		this.code = code;
		this.apiUrl = apiUrl;
		this.message = message;
	}
}
