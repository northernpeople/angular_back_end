package com.stepan.task_manager.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

	@PutMapping(path= "/{id}", consumes = "application/json")
	public Todo replaceTodo(@RequestBody Todo t, @PathVariable String id) {
		return service.update(t, id);
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
