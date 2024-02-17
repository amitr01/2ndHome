package com.app.services;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.OwnerDao;
import com.app.dao.PropertDao;
import com.app.dao.UserDao;
import com.app.dto.ApiResponse;
import com.app.dto.OwnerRequestDto;
import com.app.entities.AdharCard;
import com.app.entities.Owner;
import com.app.entities.Property;
import com.app.entities.Role;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService{
	
	@Autowired
	private OwnerDao ownerDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PropertDao propertyDao;
	
	@Autowired
	private ModelMapper mapper;

	

	@Override
	public OwnerRequestDto addNewOwner(@Valid OwnerRequestDto dto
			) {
		// TODO Auto-generated method stub
		
		Owner o=mapper.map(dto,Owner.class);
		
	    o.setCard(new AdharCard(dto.getCardNumber(),dto.getAddress()));
	  
	    o.setRole(Role.OWNER);
	  
		return mapper.map(ownerDao.save(o), OwnerRequestDto.class);
	}



	@Override
	public ApiResponse deletePropertyByName(String name) {
		Property p=propertyDao.findPropertyByName(name);
		Owner o=ownerDao.findById(p.getOwner().getUid()).orElseThrow();
		o.removeProperty(p);
		propertyDao.delete(p);
		return new ApiResponse("Property Deleted Successfully");
	}




	


}
