package com.app.services;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.dao.OwnerDao;
import com.app.dao.UserDao;
import com.app.dto.OwnerRequestDto;
import com.app.dto.SignInRequest;
import com.app.dto.UserDto;
import com.app.dto.UserDtoOTP;
import com.app.entities.AdharCard;
import com.app.entities.AuthenticationResponse;
import com.app.entities.Owner;
import com.app.entities.Role;
import com.app.entities.User;


@Service
@Transactional
public class AuthenticationService {
   
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private OwnerDao ownerDao;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	public AuthenticationResponse registerOwner(@Valid OwnerRequestDto dto) {
	   Owner owner=mapper.map(dto, Owner.class);
	   owner.setCard(new AdharCard(dto.getCardNumber(),dto.getAddress()));
		  
	    owner.setRole(Role.OWNER);
	    
		owner.setFirstName(dto.getFirstName());
		owner.setLastName(dto.getLastName());
		owner.setGender(dto.getGender());
		owner.setEmail(dto.getEmail());
		owner.setPassword(passwordEncoder.encode(dto.getPassword()));
		
		owner=ownerDao.save(owner);
		
		String token =jwtService.generateToken(owner);
		return new AuthenticationResponse(token);
	}
	public AuthenticationResponse registerUser(UserDtoOTP request) {
		User user=mapper.map(request, User.class);
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setGender(request.getGender());
		user.setEmail(request.getEmail());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setRole(Role.USER);
		user=userDao.save(user);
		String token =jwtService.generateToken(user);
		return new AuthenticationResponse(token);
		
	}

	public AuthenticationResponse authenticate(SignInRequest request) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						request.getEmail(),
						request.getPassword()
						)
				);
		User user=userDao.findByEmail(request.getEmail()).orElseThrow();
		String token=jwtService.generateToken(user);
		return new AuthenticationResponse(token);
	}
	
	}

