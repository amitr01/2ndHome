package com.app.services;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.PropertDao;
import com.app.dao.RoomDao;
import com.app.dto.ApiResponse;
import com.app.dto.RoomDto;
import com.app.entities.Property;
import com.app.entities.Room;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomDao roomDao;
	
	
	@Autowired
	private PropertDao propertyDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse addNewRoom(@Valid RoomDto rdto) {
		Room r=mapper.map(rdto,Room.class);
		//custom exception handler krna hai
		Property p=propertyDao.findById(rdto.getPId()).orElseThrow();
	    p.addRoom(r);	
	   
	    roomDao.save(r);
	   System.out.println(r.isHasBathroom());
	    return new ApiResponse("Room Added");
	 
	}

}
