package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDto;
import com.app.entities.AuthenticationResponse;
import com.app.entities.User;
import com.app.services.AuthenticationService;

@RestController
public class AuthenticationController {

	@Autowired
	private AuthenticationService authService;
//	
//	@PostMapping("/register")
//	public ResponseEntity<AuthenticationResponse> register(@RequestBody User request){
//		return ResponseEntity.ok(authService.register(request));
//	}
//	
//	@PostMapping("/login")
//	public ResponseEntity<AuthenticationResponse> login(@RequestBody User request){
//		return ResponseEntity.ok(authService.authenticate(request));
//	}
	
}
