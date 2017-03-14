package com.fsa.hibernate.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserTest {

	private static EntityManager manager;
	private static EntityManagerFactory emf;

	public static void main(String[] args) {

		emf = Persistence.createEntityManagerFactory("app");
		manager = emf.createEntityManager();

		List<User> users = manager.createQuery("FROM User").getResultList();
		System.out.println(users);
	}

}
