package com.wylegly.clinic.domain;

import java.util.Set;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity(name = "Role")
@Table(name = "role")
public class Role implements GrantedAuthority {

	private static final long serialVersionUID = 1558984081613839511L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToMany(
			mappedBy = "roles"
			)
	private Set<User> users;

	@ManyToMany( fetch = FetchType.LAZY	)
	@JoinTable(
			name = "roles_privileges",
			joinColumns = @JoinColumn(name = "role_id"),
			inverseJoinColumns = @JoinColumn(name = "privilege_id")
	)
	private Set<Privilege> privileges;

	public Role() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String getAuthority() {
		return name;
	}
	
	public void setAuthorityName(String name) {
		this.name = name;
	}

	public Set<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}
}
