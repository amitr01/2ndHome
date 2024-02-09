package com.app.services;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.OwnerDao;
import com.app.dao.PropertDao;
import com.app.dto.PropertyDto;
import com.app.entities.Owner;
import com.app.entities.Property;

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
	

}