package com.app.services;

import javax.validation.Valid;

import com.app.dto.AddressDTO;
import com.app.dto.ApiResponse;
import com.app.dto.OwnerRequestDto;
import com.app.dto.PropertyDto;
import com.app.dto.SignInRequest;
import com.app.dto.UserDto;
import com.app.entities.AdharCard;
import com.app.entities.User;

public interface OwnerService {

	OwnerRequestDto addNewOwner(@Valid OwnerRequestDto dto);

	ApiResponse deletePropertyByName(String name);

	OwnerRequestDto getOwnerDetails(Long oid);

	ApiResponse updateOwner(Long oid, OwnerRequestDto dto);

	ApiResponse deletePropertyById(Long pid);
	
	//
    User authenticateowner(SignInRequest dto);

	

	

}
