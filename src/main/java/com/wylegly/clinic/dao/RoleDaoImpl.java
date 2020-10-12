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
		return currentSession().createQuery("select role "
				+ "from Role role "
				+ "left join fetch role.users "
				+ "left join fetch role.privileges "
				+ "where role.id = :theId "
				+ "and role.name like :thePrefix", Role.class)
				.setParameter("theId", id)
				.setParameter("thePrefix", "'%ROLE_'")
				.getSingleResult();
				
	}
	
	@Override
	public List<Role> getAll() {

		return currentSession().createQuery("select role "
				+ "from Role role "
				+ "left join fetch role.users "
				+ "left join fetch role.privileges "
				+ "where role.name like :thePrefix", Role.class)
				.setParameter("thePrefix", "'%ROLE_'")
				.getResultList();

	}
}
