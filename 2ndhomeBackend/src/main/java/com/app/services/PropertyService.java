package com.app.services;

import java.util.List;

import javax.validation.Valid;

import com.app.dto.PropertyDto;

import ch.qos.logback.core.subst.Token.Type;

public interface PropertyService {

	PropertyDto addNewProperty(@Valid PropertyDto pdto);

	List<PropertyDto> getAllProperty();

	List<PropertyDto> getPropertyByEmail(String email);

	
	List<PropertyDto> getProprtyType(Type type);

}
