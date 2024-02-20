package com.app.services;

import java.util.List;

import javax.validation.Valid;

import com.app.dto.ApiResponse;
import com.app.dto.PropertyDto;
import com.app.dto.SignInRequest;
import com.app.dto.UserDto;
import com.app.entities.Role;
import com.app.entities.User;

import ch.qos.logback.core.subst.Token.Type;

public interface UserService {

	



	UserDto addNewUser(@Valid UserDto dto);

	UserDto getUserByEmail(String name);

	ApiResponse deleteUserDetails(String email, String pass);

	List<PropertyDto> getAllProperties();

	List<PropertyDto> getAllPropertiesByCity(String city);

	User userLoginDetails(SignInRequest login);

	Role getUserRole(SignInRequest login);
   
	


}
