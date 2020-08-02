package com.mari.sample01.exception;


import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mari.sample01.data.SampleCmCode;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value= {SampleException.class})
	public @ResponseBody ResponseEntity<Object> sampleErrorHandler(
			HttpServletRequest request
			, Exception e){
		
		String apiUrl = request.getRequestURI();
		SampleException ex = (SampleException) e;
		SampleCmCode commonCode = new SampleCmCode(ex.getCode().value(), apiUrl, e.getMessage());
		
		return new ResponseEntity<>(commonCode, ex.getCode());
	}
}
