package com.app.services;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.OwnerDao;
import com.app.dao.PropertDao;
import com.app.dto.PropertyDto;
import com.app.dto.ProprtyRoomDto;
import com.app.entities.Owner;
import com.app.entities.Property;

import ch.qos.logback.core.subst.Token.Type;

@Service
@Transactional
public class PropertyServiceImpl implements PropertyService {
	
	@Autowired
	private PropertDao propertyDao;
	
	@Autowired
	private OwnerDao ownerDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public PropertyDto addNewProperty(@Valid PropertyDto pdto) {
		Property p=mapper.map(pdto, Property.class);
		Owner o=ownerDao.findById(pdto.getOwnerId()).orElseThrow();
		
		o.addProperty(p);
		
		
		return mapper.map(propertyDao.save(p), PropertyDto.class);
	}

	@Override
	public List<PropertyDto> getAllProperty() {
		return propertyDao.findAll().stream().map(prop->mapper.map(prop, PropertyDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<PropertyDto> getPropertyByEmail(String email) {
		// TODO Auto-generated method stub
		Owner o=ownerDao.findOwnerByEmail(email);
		return o.getProperties().stream().map(prop->mapper.map(prop, PropertyDto.class)).
				collect(Collectors.toList());
	}

	@Override
	public List<PropertyDto> getProprtyType(Type type) {
		
		return propertyDao.findByType(type).stream().map(prop->mapper.map(prop, PropertyDto.class)).
				collect(Collectors.toList());
	}
	

}
