package com.stepan.task_manager.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stepan.task_manager.todo.Todo;
import com.stepan.task_manager.todo.TodoService;

@CrossOrigin
@RestController
@RequestMapping("/todo")
public class TodoController {

	@Autowired
	TodoService service;

	@GetMapping
	private List<Todo> all(@RequestParam(value = "index", defaultValue = "0") int index,
			@RequestParam(value = "size", defaultValue = "500") int size) {
		return service.page(index, size);
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Todo save(@RequestBody Todo dto) {
		return service.create(dto);
	}

	@PutMapping(path = "/{id}", consumes = "application/json")
	public Todo replaceTodo(@RequestBody Todo t, @PathVariable String id) {
		System.out.println(">>>>"+t);
		return service.update(t, id);
	}

	@GetMapping("/")
	public List<Todo> byUserId(@RequestParam("user_id") String userId) {
		return service.byUserId(userId);
	}
	
	@GetMapping("/{id}")
	public Todo byId(@PathVariable("id") String id) {
		return service.byId(id);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable("id") String id) {
		service.deleteById(id);
	}
}
