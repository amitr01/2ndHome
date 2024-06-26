package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="room")
@Getter
@Setter
@NoArgsConstructor
public class Room extends BaseEntity{
     
	@Column(name="NoofBeds")
	private int noOfBeds;
	
	@Column(name="Bathroom")
	private boolean hasBathroom;
	
	@Column(name="Description")
	private String desc;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "property_id")
	private Property property;
}
