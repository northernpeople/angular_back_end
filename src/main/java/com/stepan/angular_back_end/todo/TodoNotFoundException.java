package com.stepan.angular_back_end.todo;

public class TodoNotFoundException  extends RuntimeException {

	public TodoNotFoundException(String message) {
		super(message);
	}
	
}
