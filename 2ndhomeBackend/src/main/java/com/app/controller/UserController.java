package com.app.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDto;
import com.app.services.UserService;

@RestController
@RequestMapping("user")
public class UserController {
      
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping("/addUser")
	public ResponseEntity<?> addNewUser(@RequestBody UserDto dto){
		System.out.println("In Add User Controller");
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addNewUser(dto));
	}
	
//	@GetMapping("/getUser")
//	public ResponseEntity<?> getUserDetails(){
//		
//	}
	
	
}
