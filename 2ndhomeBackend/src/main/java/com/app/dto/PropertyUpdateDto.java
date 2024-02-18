package com.app.dto;

import com.app.entities.Status;
import com.app.entities.Type;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyUpdateDto {
  
@JsonProperty(access=Access.READ_ONLY)
   private Long id;
	
	private String name;
	
	private Type type;
	
	private int noOfBedrooms;


	private double rentPrice;

	private Status status;
	

	
    private String r1image;
    
	
    private String r2image;
    
	
    private String r3image;
    
    private Long propertyId;
    
}
