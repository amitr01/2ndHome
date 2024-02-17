package com.app.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDto;
import com.app.services.PropertyService;
import com.app.services.UserService;

import ch.qos.logback.core.subst.Token.Type;

@RestController
@RequestMapping("user")
public class UserController {
      
	@Autowired
	private UserService userService;
	
	@Autowired
	private PropertyService propService;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping("/addUser")
	public ResponseEntity<?> addNewUser(@RequestBody UserDto dto){
		System.out.println("In Add User Controller");
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addNewUser(dto));
	}
	
	@GetMapping("/getUser/{email}")
	public ResponseEntity<?> getUserDetails(@PathVariable String email){
		System.out.println("in getuser controller...");
		return ResponseEntity.ok(userService.getUserByEmail(email));
	}
	
	@DeleteMapping("/deleteUser/{email}")
	public ResponseEntity<?>deleteUserDetails(@PathVariable String email,String pass){
		System.out.println("in delete user in user controller");
		return ResponseEntity.ok(userService.deleteUserDetails(email,pass));
	}
	
	
	//view all property
	@GetMapping("/getAllProperties")
	public ResponseEntity<?>getAllProperties(){
		System.out.println("in get ALL properties...!!");
		return ResponseEntity.ok(userService.getAllProperties());
	}
	
<<<<<<< HEAD
	//get properties by type
	@GetMapping("/getAllProperties/{type}")
	public ResponseEntity<?>getPropertyByType(@PathVariable Type type){
		System.out.println("in getProperty by type");
		return ResponseEntity.ok(propService.getProprtyType(type));
	}
	
=======
	//view all property by addresss
	@GetMapping("/getAllProperties/{city}")
	public ResponseEntity<?> getAllPropertiesByCity(@PathVariable String city){
		System.out.println("in get All property..");
		return ResponseEntity.ok(userService.getAllPropertiesByCity(city));
	}
>>>>>>> 4b11342e9f2e164b8510ffd725fc5d52c4f555ae
}
