package com.wylegly.clinic.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Privilege")
@Table(name = "role")
public class Privilege implements GrantedAuthority {

    private static final long serialVersionUID = 1111984081634283911L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String authority;

    @ManyToMany(mappedBy = "privileges")
    private Set<Role> roles;

    public Privilege() {

    }

    public Privilege(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
