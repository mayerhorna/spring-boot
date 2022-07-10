package com.demo.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.dao.UserDAO;
import com.demo.domain.User;
import com.demo.util.Paginacion;

@Repository
public class UserDAOHibernate implements UserDAO{
	
	@Autowired
	private EntityManager em;
	
	private Session getSession(){
		return em.unwrap(Session.class);
	}
	
	@Override
	public void add(User user) {
		getSession().save(user);
	}

	@Override
	public User get(Integer id) {
		return (User)getSession().get(User.class, id);
	}

	@Override
	public List<User> loadAll() {
		Query<User> query = getSession().createQuery("from User");
		List<User> userList = query.list();
		return userList;
	}

	@Override
	public void update(User user) {
		getSession().update(user);
	}

	@Override
	public void delete(Integer id) {
		User user = getSession().get(User.class, id);
		getSession().delete(user);
	}

	@Override
	public List<User> loadAll(Paginacion paginacion) {
		Query<User> query = getSession().createQuery("from User");
		query.setMaxResults(paginacion.getRegistrosPorPagina());
		query.setFirstResult(paginacion.getStart());
		List<User> userList = query.list();
		return userList;
	}
}
