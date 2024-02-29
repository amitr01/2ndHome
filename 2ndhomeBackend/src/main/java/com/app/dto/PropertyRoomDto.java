package com.app.dto;

import com.app.entities.Status;
import com.app.entities.Type;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PropertyRoomDto {

	

	private String name;

	private Type type;

	private int noOfBedrooms;
	
	private double rentPrice;

	private Status status;
	
	private String description;
	// additional proprty
    private String number;
    
    private String whatsappNumber;
    
    
}
