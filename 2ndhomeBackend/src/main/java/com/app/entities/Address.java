package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address")
@NoArgsConstructor
@Getter
@Setter
public class Address extends BaseEntity{

	@Column(length = 50)
	private String street;
	
	@Column(length = 20)
	private String city;
	
	@Column(length = 30)
	private String state;
		
	@Column(length = 10)
	private String zipCode;
	
	//association mapping with property
	//one to one mapping with property
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn
	@MapsId
	private Property property ;

	public Address(String street, String city, String state, String zipCode, Property property) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.property = property;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode
				+ ", property=" + property + "]";
	}
	
	
	
}
