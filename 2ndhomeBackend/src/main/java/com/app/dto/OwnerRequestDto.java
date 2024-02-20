package com.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;

import org.springframework.format.annotation.DateTimeFormat;

import com.app.entities.AdharCard;
import com.app.entities.Role;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OwnerRequestDto {

//	Owner(String firstName, String lastName, String email, String password, 
//			String gender, Role role,
//			String mobNumber, String whatsappNumber, LocalDate dob, AdharCard card)
   
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	private String gender;
	
	private String mobNumber;

	private String whatsappNumber;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	
    private String cardNumber;
	

	private String address;
}
