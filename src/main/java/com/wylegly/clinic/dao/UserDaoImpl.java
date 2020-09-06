package com.wylegly.clinic.dao;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.wylegly.clinic.domain.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	@Override
	public User get(int id) {
		User user = currentSession().createQuery("select user " 
				+ "from User user "
				+ "left join fetch user.roles "
				+ "where user.id = :theId", User.class)
				.setParameter("theId", id)
				.getSingleResult();
		return user;
	}

	@Override
	public List<User> getAll() {
		List<User> users = null;
		
		users = currentSession().createQuery("select user "
				+ "from User user "
				+ "left join fetch user.roles", User.class)
				.getResultList();
		
		return users;
	}
	
	@Override
	public User findByUsername(String username) {
		User user = null;
		
		user = currentSession().createQuery("select user "
				+ "from User user "
				+ "where user.username = :theUsername", User.class)
				.setParameter("theUsername", username.toLowerCase())
				.getSingleResult();
		
		if(user == null) {
			throw new UsernameNotFoundException("Username " + username + " not found");
		}
				
		return user;
	}
}
