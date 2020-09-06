package com.wylegly.clinic.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.wylegly.clinic.dao.GenericDao;
import com.wylegly.clinic.dao.RoleDao;
import com.wylegly.clinic.dao.UserDao;
import com.wylegly.clinic.domain.User;

@Service
public class UserServiceImpl extends GenericServiceImpl<User> implements UserService {
	
	private UserDao userDao;
	
	@Autowired
	@Qualifier("roleDaoImpl")
	private RoleDao roleDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserServiceImpl() {
		
	}
	
	@Autowired
	public UserServiceImpl(
			@Qualifier("userDaoImpl") GenericDao<User> userDao) {
		super(userDao);
		this.userDao = (UserDao) userDao;
	}
	
	@Override
	@Transactional
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(), user.getAuthorities());
	}
	
	@Override
	@Transactional
	public void save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDao.saveOrUpdate(user);
	}

}
