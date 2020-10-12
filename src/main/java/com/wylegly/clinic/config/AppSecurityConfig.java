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
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.wylegly.clinic.service.UserService;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationSuccessHandlerImpl authSuccessHandler;
	
	// Configure users and encryption
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	// Configure security of web paths in application, login, logout
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 //TODO: Restrict access based on roles
		http.authorizeRequests()
				.antMatchers("/register/**").permitAll()
				.antMatchers("/").hasRole("USER")
				.antMatchers("/patients/**").hasAnyRole("USER",
				"ADMIN")
				.antMatchers("/doctors/**").hasAnyRole("ADMIN"
																)
				.antMatchers("/procedures/**").hasAnyRole("DOCTOR",
				"ADMIN")
				.anyRequest().authenticated()
			.and()	
				.formLogin()								// Customizing the form login process
					.loginPage("/showLoginForm")			// Show custom form at the requested mapping
					.loginProcessingUrl("/authenticate")	// Login form should POST data to this url for authentication
					.successHandler(authSuccessHandler)
					.permitAll()							// Let everyone see the login page
			.and()
				.logout().logoutRequestMatcher(
					new AntPathRequestMatcher("/logout"))
				.permitAll()
			.and()
				.exceptionHandling()
				.accessDeniedHandler(accessDeniedHandler())
				.accessDeniedPage("/accessDenied");

	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder()); // set password encoder
		provider.setUserDetailsService(userService);	// set custom user details service
		return provider;
	}

	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new AccessDeniedHandlerImpl();
	}
}
