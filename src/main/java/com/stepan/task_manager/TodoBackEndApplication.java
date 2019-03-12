package com.stepan.task_manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stepan.task_manager.todo.TodoService;

@SpringBootApplication
public class TodoBackEndApplication implements CommandLineRunner {

	@Autowired
	TodoService todos;



	public static void main(String[] args) {
		SpringApplication.run(TodoBackEndApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
