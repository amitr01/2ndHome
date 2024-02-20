package com.app.services;

import java.util.List;

import javax.validation.Valid;

import com.app.dto.ApiResponse;
import com.app.dto.PropertyDto;
import com.app.dto.SignInRequest;
import com.app.dto.UserDto;
<<<<<<< HEAD
import com.app.dto.UserDtoOTP;
=======
>>>>>>> 26c1711e2b6fa6320487a77f755d9f55010ea21e
import com.app.entities.Role;
import com.app.entities.User;

import ch.qos.logback.core.subst.Token.Type;

public interface UserService {

	



	ApiResponse addNewUser(@Valid UserDtoOTP dto);

	UserDto getUserByEmail(String name);

	ApiResponse deleteUserDetails(String email, String pass);

	List<PropertyDto> getAllProperties();

	List<PropertyDto> getAllPropertiesByCity(String city);

<<<<<<< HEAD
	//String LoginDetails(SignInRequest login);
=======
	User userLoginDetails(SignInRequest login);
>>>>>>> 26c1711e2b6fa6320487a77f755d9f55010ea21e

	Role getUserRole(SignInRequest login);
   
	


}
