package com.project.api.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends ApiException {
	
	public BadRequestException(String detail) {
		super("Bad request", HttpStatus.BAD_REQUEST, detail);
	}
}
