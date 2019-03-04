package com.stepan.task_manager.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.stepan.task_manager.APIException;

@Component
public class UserService {

	@Autowired
	UserRepo userRepo;

	public List<User> findAll() {
		return userRepo.findAll();
	}

	public User create(User user) {
		if (! emailTaken(user.getEmail())) {
			System.out.println("creating: "+ user);
			user = save(user);
			return user;
		}
		throw new APIException("user email already registered");
	}

	public List<User> page(int index, int size) {
		return userRepo.findAll(PageRequest.of(index, size, Sort.by("created").descending())).getContent();
	}

	public boolean emailTaken(String email) {
		return userRepo.findByEmail(email) != null;
	}

	public User byId(String id) {
		return userRepo.findById(id).orElseThrow(() -> new APIException("no user with this id:" + id));
	}

	public User save(User u) {
		return userRepo.saveAndFlush(u);
	}

	public void deleteById(String id) {
		userRepo.deleteById(id);
	}

	@Transactional
	public User update(User u, String id) {
		Optional<User> found = userRepo.findById(id);
		System.out.println(u);
		System.out.println(found);
		return found
				.map( user -> user.setName(u.getName()))
				.orElseGet(() -> create(u));

	}

}
