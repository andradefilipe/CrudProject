package com.fsa.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.fsa.hibernate.model.Phone;
import com.fsa.hibernate.model.User;

public class UserDaoTest {

	private EmbeddedDatabase db;

	UserDaoImpl userDao;

	@Before
	public void setUp() {
		db = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).addScript("db/sql/create-db.sql")
				.addScript("db/sql/insert-data.sql").build();
	}

	@Test
	public void testFindByname() {
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
		UserDaoImpl userDao = new UserDaoImpl();
		userDao.setNamedParameterJdbcTemplate(template);

		List<User> users = userDao.findAll();

		Assert.assertNotNull(users);

	}

	@Test
	public void testAddUser() {
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
		UserDaoImpl userDao = new UserDaoImpl();
		userDao.setNamedParameterJdbcTemplate(template);

		Phone phone = new Phone("31", "3243454354");

		List<Phone> phones = new ArrayList<>();
		phones.add(phone);

		User user = new User("UserName", "UserEmail", "UserPassword", phones);

		userDao.addUser(user);

		List<User> users = userDao.findAll();

		Assert.assertNotNull(users);

	}

	@After
	public void tearDown() {
		db.shutdown();
	}

}