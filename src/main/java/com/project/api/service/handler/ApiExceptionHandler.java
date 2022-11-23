package com.project.api.service.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.api.service.exception.ApiException;

@ControllerAdvice
public class ApiExceptionHandler {
	@Autowired
	private MessageSource messageSource;

	
	@ExceptionHandler(ApiException.class)
	protected ResponseEntity<ErrorResponse> apiExceptionHandler(ApiException ex, WebRequest request) throws JsonMappingException, JsonProcessingException {
		return response(
				new ObjectMapper().readValue(ex.toString(), ErrorResponse.class),
				((ServletWebRequest) request).getRequest().getRequestURI().toString(),
				ex.getStatus());
	}

	protected ResponseEntity<ErrorResponse> response(ErrorResponse errors, String instance, HttpStatus status) {
		errors.detail = messageSource.getMessage(errors.detail, null, LocaleContextHolder.getLocale());
		errors.instance = instance;
		return new ResponseEntity<ErrorResponse>(errors, status);
	}
	
	@JsonInclude(Include.NON_EMPTY)
	public static class ErrorResponse {
		@JsonIgnore
		public String type;
		public String title;
		public String status;
		public String detail;
		public String instance;

		public ErrorResponse() {}
	}
}
