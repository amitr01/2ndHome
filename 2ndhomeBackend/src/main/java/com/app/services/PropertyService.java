package com.app.services;

import java.util.List;

import javax.validation.Valid;

import com.app.dto.PropertyDto;

public interface PropertyService {

	PropertyDto addNewProperty(@Valid PropertyDto pdto);

	List<PropertyDto> getAllProperty();

	List<PropertyDto> getPropertyByEmail(String email);

}
