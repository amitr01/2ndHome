package com.app.services;

import java.util.List;

import javax.validation.Valid;

import com.app.dto.ApiResponse;
import com.app.dto.PropertyDto;
import com.app.dto.SignInRequest;
import com.app.dto.UserDto;
import com.app.dto.UserDtoOTP;
import com.app.entities.Role;
import com.app.entities.User;

public interface UserService {

	



	ApiResponse addNewUser(@Valid UserDtoOTP dto);

	UserDto getUserByEmail(String name);

	ApiResponse deleteUserDetails(String email, String pass);

	List<PropertyDto> getAllProperties();

	List<PropertyDto> getAllPropertiesByCity(String city);

	//String LoginDetails(SignInRequest login);

	Role getUserRole(SignInRequest login);
   
	


}
