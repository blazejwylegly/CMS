package com.wylegly.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wylegly.clinic.dao.RoleDao;
import com.wylegly.clinic.dao.GenericDao;
import com.wylegly.clinic.domain.Role;

@Service
public class RoleServiceImpl extends GenericServiceImpl<Role> implements RoleService {

	private RoleDao roleDao;
	
	public RoleServiceImpl() {
		
	}
	
	@Autowired
	public RoleServiceImpl(@Qualifier("roleDaoImpl") GenericDao<Role> roleDao) {
		super(roleDao);
		this.roleDao = (RoleDao) roleDao;
	}
}
