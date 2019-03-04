package com.stepan.task_manager.web.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.stepan.task_manager.APIException;

@ControllerAdvice
public class AppControllerAdvice {

	@ExceptionHandler(APIException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error handleUserNotFoundException(APIException ex) {
		return new Error();
	}

}