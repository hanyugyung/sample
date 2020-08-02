package com.mari.sample01.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.mari.sample01.exception.NotFoundException;
import com.mari.sample01.exception.SampleException;

@Controller
public class SampleController {
	
	@GetMapping("/sample")
	public String sample() {
		throw new NotFoundException(HttpStatus.NOT_FOUND, "NotFound!!");
	}
	
}
