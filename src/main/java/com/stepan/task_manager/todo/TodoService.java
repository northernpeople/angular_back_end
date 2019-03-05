package com.stepan.task_manager.todo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.stepan.task_manager.APIException;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TodoService {

	@Autowired
	TodoRepo repo;

	public Todo create(Todo todo) {
		return repo.saveAndFlush(todo);
	}

	public List<Todo> page(int index, int size) {
		return repo.findAll(PageRequest.of(index, size, Sort.by("created").descending())).getContent();
	}

	public Todo byId(String id) {
		return repo.findById(id).orElseThrow(() -> new APIException("no todo with this id:" + id));
	}

	public void deleteById(String id) {
		repo.deleteById(id);
	}

	@Transactional
	public Todo update(Todo t, String id) {
		Optional<Todo> found = repo.findById(id);
		System.out.println(t);
		System.out.println(found);
		return found
				.map( todo -> todo.setTask(t.getTask()))
				.orElseGet(() -> create(t));

	}
}
