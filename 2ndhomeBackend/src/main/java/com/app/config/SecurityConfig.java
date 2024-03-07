package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.app.filter.JwtAuthenticationFilter;
import com.app.services.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  
	private final UserServiceImpl userDetailsService;
	
	private final JwtAuthenticationFilter jwtauthenticationFilter;
	
	public SecurityConfig(UserServiceImpl userDetailsService, JwtAuthenticationFilter jwtauthenticationFilter) {
		super();
		this.userDetailsService = userDetailsService;
		this.jwtauthenticationFilter = jwtauthenticationFilter;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		return http
				.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(
				req->req.antMatchers("/login/**","/register/**","/user/sendOTP/**",
						"/user/addUser","/user/getAllProperties","/owner/addOwner")
				.permitAll()
				.anyRequest()
				.authenticated()
						).userDetailsService(userDetailsService)
				.sessionManagement(session->session
						.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(jwtauthenticationFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
				 
				
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		 return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
	
}
