package com.mari.sample01.exception;

import com.mari.sample01.data.CmError;

public class NotFoundException extends SampleException{
	
	public NotFoundException(CmError error) {
		super(error.getStatus(), error.getCmCode(), error.getMessage());
	}
	
}
