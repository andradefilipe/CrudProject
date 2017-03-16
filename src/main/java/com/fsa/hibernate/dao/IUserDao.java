package com.fsa.hibernate.dao;

import java.util.List;

import com.fsa.hibernate.model.User;

public interface IUserDao {

	public User findByName(String name);

	public List<User> findAll();

	public User addUser(User user);

}