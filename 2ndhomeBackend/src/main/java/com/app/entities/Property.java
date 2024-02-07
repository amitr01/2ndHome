package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="property")
@Getter
@Setter
@NoArgsConstructor
public class Property extends BaseEntity{
  
	@Column(name="propertynameO")
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ptype")
	private Type type;
	
	@Column(name="noOfBedrooms")
	private int noOfBedrooms;
	
	@Column(name="noOfBathrooms")
	private int noOfBathrooms;
	
	@Column(name="rentPrice")
	private double rentPrice;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private Status staus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "oid") // Optional BUT reco , to specify the name of FK col.
	private Owner owner;

	public Property(String name, Type type, int noOfBedrooms, int noOfBathrooms, double rentPrice, Status staus,
			Owner owner) {
		super();
		this.name = name;
		this.type = type;
		this.noOfBedrooms = noOfBedrooms;
		this.noOfBathrooms = noOfBathrooms;
		this.rentPrice = rentPrice;
		this.staus = staus;
		this.owner = owner;
	}
	
	
}
