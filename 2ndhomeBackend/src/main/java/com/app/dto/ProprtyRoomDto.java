package com.app.dto;

import java.util.List;

import com.app.entities.Room;
import com.app.entities.Status;
import com.app.entities.Type;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProprtyRoomDto {

	private Long id;

	private String name;

	private Type type;

	private int noOfBedrooms;
	
	private double rentPrice;

	private Status staus;
	// additional proprty
	private List<Room> rooms;
}
