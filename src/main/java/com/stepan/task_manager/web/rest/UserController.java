package com.stepan.task_manager.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stepan.task_manager.user.User;
import com.stepan.task_manager.user.UserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService service;

	@GetMapping("/{id}")
	private User byId(@PathVariable("id") String id) {
		return service.byId(id);
	}

	@GetMapping
	private List<User> all(@RequestParam(value = "index", defaultValue = "0") int index,
			@RequestParam(value = "size", defaultValue = "500") int size) {
		return service.page(index, size);
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public User save(@RequestBody User dto) {
		return service.create(dto);
	}

}
