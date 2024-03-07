package com.app.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.OwnerDao;
import com.app.dao.PropertDao;
import com.app.dao.RoomDao;
import com.app.dto.ApiResponse;
import com.app.dto.PropertyDto;
import com.app.dto.PropertyImageDto;
import com.app.dto.PropertyUpdateDto;
import com.app.dto.PropertyRoomDto;
import com.app.dto.RoomDto;
import com.app.entities.Owner;
import com.app.entities.Property;
import com.app.entities.Room;

import ch.qos.logback.core.subst.Token.Type;

import static org.apache.commons.io.FileUtils.readFileToByteArray;
@Service
@Transactional
public class PropertyServiceImpl implements PropertyService {
	
	@Autowired
	private PropertDao propertyDao;
	
	@Autowired
	private OwnerDao ownerDao;
	
	@Autowired
	private RoomDao roomDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public PropertyDto addNewProperty(@Valid PropertyDto pdto) {
		Property p=mapper.map(pdto, Property.class);
		Owner o=ownerDao.findById(pdto.getOwnerId()).orElseThrow();
		
		o.addProperty(p);
		
		
		return mapper.map(propertyDao.save(p), PropertyDto.class);
	}

//	@Override
//	public List<PropertyDto> getAllProperty() throws IOException {
//		 
//		
//		List<PropertyDto> listofAllProperty=propertyDao.findAll().stream().map(prop->mapper.map(prop, PropertyDto.class)).collect(Collectors.toList());
//	//	List<PropertyImageDto> listofAllPropertyImage=new ArrayList<>();
//	
//		return listofAllProperty;
//	}

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

	@Override
	public ApiResponse updateProperty(Long pid,@Valid PropertyUpdateDto dto) {
		Property p=propertyDao.findById(pid).orElseThrow(() -> new ResourceNotFoundException("Invalid Property ID , Property not found !!!!"));
		Owner o=ownerDao.findById(p.getOwner().getUid()).orElseThrow(() -> new ResourceNotFoundException("Invalid Property ID , Property not found !!!!"));
		mapper.map(dto,p);
		o.addProperty(p);
		dto.setId(pid);
		return new ApiResponse("Succcessfully Updated");
	}

	@Override
	public PropertyUpdateDto getPropertById(Long pid) {
		 Property p=propertyDao.findById(pid).orElseThrow();
		
		return mapper.map(p,PropertyUpdateDto.class);
	}



//	@Override
//	public byte[] getImage(Long pid) throws IOException {
//		Property p=propertyDao.findById(pid).orElseThrow();
//		String path=p.getR1image();
//		return readFileToByteArray(new File(path));
//		
//	}
	

}
