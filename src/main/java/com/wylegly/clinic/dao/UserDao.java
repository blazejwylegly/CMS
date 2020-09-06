package com.wylegly.clinic.dao;


import com.wylegly.clinic.domain.User;

public interface UserDao extends GenericDao<User> {

	public User findByUsername(String username);
}
