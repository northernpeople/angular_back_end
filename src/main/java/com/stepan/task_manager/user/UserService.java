package com.stepan.task_manager.user;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;

@Component
public class UserService {

	@Autowired
	UserRepo userRepo;

	public User byUserName(String username) {
		return userRepo.findByUsername(username);
	}

	public List<User> findAll() {
		return userRepo.findAll();
	}

	public User create(User user, Role inRole) {
		if (!usernameTaken(user)) {
			user = save(user);
			return user;
		}
		return null;
	}

	public boolean usernameTaken(User user) {
		return findAll().stream().map(u -> u.getUsername()).collect(Collectors.toSet()).contains(user.getUsername());
	}

	public User byId(String id) {
		return userRepo.findById(id).get();
	}

	public User save(User u) {
		return userRepo.saveAndFlush(u);

	}

}
