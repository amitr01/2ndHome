package com.app.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.SignInRequest;
<<<<<<< HEAD
import com.app.services.EmailService;
import com.app.services.ReCaptchaValidationService;
=======
import com.app.entities.User;
import com.app.services.OwnerService;
>>>>>>> 26c1711e2b6fa6320487a77f755d9f55010ea21e
import com.app.services.UserService;

@RestController
@RequestMapping("login")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
	
	@Autowired
	UserService userService;
	
<<<<<<< HEAD

	
	
	@Autowired
	private ReCaptchaValidationService validator;
	
	@PostMapping("/signIn")
	ResponseEntity<?> Login(@RequestBody SignInRequest login,@RequestParam(name="g-recaptcha-response")
	 String captcha){
		if(validator.validateCaptcha(captcha)) {
			return ResponseEntity.ok(userService.getUserRole(login));

		}
		return ResponseEntity.ok(new ApiResponse("Please Verify Catcha"));
=======
	@Autowired
	OwnerService ownerservice;
//	
//	@PostMapping("/login")
//	ResponseEntity<?>userLogin(@RequestBody SignInRequest login){
//		
//		User user=ownerservice.authenticateowner(login);
//		return ResponseEntity.ok((user.getRole()));
//	}

	@PostMapping("/login")
	ResponseEntity<?>loginbaseRole(@RequestBody SignInRequest login){
		return ResponseEntity.ok(userService.getUserRole(login));
>>>>>>> 26c1711e2b6fa6320487a77f755d9f55010ea21e
	}
}
