package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDtoOTP {

	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	
	
	private String email;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	
	private String gender;
	
	private String otp;
}
