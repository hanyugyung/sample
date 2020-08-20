package com.mari.sample01.exception;

import com.mari.sample01.data.CmError;

public class NotFoundException extends SampleException{
	
	public NotFoundException(CmError cm) {
		super(cm.getStatus(), cm.getCmCode(), cm.getMessage());
	}
	
}
