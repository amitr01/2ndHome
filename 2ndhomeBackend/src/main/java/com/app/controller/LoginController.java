package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.SignInRequest;
import com.app.services.UserService;

@RestController
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/login")
	ResponseEntity<?>userLogin(@RequestBody SignInRequest login){
		return ResponseEntity.ok(userService.userLoginDetails(login));
	}

}
