package com.app.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.app.entities.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto {

    
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	
	@Email
	private String email;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	
	private String gender;
	
	
	
}
