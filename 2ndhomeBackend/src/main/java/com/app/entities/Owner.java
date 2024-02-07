package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="owner")
@Getter
@Setter
@NoArgsConstructor
public class Owner extends User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;
	
//	@Column(name="aadhar_no",length = 12,unique = true)
//	private String aadharNumber;
//	
	@Column(name="mob_no",length = 10)
	private String mobNumber;
	
	@Column(name="whatsapp_no",length = 10)
	private String whatsappNumber;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true /* , fetch = FetchType.EAGER */ )
	private List<Property> properties = new ArrayList<>();

	@Embedded//optional
	private AdharCard card;

  //Helper Methods
	
	public void addProperty(Property p) {
		properties.add(p);
		p.setOwner(this);
	}
	
	public void removeProperty(Property p) {
		properties.remove(p);
		p.setOwner(null);
	}

	
	
	
	
}
