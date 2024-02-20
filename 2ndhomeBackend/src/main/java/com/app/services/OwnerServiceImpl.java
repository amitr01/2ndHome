package com.app.services;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.AddressDao;
import com.app.dao.OwnerDao;
import com.app.dao.PropertDao;
import com.app.dao.UserDao;
import com.app.dto.ApiResponse;
import com.app.dto.OwnerRequestDto;
import com.app.dto.SignInRequest;
import com.app.dto.UserDto;
import com.app.entities.Address;
import com.app.entities.AdharCard;
import com.app.entities.Owner;
import com.app.entities.Property;
import com.app.entities.Role;
import com.app.entities.User;

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
	private AddressDao addressDao;
	
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
		Address a=addressDao.findById(p.getId()).orElseThrow();
		
		addressDao.delete(a);
		o.removeProperty(p);
		propertyDao.delete(p);
		return new ApiResponse("Property Deleted Successfully");
	}
  


	@Override
	public OwnerRequestDto getOwnerDetails(Long oid) {
		Owner o=ownerDao.findById(oid).orElseThrow();
		
		
		OwnerRequestDto ownerDto= mapper.map(o, OwnerRequestDto.class);
		
		ownerDto.setCardNumber(o.getCard().getCardNumber());
		ownerDto.setAddress(o.getCard().getAddress());
		return ownerDto;
	}
	



	@Override
	public ApiResponse updateOwner(Long oid, OwnerRequestDto dto) {
		   Owner o=ownerDao.findById(oid).orElseThrow();
		   mapper.map(dto, o);
		   ownerDao.save(o);
		return new ApiResponse("Saved Owner Details Successfully");
	}



	@Override
	public ApiResponse deletePropertyById(Long pid) {
		Property p=propertyDao.findById(pid).orElseThrow();
		Owner o=ownerDao.findById(p.getOwner().getUid()).orElseThrow();
//		Address a=addressDao.findById(p.getId()).orElseThrow();
//		
//		addressDao.delete(a);
		o.removeProperty(p);
		propertyDao.delete(p);
		return new ApiResponse("Property Deleted Successfully");
	}



	@Override
	public User  authenticateowner(SignInRequest login) {
		User user = ownerDao.findByEmailAndPassword(login.getEmail(),login.getPassword()).orElseThrow(()->new ResourceNotFoundException("No User found"));
		if(user!=null) {
			System.out.println(user);
			if (user.getPassword().equals(login.getPassword())){
				return user;
			}
				return null;
		
		}else {
			return null;
	}

	}


	


	}
