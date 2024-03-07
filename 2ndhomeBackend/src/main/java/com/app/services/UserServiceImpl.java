package com.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.AddressDao;
import com.app.dao.OwnerDao;
import com.app.dao.PropertDao;
import com.app.dao.RoomDao;
import com.app.dao.UserDao;
import com.app.dto.ApiResponse;
import com.app.dto.PropertyDto;
import com.app.dto.PropertyRoomDto;
import com.app.dto.SignInRequest;
import com.app.dto.UserDto;
import com.app.dto.UserDtoOTP;
import com.app.entities.Owner;
import com.app.entities.Property;
import com.app.entities.Role;
import com.app.entities.Room;
import com.app.entities.User;

import ch.qos.logback.core.subst.Token.Type;

@Service
@Transactional
public class UserServiceImpl implements UserService ,UserDetailsService{

	@Autowired
	 private UserDao userDao;
	
	@Autowired
	private PropertDao propDdao;
	
	@Autowired
	private AddressDao addressDao;
	
	@Autowired
	private OwnerDao ownerDao;
	
	@Autowired
	private RoomDao roomDao;
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public ApiResponse addNewUser(@Valid UserDtoOTP dto) {
		
		User u=mapper.map(dto, User.class);
		u.setRole(Role.USER);
	    mapper.map(userDao.save(u),UserDto.class);
		return new ApiResponse("New User Added SuccessFully");
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


//	@Override
//	public Role getUserRole(SignInRequest login) {
//		User user = userDao.findByEmailAndPassword(login.getEmail(), login.getPassword()).orElseThrow((()->new ResourceNotFoundException("User Not Found")));
//
//	public User userLoginDetails(SignInRequest login) {
//		User user = userDao.findByEmail(login.getEmail()).orElseThrow(()->new ResourceNotFoundException("No User found"));
//		if(user!=null) {
//			
//			
//			if (user.getPassword().equals(login.getPassword())){
//				return user;
//			}
//				return null;
//		
//		}else {
//			return null;
//		}
//
//	}



	@Override
	public Role getUserRole(SignInRequest login) {
		User user = userDao.findByEmailAndPassword(login.getEmail(), login.getPassword()).orElseThrow((()->new ResourceNotFoundException("User Not Found")));

		return user.getRole();
	}



	@Override
	public PropertyRoomDto getAllPropertiesById(Long id) {
		 Property p=propDdao.findById(id).orElseThrow();
		 Owner owner=ownerDao.findById(p.getOwner().getUid()).orElseThrow();
		 Room room=roomDao.findByPropertyId(p.getId());
		 
		 PropertyRoomDto propDetails=new PropertyRoomDto();
		 propDetails.setName(p.getName());
		 propDetails.setNumber(owner.getMobNumber());
		 propDetails.setWhatsappNumber(owner.getWhatsappNumber());
		 propDetails.setRentPrice(p.getRentPrice());
         propDetails.setStatus(p.getStatus());
         propDetails.setType(p.getType());
         propDetails.setDescription(room.getDesc());
		 
		 
		return propDetails;
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return userDao.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("User not found"));
	}

}
