package com.fsa.hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fsa.hibernate.model.User;

@Repository
public class UserDaoImpl implements IUserDao {

	private static EntityManager manager;
	private static EntityManagerFactory emf;

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		emf = Persistence.createEntityManagerFactory("app");
		manager = emf.createEntityManager();
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public User findByName(String name) {

		Query query = manager.createQuery("FROM User WHERE name= :name");
		query.setParameter("name", name);

		User result = (User) query.getSingleResult();

		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {

		List<User> users = manager.createQuery("FROM User").getResultList();

		return users;

	}

	@Override
	public User addUser(User user) {
		manager.getTransaction().begin();
		manager.persist(user);
		manager.getTransaction().commit();

		return user;
	}

}