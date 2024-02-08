package com.app.services;

import javax.validation.Valid;

import com.app.dto.UserDto;

public interface UserService {

	UserDto addNewUser(@Valid UserDto dto);
   
	


}
