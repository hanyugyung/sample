package com.mari.sample01.exception;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mari.sample01.data.SampleCmCode;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//Custom Error
	@ExceptionHandler(SampleException.class)
	public @ResponseBody ResponseEntity<Object> sampleErrorHandler(
			HttpServletRequest request
			, Exception e){
		
		String apiUrl = request.getRequestURI();
		SampleException ex = (SampleException) e;
		SampleCmCode commonCode = new SampleCmCode(ex.getStatus(), ex.getCmCode(), apiUrl, ex.getMessage());
		logger.warn(String.format("%s", commonCode.toString()), e);
		return new ResponseEntity<>(commonCode, ex.getStatus());
	}
	
	//Access Denied
	@ExceptionHandler(AccessDeniedException.class)
	public @ResponseBody ResponseEntity<Object> exceptionHandler(
			HttpServletRequest request
			, AccessDeniedException e){
		
		String apiUrl = request.getRequestURI();
		AccessDeniedException ex = (AccessDeniedException) e;
		SampleCmCode commonCode = new SampleCmCode(HttpStatus.FORBIDDEN, apiUrl, ex.getMessage());
		logger.warn(String.format("%s", commonCode.toString()), e);
		return new ResponseEntity<>(commonCode, commonCode.getStatus());
	}
	
	//Internal Server Error
	@ExceptionHandler(Exception.class)
	public @ResponseBody ResponseEntity<Object> exceptionHandler(
			HttpServletRequest request
			, HttpServletResponse response
			, Exception e){
		
		String apiUrl = request.getRequestURI();
		SampleCmCode commonCode = new SampleCmCode(HttpStatus.INTERNAL_SERVER_ERROR, apiUrl, e.getMessage());
		logger.warn(String.format("%s", commonCode.toString()), e);
		return new ResponseEntity<>(commonCode, commonCode.getStatus());
	}
}