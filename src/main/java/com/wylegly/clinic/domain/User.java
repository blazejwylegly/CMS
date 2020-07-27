package com.wylegly.clinic.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.wylegly.clinic.validation.MedCode;

public class User {
	
	@Size(min = 4, max = 30)
	@NotNull
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z]+$", message = "{username.invalid}")
	private String username;
	
	@Size(min = 4, message = "{password.invalid.length}")
	@NotNull
	@NotBlank
	private String password;
	
	@NotNull
	@Min(value = 0, message = "Must be more or equal to 0")
	@Max(value = 10, message = "Must be less or equal to 10")
	private Integer testVar;
	
	@MedCode(value = "MC", message = "must start with MC")
	private String medCode;
	
	public String getMedCode() {
		return medCode;
	}

	public void setMedCode(String medCode) {
		this.medCode = medCode;
	}

	private boolean isAdmin = false;
	
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

	public Integer getTestVar() {
		return testVar;
	}

	public void setTestVar(Integer testVar) {
		this.testVar = testVar;
	}
	
	public boolean isAdmin() {
		return this.isAdmin;
	}
	
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
}
