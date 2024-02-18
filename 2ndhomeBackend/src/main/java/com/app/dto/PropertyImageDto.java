package com.app.dto;

import com.app.entities.Status;
import com.app.entities.Type;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyImageDto {

	
private String name;
	
	private Type type;
	
	private int noOfBedrooms;


	private double rentPrice;

	private Status status;
	
	private Long ownerId;
	
	
    private String r1image;
    
	
    private String r2image;
    
	
    private String r3image;
    
 
  

}
