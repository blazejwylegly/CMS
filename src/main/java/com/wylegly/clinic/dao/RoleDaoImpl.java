package com.wylegly.clinic.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wylegly.clinic.domain.Role;

@Repository
public class RoleDaoImpl 
extends GenericDaoImpl<Role> 
implements RoleDao{

	@Override
	public Role get(int id) {
		Role authority = null;
		authority = currentSession().createQuery("select role "
				+ "from Role role "
				+ "left join fetch role.users "
				+ "where role.id = :theId", Role.class)
				.setParameter("theId", id)
				.getSingleResult();
		return authority;
				
	}
	
	@Override
	public List<Role> getAll() {
		List<Role> authorities = null;
		
		authorities = currentSession().createQuery("from Role", 
				Role.class).getResultList();
				
		return authorities;
	}
}
