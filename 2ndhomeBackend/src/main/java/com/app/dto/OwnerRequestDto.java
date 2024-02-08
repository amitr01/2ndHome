package com.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;

import org.springframework.format.annotation.DateTimeFormat;

public class OwnerRequestDto {

	
	private String mobNumber;

	private String whatsappNumber;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	
	private String cardNumber;
	
	
	private String address;
}
