package com.app.services;

import javax.validation.Valid;

import com.app.dto.AddressDTO;
import com.app.dto.OwnerRequestDto;
import com.app.dto.PropertyDto;
import com.app.entities.AdharCard;

public interface OwnerService {

	OwnerRequestDto addNewOwner(@Valid OwnerRequestDto dto);

	

	

}
