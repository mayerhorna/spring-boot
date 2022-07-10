package com.demo.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.demo.dao.UserDAO;
import com.demo.domain.User;
import com.demo.util.Paginacion;
import com.demo.util.Util;


class UserRowMapper implements RowMapper<User>{
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();
		user.setCode(rs.getInt(1));
		user.setName(rs.getString(2));
		user.setPassword(rs.getString(3));
		user.setGender(rs.getString(4));
		user.setCountry(rs.getString(5));
		user.setAboutYou(rs.getString(6));
		String community = rs.getString(7);
		if(community == null) {
			community ="";
		}
		user.setCommunity(community.split(","));
		user.setMailingList(rs.getBoolean(8));
		return user;
	}
}

//@Repository
public class UserDAOJdbc implements UserDAO{
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	private SimpleJdbcInsert jdbcInsert;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("tb_user").usingGeneratedKeyColumns("code");
	}

	@Override
	public void add(User user) {
		StringBuilder builder = new StringBuilder();
		Map map = new HashMap();
		map.put("name", user.getName());
		map.put("password", user.getPassword());
		map.put("gender", user.getGender());
		map.put("country", user.getCountry());
		map.put("aboutYou", user.getAboutYou());
		map.put("community", Util.getCommunities(user.getCommunity()));
		map.put("mailingList", user.getMailingList());
		Number id = jdbcInsert.executeAndReturnKey(map);
		user.setCode(id.intValue());
	}

	@Override
	public User get(Integer id) {
		User userReturn = jdbcTemplate.queryForObject("SELECT * FROM tb_user WHERE code = ?",new UserRowMapper(), id);
		return userReturn;
	}

	@Override
	public List<User> loadAll() {
		List<User> users = jdbcTemplate.query("SELECT * FROM tb_user", new UserRowMapper());
		return users;
	}

	@Override
	public void update(User user) {
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE tb_user SET name = ?, password = ?, gender = ?, country = ?, " +
		"aboutYou = ?, community = ?, mailingList = ? WHERE code = ?;");
		
		jdbcTemplate.update(builder.toString(), 
			user.getName(),  
			user.getPassword(),  
			user.getGender(),  
			user.getCountry(),  
			user.getAboutYou(),  
			Util.getCommunities(user.getCommunity()), 
			user.getMailingList(), 
			Integer.valueOf(user.getCode()));
	}

	@Override
	public void delete(Integer id) {
		StringBuilder builder = new StringBuilder();
		builder.append("DELETE FROM tb_user WHERE code = ?");
		jdbcTemplate.update(builder.toString(), 
				 id);
	}

	@Override
	public List<User> loadAll(Paginacion paginacion) {
		List<User> users = jdbcTemplate.query("SELECT * FROM tb_user ORDER BY code desc "+paginacion.obtenerSentencia(), new UserRowMapper());
		Long count = jdbcTemplate.queryForObject("SELECT count(*) FROM tb_user", Long.class);
		paginacion.setNumeroTotalRegistros(count);
		return users;
	}
}
