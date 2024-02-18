package com.app.services;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import com.app.dto.ApiResponse;
import com.app.dto.PropertyDto;
import com.app.dto.PropertyImageDto;
import com.app.dto.PropertyUpdateDto;
import com.app.dto.RoomDto;

import ch.qos.logback.core.subst.Token.Type;

public interface PropertyService {

	PropertyDto addNewProperty(@Valid PropertyDto pdto);

	//List<PropertyDto> getAllProperty() throws IOException;

	List<PropertyDto> getPropertyByEmail(String email);

	
	List<PropertyDto> getProprtyType(Type type);

	ApiResponse updateProperty(Long pid,@Valid PropertyUpdateDto dto);

	PropertyUpdateDto getPropertById(Long pid);


	//byte[] getImage(Long pid) throws IOException;

}
