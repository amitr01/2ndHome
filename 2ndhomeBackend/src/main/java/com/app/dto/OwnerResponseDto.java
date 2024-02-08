package com.app.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OwnerResponseDto {



	private String mobNumber;

	private String whatsappNumber;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	
	

}
