package com.stepan.task_manager.user;


import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User, String> {

	
	public User findByUsername(String userName);
	public User findOneByVerificationCode(String verificationCode);
	

}