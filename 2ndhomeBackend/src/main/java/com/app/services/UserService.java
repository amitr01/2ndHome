package com.app.services;

import java.util.List;

import javax.validation.Valid;

import com.app.dto.ApiResponse;
import com.app.dto.ProprtyRoomDto;
import com.app.dto.UserDto;

public interface UserService {

	

	UserDto addNewUser(@Valid UserDto dto);

	UserDto getUserByEmail(String name);

	ApiResponse deleteUserDetails(String email, String pass);

	List<ProprtyRoomDto> getAllProperties();
   
	


}
