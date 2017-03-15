package com.fsa.hibernate.dao;

import java.util.List;

import com.fsa.hibernate.model.User;

public interface IUserDao {

	User findByName(String name);

	List<User> findAll();

}