package com.mari.sample01.exception;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mari.sample01.data.SampleCmCode;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(SampleException.class)
	public @ResponseBody ResponseEntity<Object> sampleErrorHandler(
			HttpServletRequest request
			, Exception e){
		
		String apiUrl = request.getRequestURI();
		SampleException ex = (SampleException) e;
		SampleCmCode commonCode = new SampleCmCode(ex.getCode().value(), apiUrl, e.getMessage());
		
		return new ResponseEntity<>(commonCode, ex.getCode());
	}
	
	@ExceptionHandler(Exception.class)
	public @ResponseBody ResponseEntity<Object> exceptionHandler(
			HttpServletRequest request
			, HttpServletResponse response
			, Exception e){
		
		String apiUrl = request.getRequestURI();

		//사용자 지정이 아닌 runtimeException 으로 떨어질 때는 기본 200 코드로 나가는 듯하여 500으로 떨어지게 고정함
		SampleCmCode commonCode = new SampleCmCode(500, apiUrl, e.getMessage());
		return new ResponseEntity<>(commonCode, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}