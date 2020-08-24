package com.mari.sample01.exception;

import com.mari.sample01.data.CmError;

public class UnAuthenticateException extends SampleException {
	public UnAuthenticateException(CmError cm) {
		super(cm.getStatus(), cm.getCmCode(), cm.getMessage());
	}
}
