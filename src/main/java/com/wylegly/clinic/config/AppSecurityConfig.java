package com.wylegly.clinic.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.wylegly.clinic.service.UserService;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private UserService userService;
	
	// Configure users and encryption
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(dataSource);
		
	}
	
	// Configure security of web paths in application, login, logout
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 //TODO: Restrict access based on roles
		http.authorizeRequests()						
				.anyRequest().permitAll()			// Any request must be authenticated
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

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder());
		provider.setUserDetailsService(userService);
		return provider;
	}
	
	
}
