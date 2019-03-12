package com.stepan.task_manager.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository<Todo, String> {


	List<Todo> findByUserId(String userId);
}
