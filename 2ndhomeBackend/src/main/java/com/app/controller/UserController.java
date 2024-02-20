package com.app.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.SendRequestOTP;
import com.app.dto.UserDtoOTP;
import com.app.services.EmailService;
import com.app.services.PropertyService;
import com.app.services.UserService;

import ch.qos.logback.core.subst.Token.Type;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
      
	@Autowired
	private UserService userService;
	
	@Autowired
	private PropertyService propService;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private EmailService emailService;
	
	@Value("${spring.mail.username}")
    private String mailUsername;
	

	public Map<String,String> otpMap = new HashMap<>();
	   
		@PostMapping("/sendOTP")
		ResponseEntity<?> sendOtp(@RequestBody String email){
			System.out.println("IN SendOtp");
			
			String otp=emailService.generateOTP();
			otpMap.put(email,otp);
			System.out.println(email);
			System.out.println(otp);
			   boolean otpSent = emailService.sendEmail(email,mailUsername, "Your OTP is: " + otp);
		        if (otpSent) {
		        	
		            return ResponseEntity.ok().build();
		        } else {
		            // If OTP sending failed, remove it from the map
		            otpMap.remove(email);
		            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		        }
		}
	
	
	@PostMapping("/addUser")
	public ResponseEntity<?> addNewUser(@RequestBody @Valid UserDtoOTP dto){
		System.out.println("In Add User Controller");
		String email="";
		email+=dto.getEmail();
		String formattedEmail = "\"" + email + "\"";
		System.out.println(formattedEmail);
		
		if(otpMap.containsKey(formattedEmail)) {
			String storedOtp=otpMap.get(formattedEmail);
			System.out.println("Email Matched");
			if(dto.getOtp().equals(storedOtp)) {
				System.out.println("Otp Matched");
				otpMap.remove(dto.getEmail());
				return ResponseEntity.ok(userService.addNewUser(dto));
			}
		}
	   return ResponseEntity.noContent().build();
				
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
	

	//get properties by type
	@GetMapping("/getAllProperties/{type}")
	public ResponseEntity<?>getPropertyByType(@PathVariable Type type){
		System.out.println("in getProperty by type");
		return ResponseEntity.ok(propService.getProprtyType(type));
	}
	
	//view all property by addresss
	@GetMapping("/getAllProperties/{city}")
	public ResponseEntity<?> getAllPropertiesByCity(@PathVariable String city){
		System.out.println("in get All property..");
		return ResponseEntity.ok(userService.getAllPropertiesByCity(city));
	}

}
