package com.stepan.angular_back_end.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

	@Autowired
	TodoRepo repo;

	public Todo create(Todo todo) {
		return repo.saveAndFlush(todo);
	}

	public List<Todo> page(int index, int size) {
		return repo.findAll(
				PageRequest.of(index, size, Sort.by("created").descending()))
				.getContent();
	}
	
	public Todo byId(String id){
		return repo.findById(id).get();
	}
	
	public void testData(){
		repo.saveAndFlush(new Todo().setTask("buy milk"));
		repo.saveAndFlush(new Todo().setTask("buy bread"));
		repo.saveAndFlush(new Todo().setTask("buy lettuce"));
		repo.saveAndFlush(new Todo().setTask("buy herring"));
	}

}
