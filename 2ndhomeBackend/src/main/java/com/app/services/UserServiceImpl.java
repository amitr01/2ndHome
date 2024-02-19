package com.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.AddressDao;
import com.app.dao.PropertDao;
import com.app.dao.UserDao;
import com.app.dto.ApiResponse;
import com.app.dto.PropertyDto;
import com.app.dto.SignInRequest;
import com.app.dto.UserDto;
import com.app.entities.Property;
import com.app.entities.Role;
import com.app.entities.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	 private UserDao userDao;
	
	@Autowired
	private PropertDao propDdao;
	
	@Autowired
	private AddressDao addressDao;
	@Autowired
	private ModelMapper mapper;
	
	
	
	@Override
	public UserDto addNewUser(@Valid UserDto dto) {
		
		User u=mapper.map(dto, User.class);
		u.setRole(Role.VISITOR);
		return mapper.map(userDao.save(u),UserDto.class);
		
	}



	@Override
	public UserDto getUserByEmail(String email) {
		User user = userDao.findByEmail(email).orElseThrow(()-> new ResourceNotFoundException("Invalid email"));
		return mapper.map(user, UserDto.class);
	}



	@Override
	public ApiResponse deleteUserDetails(String email, String pass) {
		
		User user = userDao.findByEmail(email).orElseThrow(()-> new ResourceNotFoundException("Invalid email id"));
		
		if(user.getPassword().equals(pass)) {
			
		userDao.delete(user);
		return new ApiResponse("User Deleted Succsessfuly..!!");
		}
		
		return new ApiResponse("User cant be deleted");
	}


	//in case of any error we will try new approch
	@Override
	public List<PropertyDto> getAllProperties() {
		
		return propDdao.findAll()
				.stream()
				.map(prop->mapper.map(prop, PropertyDto.class))
				.collect(Collectors.toList());
	}



	@Override
	public List<PropertyDto> getAllPropertiesByCity(String city) {
		Set<Long> listofProperty=addressDao.findIdByCity(city);
		
		
		List<Property> propertyList= propDdao.findAll();
		List<Property> finalProperty=new ArrayList<>();
		for(Property p:propertyList){
			if(listofProperty.contains(p.getId())) {
				finalProperty.add(p);
			}
		}
		return finalProperty.stream().map(p->mapper.map(p, PropertyDto.class)).collect(Collectors.toList());
		
	}



	@Override
	public User userLoginDetails(SignInRequest login) {
		User user = userDao.findByEmail(login.getEmail()).orElseThrow(()->new ResourceNotFoundException("No User found"));
		if(user!=null) {
			
			if (user.getPassword().equals(login.getPassword())){
				return user;
			}
				return new ApiResponse("Password Dosent match");
		
		}else {
			return new ApiResponse("Invalid Login");
		}
		return null;
	}

}
