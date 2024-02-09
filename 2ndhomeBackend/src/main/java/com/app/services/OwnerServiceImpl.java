package com.app.services;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.OwnerDao;
import com.app.dao.UserDao;
import com.app.dto.AddressDTO;
import com.app.dto.OwnerRequestDto;
import com.app.dto.PropertyDto;
import com.app.entities.Address;
import com.app.entities.AdharCard;
import com.app.entities.Owner;
import com.app.entities.Role;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService{
	
	@Autowired
	private OwnerDao ownerDao;
	
	@Autowired
	private UserDao userDao;
	
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




	


}
