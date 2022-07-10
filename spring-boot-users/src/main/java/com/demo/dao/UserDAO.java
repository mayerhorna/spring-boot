package com.demo.dao;

import java.util.List;

import com.demo.domain.User;
import com.demo.util.Paginacion;

public interface UserDAO {
	
	void add(User user);

	User get(Integer id);

	List<User> loadAll();

	void update(User user);

	void delete(Integer id);
	
	List<User> loadAll(Paginacion paginacion);

}
