package com.demo.service;

import java.util.List;

import com.demo.domain.User;

public interface UserService {

	void add(User user);

	User get(int id);
	
	List<User> loadAll();

	void update(User user);
	
	void delete(int id);
	
}
