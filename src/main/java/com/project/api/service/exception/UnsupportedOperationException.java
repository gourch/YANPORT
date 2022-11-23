package com.project.api.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.CONFLICT)
public class UnsupportedOperationException extends ApiException {
	
	public UnsupportedOperationException(String detail) {
		super("Unsupported operation", HttpStatus.CONFLICT, detail);
	}
}