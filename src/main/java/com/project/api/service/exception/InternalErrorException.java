package com.project.api.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalErrorException extends ApiException {
	
	public InternalErrorException(String detail) {
		super("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR, detail);
	}	
}

