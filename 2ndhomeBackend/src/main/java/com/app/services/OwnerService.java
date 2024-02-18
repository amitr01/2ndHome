package com.app.services;

import javax.validation.Valid;

import com.app.dto.AddressDTO;
import com.app.dto.ApiResponse;
import com.app.dto.OwnerRequestDto;
import com.app.dto.PropertyDto;
import com.app.entities.AdharCard;

public interface OwnerService {

	OwnerRequestDto addNewOwner(@Valid OwnerRequestDto dto);

	ApiResponse deletePropertyByName(String name);

	OwnerRequestDto getOwnerDetails(Long oid);

	ApiResponse updateOwner(Long oid, OwnerRequestDto dto);

	

	

}
