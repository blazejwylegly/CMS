package com.wylegly.clinic.controller.security.helper;

public class UserAccountHelper {
	
	private String username;
	
	private String password;
	
	private String matchingPassword;
	
	public UserAccountHelper() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	@Override
	public String toString() {
		return "UserAccountHelper [username=" + username + ", password=" + password + ", matchingPassword="
				+ matchingPassword + "]";
	}
	
	

}
