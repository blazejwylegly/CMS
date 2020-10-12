package com.wylegly.clinic.service;

import com.wylegly.clinic.exceptions.UserAlreadyExistsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.wylegly.clinic.controller.security.helper.UserAccountHelper;
import com.wylegly.clinic.domain.User;

public interface UserService extends GenericService<User>, UserDetailsService {

	public User findByUsername(String username);
	public UserDetails loadUserByUsername(String username);
	public void saveIfNotExist(UserAccountHelper userAccount) throws UserAlreadyExistsException;
}
