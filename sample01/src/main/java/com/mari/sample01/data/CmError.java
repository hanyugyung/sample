package com.mari.sample01.data;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum CmError {
	
	//400
	CM_BadRequest(HttpStatus.BAD_REQUEST, "C40001", "Bad Request"),
	
	//401
	CM_UnAuthenticated_Token(HttpStatus.UNAUTHORIZED, "C40101", "Unauthenticated User"),
	
	//403
	
	//404
	CM_Resource_NotFound(HttpStatus.NOT_FOUND, "C40401", "Sample Not Found"),
	
	//409
	CM_LoginId_Conflict(HttpStatus.CONFLICT, "C40901", "LoginId Conflict"),
	
	//500
	CM_Internal_ServerError(HttpStatus.INTERNAL_SERVER_ERROR, "C50001", "Internal Server Error");
	
	private final HttpStatus status;
	private final String cmCode;
	private final String message;
	
	private CmError(HttpStatus status, String cmCode, String message) {
		this.status = status;
		this.cmCode = cmCode;
		this.message = message;
	}
}
