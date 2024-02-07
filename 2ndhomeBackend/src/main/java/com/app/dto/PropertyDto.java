package com.app.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.app.entities.Owner;
import com.app.entities.Status;
import com.app.entities.Type;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PropertyDto {

	private Long id;
	


	private String name;
	
	
	private Type type;
	

	private int noOfBedrooms;
//	
//	@Column(name="noOfBathrooms")
//	private int noOfBathrooms;
//	

	private double rentPrice;

	private Status staus;
	
	private Long ownerId;
	
}
