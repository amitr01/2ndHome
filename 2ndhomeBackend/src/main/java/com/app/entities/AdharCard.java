package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AdharCard {
	
	@Column(name = "card_number",length = 12,unique = true)
	private String cardNumber;
	
	@Column(length = 30)
	private String location;
	
	@Column(name = "created_on")
	private LocalDate createdOn;
	
}
