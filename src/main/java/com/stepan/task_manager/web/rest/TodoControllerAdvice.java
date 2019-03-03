package com.stepan.task_manager.web.rest;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.stepan.task_manager.todo.TodoNotFoundException;


@ControllerAdvice
public class TodoControllerAdvice {

	@ExceptionHandler(TodoNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error handleUserNotFoundException(TodoNotFoundException ex) {
		return new Error();
	}

}