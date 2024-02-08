package com.app.services;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserDao;
import com.app.dto.UserDto;
import com.app.entities.Role;
import com.app.entities.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	 private UserDao userDao;
	
	@Autowired
	private ModelMapper mapper;
	
	
	
	@Override
	public UserDto addNewUser(@Valid UserDto dto) {
		
		User u=mapper.map(dto, User.class);
		u.setRole(Role.VISITOR);
		return mapper.map(userDao.save(u),UserDto.class);
		
	}

}
