package com.app.services;

import javax.validation.Valid;

import com.app.dto.PropertyDto;

public interface PropertyService {

	PropertyDto addNewProperty(@Valid PropertyDto pdto);

}
