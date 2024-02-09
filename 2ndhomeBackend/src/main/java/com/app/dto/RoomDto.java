package com.app.dto;

import com.app.entities.Status;
import com.app.entities.Type;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RoomDto {

	
    private int noOfBeds;
	

	private boolean hasBathroom;
	

	private String desc;
	
	private Long pId;
	

}
