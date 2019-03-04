package com.stepan.task_manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stepan.task_manager.todo.Todo;
import com.stepan.task_manager.todo.TodoService;
import com.stepan.task_manager.user.User;
import com.stepan.task_manager.user.UserService;

@SpringBootApplication
public class TodoBackEndApplication implements CommandLineRunner {

	@Autowired
	TodoService todos;

	@Autowired
	UserService users;

	public static void main(String[] args) {
		SpringApplication.run(TodoBackEndApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User one = users.create(new User().setEmail("a@a.a").setName("John"));
		User two = users.create(new User().setEmail("b@a.a").setName("Johnattan"));
		User three = users.create(new User().setEmail("c@a.a").setName("Johnson"));
		User four = users.create(new User().setEmail("d@a.a").setName("Johnman"));
		Todo first = todos.create(new Todo().setTask("Kill Bill").setUserId(one.getId()));
		Todo second = todos.create(new Todo().setTask("sell milk").setUserId(one.getId()));
		Todo third = todos.create(new Todo().setTask("sell Bill").setUserId(one.getId()));
		Todo forth = todos.create(new Todo().setTask("tell Bill").setUserId(two.getId()));
		Todo fifth = todos.create(new Todo().setTask("Dill Bill").setUserId(two.getId()));
		Todo sixth = todos.create(new Todo().setTask("Kill milk").setUserId(three.getId()));
		Todo seventh = todos.create(new Todo().setTask("Bill Bill").setUserId(four.getId()));
		Todo eightth = todos.create(new Todo().setTask("Will Bill").setUserId(four.getId()));
	}
}
