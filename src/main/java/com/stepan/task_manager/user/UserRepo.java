package com.stepan.task_manager.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {

	User findByEmail(String email);

}