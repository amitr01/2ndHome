package com.app.services;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.AddressDao;
import com.app.dao.PropertDao;
import com.app.dto.AddressDTO;
import com.app.dto.ApiResponse;
import com.app.entities.Address;
import com.app.entities.Property;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	private PropertDao propertyDao;
	
	@Autowired
	private AddressDao addrDao;
	
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public ApiResponse assignPropertyAdddress(@NotNull Long pid, @Valid AddressDTO address) {
		
		Property property = propertyDao.findById(pid).orElseThrow(()->new ResourceNotFoundException("Invalid property ID.. "));
		
		Address addr = mapper.map(address, Address.class);
		
		addr.setProperty(property);
		
		addrDao.save(addr);
		
		return new ApiResponse("Address is Assinged to property..");
	}


	@Override
	public AddressDTO getPropertyAddress(Long pid) {
		 
		
		return mapper.map(addrDao.findById(pid).
				orElseThrow(()->new ResourceNotFoundException("Invalid Id")), AddressDTO.class);
	}


	@Override
	public ApiResponse updatePropertyAddress(@NotNull Long pid, @Valid AddressDTO address) {
		
		Address addressEntity = addrDao.findById(pid)
				.orElseThrow(() -> new ResourceNotFoundException("Address is not yet assigned !!!! "));
	
		mapper.map(address, addressEntity);
		// save adr details
		addrDao.save(addressEntity);
		return new ApiResponse("Updated address for  Emp ");
	}


	




}
