package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.UserDAO;
import com.demo.domain.User;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
 
	@Override
	@Transactional(readOnly = false)
	public void add(User user) {
		userDAO.add(user);
		System.out.println("User added successfully");
	}

	@Override
	public User get(int id) {
		return userDAO.get(id);
	}

	@Override
	public List<User> loadAll() {
		return userDAO.loadAll();
	}

	@Override
	@Transactional(readOnly = false)
	public void update(User user) {
		userDAO.update(user);
	}
	
	@Override
	@Transactional(readOnly = false)
	public void delete(int id) {
		userDAO.delete(id);
	}
}
