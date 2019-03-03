package com.stepan.task_manager.todo;

@SuppressWarnings("serial")
public class TodoNotFoundException  extends RuntimeException {

	public TodoNotFoundException(String message) {
		super(message);
	}
	
}
