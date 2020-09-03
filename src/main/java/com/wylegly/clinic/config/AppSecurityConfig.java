package com.wylegly.clinic.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{

	// Configure users and encryption
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// add users for in memory authentication
		
		UserBuilder userBuilder = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
		.withUser(userBuilder.username("john").password("john").roles("user"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()						
				.anyRequest().authenticated()			// Any request must be authenticated
			.and()							
			.formLogin()								// Customizing the form login process
				.loginPage("/showLoginForm")			// Show custom form at the requested mapping
				.loginProcessingUrl("/authenticate")	// Login form should POST data to this url for authentication
				.permitAll()							// Let everyone see the login page
			.and()
			.logout().logoutRequestMatcher(
					new AntPathRequestMatcher("/logout"))
			.permitAll();
	
	}

	
	// Configure security of web paths in application, login, logout
	
	
}
